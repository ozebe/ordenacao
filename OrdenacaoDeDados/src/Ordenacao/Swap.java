package Ordenacao;






/**
 *
 * @author Wesley e Jackson
 */
public class Swap {

    public static void swap(int[] vet, int i, int j) {
        int aux = vet[i];
        vet[i] = vet[i + 1];
        vet[i + 1] = aux;
    }
}
