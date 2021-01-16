class Pou{
    private int vida;
    private int vidaMax;
    private boolean alive;
    private  int energia;
    private  int energiaMax;
    private  int bucho;
    private  int buchoMax;
    private int limpeza;
    private int limpezaMax;
    private int diamantes;
    private int idade;
    public Pou(int vidaMax, int energiaMax, int limpezaMax, int buchoMax) {
        this.vida = vidaMax;
        this.vidaMax = vidaMax;
        this.alive = true;
        this.energia = energiaMax;
        this.energiaMax = energiaMax;
        this.bucho = buchoMax;
        this.buchoMax = buchoMax;
        this.limpeza = limpezaMax;
        this.limpezaMax = limpezaMax;
        this.diamantes = 0;
        this.idade = 0;
    }
  
    private void setVida(int value){
        this.vida = value;
        if(this.vida <= 0){
            this.vida = 0;
            System.out.println("Seu pou morreu");
            this.alive = false;
        }
        if(this.vida > vidaMax)
            this.vida = vidaMax;
    }

    public boolean isAlive(){
        if(this.vida > 0 && this.energia > 0 && this.bucho > 0 && this.limpeza > 0){
        return this.alive;}
        System.out.println("Pou morreu");
        return false;
    }

    public void setComer(int qtd){
        this.bucho += qtd;
        if(this.bucho > buchoMax){
            this.bucho = buchoMax;
            System.out.println("Comi até ficar saciado");
            return;
        }
        if(this.bucho <= 0){
            this.bucho = 0;
            System.out.println("Estou com fome");
            this.isAlive();
        }
    }
    public void setLimpeza(int sujar){
        
            this.limpeza += sujar;
        if(this.limpeza > limpezaMax){
            this.limpeza = limpezaMax;
            System.out.println("Estou Limpo");
            return;
        }
        if(this.limpeza <= 0){
            this.limpeza = 0;
            System.out.println("Preciso tomar um banho");
            this.isAlive();
        }
    }
    public void setDormir(int sono){
        
            this.energia += sono;
        if(this.energia > energiaMax){
            this.energia = energiaMax;
            System.out.println("Estou descansado");
            return;
        }
        if(this.energia <= 0){
            this.energia = 0;
            System.out.println("Preciso dormir");
            this.isAlive();
        }
    }
    public void brincar(){
        if(!this.isAlive()){
            return;}
        this.setVida(getVida()-2);
        setDormir(-1);
        setComer(-2);
        setLimpeza(-2);
        diamantes +=1;
        idade += 1;
    }
    public int getVida() {
        return vida;
    }
    public void comer(){
        if(!this.isAlive()){
            return;}
            setDormir(-1);
            setComer(+2);
            setLimpeza(-2);
        idade += 1;
    }
    public void sujo(){
        if(!this.isAlive()){
            return;}
        setDormir(-2);
        setLimpeza(limpezaMax);
        idade += 1;
    }
    public void soneca(){
        if(!this.isAlive()){
            return;}
        if(this.energia < energiaMax){
            for(int i = this.energia; i < energiaMax; i++){
                setDormir(+2);
                idade+=1;
        }
        }
        
    }
    
    public String toString() {
        return "V: " + vida + "/" + vidaMax + " E: "+ energia + "/" + energiaMax + " Alimentação: "+ bucho + "/" +
         buchoMax +" L: " + limpeza + "/" + limpezaMax + " Diamantes: "  + diamantes + " Idade: " + idade ;
         
    }
  }
  
  public class tamagochi{
    public static void main(String[] args) {
        Pou isa = new Pou(10, 10, 10, 10);
        System.out.println(isa);
        System.out.println("Vamos brincar com nosso Pou ??");
        if(isa.isAlive()){
            isa.brincar();
            isa.brincar();
            System.out.println(isa);
            }
            System.out.println("Tá na hora de comer !!");
            isa.comer();
            isa.comer();
            System.out.println(isa);
            System.out.println("Tá na hora de tomar banho !!");
            isa.sujo();
            isa.sujo();
            System.out.println(isa);
            System.out.println("Tá na hora de dormir");
            isa.soneca();
            System.out.println(isa);
    }
  }