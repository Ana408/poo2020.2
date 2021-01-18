import java.util.ArrayList;
class Espiral{
    public String nome;
    public int qtd;
    public float preco;

    public Espiral(String nome, int qtd, float preco){
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String toString(){
        return "Nome: " + nome + " Quantidade: " + qtd +" Preço: " + preco;
    }
}

class maquina{
    float saldoLiquido;
    float saldoCliente;
    int maxProd;
    ArrayList<Espiral> espiral;

    maquina(int qtdEspirais, int maxProd){
        this.saldoLiquido = 0;
        this.saldoCliente = 0;
        this.maxProd = maxProd;
        this.espiral = new ArrayList<>();
        for(int i=0; i < qtdEspirais; i++)
            this.espiral.add(new Espiral("-", 0, 0));
    }

    void alterarEspiral(int i, String produto, int qtd, float preco){
        if(i >= 0 && i < espiral.size())
            espiral.set(i, new Espiral(produto, qtd, preco)); 
    }
    
    void depositar(float dinheiro){
        saldoCliente += dinheiro; 
    }

    void removerEspiral(int i){
        if(i >= 0 && i < espiral.size()){
            espiral.remove(i);
            espiral.add(i, new Espiral("-", 0, 0));
       }
    }

    void compras(int i){
        if(saldoCliente > 0){
            float valorP = espiral.get(i).preco;
            saldoLiquido += valorP;
            saldoCliente -= valorP;
            espiral.get(i).qtd -= 1;
            
            if(saldoCliente < 0)
                saldoCliente = 0;
            
            if(espiral.get(i).qtd < 0)
                espiral.get(i).qtd = 0;
        }else
            System.out.println("Por favor, efetue um deposito , não podemos fazer nenhuma operação sem que haja saldo suficiente");
    }

    void Troco(){
        System.out.println("Valor disponível: " + saldoCliente + " R$");
        saldoCliente = 0;
    }

    public String toString(){
        String saida = "Valor disponível: "+ saldoCliente + "\n";
        int i = 0;
        for(Espiral espiral : espiral){
    saida +=  i + " [" + espiral.nome + " , " + espiral.qtd + " , R$ " + espiral.preco + " ]\n";
            i++;
        }
        return saida;
    }

public static class junkfood {
    public static void main(String[] args) {
        maquina Maquina = new maquina(3, 4);
        System.out.println(Maquina);
        Maquina.alterarEspiral(0, "waffler", 2, 1.50f);
        Maquina.alterarEspiral(1, "sucrilhos", 3, 2.50f); 
        Maquina.alterarEspiral(2, "chettos", 5, 5.20f); 
        System.out.println(Maquina);
        Maquina.removerEspiral(0);
        System.out.println(Maquina);
        Maquina.depositar(5f);
        Maquina.depositar(8f);
        Maquina.depositar(2f);
        System.out.println(Maquina);
        Maquina.compras(1);
        Maquina.compras(2);
        System.out.println(Maquina);
        Maquina.Troco();

        System.out.println(Maquina);
    }
}
}