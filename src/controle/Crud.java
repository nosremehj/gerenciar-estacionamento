package controle;

import java.time.LocalDateTime;

import java.util.Scanner;

import modelo.*;

import static controle.Inicial.*;
import static modelo.Estacionar.calculaValor;


public class Crud{
	private static Scanner leitor = new Scanner(System.in);

	public static void criar(String placa){
		// Aqui cria veiculo
		System.out.println("Qual veículo deseja inserir?\n1 - Carro;\n2 - Moto.");
		int opcaoUsuario = leitor.nextInt();
		if (opcaoUsuario == 1){
			// carro
			Carro carro = Carro.lerDados(placa);
			veiculosDb.add(carro);
			estacionando(carro);

		} else if (opcaoUsuario == 2){
			// moto
			Moto moto = Moto.lerDados(placa);
			veiculosDb.add(moto);
			estacionando(moto);

		} else {
			System.out.println("Opção inválida");
		}
	}
	public static void estacionando(Veiculo veiculo){
		// Estacionando Veículo
		for (Estacionar v :
				veiculosEstacionados) {
			if (veiculo.getPlaca().equalsIgnoreCase(v.getVeiculo().getPlaca())) {
				System.out.println("Esse veículo já está estacionado!");
				return;
			}
		}

		Estacionar novoVeiculo = new Estacionar();
		novoVeiculo.setVeiculo(veiculo);
		novoVeiculo.setEntrada(LocalDateTime.now());
		novoVeiculo.setSaida(null);
		veiculosEstacionados.add(novoVeiculo);
		System.out.println("Veículo estacionado com sucesso!");
	}
	public static void remover(String placa) {

		for(int i = 0; i<veiculosEstacionados.size(); i++) {
			Estacionar estacionado = veiculosEstacionados.get(i);
			if(estacionado.getVeiculo().getPlaca().equalsIgnoreCase(placa)) {
				estacionado.setSaida(LocalDateTime.now());
				estacionado.setValor(calculaValor(estacionado.getEntrada(), estacionado.getSaida()));
				System.out.println("Selecione o tipo de pagamento: " +
						"\n1 - " + TipoPagamento.DINHEIRO +
						"\n2 - " + TipoPagamento.CREDITO +
						"\n3 - " + TipoPagamento.DEBITO +
						"\n4 - " + TipoPagamento.FATURAR +
						"\n5 - " + TipoPagamento.CORTESIA
					);
				int pagamento = leitor.nextInt();
				if (pagamento == 1){
					estacionado.setPagamento(new Pagamento(estacionado.getValor(), TipoPagamento.DINHEIRO));
					caixa.setEstacionados(estacionado);
					caixa.calculaCaixa(estacionado.getPagamento().getValor());
					veiculosEstacionados.remove(i);
					System.out.println("Veículo removido: "+estacionado.getVeiculo());
				} else if (pagamento == 2){
					estacionado.setPagamento(new Pagamento(estacionado.getValor(), TipoPagamento.CREDITO));
					caixa.setEstacionados(estacionado);
					caixa.calculaCaixa(estacionado.getPagamento().getValor());
					veiculosEstacionados.remove(i);
					System.out.println("Veículo removido: "+estacionado.getVeiculo());
				} else if (pagamento == 3){
					estacionado.setPagamento(new Pagamento(estacionado.getValor(), TipoPagamento.DEBITO));
					caixa.setEstacionados(estacionado);
					caixa.calculaCaixa(estacionado.getPagamento().getValor());
					veiculosEstacionados.remove(i);
					System.out.println("Veículo removido: "+estacionado.getVeiculo());
				} else if (pagamento == 4){
					estacionado.setPagamento(new Pagamento(estacionado.getValor(), TipoPagamento.FATURAR));
					caixa.setEstacionados(estacionado);
					caixa.calculaCaixa(estacionado.getPagamento().getValor());
					veiculosEstacionados.remove(i);
					System.out.println("Veículo removido: "+estacionado.getVeiculo());
				} else if (pagamento == 5){
					System.out.println("O valor não deve ser cobrado do cliente");
					veiculosEstacionados.remove(i);
					System.out.println("Veículo removido: "+estacionado.getVeiculo());
				} else {
					System.out.println("Opção Inválida");
				}
			}
		}
	}
	public static void imprimirEstacionados() {
		for (Estacionar estacionado : veiculosEstacionados) {
			estacionado.imprimir();
			System.out.println("");
		}
	}
	public static void imprimirPorMarca(String marca) {
		for (Estacionar estacionado : veiculosEstacionados) {
			if (estacionado.getVeiculo().getMarca().equalsIgnoreCase(marca)) {
				estacionado.imprimir();
			}
		}
	}
	public static void ordenarPorMarca() {
		System.out.println("Por marca \n");
				veiculosEstacionados.stream().sorted((arg0, arg1) -> arg0.getVeiculo().getMarca().compareTo(arg1.getVeiculo().getMarca()))
				.forEach(vMarca -> vMarca.imprimir());
		System.out.println("");
	}
	public static void imprimirPorModelo(String modelo) {
		for (Estacionar estacionado : veiculosEstacionados) {
			if (estacionado.getVeiculo().getModelo().equalsIgnoreCase(modelo)){
				estacionado.imprimir();
			}
		}
	}
	public static void ordenadorPorModelo() {
		System.out.println("Por modelo \n");
				veiculosEstacionados.stream().sorted((arg0, arg1) -> arg0.getVeiculo().getModelo().compareTo(arg1.getVeiculo().getModelo()))
				.forEach(vModelo -> vModelo.getVeiculo().imprimir());
		System.out.println("");
	}
	public static void ordenacaoPorPlaca() {
		System.out.println("Por placa \n");
				veiculosEstacionados.stream().sorted((arg0, arg1) -> arg0.getVeiculo().getPlaca().compareTo(arg1.getVeiculo().getPlaca()))
				.forEach(vPlaca -> vPlaca.imprimir());
		System.out.println("");
	}

