package projeto03lapiseira;

enum grafite{

    Gra2(0.5f,"2B",2,20), // 2mm , 20mm
    Gra3(0.7f,"4B",4,20), // 4mm , 20mm
    Gra4(0.9f,"6B",6,20); // 6mm , 20mm
    float calibre;
    String dureza;
    int maciez;
    int tamGrafite;
    grafite(float calibre, String dureza, int maciez,  int tamGrafite) {
      this.calibre = calibre;
     this.dureza = dureza;
     this.maciez = maciez;
     this.tamGrafite = tamGrafite;
 }
 
 public String toString() {
     return "Calibre: " + calibre + " Dureza: " + dureza + " Maciez: " + maciez;
 }}

 class iniciarLapis {
    float calibreMax;
    int qtdgrafite;
    int qtdfolhas;
    int folhaEscrita ;
    iniciarLapis(float calibreMax, int qtdgrafite, int qtdfolhas,int folhaEscrita){
       this.calibreMax = calibreMax;
       this.qtdgrafite = qtdgrafite; 
       this.qtdfolhas = qtdfolhas;
   this.folhaEscrita = folhaEscrita;
    }

    boolean inserir(grafite Grafite){
        if(Grafite.calibre > this.calibreMax){
            System.out.println("Não suporta");
            return false;
        }if(Grafite.calibre < this.calibreMax){
            System.out.println("É menor, vai cair !!!");
            return false;
        }if (Grafite.calibre == this.calibreMax && this.qtdgrafite >= 1){
            System.out.println("Só um por vez !!");
            return false;
        }if(Grafite.calibre == this.calibreMax && this.qtdgrafite == 0)
            this.qtdgrafite += 1;
            return true;   
    }

    boolean remover(grafite Grafite){
        if(Grafite.calibre == this.calibreMax && this.qtdgrafite == 1)
        this.qtdgrafite-= 1;
       return true;
    }
     boolean escrever(grafite folhas){
        if(this.qtdgrafite == 0){
          System.out.println("Sem grafite !");
          return false;
        }
        if(folhas.calibre == this.calibreMax && this.qtdgrafite == 1)
            System.out.println("Escreveram quantas folhas ??");
            while(folhas.maciez < folhas.tamGrafite && this.qtdfolhas <= 10){
                folhas.tamGrafite  -= folhas.maciez;
                 this.qtdfolhas-=1;
                 this.folhaEscrita +=1;
                 
            }
           System.out.println(this.folhaEscrita);
           System.out.println("Folhas restantes ?? ");
           System.out.println(this.qtdfolhas);
           
           return true;
        
           
     }
      boolean grafiteacabar(grafite acabar){
        if(acabar.tamGrafite % acabar.maciez >= 0)
           System.out.println("Sem grafite suficiente para escrever !");
           return true;
      }
     
     public String toString() {
        return "Calibre : " + calibreMax + " Quantidade de grafite: " + qtdgrafite + " Quantidade da folha: " + qtdfolhas ;
    }
 }
 
public class Lapiseira{
    public static void main(String[] args) {
        iniciarLapis lapiseira = new iniciarLapis(0.5f,0,10,0);// calibreMáx, maciez e tamanhoGrafite
        System.out.println("Lapiseira");
        System.out.println(lapiseira);
        lapiseira.inserir(grafite.Gra2);
        System.out.println(lapiseira);
        lapiseira.remover(grafite.Gra2);
        System.out.println(lapiseira);
        lapiseira.inserir(grafite.Gra2);
        System.out.println(lapiseira);
        lapiseira.escrever(grafite.Gra2);
        lapiseira.grafiteacabar(grafite.Gra2);
        }
        }
