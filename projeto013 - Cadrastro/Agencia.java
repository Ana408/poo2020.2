import java.util.TreeMap;
public class Agencia{
    TreeMap<String, Cliente> clientes;
    TreeMap<String,Conta> conta;
    
    Agencia(){
        this.clientes= new TreeMap<>();
        this.conta = new TreeMap<>();
    }
    int contador;
    void adicionar(String nome){
        if(clientes.containsKey(nome)){
            throw new RuntimeException("fail: cliente já esxite.");
        }
        Cliente cliente = new Cliente(nome);
        clientes.put(nome, cliente);
        conta.put(nome, new Corrente(contador,nome));
        cliente.conta.put(nome, new Corrente(contador,nome));
        contador++;
        cliente.conta.put(nome, new Poupança(contador, nome));
        conta.put(nome, new Poupança(contador,nome));
        ++contador;
    }
    public String toString(){
        String saida ;
        int i = 0;
        for(Conta conta : this.conta){
            saida += " [" + i + ":" + conta + "]\n";
            i++;
        }
        return saida;
    }
}