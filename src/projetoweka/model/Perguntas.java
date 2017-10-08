/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoweka.model;

import java.util.ArrayList;

/**
 *
 * @author farofa
 */
public class Perguntas {
    private String pergunta;
    private String[] alternativas;

    public Perguntas(String pergunta, String[] alternativas) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }
    
    @Override
    public String toString()
    {
        String toString = "";
        
        toString = this.getPergunta();
            
        for(String alternativa : this.getAlternativas())
            toString = toString + "\n\t"+alternativa;
        
        return toString;
    }
}
