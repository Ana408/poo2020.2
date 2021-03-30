package copp;
import java.util.ArrayList;
import java.util.TreeMap;
public abstract class AgendaT{
    TreeMap<String, Contato> contatos;

    AgendaT(){
        this.contatos = new TreeMap<>();
    }

    public void adicionarC(ContatoPlus contatoPlus){
        if(!this.contatos.containsKey(contatoPlus.nome))
            contatos.put(contatoPlus.nome, new ContatoPlus(contatoPlus.nome, contatoPlus.telefone));
        for(int i=0; i < contatoPlus.telefone.size(); i++)
            contatos.get(contatoPlus.nome).adicionar(contatoPlus.telefone.get(i).label, contatoPlus.telefone.get(i).numero);
    }

    ArrayList<Contato> search(String patter){
        ArrayList<Contato> busca = new ArrayList<>();
        if(this.contatos.containsKey(patter))
            busca.add(contatos.get(patter));
        return busca;
    }

    public abstract void adicionarF(String nome);
    public abstract void removerF(String id);
    public abstract ArrayList<Contato> Starred();
    public abstract boolean removerC(String nome);
    abstract public String toString();
}