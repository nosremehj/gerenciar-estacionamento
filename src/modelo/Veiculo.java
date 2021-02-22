package modelo;

import visualizacao.Impressao;

public abstract class Veiculo implements Impressao {
    private String modelo;
    private String marca;
    private String placa;


    @Override
    public String toString() {
        return "Veiculo" +
                "\nModelo: " + this.getModelo() +
                "\nMarca: " + this.getMarca() +
                "\nPlaca: " + this.getPlaca();
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() { return placa;
    }

    public void setPlaca(String placa) { this.placa = placa;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
}
