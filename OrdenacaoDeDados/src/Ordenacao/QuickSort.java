package Ordenacao;




/**
 *
 * @author Wesley e Jackson
 */
public class QuickSort {

    public static void quickSort(int v[], int ini, int fim) {

        int posPilha;
        int j;

        int[] pilhaEsq = new int[fim - ini + 1];
        int[] pilhaDir = new int[fim - ini + 1];
        pilhaEsq[0] = ini;
        pilhaDir[0] = fim;
        posPilha = 0;

        while (posPilha >= 0) {
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
