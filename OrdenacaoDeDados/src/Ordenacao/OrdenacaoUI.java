/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;
//biblioteca especial que consegue manipular arquivos de forma mais fácil

import org.apache.commons.io.FileUtils;

import static Ordenacao.BubbleSort.bubbleSort;
import static Ordenacao.InsertionSort.insertionSort;
import static Ordenacao.MergeSort.mergeSort;
import static Ordenacao.MostrarVetor.mostrarVetor;

import static Ordenacao.PesquisaBinaria.pesquisaBinaria;
import static Ordenacao.PesquisaSequencial.pesquisaSequencial;
import static Ordenacao.QuickSort.quickSort;
import static Ordenacao.SelectionSort.selectionSort;
import com.bulenkov.darcula.DarculaLaf;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 *
 * @author Wesley
 */
public class OrdenacaoUI extends javax.swing.JFrame {

    
   
    public static String statusConversao = "";
    public static String nome;
    public static int[] vetor;
    public static int[] copiaVet;
    String array[];
    public static int trigger = 0;
    public static JFileChooser fc;
    
   
    Icon erroIcone = new ImageIcon(getToolkit().createImage(getClass().getResource("/Ordenacao/images/Erro.png")));
    Icon sucessoIcone = new ImageIcon(getToolkit().createImage(getClass().getResource("/Ordenacao/images/icons8-Sobre-32.png")));

    /**
     * Creates new form OrdenacaoUI
     */
    public OrdenacaoUI() {
        initComponents();
    }

