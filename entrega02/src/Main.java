import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        System.out.print("Digite o primeiro número: ");
        double a = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double b = scanner.nextDouble();

        switch (opcao) {
            case 1:
                System.out.println("Resultado: " + calculadora.somar(a, b));
                break;

            case 2:
                System.out.println("Resultado: " + calculadora.subtrair(a, b));
                break;

            case 3:
                System.out.println("Resultado: " + calculadora.multiplicar(a, b));
                break;

            case 4:
                System.out.println("Resultado: " + calculadora.dividir(a, b));
                break;

            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}