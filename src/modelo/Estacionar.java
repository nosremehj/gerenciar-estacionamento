package modelo;

import visualizacao.Impressao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static controle.Inicial.configInicial;

public class Estacionar implements Impressao {
    private Veiculo veiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Double valor;
    private Pagamento pagamento;

    @Override
    public String toString() {
        return "Veículo estacionado" +
                "\nveiculo: " + this.getVeiculo() +
                "\nData da entrada: " + formatarData(this.getEntrada()) +
                "\nHora da entrada: " + formatarHora(this.getEntrada()) +
                "\nHora da Saida: " + (this.getSaida()!=null? formatarHora(this.getSaida()):"") +
                "\nValor: " + calculaValor(this.getEntrada(), LocalDateTime.now());
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public static Double calculaValor(LocalDateTime entrada, LocalDateTime saida) {
        int dias = saida.getDayOfMonth() - entrada.getDayOfMonth();
        int horas = saida.getHour() - entrada.getHour();
        int minutos = saida.getMinute() - entrada.getMinute();

        if (dias == 0 && horas == 0){
            return configInicial.getValorHora();
        } else if (dias == 0 && horas > 0) {
            if (minutos > 5) {
                horas++;
                return calcula(horas, configInicial.getValorHora());
            }
        } else if (dias > 0){
            return calcula(dias, configInicial.getValorDiaria().intValue());
        }
        return null;
    }

    public static Double calcula(int hora, Double valor){
        return valor*hora;
    }

    public static Double calcula(int dia, int valor){
        return (Double) (double) (valor * dia);
    }

    public String formatarData(LocalDateTime data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatador);
    }

    public String formatarHora(LocalDateTime hora){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatador);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
