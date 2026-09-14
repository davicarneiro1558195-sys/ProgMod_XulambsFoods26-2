import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach
    public void setUp(){
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }
    @Test
    public void adicionaVariasPizzasCorretamente(){
        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
        //Assert
        assertEquals(2, quantidade);
    }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.fecharPedido();
        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void calcularValorPedidoCorretamente(){
        //Act
        double preco = pedido.precoAPagar();
        //Assert
        assertEquals(29d, preco, 0.01);
    }

    @Test
    public void calcularPrecoDePedidoComVariasPizzas(){
        //Arrange
        Pizza pizza1Ingrediente = new Pizza(1);
        pedido.adicionarPizza(pizza1Ingrediente);
        //Act
        double preco = pedido.precoAPagar();
        //Assert
        assertEquals(63d, preco, 0.01);
    }

    @Test
    public void gerarRelatorioDePedido(){
        //Act
        String cupom = pedido.relatorio();
        //Assert
        assertTrue(
            cupom.contains("29,00") &&
            cupom.contains("1 pizza") && 
            cupom.contains("aberto") );          
    }
}
