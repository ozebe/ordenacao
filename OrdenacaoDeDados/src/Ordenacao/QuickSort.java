
package Ordenacao;

import static Ordenacao.OrdenacaoUI.barraProgresso;
import static Ordenacao.OrdenacaoUI.conversor;
import static Ordenacao.OrdenacaoUI.copiaVet;
import static Ordenacao.OrdenacaoUI.mostrarValoresOrdenados;


/**
 *
 * @author Wesley
 */
class QuickSort implements Runnable {


    public void run() {
        QuickSort();
    }

    public void QuickSort() {
        barraProgresso.setVisible(true);
        barraProgresso.setIndeterminate(true);
        OrdenacaoUI.ordenando = 1;
        quickSort(copiaVet, 0, copiaVet.length - 1);
        
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
    
    public static void quickSort(int v[], int ini, int fim) {

        int posPilha;
        int j;

        int[] pilhaEsq = new int[fim - ini + 1];
        int[] pilhaDir = new int[fim - ini + 1];
        pilhaEsq[0] = ini;
        pilhaDir[0] = fim;
        posPilha = 0;

        while (posPilha >= 0) {
            OrdenacaoUI.status.setText("Ordenando...");
            ini = pilhaEsq[posPilha];
            fim = pilhaDir[posPilha];
            --posPilha;
            if (ini < fim) {
                j = ordena(v, ini, fim);
                ++posPilha;
                pilhaEsq[posPilha] = ini;
                pilhaDir[posPilha] = j - 1;
                ++posPilha;
                pilhaEsq[posPilha] = j + 1;
                pilhaDir[posPilha] = fim;
            }
            
        }
    }
    
    
     private static int ordena(int v[], int ini, int fim) {
        int i = ini + 1; // vari�vel utilizada para percorer o vetor v da esquerda para a direita partindo do in�cio + 1
        int j = fim; // vari�vel utilizada para percorer o vetor v da direita para a esquerda partindo do fim 
        int pivo = v[ini]; // o pivo inicia-se do primeiro elemento do vetor 
        int aux;
        while (i <= j) {
            if (v[i] <= pivo) {
                ++i;
            } else if (pivo < v[j]) {
                --j;
            } else {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                ++i;
                --j;
            }
            
        }
        // agora i == j+1                 
        v[ini] = v[j];
        v[j] = pivo;
        return j;
    }
}
