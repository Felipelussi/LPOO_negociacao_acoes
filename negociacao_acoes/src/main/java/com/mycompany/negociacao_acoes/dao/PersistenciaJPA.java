package com.mycompany.negociacao_acoes.dao;

import com.mycompany.negociacao_acoes.dao.InterfaceDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.function.Consumer;
import model.Pessoa;

public class PersistenciaJPA implements InterfaceDB {

    private final EntityManagerFactory factory;

    public PersistenciaJPA() {
        // Inicializa o EntityManagerFactory com a unidade de persistência definida no persistence.xml
        factory = Persistence.createEntityManagerFactory("negociacao_acoes");
    }

    // Método utilitário para executar operações dentro de uma transação
    private void inTransaction(Consumer<EntityManager> work) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            work.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Repropaga a exceção para tratamento externo, se necessário
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Boolean conexaoAberta() {
        return factory.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (factory.isOpen()) {
            factory.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return factory.createEntityManager().find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        // Usando inTransaction para gerenciar transações
        inTransaction(entityManager -> entityManager.persist(o));
    }

    @Override
    public void remover(Object o) throws Exception {
        inTransaction(entityManager -> {
            Object objeto = o; // Copia o valor de 'o' para uma variável local
            if (!entityManager.contains(objeto)) {
                objeto = entityManager.merge(objeto); // Atualiza a referência dentro do lambda
            }
            entityManager.remove(objeto);
        });
}


    // Método para listar todas as Pessoas
    public List<Pessoa> getPessoas() {
        EntityManager entityManager = factory.createEntityManager();
        try {
            TypedQuery<Pessoa> query = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        } finally {
            entityManager.close();
        }
    }
}
