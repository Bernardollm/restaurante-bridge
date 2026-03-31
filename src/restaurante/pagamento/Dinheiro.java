package restaurante.pagamento;

public class Dinheiro implements FormaPagamento {

    @Override
    public double calcularPagamento(double valor) {
        return valor; // sem taxa
    }
}
