package visualizacao;

import modelo.Usuario;

import java.util.List;

public class Listas {
    public static void imprimir(List<Usuario> lista){
        for (Usuario usuario:
             lista) {
            usuario.imprimir();
        }
    }
}
