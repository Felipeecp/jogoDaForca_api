package org.jogoDaForca.daos;

import org.jogoDaForca.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UsuarioDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Usuario usuario){
        System.out.println(usuario);
        manager.persist(usuario);
    }

    public List<Usuario> listarUsuarios(){
        String jpql = "select u from Usuario u";
        return manager.createQuery(jpql, Usuario.class).getResultList();
    }

    public Usuario buscarUsuario(String email, String senha){
        try{
            String jqpl = "select u from Usuario u where email = :email and senha = :senha";
            return manager.createQuery(jqpl,Usuario.class).setParameter("email",email )
                    .setParameter("senha",senha).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

}
