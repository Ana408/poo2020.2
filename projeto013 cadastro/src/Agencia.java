import java.util.*;

public class Agencia{
    TreeMap<String, Cliente> clientes;
    ArrayList<Conta> contas;
    
    Agencia(){
        this.clientes= new TreeMap<>();
        this.contas = new ArrayList<>();
    }
    int contador;
    void adicionar(String nome){
        if(clientes.containsKey(nome)){
            throw new RuntimeException("fail: cliente já esxite.");
        }
        Cliente cliente = new Cliente(nome);
        clientes.put(nome, cliente);
        contas.add( new Corrente(contador,nome));
        cliente.contas.put(nome, new Corrente(contador,nome));
        contador++;
        cliente.contas.put(nome, new Poupança(contador, nome));
        contas.add(new Poupança(contador,nome));
        ++contador;
    }
    public String toString(){
        String saida = "" ;
        int i = 0;
        for(Conta conta : contas){
            saida += " [" + i + ":" + conta + "]\n";
            i++;
        }
        return saida;
    }
}