	public static void imprimirPorCor(String cor) {
		for (Estacionar estacionado : veiculosEstacionados){
			if (estacionado.getVeiculo() instanceof Carro){
				if (((Carro) estacionado.getVeiculo()).getCor().equalsIgnoreCase(cor)){
					estacionado.imprimir();
				}
			}
			if (estacionado.getVeiculo() instanceof Moto){
				if (((Moto) estacionado.getVeiculo()).getCor().equalsIgnoreCase(cor)){
					estacionado.imprimir();
				}
			}
		}
	}

	public static void editarUsuario(int id) {
		boolean root = true;
		int opcaoUsuario;
		for (Usuario usuario :
				usuarios) {
				if (usuario.getId() == id) {
					do {
						usuario.imprimirEditar();
						System.out.println("Digite o número da informação que deseja editar ou digite 0 para sair: ");
						opcaoUsuario = leitor.nextInt();leitor.nextLine();
						if (opcaoUsuario == 0){
							root = false;
							return;
						} else if (opcaoUsuario == 1){
							System.out.println("Digite o novo nome: ");
							usuario.setNome(leitor.next());leitor.nextLine();
						} else if (opcaoUsuario == 2){
							System.out.println("Digite o novo nome de usuario: ");
							usuario.setUsuario(leitor.next());leitor.nextLine();
						} else if (opcaoUsuario == 3){
							System.out.println("Digite 1 para Administrador ou 2 para Vallet: ");
							opcaoUsuario = leitor.nextInt();leitor.nextLine();
							if (opcaoUsuario == 1){
								usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
							} else if (opcaoUsuario == 2){
								usuario.setTipoUsuario(TipoUsuario.VALLET);
							} else {
								System.out.println("Opção inválida");
							}
						} else if (opcaoUsuario == 4){
							System.out.println("Digite a nova senha ou digite 0 para sair: ");
							usuario.setSenha(leitor.next());leitor.nextLine();
						}
					} while (root);
				}
			}
	}
}
