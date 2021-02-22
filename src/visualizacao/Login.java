package visualizacao;

import controle.Logar;

import java.util.Scanner;

public class Login {
    public static Boolean login(){
        Scanner leitor = new Scanner(System.in);
        String usuario, senha;
        System.out.println("Insira as credenciais");
        System.out.println("Usuário: ");
        usuario = leitor.next();
        System.out.println("Senha: ");
        senha = leitor.next();

        return Logar.confereUsuario(usuario,senha);
    }
}