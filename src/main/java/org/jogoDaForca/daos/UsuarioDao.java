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

//            String jqpl = "select u from Usuario u where email = :email and senha = :senha";
            String jpql = "select u from Usuario u where email";
            return manager.createQuery(jpql,Usuario.class).setParameter("email",email )
                    .setParameter("senha",senha).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public List<Usuario> obterRanking(){
        String jpql = "select u from Usuario u order by pontos";
        return manager.createQuery(jpql, Usuario.class).setMaxResults(5).getResultList();
    }

    public Usuario atualizarPontosUsuario(Integer id, Integer pontos){
        String jpql = "update Usuario set pontos = :pontos where id = :id";
        return manager.createQuery(jpql, Usuario.class)
                .setParameter("id", id)
                .setParameter("pontos",pontos)
                .getSingleResult();
    }
}
