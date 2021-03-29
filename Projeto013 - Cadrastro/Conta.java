

public abstract class Conta {
    int chaveConta;
    float saldo;
    static String nomeCli;
    String tipoConta;

    Conta(int chaveConta, String nomeCli){
        this.chaveConta = chaveConta;
        Conta.nomeCli = nomeCli;
        this.saldo = 0;
    }
    void depositar(float valor){
         saldo += valor;
    }
    void sacar(float valor){
         if(saldo <= 0 || valor > saldo){
          throw new RuntimeException("fail: Saldo Insuficiente");
         }else
         saldo -= valor;
    }
    void transferencia(Conta otherConta,float valor){
        sacar(valor);
        otherConta.depositar(valor);
    }
    abstract void taxas();

    public String toString(){
        return chaveConta + ":" + nomeCli + ":" + saldo + ":" + tipoConta;
    }
}