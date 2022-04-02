package org.jogoDaForca.daos;

import org.jogoDaForca.models.Palavra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PalavrasDao {

    @PersistenceContext
    private EntityManager manager;
    private boolean queryRealizada = false;

    public void salvar(Palavra palavra){
        System.out.println("DAO: A nova palavra é "+ palavra);
        manager.persist(palavra);
    }

    public Palavra obterPalavraPorId(int id){
        String jpql = "select p from Palavra p where id = :id";
        return manager.createQuery(jpql, Palavra.class).setParameter("id",id).getSingleResult();
    }

    public String obterNomePalavraPorId(int id){
       String jpql = "select p.nome from Palavra p where id = :id";
       return manager.createQuery(jpql, String.class).setParameter("id",id).getSingleResult();
    }

}
