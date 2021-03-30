

public class Poupança extends Conta{
     float redimento;
    Poupança(int chaveConta, String nomeCli) {
        super(chaveConta, nomeCli);
         this.redimento = (float) 1.00;
    }
    void taxas(){
        saldo *= redimento;
    }

}