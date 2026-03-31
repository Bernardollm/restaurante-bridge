package restaurante.bridge;

import restaurante.pagamento.FormaPagamento;

public class PedidoComum extends Pedido {

    private double valor;

    public PedidoComum(FormaPagamento formaPagamento, double valor) {
        super(formaPagamento);
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return formaPagamento.calcularPagamento(valor);
    }
}