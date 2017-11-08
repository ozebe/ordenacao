/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class Arquivo {
    public static int[] carregarArquivo(String nome){
    try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // l� a primeira linha
            JOptionPane.showMessageDialog(null, "Sucesso ao ler dados do arquivo!");

// a vari�vel "linha" recebe o valor "null" quando o processo
// de repeti��o atingir o final do arquivo texto
            while (linha != null) {
                
                //a v�riavel local linha recebe os valores do arquivo e com o replace ela retira as virgulas do arquivo e susbstitui por espa�os " "
                linha = linha.replace(",", " ");

                //  JOptionPane.showMessageDialog(null, linha);
                String array[] = linha.split(" ");
                int vetor[] = new int[array.length];
                //esse m�todo for, realiza a convers�o da string array(que recebeu o valor da linha.split, ou seja, usou os espa�os para definir o come�o e final do n�mero)
                for (int i = 0; i < array.length; i++) {
                    vetor[i] = Integer.parseInt(array[i]);

                }
                  return vetor;
            }
          
            arq.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    int vetor[] = new int[2];
    vetor[0] = 0;
    vetor[1] = 0;
    vetor[2] = 0;
    return vetor;
}
    public static int salvarArquivo(String nome, String s){
       
  
    try{
    FileWriter arq = new FileWriter(nome);
    PrintWriter gravarArq = new PrintWriter(arq);
 
    gravarArq.printf(s);
    arq.close();
    return 1;
    } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
   
  }
    return 0;
}
}
