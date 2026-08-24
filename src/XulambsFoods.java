import java.util.LinkedList;
import java.util.List;

public class XulambsFoods {
    static List<Pizza>pizzas;

    private void cabecalho(){
        IO.println("Xulambs Pizza v0.1");
        IO.println("===================");
    }

    private int menuPrincipal(){
        cabecalho();
        IO.println("1 - Comprar uma pizza");
        IO.println("2 - Ver pizzas Vendidas");
        IO.println("0 - Sair");

        return Integer.parseInt(IO.readln("Digite sua opção: "));

    }

    private void comprarPizza(){
        cabecalho();
        IO.println("Comprando uma pizza");
        int adicionais = escolherIngredientes();
        Pizza novaPizza = new Pizza(adicionais);
        mostrarNota(novaPizza);
        pizzas.add(novaPizza);
    }

    private void mostrarNota(Pizza novaPizza) {
        IO.println("===================");
        IO.println(novaPizza.gerarCupom());
        IO.println("===================");
    }

    private int escolherIngredientes(){
        return Integer.parseInt(IO.readln("Quantos adicionais? "));
    }

    private void mostrarPizzas() {
        cabecalho();
        for (Pizza pizza : pizzas) {
            mostrarNota(pizza);
            IO.println();
        }
    }

    void main() {
        int opcao;
        pizzas = new LinkedList<>();
        do {
            opcao = menuPrincipal();
            switch (opcao) {
                case 1 -> comprarPizza();
                case 2 -> mostrarPizzas();
                case 0 -> IO.println("Encerrando!!");
                default -> IO.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    

}
