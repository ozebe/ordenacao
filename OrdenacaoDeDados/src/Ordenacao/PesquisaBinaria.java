
package Ordenacao;

/**
 *
 * @author Wesley e Jackson
 */
public class PesquisaBinaria {

    public static int pesquisaBinaria(int[] vetor, int x) {
        return pesquisaBinariaAuxiliar(vetor, 0, vetor.length - 1, x);
    }

    public static int pesquisaBinariaAuxiliar(int[] vetor, int inf, int sup, int x) {
        int meio;
        if (inf <= sup) {
            meio = (inf + sup) / 2;
            if (x == vetor[meio]) {
                return meio;
            } else if (x < vetor[meio]) {
                return pesquisaBinariaAuxiliar(vetor, inf, meio - 1, x);
            } else {
                return pesquisaBinariaAuxiliar(vetor, meio + 1, sup, x);
            }
        } else {
            return -1;
        }
    }

}