    class MyCustomFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            //apenas diretórios e arquivos com extensão .txt
            return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
        }

        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Documentos de texto (*.txt)";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        carregar = new javax.swing.JButton();
        salvarArq = new javax.swing.JButton();
        metodosDeOrdenacao = new javax.swing.JButton();
        metodosDePesquisa = new javax.swing.JButton();
        resetar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarValoresOrdenados = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        fileChooser.setDialogTitle("");
        fileChooser.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ordenção de dados");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setIconImage(getToolkit().createImage(getClass().getResource("/Ordenacao/images/Ordenar.png")));
        setResizable(false);
        setSize(new java.awt.Dimension(769, 392));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Métodos de ordenação de dados");

        carregar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        carregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ordenacao/images/icons8-Import-32.png"))); // NOI18N
        carregar.setText("    Abrir");
        carregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carregarMouseEntered(evt);
            }
        });
        carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarActionPerformed(evt);
            }
        });

        salvarArq.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        salvarArq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ordenacao/images/icons8-Save-32.png"))); // NOI18N
        salvarArq.setText("   Salvar");
        salvarArq.setMaximumSize(new java.awt.Dimension(113, 48));
        salvarArq.setMinimumSize(new java.awt.Dimension(113, 48));
        salvarArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarArqActionPerformed(evt);
            }
        });

        metodosDeOrdenacao.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        metodosDeOrdenacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ordenacao/images/icons8-Ordenar-32.png"))); // NOI18N
        metodosDeOrdenacao.setText(" Ordenar");
        metodosDeOrdenacao.setMaximumSize(new java.awt.Dimension(113, 48));
        metodosDeOrdenacao.setMinimumSize(new java.awt.Dimension(113, 48));
        metodosDeOrdenacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodosDeOrdenacaoActionPerformed(evt);
            }
        });

        metodosDePesquisa.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        metodosDePesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ordenacao/images/icons8-Search-32.png"))); // NOI18N
        metodosDePesquisa.setText("Pesquisar");
        metodosDePesquisa.setMaximumSize(new java.awt.Dimension(88, 42));
        metodosDePesquisa.setMinimumSize(new java.awt.Dimension(88, 42));
        metodosDePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodosDePesquisaActionPerformed(evt);
            }
        });

        resetar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        resetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ordenacao/images/icons8-Reiniciar-32.png"))); // NOI18N
        resetar.setText("  Resetar");
        resetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ordenacao/images/icons8-Sobre-32.png"))); // NOI18N
        jButton1.setText("   Sobre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Versão 1.8");

        textarea.setEditable(false);
        textarea.setColumns(20);
        textarea.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textarea.setRows(5);
        jScrollPane3.setViewportView(textarea);

        mostrarValoresOrdenados.setEditable(false);
        mostrarValoresOrdenados.setColumns(20);
        mostrarValoresOrdenados.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mostrarValoresOrdenados.setRows(5);
        mostrarValoresOrdenados.setText("Arquivo não carregado!");
        jScrollPane1.setViewportView(mostrarValoresOrdenados);

        jLabel3.setText("criado por Ozebe e Jack |");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(metodosDePesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(metodosDeOrdenacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salvarArq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(348, 348, 348)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salvarArq, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(metodosDeOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(metodosDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarActionPerformed
        /*        
        nome = JOptionPane.showInputDialog("Informe a localização do arquivo");
        vetor = Arquivo.carregarArquivo(nome);
        copiaVet = copiarVetor.copiarVetor(vetor);
        mostrarArquivoCarregado.setText("Arquivo: " + nome);
        String valorConvertido = converter.toString(vetor);
        mostrarValoresDoArquivoCarregado.setText("Dados: " + valorConvertido); */
        
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
            try {
             
                // What to do with the file, e.g. display it in a TextArea
                textarea.read(new FileReader(file.getAbsolutePath()), null);
                //biblioteca especial apache FileUtils
                String conteudo = FileUtils.readFileToString(file, "UTF-8");
              
                conteudo = conteudo.replaceAll("\r", "");
                conteudo = conteudo.replaceAll("\t", " ");
                conteudo = conteudo.replaceAll("\n", "");
                conteudo = conteudo.replaceAll(",", " ");
                // char [] letras = conteudo.toCharArray();
                array = conteudo.split(" ");
                vetor = new int[array.length];
                //esse m�todo for, realiza a convers�o da string array(que recebeu o valor da linha.split, ou seja, usou os espa�os para definir o come�o e final do n�mero)
                for (int i = 0; i < array.length; i++) {
                    vetor[i] = Integer.parseInt(array[i]);
                   
                }
                copiaVet = copiarVetor.copiarVetor(vetor);
             
                String convertido = converter.toString(vetor);
                // JOptionPane.showMessageDialog(null, convertido);
                // JOptionPane.showMessageDialog(null, vetor.length);
                trigger = 1;
                
                mostrarValoresOrdenados.setText("Arquivo carregado!");
              
              
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado" + file.getAbsolutePath(), "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Arquivo inválido carregado" + "\n" +file.getAbsolutePath(), "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
                mostrarValoresOrdenados.setText("Arquivo inválido carregado");
                textarea.setText("Arquivo inválido carregado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);

        }
       
    }//GEN-LAST:event_carregarActionPerformed

    private void salvarArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarArqActionPerformed
        if (trigger == 1) {
             int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
           
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.print(converter.toString(copiaVet));
                JOptionPane.showMessageDialog(null, "Sucesso ao salvar\n" + file.getAbsolutePath(), "Sucesso", JOptionPane.INFORMATION_MESSAGE, sucessoIcone);
                printWriter.close();
            }catch(IOException ex) {
                
                JOptionPane.showMessageDialog(null, "Erro ao salvar" + file.getAbsolutePath(), "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
            }
            /*
            String nome = JOptionPane.showInputDialog("Informe onde deseja salvar o arquivo");
            String conv = converter.toString(copiaVet);
            Arquivo.salvarArquivo(nome, conv);
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!\n" + nome, "Salvar", JOptionPane.INFORMATION_MESSAGE);
            */
            
           
            /*
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
            */
        }
        }
    }//GEN-LAST:event_salvarArqActionPerformed

    private void metodosDeOrdenacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodosDeOrdenacaoActionPerformed
        if (trigger == 1) {

            Object[] Ordenacao = {"bubbleSort", "insertionSort", "selectionSort", "mergeSort", "quickSort"};
            Object metodoDeOrdenacaoSelecionado = JOptionPane.showInputDialog(null, "Escolha um método de ordenação", "Opções de ordenação", JOptionPane.INFORMATION_MESSAGE, null, Ordenacao, Ordenacao[0]);
            if (metodoDeOrdenacaoSelecionado == Ordenacao[0]) {
                long inicioMedicao = System.currentTimeMillis();
                bubbleSort(copiaVet);

                String valorConvertido = converter.toString(copiaVet);
                long finalMedicao = System.currentTimeMillis();
                long Medicao = finalMedicao - inicioMedicao;
                JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Foram necessários: " + Medicao + " Milisegundos para a ordenação", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                mostrarValoresOrdenados.setText("Vetor ordenado: " + valorConvertido);
            } else if (metodoDeOrdenacaoSelecionado == Ordenacao[1]) {
                long inicioMedicao = System.currentTimeMillis();
                insertionSort(copiaVet);

                String valorConvertido = converter.toString(copiaVet);
                long finalMedicao = System.currentTimeMillis();
                long Medicao = finalMedicao - inicioMedicao;
                JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Foram necessários: " + Medicao + " Milisegundos para a ordenação", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                mostrarValoresOrdenados.setText("Vetor ordenado: " + valorConvertido);
            } else if (metodoDeOrdenacaoSelecionado == Ordenacao[2]) {
                long inicioMedicao = System.currentTimeMillis();
                selectionSort(copiaVet);

                String valorConvertido = converter.toString(copiaVet);
                long finalMedicao = System.currentTimeMillis();
                long Medicao = finalMedicao - inicioMedicao;
                JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Foram necessários: " + Medicao + " Milisegundos para a ordenação", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                mostrarValoresOrdenados.setText("Vetor ordenado: " + valorConvertido);
            } else if (metodoDeOrdenacaoSelecionado == Ordenacao[3]) {
                long inicioMedicao = System.currentTimeMillis();
                mergeSort(copiaVet, 0, copiaVet.length - 1);

                String valorConvertido = converter.toString(copiaVet);
                long finalMedicao = System.currentTimeMillis();
                long Medicao = finalMedicao - inicioMedicao;
                JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Foram necessários: " + Medicao + " Milisegundos para a ordenação", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                mostrarValoresOrdenados.setText("Vetor ordenado: " + valorConvertido);
            } else if (metodoDeOrdenacaoSelecionado == Ordenacao[4]) {
                long inicioMedicao = System.currentTimeMillis();
                quickSort(copiaVet, 0, copiaVet.length - 1);

                String valorConvertido = converter.toString(copiaVet);
                long finalMedicao = System.currentTimeMillis();
                long Medicao = finalMedicao - inicioMedicao;
                JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Foram necessários: " + Medicao + " Milisegundos para a ordenação", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                mostrarValoresOrdenados.setText("Vetor ordenado: " + valorConvertido);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
        }
    }//GEN-LAST:event_metodosDeOrdenacaoActionPerformed

    private void metodosDePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodosDePesquisaActionPerformed
        if (trigger == 1) {

            Object[] metodosPequisa = {"Pesquisa Sequencial", "Pesquisa Binária"};
            Object pesquisaSelecionada = JOptionPane.showInputDialog(null, "Escolha um método de pesquisa", "Opções de pesquisa", JOptionPane.INFORMATION_MESSAGE, null, metodosPequisa, metodosPequisa[0]);
            if (pesquisaSelecionada == metodosPequisa[0]) {
                String pesquisarNoVetor = JOptionPane.showInputDialog("Informe o valor que deseja pesquisa");
                int converterValorParaPesquisar = Integer.parseInt(pesquisarNoVetor);
                int resultadoDaPesquisa = pesquisaSequencial(copiaVet, converterValorParaPesquisar);
                if (resultadoDaPesquisa == -1) {
                    JOptionPane.showMessageDialog(null, "O valor " + converterValorParaPesquisar + " não pode ser encontrado no vetor",
                            "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
                } else {
                    JOptionPane.showMessageDialog(null, "Valor pesquisado: " + converterValorParaPesquisar + "\nEncontrado na posição: " + resultadoDaPesquisa);
                }

            }

            if (pesquisaSelecionada == metodosPequisa[1]) {
                String pesquisarNoVetor = JOptionPane.showInputDialog("Informe o valor que deseja pesquisar");
                int converterValorParaPesquisar = Integer.parseInt(pesquisarNoVetor);
                int resultadoDaPesquisa = pesquisaBinaria(copiaVet, converterValorParaPesquisar);
                if (resultadoDaPesquisa == -1) {
                    JOptionPane.showMessageDialog(null, "O valor " + converterValorParaPesquisar + " não pode ser encontrado no vetor",
                            "Sucesso", JOptionPane.ERROR_MESSAGE, erroIcone);
                } else {
                    JOptionPane.showMessageDialog(null, "Valor pesquisado: " + converterValorParaPesquisar + "\nEncontrado na posição: " + resultadoDaPesquisa);
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
        }
    }//GEN-LAST:event_metodosDePesquisaActionPerformed

    private void resetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetarActionPerformed
        if (trigger == 1) {
            copiaVet = copiarVetor.copiarVetor(vetor);

            JOptionPane.showMessageDialog(null, "Vetor resetado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            mostrarValoresOrdenados.setText("Vetor não ordenado");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
        }
    }//GEN-LAST:event_resetarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (trigger == 1) {
            int tam = vetor.length;
            JOptionPane.showMessageDialog(null, "Tamanho do vetor: " + tam + " posições", "Sobre o arquivo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void carregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarMouseEntered
        carregar.setToolTipText("Carregar Arquivo");
    }//GEN-LAST:event_carregarMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdenacaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenacaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenacaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenacaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                BasicLookAndFeel darcula = new DarculaLaf();
             //   if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(darcula);
                  //  break;
               // }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenacaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new OrdenacaoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton carregar;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton metodosDeOrdenacao;
    public javax.swing.JButton metodosDePesquisa;
    private static javax.swing.JTextArea mostrarValoresOrdenados;
    public javax.swing.JButton resetar;
    public javax.swing.JButton salvarArq;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
