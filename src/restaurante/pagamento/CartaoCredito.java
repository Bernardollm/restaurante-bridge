package restaurante.pagamento;

public class CartaoCredito implements FormaPagamento {

    @Override
    public double calcularPagamento(double valor) {
        return valor * 1.10; // 10% de taxa
    }
}
