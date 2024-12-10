package com.mycompany.negociacao_acoes.dao;

import com.mycompany.negociacao_acoes.dao.InterfaceDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.function.Consumer;
import model.AcaoCliente;
import model.Cliente;
import model.Pessoa;

public class PersistenciaJPA implements InterfaceDB {

    private final EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("negociacao_acoes");
    }

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
            throw e;
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

    public List<?> findAll(Class c) throws Exception {
        EntityManager em = factory.createEntityManager();
        try {
            String query = "SELECT e FROM " + c.getSimpleName() + " e";
            System.out.println(c.getSimpleName());
            return em.createQuery(query, c).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void persist(Object o) throws Exception {
        // Usando inTransaction para gerenciar transações
        inTransaction(entityManager -> entityManager.persist(o));
    }

    @Override
    public void remover(Object o) throws Exception {
        inTransaction(entityManager -> {
            Object objeto = o;
            System.out.println("aka");
            System.out.println(o);
            if (!entityManager.contains(objeto)) {
                objeto = entityManager.merge(objeto);
            }
            entityManager.remove(objeto);
        });
    }

    public List<AcaoCliente> findByCliente(Cliente cliente) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT ac FROM AcaoCliente ac WHERE ac.cliente = :cliente", AcaoCliente.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
        } finally {
            em.close();
        }

    }

//   @Override
//    public void remover(Object o) throws Exception {
//       EntityManager entity = factory.createEntityManager();
//        try {
//            entity.getTransaction().begin();
//            if (!entity.contains(o)) {
//                o = entity.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
//            }
//            entity.remove(o);
//            entity.getTransaction().commit();
//        } catch (Exception e) {
//            System.err.println("Erro ao remover item: "+e);
//            if (entity.getTransaction().isActive()) {
//                entity.getTransaction().rollback();
//            }
//        }finally{entity.close();}
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
