package br.ocjp.escopoVariaveis;


import br.ocjp.interfaceFuncional.MyConsumer;

public class Exemplos {

    private static int x;
    private int y;

    public static void main(String ...args){
        separador(Exemplos::exemplo1,"Exerc 1");
        separador(Exemplos::exemplo2,"Exerc 2");
        separador(Exemplos::exemplo3,"Exerc 3");
        separador(()->new Exemplos().exemplo4(30),"Exerc 4");

    }

    private static void separador(MyConsumer consumer, String titulo) {
        consumer.print(titulo);
    }

    /**
     * Exemplo que demonstra como funciona declaração de variável e seu scopo.
     */
    private static void exemplo1() {
        for(int x = 0; x < 10 ; x++){
            System.out.println(x); // imprime de 0 a 9
        }
        int i = 15;
        System.out.println(i); // imprime 15
    }

    /**
     * Exemplo demonstra varias formas de acessar uma variável estática
     */
    private static void exemplo2() {
        x = 10;
        System.out.println(x);
        System.out.println(Exemplos.x);
        System.out.println(new Exemplos().x);
    }

    /**
     * Exemplo que demonstra a possibilidade de declarar variavel local com mesmo nome da variavel declarada na classe
     */
    private static void exemplo3(){
        int x = 20; // cria uma nova variável no scopo do método
        System.out.println(x); // acessa a variável do scopo do método
        System.out.println(Exemplos.x); // acessa variável statica
    }

    /**
     * precisa de uma instancia, pois não é static, demonstra tecnica de shadowing
     * @param x
     */
    private void exemplo4(int x){
        System.out.println(x); // aprensenta valor passado como parametro
        System.out.println(this.x); // printa 10, porque no metodo exemplo2 o mesmo foi alterado, e como é static ele é compartilhado.
        System.out.println(this.y); // printa valor default
    }

}
