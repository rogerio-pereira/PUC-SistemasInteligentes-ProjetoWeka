/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoweka.test;

import java.util.Random;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Attribute;

/**
 *
 * @author al550385669
 */
public class testeWeka {
    private String caminhoDados;
    private Instances dados;

    /**
     * Define o caminho dos dados a serem lidos
     * @param cominhoDados Caminho dos dados
     */
    public testeWeka(String caminhoDados) {
        this.caminhoDados = caminhoDados;
    }
    
    /**
     * Le os dados, se a definição de classe não for a primeira, então define como sendo a ultima
     * @throws Exception 
     */
    public void leDados() throws Exception
    {
        DataSource fonte =  new DataSource(caminhoDados);
       
        /*
            Arquivo prioritário: .arff (suporta: csv, xrff, tabelas de BD relacionais)
            DataSource examina o formato da BD entrada e usa o conversor adequado para importar para a memória
        */
        dados = fonte.getDataSet();
       
        if(dados.classIndex() == -1)
            //Define o atributo que representa a Classe  (índices)
            dados.setClassIndex(dados.numAttributes() -1);
    }
    
    /**
     * Percorre todos os dados imprimindo na tela
     */
    public void imprimeDados()
    {
        System.out.println("Dados Inicial:");
        
        for(int i=0; i<dados.numInstances(); i++) {            
            Instance atual = dados.instance(i);
            System.out.println((i + 1) + ": " + atual);
        }
        
        System.out.println("");
    }
    
    /**
     * Gera arvore de decisão
     * @throws Exception 
     */
    public void arvoreDeDecisaoJ48() throws Exception
    {
        //Cria uma nova instância da árvore
        J48 tree = new J48();
        
        //Constrói o classificador
        tree.buildClassifier(dados);
        
        System.out.println("Arvore Inicial:");
        System.out.println(tree);
        
        
        //AVALIAÇÃO NORMAL
        System.out.println("\nAvaliação Inicial");
        Evaluation avaliacao = new Evaluation(dados);
        
        //Avalia o resultado
        avaliacao.evaluateModel(tree, dados);
        System.out.println("-->    Instancias    corretas:    " + avaliacao.correct() + "\n");
        
        
        //AVALIAÇÃO CRUZADA
        System.out.println("Avaliacao cruzada: \n");
        Evaluation avalCruzada;
        avalCruzada = new Evaluation(dados);
        
        /*
         * PARAMETROS
         * Classificador
         * Conjunto de exemplos
         * Folds (x-1 treinamentos, 1 teste)
         * Número randomico
         */
        avalCruzada.crossValidateModel(tree, dados, 10, new Random(1));
        System.out.println("-->    Instancias    corretas    CV:    "+avalCruzada.correct() + "\n");
        
        
        /* 
         * OPÇÕES DO CONJUNTO
         * -t:  nome do arquivo com o conjunto de teste
         * -c:  índice do atributo classe
         * -x:  nº de folds para o cross-validation(default: 10)
         * -m:  nome do arquivo contendo uma matriz de custos...
         *      Outras opções.... (http://weka.sourceforge.net/doc/weka/classifiers/Evaluation.html)
         */
        System.out.println("Chamada de linha de código: \n");
        String[] options = new String[2];
        options[0] = "-t";
        options[1] = caminhoDados; //Nome do arquivo com o conjunto de treinamento

        System.out.println(Evaluation.evaluateModel(new J48(),options));
    }
    
    public void InstanceBased() throws Exception 
    {
        //Construção do modelo classificador – 3NN
        IBk k3 = new IBk(3);
        k3.buildClassifier(dados);
        
        //Criando uma nova instância
        Instance newInst = new Instance(5);
        newInst.setDataset(dados);
        newInst.setValue(0, 3);
        newInst.setValue(1, 3.5);
        newInst.setValue(2, 8.2);
        newInst.setValue(3, 1.4);
        newInst.setValue(4, "Iris-versicolor");
        
        //Classificando a nova instância com base no IBK
        double pred = k3.classifyInstance(newInst);
        
        //Imprimindo valor de predição
        System.out.println("Predição: " + pred);
        
        //Imprimindo o nome da classe de predição
        Attribute a = dados.attribute(4);
        String predClass = a.value((int) pred);
        System.out.println("Predição: " + predClass);
    }
}
