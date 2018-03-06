
package Ordenacao;

import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conversor;
import static Ordenacao.OrdenacaoUI.copiaVet;
import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;
import static Ordenacao.SelectionSort.selectionSort;


/**
 *
 * @author Wesley
 */
class SelectionSort implements Runnable {

    public void run() {
        SelectionSort();
    }

    public void SelectionSort() {
        barraProgresso.setVisible(true);
        barraProgresso.setIndeterminate(true);
        OrdenacaoUI.ordenando = 1;
        selectionSort(copiaVet);

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
    
     public static void selectionSort(int vet[]) {
         OrdenacaoUI.status.setText("Ordenando...");
        for (int i = 0; i < vet.length - 1; i++) {
            int p = 1;
            for (int j = i + 1; j < vet.length; j++) {
                if (vet[j] < vet[p]) {
                    p = j;
                }

            }
            if (p != i) {
                swap(vet, i, i + 1);
            }
        }
    }
     
     public static void swap(int[] vet, int i, int j) {
        int aux = vet[i];
        vet[i] = vet[i + 1];
        vet[i + 1] = aux;
    }

    
}