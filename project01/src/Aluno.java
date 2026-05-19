
public class Aluno {
    String nome;
    double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public boolean verificarAprovacao() {
        return nota >= 7;
    }

    public String obterConceito() {
        if (nota >= 9) {
            return "A";
        } else if (nota >= 7) {
            return "B";
        } else {
            return "C";
        }
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Carlos", 8.5);

        System.out.println("Aluno: " + aluno.nome);
        System.out.println("Nota: " + aluno.nota);

        if (aluno.verificarAprovacao()) {
            System.out.println("Aluno aprovado.");
        } else {
            System.out.println("Aluno reprovado.");
        }

        System.out.println("Conceito: " + aluno.obterConceito());
    }
}