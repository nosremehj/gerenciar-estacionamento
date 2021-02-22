package controle;

import modelo.*;
import visualizacao.Cabecalho;
import visualizacao.Listas;
import visualizacao.Menu;

import java.lang.invoke.MutableCallSite;
import java.util.Scanner;

import static controle.Inicial.*;

public class Logado {
    public static Usuario usuarioLogado;
    private static Scanner leitor = new Scanner(System.in);

    public static void session(){
        // Aqui tudo sobre area logada
        int opcaoUsuario;
        Scanner leitor = new Scanner(System.in);
        boolean root = true;
        if (usuarioLogado.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
            // Aqui tudo sobre admin
            do {
                Cabecalho.cabecalhoAdministrador();
                Menu.menuAdminstrador();
                opcaoUsuario = leitor.nextInt();
                switch (opcaoUsuario){
                    case 1:
                        // Dar entrada de uma veiculo no estacionamento
                        verificaCria();
                        break;
                    case 2:
                        // Listar carros no estacionamento
                        if (veiculosEstacionados.size() == 0)
                            System.out.println("Não há nenhum veículo no estacionamento.");
                        else
                            Crud.imprimirEstacionados();
                        break;
                    case 3:
                        // Fazer saída do veículo
                        if (veiculosEstacionados.size() == 0){
                            System.out.println("Não há nenhum veículo estacionado");
                        } else {
                            verificaSair();
                        }
                        break;
                    case 4:
                        // Imprimir saldo do caixa
                        Cabecalho.cabecalhoAdministrador();
                        caixa.imprimir();
                        break;
                    case 5:
                        // Gerenciar usuários
                        Cabecalho.cabecalhoAdministrador();
                        Menu.menuGerenciarUsuario();
                        opcaoUsuario = leitor.nextInt();
                        if (opcaoUsuario == 1){
                            Usuario.lerDados();
                        } else if (opcaoUsuario == 2) {
                            Listas.imprimir(usuarios);
                            System.out.println("Digite o ID do usuário que deseja editar: ");
                            Crud.editarUsuario(leitor.nextInt());
                        } else if (opcaoUsuario == 3) {
                            Listas.imprimir(usuarios);
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;
                    case 6:
                        // Setar configurações
                        Cabecalho.cabecalhoAdministrador();
                        configInicial.imprimir();
                        System.out.println("5 - Voltar\nDigite o número da opção que deseja alterar: ");
                        opcaoUsuario = leitor.nextInt();leitor.nextLine();
                        if (opcaoUsuario == 1){
                            System.out.println("Digite o novo nome do Estacionamento: ");
                            configInicial.setNomeEstacionamento(leitor.nextLine());
                        } else if (opcaoUsuario == 2){
                            System.out.println("Digite o novo número de Vagas: ");
                            configInicial.setNumeroVagas(leitor.nextInt());leitor.nextLine();
                        } else if (opcaoUsuario == 3){
                            System.out.println("Digite o novo valor da Hora");
                            configInicial.setValorHora(leitor.nextDouble());leitor.nextLine();
                        } else if (opcaoUsuario == 4){
                            System.out.println("Digite o novo da diária");
                            configInicial.setValorDiaria(leitor.nextDouble());leitor.nextLine();
                        } else if (opcaoUsuario == 5) {
                            System.out.println("Opção inválida");
                        } else {
                            System.out.println("Você será redirecionado para o menu anterior");
                        }
                        break;
                    case 7:
                        Cabecalho.cabecalhoAdministrador();
                        Menu.menuImprimirOrdenado();
                        opcaoUsuario = leitor.nextInt();
                        if (opcaoUsuario == 1){
                            Crud.ordenarPorMarca();
                        } else if (opcaoUsuario == 2){
                            Crud.ordenadorPorModelo();
                        } else if (opcaoUsuario == 3){
                            Crud.ordenacaoPorPlaca();
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;
                    case 8:
                        root = false;
                        break;
                    default:
                        System.out.println("Opção inválida");
                }

            } while (root);
        } else if (usuarioLogado.getTipoUsuario() == TipoUsuario.VALLET){
            // Aqui tudo sobre o vallet
            do {
                Cabecalho.cabecalhoVallet();
                Menu.menuVallet(false);
                opcaoUsuario = leitor.nextInt();leitor.nextLine();
                switch (opcaoUsuario){
                    case 1:
                        // Dar entrada de veículo no estacionamento
                        verificaCria();
                        break;
                    case 2:
                        // Listar carros no estacionamento
                        if (veiculosEstacionados.size() == 0) {
                            System.out.println("Não há nenhum veículo no estacionamento.");
                        } else {
                            Crud.imprimirEstacionados();
                        }
                        break;
                    case 3:
                        // Fazer a saída do veículo
                        if (veiculosEstacionados.size() == 0){
                            System.out.println("Não há nenhum veículo estacionado");
                        } else {
                            verificaSair();
                        }
                        break;
                    case 4:
                        root = false;
                }
            } while (root);
        }
    }

    public static void verificaCria(){
        if (veiculosDb.isEmpty()){
            System.out.println("Informe a placa do veículo:");
            String placa = leitor.nextLine();
            Crud.criar(placa);
        } else if (veiculosEstacionados.size() < configInicial.getNumeroVagas()){
            System.out.println("Informe a placa do veículo:");
            String placa = leitor.nextLine();

            boolean estaNaLista = false;
            Veiculo veiculoEstacionando = null;

            for (Veiculo veiculo :
                    veiculosDb) {
                if (placa.equals(veiculo.getPlaca())) {
                    estaNaLista = true;
                    veiculoEstacionando = veiculo;
                }
            }

            if (estaNaLista){
                Crud.estacionando(veiculoEstacionando);
            } else {
                Crud.criar(placa);
            }

        } else {
            System.out.println("Estacionamento Lotado!");
        }
    }

    public static void verificaSair(){
        boolean root = true;
        String opcao;
        Menu.menuSairVeiculo();
        int opcaoUsuario = leitor.nextInt();leitor.nextLine();
        if (opcaoUsuario == 1){
            do {
                System.out.println("Digite a marca do veículo: ");
                opcao = leitor.nextLine();
                if (opcao.equals("0")){
                    root = false;
                } else if (verificaVeiculo(opcao)){
                    Crud.imprimirPorMarca(opcao);
                    System.out.println("Digite o número da placa do veículo que você deseja sair: ");
                    Crud.remover(leitor.nextLine());
                    root = false;
                } else {
                    System.out.println("Não existe nenhum veículo com essa marca\nTente outra vez ou digite 0 para sair");
                }
            } while (root);

        } else if (opcaoUsuario == 2){
            do {
                System.out.println("Digite a modelo do veículo: ");
                opcao = leitor.nextLine();
                if (opcao.equals("0")){
                    root = false;
                } else if (verificaVeiculo(opcao)){
                    Crud.imprimirPorModelo(opcao);
                    System.out.println("Digite o número da placa do veículo que você deseja sair: ");
                    Crud.remover(leitor.nextLine());
                    root = false;
                } else {
                    System.out.println("Não existe nenhum veículo com esse modelo\nTente outra vez ou digite 0 para sair");
                }
            } while (root);

        } else if (opcaoUsuario == 3){
            do {
                System.out.println("Digite a cor do veículo: ");
                opcao = leitor.nextLine();
                if (opcao.equals("0")){
                    root = false;
                } else if (verificaVeiculo(opcao)){
                    Crud.imprimirPorCor(opcao);
                    System.out.println("Digite o número da placa do veículo que você deseja sair: ");
                    Crud.remover(leitor.nextLine());
                    root = false;
                } else {
                    System.out.println("Não existe nenhum veículo com essa cor\nTente outra vez ou digite 0 para sair");
                }
            } while (root);
        } else if (opcaoUsuario == 4){
            System.out.println("Digite o número da placa do veículo que você deseja sair: ");
            Crud.remover(leitor.nextLine());
        }
    }
}
