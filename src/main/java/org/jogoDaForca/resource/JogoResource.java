package org.jogoDaForca.resource;

import org.jogoDaForca.daos.PalavrasDao;
import org.jogoDaForca.daos.UsuarioDao;
import org.jogoDaForca.models.Palavra;
import org.jogoDaForca.models.Usuario;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

@Path("jogo")
public class JogoResource {

    @Inject
    private PalavrasDao palavrasDao;

    @Inject
    private UsuarioDao usuarioDao;

    @GET
    @Path("palavras")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Palavra> obterPalavrasJson(){
        return palavrasDao.obterPalavras();
    }

    @GET
    @Path("obterPalavraAleatoria")
    @Produces({MediaType.APPLICATION_JSON})
    public Palavra obterPalavraAleatoriaJson(){
        Random random = new Random();
        int idAleatorio = random.nextInt(10);
        return palavrasDao.obterPalavraPorId(idAleatorio);
    }

    @POST
    @Path("adicionarPalavra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response adicionaPalavra(Palavra palavra){
        try{
            palavrasDao.salvar(palavra);
            return Response.status(Response.Status.CREATED).entity(palavra).build();
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
            System.out.println(usuario);
            usuarioDao.salvar(usuario);
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
