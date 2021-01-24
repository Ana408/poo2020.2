import java.util.ArrayList;

class passageiro{
  String nome;
  int idade;
  passageiro(String nome, int idade){
      this.nome = nome;
      this.idade = idade; 
  }
  public String toString(){
      return "Nome: " + nome + " Idade: " + idade;
  }
}

class transporte{
   ArrayList<passageiro> assento;
   int preferencial;
   transporte( int quantidade, int preferencial){
       this.preferencial = preferencial;
       this.assento = new ArrayList<>();
       for(int i = 0; i < quantidade; i++){
             assento.add(null);
       }
   }

   void adicionarpassageiro(String nome,int idade){
    int cont =0 ;
    for(passageiro assento : assento){
        if(assento != null && assento.nome.equals(nome)){
            System.out.println("O passageiro já se encontra sentado na topic");
            return;
        }
    }
    for(int i=preferencial; i < assento.size(); i++)
        if(assento.get(i) != null)
        cont++;

    for(int i=0; i < assento.size(); i++){
        if(idade >= 55 && (i < preferencial) && assento.get(i) == null){
            assento.set(i, new passageiro(nome,idade));
            return;
        }
        if(idade >= 55 && (i >= preferencial) && assento.get(i) == null){
            assento.set(i, new passageiro(nome,idade));
            return;
        }
        if(i >= preferencial && assento.get(i) == null){
            assento.set(i, new passageiro(nome,idade));
            return;
        }
        if((cont == assento.size() - preferencial) && idade < 55 && i < preferencial && assento.get(i) == null) {
            assento.set(i, new passageiro(nome,idade));
            return;
        }
    }
    System.out.println("Não há mais vagas");
   }

   void removerpassageiro(String nome){
    for(int i=0; i < assento.size(); i++)
            if(assento.get(i) != null && assento.get(i).nome.equals(nome)){
                 assento.set(i, null);
              return;
    }
    System.out.println("Não há passageiro com essa identificação no transporte !!");
   }

   public String toString(){
    String saida = "[";
    int i = 0;
    for (passageiro assento : assento) {
        if(i < preferencial && assento == null){
            saida += " @ ";
        }else if(i >= preferencial && assento == null){
            saida += " = ";
        }else
            saida += " " + assento + " ";
        i++;
    }
    return saida + "]";
}
}

public class topic {
    public static void main(String[] args) {
        transporte Transporte = new transporte(5,1);
        System.out.println(Transporte);
        Transporte.adicionarpassageiro("Ana",98);
        Transporte.adicionarpassageiro("karine",89);
        Transporte.adicionarpassageiro("mikael",83);
        Transporte.adicionarpassageiro("Ana",19);
        Transporte.adicionarpassageiro("Bia",79);
        Transporte.adicionarpassageiro("joão",880);
        System.out.println(Transporte);
        Transporte.removerpassageiro("Ana");
        Transporte.removerpassageiro("mikael");
        System.out.println(Transporte);
    }
}
