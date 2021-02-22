package modelo;

import java.util.Scanner;

import visualizacao.Impressao;

public class Moto extends Veiculo implements Impressao {
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
    
    public static Moto lerDados(String placa) {
    	Moto moto = new Moto();
    	moto.setPlaca(placa);
    	System.out.println("Informe o modelo da moto: ");
    	moto.setModelo(scan.nextLine());
    	System.out.println("Informe a marca da moto: ");
    	moto.setMarca(scan.nextLine());
    	System.out.println("Informe a cor da moto:");
    	moto.setCor(scan.nextLine());
    	System.out.println("Informe a descrição da moto: ");
    	moto.setDescricao(scan.nextLine());
    	return moto;
    }
}
