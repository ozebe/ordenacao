package Ordenacao;




import javax.swing.JOptionPane;

/**
 *
 * @author Wesley e Jackson
 */
public class MostrarVetor {

    public static void mostrarVetor(int[] vetor) {
        String converter = "";
        for (int i = 0; i < vetor.length; i++) {

            converter += Integer.toString(vetor[i]) + ", ";

        }
        JOptionPane.showMessageDialog(null, converter);

    }
}
