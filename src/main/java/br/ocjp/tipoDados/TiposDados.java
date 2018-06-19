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
        new TiposDados().init();
    }

    private void init() {
        separador(this::utilizandoVariavelDeclaradaExplicitamente,"Variavel declarada localmente");
        separador(this::utilizandoVariavelDeclaradaImplicitamente,"Acessando variável inicializada implicitamente");
        separador(this::resultadosPontosFlutuantes,"Possíveis resultados para pontos flutuantes");
        separador(this::variavelInicializadaEmBlocosCondicionais,"Variáveis em blocos condicionais");
    }

    private static void separador(MyConsumer consumer, String titulo){
        consumer.print(titulo);
    }

    /**
     * Demonstra como é uma declaração explícita e sua utilização
     */
    private void utilizandoVariavelDeclaradaExplicitamente() {
        int x = 10; // inicialização inicializada de forma explícita
        System.out.println(x);
    }

    /**
     * Demonstra os resultados como (Infinity, -Infinity, NaN) utilizando variáveis do tipo flutuantes
     */
    private void resultadosPontosFlutuantes(){
        float a = 10;
        float b = -10;
        float c = 0;
        System.out.println(a/c); //Infinity
        System.out.println(b/c); //-Infinity
        System.out.println(c/c); //NaN

        //(OBS: se o tipo fosse inteiro dividindo por ZERO, o resultado seria exception: ArithmeticException by zero)

    }
    private void utilizandoVariavelDeclaradaImplicitamente() {
        Field[] declaredFields = TiposDados.class.getDeclaredFields();
        Arrays.asList(declaredFields).stream().forEach(field -> {
            try {
                System.out.println(field.getType()+" : "+field.get(new TiposDados()));
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        });
    }

    /**
     * Uma variável programada para ser inicializada dentro de um bloco condicional, pode não ser inicializada, impedindo
     * sua utilização fora do block. segue exemplo:
     */
    private void variavelInicializadaEmBlocosCondicionais(){
        int a = 10;
        int b;
        if(a > 0){
            b = 20;
            System.out.println(b); //Compilada
        }
        //System.out.println(b); //Erro de compilação, pois não temos garantia que b foi inicializada.
    }


}
