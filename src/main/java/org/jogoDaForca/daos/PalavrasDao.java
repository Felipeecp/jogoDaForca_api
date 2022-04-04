package org.jogoDaForca.daos;

import org.jogoDaForca.models.Palavra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PalavrasDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Palavra palavra){
        manager.persist(palavra);
    }

    public Palavra obterPalavraPorId(int id){
        String jpql = "select p from Palavra p where id = :id";
        return manager.createQuery(jpql, Palavra.class).setParameter("id",id).getSingleResult();
    }

    public List<Palavra> obterPalavras() {
        String jpql = "select p from Palavra p";
        return manager.createQuery(jpql,Palavra.class).getResultList();
    }
}
