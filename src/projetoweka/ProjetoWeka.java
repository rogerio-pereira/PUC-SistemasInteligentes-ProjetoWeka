/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoweka;

import projetoweka.test.testeWeka;
import projetoweka.view.BuscaArquivo;
import projetoweka.view.controller.LookAndFeelController;

/**
 *
 * @author al550385669
 */
public class ProjetoWeka {
    
    private static String caminhoDados;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*caminhoDados = "arquivos/iris.arff";
        
        testeWeka exemplo = new testeWeka(caminhoDados);
        
        exemplo.leDados();
        exemplo.imprimeDados();
        //exemplo.arvoreDeDecisaoJ48();
        //exemplo.InstanceBased();*/
        
        LookAndFeelController.setLookAndFeel();
        
        new BuscaArquivo().setVisible(true);
    }
    
}
