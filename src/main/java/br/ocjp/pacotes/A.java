package br.ocjp.pacotes;


import br.ocjp.pacotes.exemploSubPacote.C;
import static br.ocjp.pacotes.exemploOutroSubPacote.F.*;

/**
 * OBS: uma classe não pode importar outra classe que esteja no pacote padrão/default e
 * por padrão todas as classes do java.lang são importadas
 */
public class A {
    public static void main (String ...args){

        //não existe necessidade de importar essa classe porque B ta no mesmo pacote de A
        B b = new B();

        //import no topo da classe, deve ser depois da declaração de pacote e antes da declaração de classe
        C c = new C();

        //utilização do Full Qualified Name
        br.ocjp.pacotes.exemploSubPacote.D d = new br.ocjp.pacotes.exemploSubPacote.D();

        //metodo importado da classe F
        metodoStatic();

        //constante importado da classe F
        System.out.println(TESTE);

    }
}


