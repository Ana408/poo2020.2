import java.util.*;

import copp.Telefonee;
import copp.Contato;
import copp.ContatoPlus;
import copp.AgendaT;
import copp.AgendPlus;


public class copp {
    public static void main(String[] args) {
        AgendaT agenda = new AgendPlus();
        System.out.println("Contatos:");
       agenda.adicionarC(new ContatoPlus("Lucca", Arrays.asList(new Telefonee("oio", "8585"), new Telefonee("cla", "9999"))));
       agenda.adicionarC(new ContatoPlus("Karine", Arrays.asList(new Telefonee("Tim", "3434"))));
       agenda.adicionarC(new ContatoPlus("Mikael", Arrays.asList(new Telefonee("VIVO", "5454"))));
       System.out.println(agenda);
       
       
       agenda.adicionarF("Karine");
       agenda.adicionarF("Mikael");
       

       agenda.removerC("Lucca");  
       System.out.println(agenda);
    
       System.out.println("Contatos Favoritos:");
       for(Contato Favoritos : agenda.Starred())
            System.out.println(Favoritos);

                System.out.println("Contatos Favoritos:");
            agenda.removerF("Karine");  
            System.out.println(agenda);
    }
}

