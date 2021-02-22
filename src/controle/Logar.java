package controle;

import modelo.Usuario;

import static controle.Inicial.usuarios;

public class Logar {
    public static boolean confereUsuario(String nomeUsuario, String senha) {
        if (usuarios.size()==0){
            return false;
        } else {
            for (Usuario usuario:
                 usuarios) {
                if (nomeUsuario.equals(usuario.getUsuario()) && senha.equals(usuario.getSenha())) {
                    Logado.usuarioLogado = usuario;
                    return true;
                }
            }
            return false;
        }
    }
}
