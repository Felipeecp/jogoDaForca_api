package org.jogoDaForca.daos;

import org.jogoDaForca.models.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EnderecoDao {

    @PersistenceContext
    private EntityManager manager;

    public void inserirEndereco(Endereco endereco){
        manager.persist(endereco);
    }

    public List<Endereco> obterListaEnderecos(){
        String jpql = "select e from Endereco e";
        return manager.createQuery(jpql,Endereco.class).getResultList();
    }


}
