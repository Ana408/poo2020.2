package copp;
import java.util.*;
import java.util.ArrayList;

public abstract class Contato{
    public String nome;
    ArrayList<Telefonee> telefone;
    public boolean starred;
   
    public Contato(String nome){
        this.nome = nome;
        this.telefone = new ArrayList<>();
        this.starred = false;
    }
     public void adicionar(String label, String numero){
        if(Telefonee.validacao(numero)){
            telefone.add(new Telefonee(label, numero));
            return;   
        }
        throw new RuntimeException("fail: Contato não adicionado");
    }
    boolean remover(int index){
        if(index < 0 || index >= telefone.size()){
            throw new RuntimeException("fail: Contato não removido");
        }
       telefone.remove(index);
        return true;
    }
    public abstract boolean Plus(TreeMap<String, Contato> contatos, String nome, Contato contato);
    public String toString(){
        String saida = this.nome;
        int i = 0;
        for(Telefonee telefones : telefone){
            saida += " [" + i + ":" + telefones + "]\n";
            i++;
        }
        return saida;
    }
}