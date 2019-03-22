
package Ordenacao;

import static Ordenacao.OrdenacaoUI.array;
import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conteudo;
import static Ordenacao.OrdenacaoUI.copiaVet;

import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;

import static Ordenacao.OrdenacaoUI.trigger;
import static Ordenacao.OrdenacaoUI.vetor;
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
        
        if(conteudo.matches(".*[a-zA-Z/[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]/].*")){
             error01Transparent32px("Arquivo inválido carregado" + "\n" + "Verificar se existem letras ou símbolos no arquivo!", "Erro");
             conteudo = null;
        } else{
        array = conteudo.split(" ");
        vetor = new int[array.length];
        
        //esse método for, realiza a convers�o da string array(que recebeu o valor da linha.split, ou seja, usou os espa�os para definir o come�o e final do n�mero)
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
}
