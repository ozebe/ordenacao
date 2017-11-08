package Ordenacao;






/**
 *
 * @author Wesley e Jackson
 */
public class InsertionSort {

    public static void insertionSort(int[] vet) {
        int mov = 0;
        for (int i = 0; i < vet.length; i++) {
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
