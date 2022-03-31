package org.jogoDaForca.beans;

import org.jogoDaForca.daos.PalavrasDao;
import org.jogoDaForca.models.Palavra;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class AdminPalavrasBean {
    private Palavra palavra = new Palavra();

    @Inject
    private PalavrasDao palavraDao;

    @Transactional
    public void salvar(){
        palavraDao.salvar(palavra);
        System.out.println("Nova palavra adicionada: " + palavra);
    }

    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }
}
