package org.jogoDaForca.resource;

import org.jogoDaForca.daos.EnderecoDao;
import org.jogoDaForca.daos.UsuarioDao;
import org.jogoDaForca.models.Endereco;
import org.jogoDaForca.models.Usuario;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("jogo/usuario")
public class jogoResourceUsuario {

    @Inject
    private UsuarioDao usuarioDao;

    @Inject
    private EnderecoDao enderecoDao;

    @GET
    @Path("obterListaEnderecosJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> obterListaEnderecosJson(){
        return enderecoDao.obterListaEnderecos();
    }


    @GET
    @Path("obterRanking")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> obterRakingJson() {return usuarioDao.obterRanking();}

    @POST
    @Path("inserirEndereco")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response inserEnderecoJson(Endereco endereco){
        try{
            enderecoDao.inserirEndereco(endereco);
            return Response.status(Response.Status.CREATED).entity(endereco).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("adicionarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response cadastrarUsuario(Usuario usuario){
        try{
            usuarioDao.salvar(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("atualizarPontosUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarPontosUsuario(Usuario usuario){
        try{
            usuarioDao.atualizarPontosUsuario(usuario.getId(), usuario.getPontos());
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarUsuario(Usuario usuario){
        Usuario resultadoUsuario = usuarioDao.buscarUsuario(usuario.getEmail(), usuario.getSenha());
        if(resultadoUsuario!=null){
            return Response.status(Response.Status.CREATED).entity(resultadoUsuario).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario não cadastrado").build();
    }
}
