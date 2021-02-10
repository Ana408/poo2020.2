import java.util.*;

class Telefonee{
    String label;
    String numero;

    public Telefonee(String label, String numero){
        this.label = label;
        this.numero = numero;
    }
public static boolean validacao(String numero){
        String valido = "0123456789()-";
        for(int i = 0; i < numero.length(); i++){
            char a = numero.charAt(i);
            if(valido.indexOf(a) == -1)
                return false;
        }
        return true;
    }
    public String toString(){
        return " Id: " + label + " Número: " + numero;
    }
}

class Contatoss{
    String nome;
    ArrayList<Telefonee> telefone;
    boolean starred;
   
    public Contatoss(String nome){
        this.nome = nome;
        this.telefone = new ArrayList<>();
    }
     void adicionar(String label, String numero){
        if(Telefonee.validacao(numero)){
            telefone.add(new Telefonee(label, numero));
            return;   
        }
        System.out.println("invalido444");
    }
    boolean remover(int index){
        if(index < 0 || index >= telefone.size()){
            System.out.println("Invalido");
            return false;
        }
       telefone.remove(index);
        return true;
    }
    
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
class AgendaTelefonicaa{
    TreeMap<String, Contatoss> contato;
    TreeMap<String, Contatoss> Favoritos;
   
    public AgendaTelefonicaa(){
    this.contato = new TreeMap<>();
    this.Favoritos = new TreeMap<>();
   }

   void adicionarC(String nome , List<Telefonee> telefone){
         if(!this.contato.containsKey(nome)){
          contato.put(nome, new Contatoss(nome));
         }
          for(int i=0; i < telefone.size(); i++){
            contato.get(nome).adicionar(telefone.get(i).label, telefone.get(i).numero);
          }
   }

    boolean removerT(String nome, int index){
        if(contato.containsKey(nome)){
            contato.get(nome).remover(index);           
           return true;
        }
        System.out.println("Telefone não existe");
        return false;
    }
    boolean removerC(String nome){
        if(this.contato.containsKey(nome)){
            contato.remove(nome);
            return true;
         }
         if(this.Favoritos.containsKey(nome)){
             Favoritos.remove(nome);
             return true;
          }
          System.out.println("Contato não existe");
        return false;
    }
    ArrayList<Contatoss> search(String patter){
        ArrayList<Contatoss> busca = new ArrayList<>();
            if(this.contato.containsKey(patter)){
                busca.add(contato.get(patter));
            }
        
        return busca;
    }
    void adicionarF(String nome){
        Contatoss contatos = contato.get(nome);
        if(!contato.get(nome).starred){
            contatos.starred = true;
            Favoritos.put(nome,contatos);
            return;
        }
        System.out.println("Contato não existe");
    }

    void removerF(String nome){
        Contatoss contatos = contato.get(nome);
        if(contato.get(nome).starred){
            contatos.starred = false;
            Favoritos.remove(nome);
            return;
        }
        System.out.println("Contato nãooo existe");
    }

    ArrayList<Contatoss> Starred(){
        ArrayList<Contatoss> Favorito = new ArrayList<>();
            Favorito.addAll(Favoritos.values());
        return Favorito;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(Contatoss contato : this.contato.values())
            if(Favoritos.containsKey(contato.nome)){
                saida.append("@ " + contato.nome + " " + contato.telefone +"\n");
            }else
                saida.append("- " + contato.nome + " " + contato.telefone + "\n");
        return saida.toString();
    }
}

public class favorito{
    public static void main(String[] args) {
       AgendaTelefonicaa agenda = new AgendaTelefonicaa();
       System.out.println("Contatos:");
       agenda.adicionarC("Pedro", Arrays.asList(new Telefonee("OI", "8585"), new Telefonee("CLARO", "9999")));
       agenda.adicionarC("Karine", Arrays.asList(new Telefonee("Tim", "3434")));
       agenda.adicionarC("Mikael", Arrays.asList(new Telefonee("VIVO", "5454")));
       System.out.println(agenda);

       System.out.println("Contatos Favoritos:");
       agenda.adicionarF("Karine");
       agenda.adicionarF("Mikael");
       for(Contatoss Favoritos : agenda.Starred())
            System.out.println(Favoritos);

       System.out.println("Números removidos: ");
        agenda.removerT("Pedro", 1);
        System.out.println(agenda);
        System.out.println("Contatos removidos: ");
        agenda.removerC("G");
        System.out.println(agenda); 

        System.out.println("Favoritos removidos: ");
        agenda.removerF("Karine");
        for(Contatoss Favoritos : agenda.Starred())
            System.out.println(Favoritos);
        
        
        System.out.println("Busca por nome de Contato: ");
        for(Contatoss contatos : agenda.search("Mikael"))
            System.out.println(contatos);
        
        System.out.println(agenda);
    }
}

