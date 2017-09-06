/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoweka.controller;

import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author farofa
 */
public class MainController {
    private String caminhoDados;
    private Instances dados;

    /**
     * Construtor
     * @param cominhoDados Caminho dos dados
     * @throws Exception 
     */
    public MainController(String caminhoDados) throws Exception {
        this.caminhoDados = caminhoDados;
        setDados();
    }
    
    /**
     * Le os dados, se a definição de classe não for a primeira, então define como sendo a ultima
     * @throws Exception 
     */
    private void setDados() throws Exception
    {
        DataSource fonte =  new DataSource(this.caminhoDados);
        this.dados = fonte.getDataSet();
       
        if(this.dados.classIndex() == -1)
            //Define o atributo que representa a Classe  (índices)
            this.dados.setClassIndex(this.dados.numAttributes() -1);
    }
    
    /**
     * Percorre todos os dados imprimindo na tela
     */
    public String imprimeDados()
    {
        String retorno = "";
        
        for(int i=0; i<this.dados.numInstances(); i++) {            
            Instance atual = this.dados.instance(i);
            
            retorno = retorno + (i + 1) + ": " + atual+"\n";
        }
        
        return retorno;
    }
    
    /**
     * Gera arvore de decisão
     * @throws Exception 
     */
    public String imprimeArvoreDeDecisao(boolean avaliacaoNormal, boolean avaliacaoCruzada, int folds, String[] options) throws Exception
    {
        String retorno = "";
        
        //Cria uma nova instância da árvore
        J48 tree = new J48();
        
        //Constrói o classificador
        tree.buildClassifier(this.dados);
        
        retorno = retorno + "Arvore Inicial:\n";
        retorno = retorno + tree;
        
        if(avaliacaoNormal == true)
            retorno = retorno + this.imprimeAvaliacaoNormalDaArvoreDeDecisao(tree);
        
        if(avaliacaoCruzada == true)
            retorno = retorno + this.imprimeAvaliacaoCruzadaDaArvoreDeDecisao(tree, folds);
        
        if(options != null)
        {
            retorno = retorno + this.avaliacaoDoModelo(options);
        }
        
        return retorno;
    }
    
    /**
     * Gera Avaliação normal da árvore de decisão
     * @param tree
     * @return 
     */
    private String imprimeAvaliacaoNormalDaArvoreDeDecisao(J48 tree) throws Exception
    {
        String retorno = "";
        //AVALIAÇÃO NORMAL
        retorno = retorno + "\n\nAvaliação Inicial\n";
        Evaluation avaliacao = new Evaluation(this.dados);
        
        //Avalia o resultado
        avaliacao.evaluateModel(tree, this.dados);
        retorno = retorno + "-->    Instancias    corretas:    " + avaliacao.correct() + "\n";
        
        return retorno;
    }
    
    
    /**
     * Gera Avaliação cruzada da árvore de decisão
     * @param tree
     * @return 
     */
    private String imprimeAvaliacaoCruzadaDaArvoreDeDecisao(J48 tree, int folds) throws Exception
    {
        String retorno = "";
        
        retorno = retorno + "\n\nAvaliacao cruzada: \n";
        Evaluation avalCruzada;
        avalCruzada = new Evaluation(this.dados);
        
        avalCruzada.crossValidateModel(tree, this.dados, folds, new Random(1));
        retorno = retorno + "\n-->    Instancias    corretas    CV:    "+avalCruzada.correct() + "\n";
        
        return retorno;
    }
    
    
    /**
     * Gera Avaliação do modelo da árvore de decisão
     * @param tree
     * @return 
     */
    private String avaliacaoDoModelo(String[] options) throws Exception
    {
        String retorno = "";
        
        retorno = retorno + "\n\nChamada de linha de código: \n";

        retorno = retorno + Evaluation.evaluateModel(new J48(),options);
        
        
        return retorno;
    }
}
