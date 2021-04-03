
public class Poupança extends Conta{
    float redimento;
   Poupança(int chaveConta, String nomeCli) {
       super(chaveConta, nomeCli);
       this.tipoConta = "Conta-Poupança";
        this.redimento = (float) 1.00;
   }
   void taxas(){
       saldo *= redimento;
   }

}