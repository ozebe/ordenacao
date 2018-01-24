/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
