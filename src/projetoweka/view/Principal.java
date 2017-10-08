/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoweka.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import projetoweka.controller.DadosController;
import projetoweka.controller.PerguntasController;
import projetoweka.model.Relatorio;

/**
 *
 * @author farofa
 */
public class Principal extends javax.swing.JFrame {
    private DadosController mainController;
    private PerguntasController perguntasController;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        this.mainController = new DadosController();
        this.perguntasController = new PerguntasController();
        
        initComponents();
	
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuDados = new javax.swing.JMenu();
        menuDadosARFF = new javax.swing.JMenuItem();
        menuDadosPerguntas = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuRelatoriosDados = new javax.swing.JMenuItem();
        menuRelatoriosArvoreDeDecisao = new javax.swing.JMenuItem();
        menuQuiz = new javax.swing.JMenu();
        menuQuizFazer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modo de Operação");

        jLabel2.setText("1 - Importar Dados (arff)");

        jLabel3.setText("2 - Importar Formulario");

        jLabel4.setText("     Prestar atenção na formatação do arquivo");

        jLabel5.setText("3 - Realizar Quiz");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Alunos");

        jLabel7.setText("Rogério Eduardo Pereira");

        jLabel8.setText("Heverton Nonato Ferreira");

        menuDados.setText("Importar Dados");

        menuDadosARFF.setText("Importar ARFF");
        menuDadosARFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDadosARFFActionPerformed(evt);
            }
        });
        menuDados.add(menuDadosARFF);

        menuDadosPerguntas.setText("Importar Perguntas");
        menuDadosPerguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDadosPerguntasActionPerformed(evt);
            }
        });
        menuDados.add(menuDadosPerguntas);

        jMenuBar1.add(menuDados);

        menuRelatorios.setText("Relatórios");

        menuRelatoriosDados.setText("Dados");
        menuRelatoriosDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatoriosDadosActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuRelatoriosDados);

        menuRelatoriosArvoreDeDecisao.setText("Árvore de Decisão (J48)");
        menuRelatoriosArvoreDeDecisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatoriosArvoreDeDecisaoActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuRelatoriosArvoreDeDecisao);

        jMenuBar1.add(menuRelatorios);

        menuQuiz.setText("Quiz");

        menuQuizFazer.setText("Fazer Quiz");
        menuQuizFazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuizFazerActionPerformed(evt);
            }
        });
        menuQuiz.add(menuQuizFazer);

        jMenuBar1.add(menuQuiz);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuRelatoriosDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatoriosDadosActionPerformed
        try{
            String relatorio = mainController.imprimeDados();
        
            Relatorio model = new Relatorio("Dados Inicial", relatorio);
            new Relatorios(model).setVisible(true);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(
                                            this, 
                                            "Erro ao gerar relatório, provavelmente você não importou os dados"+
                                                    "\nErro: "+ex.getMessage()+
                                                    "\nCausa: "+ex.getCause(), 
                                            "Erro", 
                                            JOptionPane.INFORMATION_MESSAGE, 
                                            new ImageIcon("img/error-circle.png")
                                        );
        }
    }//GEN-LAST:event_menuRelatoriosDadosActionPerformed

    private void menuRelatoriosArvoreDeDecisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatoriosArvoreDeDecisaoActionPerformed
        new ConfiguracoesArvoreDeDecisao(mainController).setVisible(true);
    }//GEN-LAST:event_menuRelatoriosArvoreDeDecisaoActionPerformed

    private void menuDadosARFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDadosARFFActionPerformed
        new BuscaArquivoDados().setVisible(true);
    }//GEN-LAST:event_menuDadosARFFActionPerformed

    private void menuDadosPerguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDadosPerguntasActionPerformed
        new BuscaArquivoPerguntas().setVisible(true);
    }//GEN-LAST:event_menuDadosPerguntasActionPerformed

    private void menuQuizFazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuizFazerActionPerformed
        new Quiz().setVisible(true);
    }//GEN-LAST:event_menuQuizFazerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuDados;
    private javax.swing.JMenuItem menuDadosARFF;
    private javax.swing.JMenuItem menuDadosPerguntas;
    private javax.swing.JMenu menuQuiz;
    private javax.swing.JMenuItem menuQuizFazer;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenuItem menuRelatoriosArvoreDeDecisao;
    private javax.swing.JMenuItem menuRelatoriosDados;
    // End of variables declaration//GEN-END:variables
}
