package org.jogoDaForca.watchFile;

import org.jogoDaForca.daos.PalavrasDao;
import org.jogoDaForca.models.Palavra;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalavrasFile {

    public List<Palavra> lerDados(File file, Palavra novaPalavra){
        List<Palavra> palavras = new ArrayList<>();
        try(Scanner input = new Scanner(file)){
            List<String> tokens = List.of(input.nextLine().split(";"));
            novaPalavra.setCategoria(tokens.get(0));
            novaPalavra.setNome(tokens.get(1));
            palavras.add(novaPalavra);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return palavras;
    }

}
