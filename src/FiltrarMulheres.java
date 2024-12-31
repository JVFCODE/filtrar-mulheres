import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class FiltrarMulheres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lendo a lista de pessoas no console
        System.out.print("Digite os nomes e sexos no formato Nome-Sexo, separados por vírgula: ");
        String input = scanner.nextLine();

        // Dividindo a entrada em uma lista de strings
        String[] pessoasInput = input.split(",");
        List<Pessoa> pessoas = new ArrayList<>();

        // Populando a lista de objetos Pessoa
        for (String pessoaStr : pessoasInput) {
            String[] partes = pessoaStr.split("-");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String sexo = partes[1].trim();
                pessoas.add(new Pessoa(nome, sexo));
            }
        }

        // Filtrando a lista para conter apenas mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> "f".equalsIgnoreCase(pessoa.getSexo()))
                .collect(Collectors.toList());

        // Exibindo a lista de mulheres
        System.out.println("Lista de mulheres:");
        mulheres.forEach(System.out::println);

        scanner.close();
    }
}

class Pessoa {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return nome + " - " + sexo;
    }
}
