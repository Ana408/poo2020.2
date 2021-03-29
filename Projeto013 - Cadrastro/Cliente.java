import java.util.TreeMap;

public class Cliente {
    String nome;
    TreeMap<String, Conta> conta;

    Cliente(String nome){
        this.nome = nome;
        this.conta = new TreeMap<>();
    }
}