
package Ordenacao;

import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conversor;
import static Ordenacao.OrdenacaoUI.copiaVet;
import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;

import java.util.Arrays;

/**
 *
 * @author Wesley
 */
class MergeSort implements Runnable {

    public void run() {
        MergeSort();
    }

    public void MergeSort() {
        barraProgresso.setVisible(true);
        barraProgresso.setIndeterminate(true);
        OrdenacaoUI.ordenando = 1;
        mergeSort(copiaVet, 0, copiaVet.length - 1);

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

    public static void mergeSort(int vet[], int ini, int fim) {
        if (ini < fim) {
            OrdenacaoUI.status.setText("Ordenando...");
            int meio = (ini + fim) / 2;
            mergeSort(vet, ini, meio);      // ordenar a primeira metade
            mergeSort(vet, meio + 1, fim);  // ordenar a segunda metade

            int A[], B[];
            A = Arrays.copyOfRange(vet, ini, meio + 1);
            B = Arrays.copyOfRange(vet, meio + 1, fim + 1);
            int i = 0, j = 0, pos = ini; // intercalar as partes:

            while (i < A.length || j < B.length) {
                if (i < A.length && j < B.length) {
                    if (A[i] < B[j]) {
                        vet[pos++] = A[i++];
                    } else {
                        vet[pos++] = B[j++];
                    }
                } else {
                    if (i < A.length) {
                        vet[pos++] = A[i++];
                    } else {
                        vet[pos++] = B[j++];
                    }
                }

            }
        }
    }
}
