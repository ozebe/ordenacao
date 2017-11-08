
package Ordenacao;



public class converter {
    public static String toString(int[] vetor) {
        String converter = "";
        for (int i = 0; i < vetor.length; i++) {

            converter += Integer.toString(vetor[i]) + ", ";

        }
        return converter;

    }
    public static int[] stringToInt(String s){
        char[] array = s.toCharArray(); 
        int[] v = new int[array.length];
        for(int i = 0; i < array.length; i++){
            v[i] = Integer.parseInt(String.valueOf(array[i]));
        }
        return v;
    }
}
