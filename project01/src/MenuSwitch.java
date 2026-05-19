import java.util.Scanner;

public class MenuSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Excluir");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Opção cadastrar selecionada.");
                break;

            case 2:
                System.out.println("Opção consultar selecionada.");
                break;

            case 3:
                System.out.println("Opção atualizar selecionada.");
                break;

            case 4:
                System.out.println("Opção excluir selecionada.");
                break;

            default:
                System.out.println("Erro: opção inválida.");
        }

        scanner.close();
    }
}