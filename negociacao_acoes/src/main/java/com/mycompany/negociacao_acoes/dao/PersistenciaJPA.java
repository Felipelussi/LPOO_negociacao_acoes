/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negociacao_acoes.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Pessoa;

/**
 *
 * @author felipe
 */
public class PersistenciaJPA implements InterfaceDB {

    public EntityManager entity;
    public EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("negociacao_acoes");
        entity = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try{
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
        }catch(Exception e){
            if(entity.getTransaction().isActive())
            entity.getTransaction().rollback();
        }
        }
    
    public List<Pessoa> getPessoas() {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p", Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }
    
    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try{
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
        }catch(Exception e){
            if(entity.getTransaction().isActive())
            entity.getTransaction().rollback();
        }
        }

//    @Override
//    public void remover(Object o) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
