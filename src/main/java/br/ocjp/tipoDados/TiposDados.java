package br.ocjp.tipoDados;

import br.ocjp.interfaceFuncional.MyConsumer;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * OBS: Java Exige que as variáveis SEMPRE sejam inicializadas antes de serem utilizadas,
 * caso contrario ocorrerá um erro de compilação
 */
public class TiposDados {

    //Inicialização inplícita com valores defaults quando a classe é inicializada.
    private byte a;
    private short b;
    private int c;
    private long d;
    private float e;
    private double f;
    private char g;
    private boolean h;


    public static void main(String ...args){
        separador(TiposDados::variavelDeclaradaExplicitamente,"Variavel declarada localmente");
        separador(TiposDados::variavelDeclaradaImplicitamente,"Acessando variável inicializada implicitamente");
    }

    private static void separador(MyConsumer consumer, String titulo){
        consumer.print(titulo);
    }
    private static void variavelDeclaradaExplicitamente() {
        int x = 10; // inicialização inicializada de forma explícita
        System.out.println(x);
    }


    private static void variavelDeclaradaImplicitamente() {
        Field[] declaredFields = TiposDados.class.getDeclaredFields();
        Arrays.asList(declaredFields).stream().forEach(field -> {
            try {
                System.out.println(field.getType()+" : "+field.get(new TiposDados()));
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        });
    }


}
