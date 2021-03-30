import java.util.*;
import java.util.Scanner;
class Tweet{
    int id;
    String nome;
    String mensagem;
    TreeSet<String> curtir;
    public Tweet(int id, String nome, String mensagem){
        this.id = id;
        this.nome = nome;
        this.mensagem = mensagem;
        this.curtir = new TreeSet<String>();
    }
    public void Curtir(String username){
        for(String user : curtir)
            if(user.equals(username))
                return;
        curtir.add(username);
    }
    public String toString(){
        String saida = "";
        saida += "id: " + this.id + " Nome: " + this.nome + " Mensagem: " +"[" + this.mensagem + "]"+ "\n";
        if(curtir.size() > 0){
            saida += "[ ";
            for(String user : this.curtir)
                saida += user + " ";
            saida += "]";
        }
        return saida;
    }
}

class User{
    String nome;
    ArrayList<Tweet> timeline; 
    TreeMap<String, User> seguidores;
    TreeMap<String, User> seguir;
    int nãoLidos;
    public User(String id){
        this.nome = id;
        nãoLidos = 0;
        timeline  = new ArrayList<Tweet>();
        seguidores = new TreeMap<String, User>();
        seguir = new TreeMap<String, User>();   
    }
    public void Seguir(User other){
        if(seguir.containsKey(other.nome)){
            throw new RuntimeException("fail: já está seguindo");
        }
        this.seguir.put(other.nome, other);
        other.seguidores.put(this.nome, this);
    }
    public void NãoSeguir(String nome){
        if(!seguir.containsKey(nome)){
            throw new RuntimeException("fail: voce não é seguidor");
        }
        User other = seguir.get(nome);
        this.seguir.remove(nome);
        other.seguidores.remove(this.nome);
    }
    public Tweet gerarTweet(int id){
        for(Tweet twteet : timeline){
            if(twteet.id == id)
                return twteet;
        }
        throw new RuntimeException("fail: Tweet não encontrado");
    }
    public void enviarT(Tweet twteet){
        this.timeline.add(twteet);
        for(User user : seguidores.values()){
            user.timeline.add(twteet);
            user.nãoLidos += 1;
        }
    }
    public String getTimeline(){
        String saida = "";
        for(Tweet twteet : this.timeline)
            saida += twteet + "\n";
        return saida;
    }
    public String getnLidos(){
        String saida = "";
        for(int i = timeline.size() - nãoLidos; i < timeline.size(); i++)
            saida += timeline.get(i);
        nãoLidos = 0;
        return saida;
    }
    public String toString(){
        return "Nome: " + this.nome + "\n" +  " Seguindo: [" + seguir.keySet() + "] "+ " Seguidores: [" + seguidores.keySet() + "]" + "\n";
    }
    
}

class Controle{
    TreeMap<String, User> usuario;
    TreeMap<Integer, Tweet> tweets;
    int nextTwT = 0;
    public Controle(){
        usuario = new TreeMap<String, User>();
    }
    public void Enviar(String nome, String mensagem){
        User usuario = this.getUser(nome);
        Tweet twteet = new Tweet(nextTwT++, nome, mensagem);
        usuario.enviarT(twteet);
    }
    public void adicionaUser(String nome){
        User user = usuario.get(nome);
        if(user == null){
            usuario.put(nome, new User(nome));
        }
        return;
    }
    public User getUser(String nome){
        User user = usuario.get(nome);
        if(user == null){
            throw new RuntimeException("fail: O usuario não encontrado");
        }
        return user;
    }
    public String toString(){
        String saida = "";
        for(User user : usuario.values())
            saida += user;
        return saida;
    }
}
public class twiterr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controle twet = new Controle();
        
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            try {
                if (ui[0].equals("end"))
                    break;
                else if (ui[0].equals("adicionaUser")) {
                    twet.adicionaUser(ui[1]);
                } else if (ui[0].equals("Ver")) {
                 System.out.print(twet);
                } else if (ui[0].equals("Seguir")) {//goku tina
                    User one = twet.getUser(ui[1]);
                    User two = twet.getUser(ui[2]);
                    one.Seguir(two);
                }
                else if (ui[0].equals("twittar")) {
                    String nome = ui[1];
                    String mensagem = "";
                    for(int i = 2; i < ui.length; i++)
                        mensagem += ui[i] + " ";
                    twet.Enviar(nome, mensagem);
                }
                else if (ui[0].equals("timeline")) {
                    User user = twet.getUser(ui[1]);
                    System.out.print(user.getTimeline());
                }
                else if (ui[0].equals("Curtir")) {
                    User user = twet.getUser(ui[1]);
                    Tweet twe = user.gerarTweet(Integer.parseInt(ui[2]));
                    twe.Curtir(ui[1]);
                }else if (ui[0].equals("Deixardeseguir")) {
                    User user = twet.getUser(ui[1]);
                    user.NãoSeguir(ui[2]);
                }else{
                    throw new RuntimeException("fail: comando invalido");
                }
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
        scanner.close();
    }
}
