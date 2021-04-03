

public class Corrente extends Conta{
    float manutencaoConta;
   Corrente(int chaveConta, String nomeCli) {
       super(chaveConta, nomeCli);
       this.tipoConta = "Conta-Corrente";
       this.manutencaoConta = 20;
   }
    void taxas(){
        saldo -= manutencaoConta;
    }
}