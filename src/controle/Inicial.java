package controle;

import modelo.*;

import java.util.ArrayList;
import java.util.List;


public class Inicial {
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Veiculo> veiculosDb = new ArrayList<>();
    public static Configuracao configInicial = new Configuracao();
    public static List<Estacionar> veiculosEstacionados = new ArrayList<>();
    public static Caixa caixa = new Caixa();

    public static void inicializar(){
        // Configurando Estacionamento
        configInicial.setNomeEstacionamento("Estacionamento Tocantins");
        configInicial.setNumeroVagas(50);
        configInicial.setValorDiaria(20.00);
        configInicial.setValorHora(10.00);

        // Configurando Usuários
        Usuario admin = new Usuario(1, "José Aquino", "j.aquino", "123", TipoUsuario.ADMINISTRADOR);
        usuarios.add(admin);
        Usuario vallet = new Usuario(2, "Giovanni Souza", "g.souza", "321", TipoUsuario.VALLET);
        usuarios.add(vallet);

        //Configurando Carros
        Carro uno = new Carro();
        uno.setMarca("FIAT");
        uno.setModelo("Uno way");
        uno.setPlaca("AUG-5587");
        uno.setCor("Cinza");
        uno.setDescricao("Hóspede Quarto 305");
        veiculosDb.add(uno);

        Carro onix = new Carro();
        onix.setMarca("Chevrolet");
        onix.setModelo("Onix Prime");
        onix.setPlaca("MVW-5744");
        onix.setCor("Azul");
        onix.setDescricao("Hóspede Quarto 208");
        veiculosDb.add(onix);

        Carro ranger = new Carro();
        ranger.setMarca("FORD");
        ranger.setModelo("Ranger");
        ranger.setPlaca("ADO5P587");
        ranger.setCor("Braca");
        ranger.setDescricao("Hóspede Quarto 515");
        veiculosDb.add(ranger);

        Carro kwid = new Carro();
        kwid.setMarca("Renault");
        kwid.setModelo("Kwid");
        kwid.setPlaca("CGK9R63");
        kwid.setCor("Vermelho");
        kwid.setDescricao("Hóspede Quarto 201");
        veiculosDb.add(kwid);

        // Configurando Motos
        Moto cg = new Moto();
        cg.setMarca("Honda");
        cg.setModelo("CG Fun");
        cg.setPlaca("MOV-1298");
        cg.setCor("Vermelha");
        cg.setDescricao("Funcionário da Manutenção");
        veiculosDb.add(cg);

        Moto bis = new Moto();
        bis.setMarca("Honda");
        bis.setModelo("Bis");
        bis.setPlaca("JFK-5548");
        bis.setCor("Vermelha");
        bis.setDescricao("Funcionária da contabilidade");
        veiculosDb.add(bis);

        Moto bmw = new Moto();
        bmw.setMarca("BMW");
        bmw.setModelo("F 800 GS");
        bmw.setPlaca("FFT-3945");
        bmw.setCor("Cinza");
        bmw.setDescricao("Hóspede 115");
        veiculosDb.add(bmw);
    }

    public static boolean verificaUsuario(String nomeUsuario) {
        for (Usuario usuario :
                usuarios) {
            if (nomeUsuario.equals(usuario.getUsuario())){
                return false;
            }
        }
        return true;
    }

    public static boolean verificaVeiculo(String arg){
        for (Estacionar veiculo :
                veiculosEstacionados) {
                if (veiculo.getVeiculo().getPlaca().equals(arg)){
                    return true;
                } else if(veiculo.getVeiculo().getMarca().equalsIgnoreCase(arg)){
                    return  true;
                } else if (veiculo.getVeiculo().getModelo().equalsIgnoreCase(arg)){
                    return true;
                } else if (veiculo.getVeiculo() instanceof Carro) {
                    if (((Carro) veiculo.getVeiculo()).getCor().equalsIgnoreCase(arg)){
                        return true;
                    }
                } else if (veiculo.getVeiculo() instanceof Moto){
                    if (((Moto) veiculo.getVeiculo()).getCor().equalsIgnoreCase(arg)){
                        return true;
                    }
                }
        }
        return false;
    }
}
