package src;

public class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int vida;
    boolean alive;
    int asa;
    int rabo;
    int magia;
    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxBucho){ //parametros
        this.bucho = maxBucho;
        this.maxBucho = maxBucho;
        this.nPatas = 4;
        this.vida = 4;
        this.alive = true;
        this.asa = 0;
        this.rabo = 1;
        this.magia = 0;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            
            System.out.println("Ouch! Perdi uma pata");
        }else if (nPatas == 0){
            alive = false;
            System.out.println("morri!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }
     void voar(){
        if(nPatas == 0 && asa == 0 ){
            asa += 1;
            System.out.println("Estou perto de voar");
            
        }else if (bucho > 0 && asa == 1 && nPatas == 0){
            asa += 1;
            bucho -= 1;
            rabo -= 1;
            System.out.println("Opa! posso voar e ser uma borboleta");
        }else{
            rabo += 1;
            System.out.println("Nao posso voar,voltarei ser um calango");
        }
     }

    void magia(){
        if(asa == 1 && nPatas == 0){
            System.out.println("Estou perto de adquirir poderes");
       }else if(asa == 2 && nPatas == 0){
             bucho -= 1;
             magia += 1;
             System.out.println("Tenho poderes agora, virei a fada madrinha kkkkkk");
        }else {
             magia -= 1;
             System.out.println("Voltei a ser um mero calango sem poderes");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas  + " Alive: " + alive + " Rabo: " + rabo;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Calango deadlango = new Calango(20);

        System.out.println(deadlango);

        
        for(int i = 0; i < 21; i++)
            deadlango.comer(1);
        System.out.println(deadlango);
        
        for(int i = 0; i < 3; i++)
        deadlango.andar();
    System.out.println(deadlango);

        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        System.out.println(deadlango);
        
        for(int i = 0; i < 3; i++)
        deadlango.andar();
    System.out.println(deadlango);

        deadlango.voar();
        deadlango.magia();
        deadlango.voar();
        deadlango.magia();
        System.out.println(deadlango);
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        System.out.println(deadlango);
        deadlango.voar();
        deadlango.magia();
        System.out.println(deadlango);

    }
}