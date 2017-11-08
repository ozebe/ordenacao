
package Ordenacao;

/**
 *
 * @author Wesley e Jackson
 */
public class PesquisaSequencial {

    public static int pesquisaSequencial(int vetor[], int x) {
        int i;
        for (i = 0; i < vetor.length; i++) {

            if (vetor[i] == x) {

                return i;
            }
        }
        return -1;
    }
}
