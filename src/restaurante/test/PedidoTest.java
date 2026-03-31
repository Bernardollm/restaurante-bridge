package restaurante.test;

import org.junit.jupiter.api.Test;

import restaurante.bridge.Pedido;
import restaurante.bridge.PedidoComum;
import restaurante.pagamento.CartaoCredito;
import restaurante.pagamento.Dinheiro;
import restaurante.pagamento.FormaPagamento;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void deveRetornarValorSemTaxaQuandoPagamentoDinheiro(){
        FormaPagamento pagamento = new Dinheiro();
        Pedido pedido = new PedidoComum(pagamento, 100.0);

        double resultado = pedido.calcularTotal();


        System.out.println(resultado);

        assertEquals(100.0, resultado);      // retorna o valor sem taxa quando o pagamento for em dinheiro
    }

    @Test
    void deveAplicarTaxaQuandoPagamentoCartaoCredito() {
        FormaPagamento pagamento = new CartaoCredito();
        Pedido pedido = new PedidoComum(pagamento, 100.0);


        double resultado = pedido.calcularTotal();

        System.out.println(resultado);

        assertEquals(110.0, resultado, 0.0001);   // aplica taxa de 10% quando o pagamento for no credito
    }

    @Test
    void deveRetornarZeroQuandoValorZero() {
        FormaPagamento pagamento = new Dinheiro();
        Pedido pedido = new PedidoComum(pagamento, 0.0);

        double resultado = pedido.calcularTotal();  

        System.out.println(resultado);

        assertEquals(0.0, resultado);             // quando nao tem valor nenhum retorna 0
    }

    @Test
    void deveCalcularCorretamenteValoresDiferentes() {
        FormaPagamento pagamento = new CartaoCredito();
        Pedido pedido = new PedidoComum(pagamento, 50.0);

        double resultado = pedido.calcularTotal();

        System.out.println(resultado);

        assertEquals(55.0, resultado, 0.0001);   // calcula corretamente os valores
    }
}