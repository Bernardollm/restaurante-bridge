package restaurante.bridge;

import restaurante.pagamento.FormaPagamento;

public abstract class Pedido {

    protected FormaPagamento formaPagamento;

    public Pedido(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public abstract double calcularTotal();
}