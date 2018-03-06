
package Ordenacao;

/**
 *
 * @author Wesley
 */
public class copiarVetor {
    public static int[] copiarVetor(int[] vetor){ //era int
        int[] vetorCopiado = new int[vetor.length];
        System.arraycopy(vetor, 0, vetorCopiado, 0, vetor.length);
        return vetorCopiado;
    }
}
