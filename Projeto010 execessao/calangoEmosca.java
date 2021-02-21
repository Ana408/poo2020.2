import java.util.ArrayList;
abstract class Pett{
    String nome;
    int bucho; 
    int maxBucho;
    int nPatas;
    int vida;
    boolean alive;
    int asa;
    public Pett(String nome, int maxBucho){
        this.nome = nome;
        this.bucho = maxBucho;
        this.maxBucho = maxBucho;
        this.nPatas = 4;
        this.vida = 8;
        this.asa = 2;
        this.alive = true;
    }
    String getNome() {
        return nome;
    }
    abstract void comer(int qtd); //eh abstrata
     boolean Vivo(){
        if(vida <= 0){
            throw new RuntimeException("fail: vida acabou");
    }else
        return true;
     }
}
interface Adoravel{
    void correr();
}
class Calango extends Pett implements Adoravel{
    public Calango(String nome, int maxBucho){
        super(nome, maxBucho);
    }
    public void correr() {
        if(Vivo()){
        if (nPatas < 4 && vida <= 0) {
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if (bucho > 0) {
            bucho -= 2;
            vida-=1;
            System.out.println("Corre pra pegar a Mosca calango lesado");
            return;
        }else
        System.out.println("Estou muito cansado");
    }
    }
    void busca(){
        if(Vivo()){
        System.out.println("Levantei a cabeça e cadê esse troço");}
    }
    @Override
    void comer(int qtd) {
        if(Vivo()){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else
        bucho =10;
            vida+=1;
            System.out.println("Tô cheio");}
    }
    
    public String toString() {
        return "Bucho Calango: " + bucho + "/" + maxBucho + " Patas: " + nPatas  + " Alive: " + alive + " Vida: " + vida + "\n";
    }
}
class Mosca extends Pett implements Adoravel{
    public Mosca(String nome, int maxBucho){
        super(nome, maxBucho);
    }
    public void comer(int qtd){
        bucho += qtd;
        if(Vivo()){
        if(bucho > maxBucho ){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            bucho =10;
            vida+=1;
            System.out.println("Tô cheio");
        }
    }
    }
     public void voar(){
        if(Vivo()){
        if (bucho > 0 && asa == 2 && nPatas == 4){
            bucho -= 2;
            System.out.println("Opa! posso voar ");
        }else
            System.out.println("Nao posso voar");
    }
     }
     void matar(){
        if(nPatas > 0){
            nPatas -= 4;
            asa-=2;
            vida -=8;
            System.out.println("Ouch! Perdi pata e asa");
        }
        if (nPatas <= 0 && asa <= 0 && vida <= 0){
            alive = false;
            System.out.println("morri!!");
        }else
        System.out.println("Nao posso morrer");
    }
    public void correr() {
        if(Vivo()){
        if (nPatas < 4 && vida <= 0) {
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if (bucho > 0) {
            bucho -= 2;
            vida-=1;
            System.out.println("Fugir desse calango logo");
            return;
        }else
        System.out.println("Estou muito cansado");
    }
    } 
    public String toString() {
        return "Bucho da Mosca: " + bucho + "/" + maxBucho + " Patas: " + nPatas  + " Alive: " + alive + " Vida: " + vida + " Asas: " + asa + "\n";
    }
}
class CalangoPreto extends Calango{
   public CalangoPreto(String nome,int maxBucho){
        super(nome, maxBucho);
    }
    String getNome(){
        return "deadlango PRETO: " + super.getNome();
    }
    public void comer(int qtd){
        super.comer(qtd);
    }
    public void correr() {
        super.correr();
    }

    void matar(Pett pet){
        if(Vivo()){
        pet.nome = "RIP ... " + pet.nome;}
    }

    void busca(){
        if(Vivo()){
        System.out.println("Nhaum!!!!!!");}
    }
    public String toString() {
        return "Bucho do Preto: " + bucho + "/" + maxBucho + " Patas: " + nPatas  + " Alive: " + alive + " Vida: " + vida;
    }
}

public class calangoEmosca {
    public static void main(String[] args) {
        ArrayList<Pett> animais = new ArrayList<>();
        animais.add(new Calango("Vamp",10));
        animais.add(new Mosca("Wash",10));
        animais.add(new CalangoPreto("Babe Yoda",10));
        System.out.println(animais);

        //Teste de gastar energia e ganhar energia ,(while) faz que ele zere as energia, 
        //se caso zerar o pet vai comer para restaurar as energias 
        for(Pett pet : animais){
            while(pet.bucho > 1){
            System.out.println("Gastar energia de:" + pet.getNome());
            ((Adoravel) pet).correr();
            System.out.println(animais + "\n");
        }
            if(pet.bucho >= 0 && pet.vida > 0){ 
                System.out.println("Hora do rango: " + pet.getNome());
                pet.comer(0);
                System.out.println(animais + "\n");}
           
        }
        Calango cal = new Calango("Pereira",10);
        System.out.println("Cadê essas moscas em ??");
        cal.busca();
        Pett mosca = new Mosca("toin",10);
        ((Mosca) mosca).voar();
        //((Mosca) mosca).matar();
        CalangoPreto deadlango = new CalangoPreto("chico", 10);
        System.out.println("Cadê essas moscas em ??");
        deadlango.busca(); 
        Pett pet2 = deadlango;
        System.out.println(pet2.getNome());
        deadlango.matar(mosca);
        System.out.println("matou o " + mosca.getNome());
        }
}

