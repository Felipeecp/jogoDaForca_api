package org.jogoDaForca.resource;

import org.jogoDaForca.daos.PalavrasDao;
import org.jogoDaForca.models.Palavra;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("palavras")
public class PalavraResource {

    @Inject
    private PalavrasDao dao;

    private Random random = new Random();
    private int idAleatorio = random.nextInt(10);

    @GET
    @Path("palavraAleatoria")
    @Produces({MediaType.APPLICATION_JSON})
    public Palavra obterPalavraJson(){
        return dao.obterPalavraPorId(idAleatorio);
    }

}
