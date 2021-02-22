package modelo;

import visualizacao.Impressao;

import java.util.ArrayList;
import java.util.List;

public class Caixa implements Impressao {
    private List<Estacionar> estacionados = new ArrayList<>();
    private Double saldo;

    public Caixa(){}

    public Caixa(List<Estacionar> estacionados) {
        this.estacionados = estacionados;
    }

    @Override
    public String toString() {
        return "Caixa" +
                "Saldo: R$ " + this.getSaldo();
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public void calculaCaixa(Double valor){
        if (this.getSaldo() == null)
            this.setSaldo(valor);
        else
            valor += getSaldo();
            this.setSaldo(valor);
    }

    public List<Estacionar> getEstacionados() {
        return estacionados;
    }

    public void setEstacionados(Estacionar estacionados) {
        this.estacionados.add(estacionados);
    }

    public Double getSaldo() {
        if (saldo == null){
            return 0.00;
        } else {
            return saldo;
        }
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
