import java.util.Scanner;

public class NumerosImpares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o início do intervalo: ");
        int inicio = scanner.nextInt();

        System.out.print("Digite o fim do intervalo: ");
        int fim = scanner.nextInt();

        int contador = 0;
        int atual = inicio;

        while (atual <= fim) {
            if (atual % 2 != 0) {
                contador++;
            }

            atual++;
        }

        System.out.println("Quantidade de números ímpares: " + contador);

        scanner.close();
    }
}