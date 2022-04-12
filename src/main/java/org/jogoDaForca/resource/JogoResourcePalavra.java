package org.jogoDaForca.resource;

import org.jogoDaForca.daos.PalavrasDao;
import org.jogoDaForca.models.Palavra;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

@Path("jogo/palavra")
public class JogoResourcePalavra {

    @Inject
    private PalavrasDao palavrasDao;

    @GET
    @Path("listarPalavras")
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

}
