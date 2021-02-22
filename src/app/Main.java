package app;

import controle.Inicial;
import controle.Logado;
import visualizacao.Cabecalho;
import visualizacao.Login;
import visualizacao.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //App
        Scanner leitor = new Scanner(System.in);
        boolean root = true;

        Inicial.inicializar();

        do {
            // Laço para manter o sistema rodando
            Cabecalho.cabecalhoInicial();
            Menu.menuInicial();
            int opcaoUsuario = leitor.nextInt();leitor.nextLine();
            switch (opcaoUsuario){
                case 1:
                    // Faz login
                    if (Login.login()) {
                        // Chama logado
                        Logado.session();
                    } else {
                        System.out.println("Usuário ou senha inválidos");
                    }
                    break;
                case 2:
                    // Sai do sistema
                    root = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (root);
    }
}
