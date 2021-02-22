package modelo;

import controle.Inicial;
import visualizacao.Impressao;

import java.util.Scanner;

import static controle.Inicial.usuarios;

public class Usuario implements Impressao {
    private Integer id;
    private String nome;
    private String usuario;
    private String senha;
    private TipoUsuario tipoUsuario;

    public Usuario(){
        this.id = usuarios.get(usuarios.size()-1).id + 1;
    }

    public Usuario(Integer id, String nome, String usuario, String senha, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public static void lerDados() {
        Scanner leitor = new Scanner(System.in);
        Boolean root = true;
        Usuario novoUsuario = new Usuario();

        System.out.println("Insira o nome: ");
        novoUsuario.setNome(leitor.nextLine());
        do {
            System.out.println("Insira o nome do usuário");
            String nomeUsuario = leitor.nextLine();
            if (nomeUsuario == "0"){
                System.out.println("Usuário não adicionado");
                return;
            } else if (Inicial.verificaUsuario(nomeUsuario)){
                novoUsuario.setUsuario(nomeUsuario);
                root = false;
            } else {
                System.out.println("Tente outro nome de usuário ou digite 0 para sair");
            }
        } while (root);
        System.out.println("Digite a senha: ");
        novoUsuario.setSenha(leitor.nextLine());
        System.out.println("Escolha o tipo do Usuário:\n 1 - Administrador;\n2 - Vallet.");
        root = true;
        do {
            int opcao = leitor.nextInt();leitor.nextLine();
            if (opcao == 0) {
                return;
            } else if (opcao == 1){
                novoUsuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
                root = false;
            } else if (opcao == 2){
                novoUsuario.setTipoUsuario(TipoUsuario.VALLET);
                root = false;
            } else {
                System.out.println("Digite uma opção válida ou digite 0 para sair");
            }
        } while (root);

        usuarios.add(novoUsuario);
    }

    @Override
    public String toString() {
        return "Usuario" +
                "\nID: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nUsuário: " + this.getUsuario()+
                "\nTipo do Usuário: " + this.getTipoUsuario();
    }

    @Override
    public void imprimir(){
        System.out.println(this);
    }

    public void imprimirEditar(){
        System.out.println("Usuario" +
                "\n1 - Nome: " + this.getNome() +
                "\n2 - Nome de usuário: " + this.getUsuario() +
                "\n3 - Tipo de usuário: " + this.getTipoUsuario() +
                "\n4 - Senha: **********"
                );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
