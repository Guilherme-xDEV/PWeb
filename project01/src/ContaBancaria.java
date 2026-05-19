public class ContaBancaria {
    String numero;
    double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Erro: saldo insuficiente.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("12345-6", 1000.0);

        conta.depositar(500);
        conta.sacar(300);
        conta.sacar(1500);

        System.out.println("Saldo atual: R$ " + conta.consultarSaldo());
    }
}