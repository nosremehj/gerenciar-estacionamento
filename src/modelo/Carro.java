package modelo;

import java.util.Scanner;


import visualizacao.Impressao;

public class Carro extends Veiculo implements Impressao {
    private String cor;
    private String descricao;
    private static Scanner scan = new Scanner(System.in);
    @Override
    public String toString() {
        return super.toString() +
                "\nCor: " + this.getCor() +
                "\nDescricao: " + this.getDescricao();
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static Carro lerDados(String placa) {
    	Carro carro = new Carro();
    	carro.setPlaca(placa);
    	System.out.println("Informe o modelo do carro: ");
    	carro.setModelo(scan.nextLine());
    	System.out.println("Informe a marca do carro: ");
    	carro.setMarca(scan.nextLine());
    	System.out.println("Informe a cor do carro:");
    	carro.setCor(scan.nextLine());
    	System.out.println("Informe a descrição do carro: ");
    	carro.setDescricao(scan.nextLine());
    	return carro;
    }
}
