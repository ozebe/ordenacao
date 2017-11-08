package Ordenacao;






import static Ordenacao.Swap.swap;

/**
 *
 * @author Wesley e Jackson
 */
public class SelectionSort {

    public static void selectionSort(int vet[]) {
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
}
