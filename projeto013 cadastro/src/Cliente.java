import java.util.TreeMap;

public class Cliente {
    String nome;
    TreeMap<String, Conta> contas;

    Cliente(String nome){
        this.nome = nome;
        this.contas = new TreeMap<>();
    }
}