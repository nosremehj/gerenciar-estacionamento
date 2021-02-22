package visualizacao;

public class Menu {
    public static void menuInicial(){
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Fazer login");
        System.out.println("2 - Sair");
    }

    public static void menuAdminstrador(){
        // Aqui o menu do administrador
        menuVallet(true);
        System.out.println("4 - Relatório do Caixa");
        System.out.println("5 - Gerenciar usuários");
        System.out.println("6 - Configurações");
        System.out.println("7 - Imprimir ordenando por filtro");
        System.out.println("8 - Fazer Logout");
    }

    public static void menuVallet(boolean admin){
        // Aqui o menu do manobrista
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Entrar veículo no estacionamento");
        System.out.println("2 - Consultar veiculos no estacionamento");
        System.out.println("3 - Sair veiculo do estacionamento");
        if (!admin)
            System.out.println("4 - Fazer Logout");
    }

    public static void menuSairVeiculo(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Mostrar veículos por marca");
        System.out.println("2 - Mostrar veículos por modelo");
        System.out.println("3 - Mostrar veículos por cor");
        System.out.println("4 - Digitar o número da placa");

    }

    public static void menuImprimirOrdenado(){
        System.out.println("Escolha por qual filtro deseja ordenar");
        System.out.println("1 - Marca");
        System.out.println("2 - Modelo");
        System.out.println("3 - Placa");
    }

    public static void menuGerenciarUsuario() {
        System.out.println("Deseja inserir um novo usuário ou editar usuário existente:");
        System.out.println("1 - Novo usuário;");
        System.out.println("2 - Editar usuário cadastrado.");
        System.out.println("3 - Listar usuários cadastrados.");
    }
}
