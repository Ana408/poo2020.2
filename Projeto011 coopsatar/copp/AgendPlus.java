package copp;
import java.util.ArrayList;
import java.util.TreeMap;

public class AgendPlus extends AgendaT{
    TreeMap<String, Contato> favorito;
    public AgendPlus(){
        this.favorito = new TreeMap<>();
    }
    public ArrayList<Contato> Starred(){
        ArrayList<Contato> Estrela = new ArrayList<>();
            Estrela.addAll(favorito.values());
        return Estrela;
    }
    public boolean removerC(String nome){
        if(this.contatos.containsKey(nome)){
            contatos.remove(nome);
            return true;
         }
         if(this.favorito.containsKey(nome)){
             favorito.remove(nome);
             return true;
          }
          throw new RuntimeException("fail: Contato não removido");
    }
    public void adicionarF(String nome){
        Contato conta = contatos.get(nome);
        if(!contatos.get(nome).starred){
            conta.starred = true;
            favorito.put(nome,conta);
            return;
        }
        throw new RuntimeException("fail: Favorito não adicionado");
    }
    public void removerF(String nome){
        Contato conta = contatos.get(nome);
        if(contatos.get(nome).starred){
            conta.starred = false;
            favorito.remove(nome);
            return;
        }
        throw new RuntimeException("fail: favorito removido");
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(Contato contatos : this.contatos.values())
            if(favorito.containsKey(contatos.nome)){
                saida.append("@ " + contatos.nome + " " + contatos.telefone +"\n");
            }else
                saida.append("- " + contatos.nome + " " + contatos.telefone + "\n");
        return saida.toString();
    }
}