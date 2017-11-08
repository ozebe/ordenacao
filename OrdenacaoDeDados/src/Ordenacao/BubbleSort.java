package Ordenacao;





import static Ordenacao.Swap.swap;

/**
 *
 * @author Wesley e Jackson
 */
public class BubbleSort {

    public static void bubbleSort(int[] vet) {

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
            }
        }

    }
}
