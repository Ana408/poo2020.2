package copp;


public class Telefonee{
    public String label;
    public String numero;

    public Telefonee(String label, String numero){
        this.label = label;
        this.numero = numero;
    }
public static boolean validacao(String numero){
        String valido = "0123456789()-";
        for(int i = 0; i < numero.length(); i++){
            char a = numero.charAt(i);
            if(valido.indexOf(a) == -1)
                return false;
        }
        return true;
    }
    public String toString(){
        return " Id: " + label + " Número: " + numero;
    }
}