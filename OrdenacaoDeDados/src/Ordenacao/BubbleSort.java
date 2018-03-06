
package Ordenacao;

import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conversor;
import static Ordenacao.OrdenacaoUI.copiaVet;
import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;

/**
 *
 * @author Wesley
 */
class BubbleSort implements Runnable {

    public void run() {
        intToString();
    }

    public void intToString() {
        barraProgresso.setVisible(true);
        OrdenacaoUI.ordenando = 1;
        barraProgresso.setIndeterminate(true);
        int[] vet = copiaVet;
        int movimentacao = 0;
        boolean troca = true;
        int tam = vet.length;
        while (troca) {
            troca = false;
            tam--;
            for (int i = 0; i < tam; i++) {
                if (vet[i] > vet[i + 1]) {
                    swap(vet, i, i + 1);
                    movimentacao += 3;
                    troca = true;
                }
                
                OrdenacaoUI.status.setText("Ordenando...");
            }
        }

        String converter = "";
        for (int i = 0; i < copiaVet.length; i++) {
            converter += Integer.toString(copiaVet[i]) + ",";
           
            OrdenacaoUI.status.setText("Convertendo...");
        }

        OrdenacaoUI.conversor = converter;
        mostrarValoresOrdenados.setText("Vetor ordenado: " + conversor);
        barraProgresso.setIndeterminate(false);
        barraProgresso.setVisible(false);
        OrdenacaoUI.status.setText("");
        OrdenacaoUI.ordenando = 0;
    }

    public static void swap(int[] vet, int i, int j) {
        int aux = vet[i];
        vet[i] = vet[i + 1];
        vet[i + 1] = aux;
    }
}
