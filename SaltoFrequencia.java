
// ESPALHAMENTO ESPECTRAL POR SALTO DE FREQUENCIA
import java.util.Scanner;
public class SaltoFrequencia {

    public static String converterParaBits(String mensagem) {
        // montagem da sequencia de bits com StringBuilder
        StringBuilder bits = new StringBuilder();
        // conversão da menssagem exemplo: pato ["p", "a", "t", "o"]
        for (char caractere : mensagem.toCharArray()) {
            // conversão para binario
            String binario = Integer.toBinaryString(caractere);
            while (binario.length() < 8) { //adicionei um zero quando for menor que 8 pq sabemos que 1 byte = 8bits
                binario = "0" + binario;
            }

            bits.append(binario); 
        }
        
        return bits.toString();
    }

    
    public static void transmitirMensagem(String bits) {
        String[] canais = {"Canal 1", "Canal 2", "Canal 3"};
        int canalAtual = 0;

        System.out.println("\nIniciando transmissão com salto de frequência:\n");

        for (int i = 0; i < bits.length(); i++) {
            char bit = bits.charAt(i);
            System.out.println(canais[canalAtual] + " transmitiu o bit: " + bit);

            canalAtual++; 
            if (canalAtual == canais.length) {
                canalAtual = 0; 
            }
        }

        System.out.println("\nTransmissão finalizada!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a mensagem que deseja transmitir: ");
        String mensagem = scanner.nextLine();

        String bitsConvertidos = converterParaBits(mensagem);

        System.out.println("\nMensagem convertida para bits: " + bitsConvertidos);

        transmitirMensagem(bitsConvertidos);

        scanner.close();
    }
}
