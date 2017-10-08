/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoweka.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import projetoweka.model.Perguntas;

/**
 *
 * @author farofa
 */
public class PerguntasController {
    private static ArrayList<Perguntas> perguntas  = new ArrayList<Perguntas>();

    public static ArrayList<Perguntas> getPerguntas() {
        return perguntas;
    }
    
    /**
     * Le os dados, se a definição de classe não for a primeira, então define como sendo a ultima
     * @throws Exception 
     */
    public void setPerguntas(String caminhoDados) throws Exception
    {
        String texto = leArquivo(caminhoDados);
        
        String[] perguntas = texto.split("%%%");
        
        for(String perguntaAlternativas: perguntas){
            String[] perguntaExploded = perguntaAlternativas.split(":");
            
            String pergunta = perguntaExploded[0];
            String[] alternativas = perguntaExploded[1].split(";");
            
            
            this.perguntas.add(new Perguntas(pergunta, alternativas));
        }
    }
    
    private String leArquivo(String caminhoDados) throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(caminhoDados));
        String texto = "";
        
        while(br.ready()){
            texto = texto + br.readLine();
        }
        br.close();
        
        return texto;
    }
    
    public void imprimePerguntas()
    {
        for(Perguntas pergunta : this.perguntas) {
            System.out.println(pergunta.toString());
            
            System.out.println("");
        }
    }
}
