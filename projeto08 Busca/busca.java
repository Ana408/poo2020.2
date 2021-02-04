import java.util.*;

class Telefone{
    String label;
    String numero;

    public Telefone(String label, String numero){
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

class Contato{
    String nome;
    ArrayList<Telefone> telefone;

    public Contato(String nome){
        this.nome = nome;
        this.telefone = new ArrayList<>();
    }
     void adicionar(String label, String numero){
        if(Telefone.validacao(numero)){
            telefone.add(new Telefone(label, numero));
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
        for(Telefone telefones : telefone){
            saida += " [" + i + ":" + telefones + "]\n";
            i++;
        }
        return saida;
    }
}
class AgendaTelefonica{
    ArrayList<Contato> contato;
   public AgendaTelefonica(){
       this.contato = new ArrayList<>();
   }

   int encontrar(String nome){
        for(int i = 0; i < this.contato.size(); i++)
            if(this.contato.get(i).nome.equals(nome)){
                return i;
            }
        return -1;
   }
   void adicionarC(String nome , List<Telefone> telefone){
       for(int i = 0; i < telefone.size(); i++){
           if(encontrar(nome) != -1){
               this.contato.get(encontrar(nome)).adicionar(telefone.get(i).label,telefone.get(i).numero);
           }
         Contato contato = new Contato(nome);
         contato.adicionar(telefone.get(i).label, telefone.get(i).numero);
                this.contato.add(contato);
    }
   }

    boolean removerT(String nome, int index){
        if(encontrar(nome) != -1){
            this.contato.get(encontrar(nome)).remover(index);           
           return true;
        }
        return false;
    }
    boolean removerC(String nome){
        if(encontrar(nome) != -1){
            this.contato.remove(encontrar(nome));           
           return true;
        }
        return false;
    }
    ArrayList<Contato> search(String patter){
        ArrayList<Contato> busca = new ArrayList<>();
        for(Contato contato : this.contato){
            if(contato.toString().contains(patter)){
                busca.add(contato);
            }
        }
        return busca;
    }
    Contato getContato(String nome){
        for(int i=0; i < this.contato.size(); i++)
            if(this.contato.get(i).nome.equals(nome)){
                return contato.get(i);
            }
        return null;
    }

    public String toString(){
        String saida = " ";
        for(Contato contato : contato)
            saida += contato;
        return saida + " ";
    }
}

class ComparadorC implements Comparator<Contato> {
    public int compare(Contato arg0, Contato arg1){
        if(arg0.nome.compareTo(arg1.nome) != 0)
            return arg0.nome.compareTo(arg1.nome);
        return arg1.nome.compareTo(arg0.nome);
    }
}
public class busca{
    public static void main(String[] args) {
       AgendaTelefonica agenda = new AgendaTelefonica();
       System.out.println("Contatos:");
       agenda.adicionarC("Pedro", Arrays.asList(new Telefone("OI", "8585"), new Telefone("CLARO", "9999")));
       agenda.adicionarC("Karine", Arrays.asList(new Telefone("Tim", "3434")));
       agenda.adicionarC("Mikael", Arrays.asList(new Telefone("VIVO", "5454")));
       agenda.adicionarC("Gustavo", Arrays.asList(new Telefone("CLARO", "4567")));  
       System.out.println(agenda);
       System.out.println("Números removidos: ");
        agenda.removerT("Pedro", 0);
        System.out.println(agenda);
        System.out.println("Contatos removidos: ");
        agenda.removerC("Gustavo");
        System.out.println(agenda); 
        System.out.println("Busca por telefone: ");
        for(Contato contato : agenda.search("4")){
            System.out.println(contato);
        }
        System.out.println("Busca por nome de Contato: ");
        for(Contato contato : agenda.search("Mi")){
            System.out.println(contato);
        }
        System.out.println("Retorna por nome de Contato: ");
        System.out.println(agenda.getContato("Karine"));
        System.out.println("Contato em ordem: ");
        Collections.sort(agenda.contato, new ComparadorC());
        System.out.println(agenda);



    }
}

