package modelo;

import visualizacao.Impressao;

public class Configuracao implements Impressao {
    private String nomeEstacionamento;
    private Integer numeroVagas;
    private Double valorHora;
    private Double valorDiaria;

    @Override
    public String toString() {
        return "Configuração" +
                "\n1 - Nome do Estacionamento: " + getNomeEstacionamento() +
                "\n2 - Número de Vagas: " + getNumeroVagas() +
                "\n3 - Valor por Hora: " + getValorHora() +
                "\n4 - Valor por Diaria: " + getValorDiaria();
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }

    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }

    public Integer getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(Integer numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
