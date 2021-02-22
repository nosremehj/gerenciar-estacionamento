package modelo;

import visualizacao.Impressao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pagamento implements Impressao {
    private Double valor;
    private TipoPagamento tipoPagamento;
    private LocalDateTime dataHora;

    public Pagamento(Double valor, TipoPagamento tipoPagamento) {
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Pagamento" +
                "\nValor: " + this.getValor() +
                "\nForma do pagamento: " + this.getTipoPagamento() +
                formatarData(this.getDataHora());
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public String formatarData(LocalDateTime dataHora){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy\nHH:mm:ss");
        return dataHora.format(formatador);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
