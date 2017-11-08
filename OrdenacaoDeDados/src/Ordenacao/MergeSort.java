package Ordenacao;






import java.util.Arrays;

/**
 *
 * @author Wesley e jackson
 */
public class MergeSort {

    public static void mergeSort(int vet[], int ini, int fim) {
        if (ini < fim) {
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
