
package Ordenacao;

import static Ordenacao.InsertionSort.insertionSort;
import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conversor;
import static Ordenacao.OrdenacaoUI.copiaVet;
import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;


/**
 *
 * @author Wesley
 */
class InsertionSort implements Runnable {

    public void run() {
        InsertionSort();
    }

    public void InsertionSort() {
        barraProgresso.setVisible(true);
        barraProgresso.setIndeterminate(true);
        OrdenacaoUI.ordenando = 1;
        insertionSort(copiaVet);
        
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
    
    public static void insertionSort(int[] vet) {
        int mov = 0;
        for (int i = 0; i < vet.length; i++) {
            OrdenacaoUI.status.setText("Ordenando...");
            int eleito = vet[i];
            int j = i - 1;
            while (j >= 0 && vet[j] > eleito) {
                vet[j + 1] = vet[j];
                j--;
            }
            vet[j + 1] = eleito;
            mov += 3;

        }

    }

   
}
