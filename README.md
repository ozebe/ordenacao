
# Sistema de ordenação de dados numéricos 
### versão 1.9
desenvolvido por Wesley Ozebe e Jackson Vinicius
<p>última atualização: 23/01/2018</p>


### FAQ:
#### Tipos de arquivos válidos 
##### separados por espaçamento simples:
```
1 3 2 7 10 5 
22 32 12 15
```
observe que ao final da primeira linha, depois do 5 há um espaço,
ele delimita a primeira linha da segunda, fique atento
caso seu arquivo seja dessa forma

##### Separados por vírgulas
```
13,2,5,8,9,36,66,
32,10,21
```
observe que as linhas são separadas por vírgulas

##### separados por tabulação
```
79179	33886	94019	65386	4699	
43448	15904	30542	99899	72414	
78291	7953	53250	93258	41164	
92766	90124	11179	92408	74786   
```
observe que no final de cada linha há um tab
</p>você pode testar nesse site: https://www.invertexto.com/numeros-aleatorios
para fins de teste no programa.</p>

#### Considerações
cada número a ser carregado do arquivo não pode ultrapassar o seguinte tamanho:
2147483647 ou ((2^32 )- 1), caso exista o cálculo vai ser prejudicado e irá ocorrer
um overflow.<p>Na próxima grande atualização, a v2.0 colocarei algum aviso para evitar
que esse tipo de problema ocorra.</p>


#### Sobre a versão 1.9
<p>Melhorias:</p>
<p>sistema de carregamento, utilizando-se thread para o carregamento ser mais rápido.</p>
<p>retirado partes de códigos desnecessárias ao abrir arquivos para deixar o carregamento de arquivos .txt mais rápido.<p/>
<p>Adicionado:</p>
<p>adicionado uma barra de carregamento ao carregar os arquivos.<p/>

#### Sobre a versão 1.8
<p>Melhorias:</P>
<P>modificado o design gráfico do programa, o tema padrão anterior era o Nimbus, agora
o tema padrão é o Darcula LAF</p>

#### Sobre a versão 1.7
<p>Correções:</p>
<p>Consertado todos os bugs restantes na abertura de arquivos.</p>
<p>Adicionado:</p>
<p>aviso caso o arquivo carregado não seja válido.</p>
<p>Após o arquivo ser ordenado agora aparece a quantia em milisegundos que foi necessário para sua ordenação.</p>
<p>Melhorias:</p>
<p>design do programa, aumentando a janela e os botões.</p>
<p>Atualizado o sistema de carregamento, agora é utilizado um JFileChooser para escolher o arquivo a ser carregado.</p>
<p>Atualizado o sistema de salvamento, agora é utilizado um JFileChooser para escolher onde salvar.</p>

#### Sobre a versão 1.6
<p>Correções:</p>
<p>solucionado alguns problemas com o sistema de carregamento, onde havia a possibilidade de abrir um arquivo contendo letras, assim travando o programa.</p>
<p>Adicionado:</p>
<p>adicionado ícones para os botões, deixando o programa mais intuitivo.</p>
<p>sistema de carregamento de arquivos melhorado, substituindo método antigo(veja o FAQ).</p>
<p>botão "sobre", ele mostra a quantia de números que foram carregados do arquivo(descartando tabulação, espaços e vírgulas).</p>
<p>Melhorias:</p>
<p>estabilidade do programa, sendo possivel abrir arquivos maiores.</p>

#### Sobre a versão 1.5
<p>Modificado:</p>
<p>visual do programa totalmente remodelado, utilizando-se JFrame.</p>
<p>Melhorias:</p>
<p>melhorado o sistema de conversão dos dados, de String para Vetor, o que corrige o bug de as vezes um número mesmo separado ser confundido com outro.</p>
<p>Adicionado:</p>
<p>todos os outros métodos restantes de ordenação como também de pesquisa de dados.</p>

#### Sobre a versão 1.3
<p>Modificado:</p>
<p>Loógica de carregamento</>
<p>Adicionado:</p>
<p>cJButtons para o programa ficar mais intuitivo</p>

#### Sobre a versão 1.0
<p>Adicionado:</p> 
<p>lógica de carregamento de arquivos .txt e sua conversão para vetor</p>
<p>JOptionPanes para leitura de arquivos e para a leitura dos dados.</p>
<p>forma de ordenação bubble sort.</p>

#### Classes e métodos do programa para os curiosos


##### Sistema de carregamento:
```java
private void carregarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
            try {
             
              
                textarea.read(new FileReader(file.getAbsolutePath()), null);

                //biblioteca especial apache FileUtils 
                String conteudo = FileUtils.readFileToString(file, "UTF-8");
              
                conteudo = conteudo.replaceAll("\r", "");
                conteudo = conteudo.replaceAll("\t", " ");
                conteudo = conteudo.replaceAll("\n", "");
                conteudo = conteudo.replaceAll(",", " ");
               
                array = conteudo.split(" ");
                vetor = new int[array.length];
                //esse método for, realiza a conversão da string array(que recebeu o valor da linha.split, ou seja, usou os espaços para definir o começo e final do número)
                for (int i = 0; i < array.length; i++) {
                    vetor[i] = Integer.parseInt(array[i]);
                   
                }
                copiaVet = copiarVetor.copiarVetor(vetor);
             
                String convertido = converter.toString(vetor);
                
                trigger = 1;
                
                mostrarValoresOrdenados.setText("Arquivo carregado!");
              
              
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado" + file.getAbsolutePath(), "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Arquivo inválido carregado" + "\n" +file.getAbsolutePath(), "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
                mostrarValoresOrdenados.setText("Arquivo inválido carregado");
                textarea.setText("Arquivo inválido carregado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo carregado", "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);

        }
       
    }
```

##### sistema de salvamento:
```java
private void salvarArqActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (trigger == 1) {
             int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
           
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.print(converter.toString(copiaVet));
                JOptionPane.showMessageDialog(null, "Sucesso ao salvar\n" + file.getAbsolutePath(), "Sucesso", JOptionPane.INFORMATION_MESSAGE, sucessoIcone);
                printWriter.close();
            }catch(IOException ex) {
                
                JOptionPane.showMessageDialog(null, "Erro ao salvar" + file.getAbsolutePath(), "Erro", JOptionPane.ERROR_MESSAGE, erroIcone);
            }
          
            
        }
        }
    }
```

##### sistema de conversão:
```java
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
```

##### sistema de copia de vetor:
```java
public class copiarVetor {
    public static int[] copiarVetor(int[] vetor){
        int[] vetorCopiado = new int[vetor.length];
        System.arraycopy(vetor, 0, vetorCopiado, 0, vetor.length);
        return vetorCopiado;
    }
} 
```


##### sistema para mostrar o vetor:
```java
public class MostrarVetor {

    public static void mostrarVetor(int[] vetor) {
        String converter = "";
        for (int i = 0; i < vetor.length; i++) {

            converter += Integer.toString(vetor[i]) + ", ";

        }
        JOptionPane.showMessageDialog(null, converter);

    }
}
```

##### sistema do bubbleSort:
```java
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
```

##### sistema do insertionSort:
```java
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
```

##### sistema do mergeSort:

```java
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
```

##### sistema do selectionSort:

```java
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
```
