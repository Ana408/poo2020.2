package copp;
import java.util.List;
import java.util.TreeMap;
public class ContatoPlus extends Contato{
    public List<Telefonee> telefone;
    boolean starred;
    public TreeMap<String, Contato> contatos;
   
    public ContatoPlus(String nome, List<Telefonee> list){
        super(nome);
        this.telefone = list;
    }
    

    public boolean Plus(TreeMap<String, Contato> contatos, String nome, Contato contato) {
        this.contatos = contatos;
        if(contatos.get(nome).starred){
            contato.starred = false;
            return true;
        }
        contato.starred = true;
        return false;
    }
    
}