/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import static Ordenacao.OrdenacaoUI.array;
import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conteudo;
import static Ordenacao.OrdenacaoUI.copiaVet;
import static Ordenacao.OrdenacaoUI.fileChooser;
import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;
import static Ordenacao.OrdenacaoUI.textarea;
import static Ordenacao.OrdenacaoUI.trigger;
import static Ordenacao.OrdenacaoUI.vetor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import static out.transparent.error.ErrorOutJOptions.error01Transparent32px;

/**
 *
 * @author Wesley
 */
class FileProcessor implements Runnable {
//modificar
    public void run() {
        processFile();
    }

    public void processFile() {
        barraProgresso.setVisible(true);

        conteudo = conteudo.replaceAll("\r", "");
        conteudo = conteudo.replaceAll("\t", " ");
        conteudo = conteudo.replaceAll("\n", "");
        conteudo = conteudo.replaceAll(",", " ");

        array = conteudo.split(" ");
        vetor = new int[array.length];

        //esse m�todo for, realiza a convers�o da string array(que recebeu o valor da linha.split, ou seja, usou os espa�os para definir o come�o e final do n�mero)
        for (int i = 0; i < array.length; i++) {
            vetor[i] = Integer.parseInt(array[i]);
            barraProgresso.setIndeterminate(true);
        }

        copiaVet = copiarVetor.copiarVetor(vetor);

        //não é utilizado
        //String convertido = converter.toString(vetor);
        trigger = 1;

        mostrarValoresOrdenados.setText("Arquivo carregado!");
        barraProgresso.setIndeterminate(false);
        barraProgresso.setVisible(false);
    }
}
