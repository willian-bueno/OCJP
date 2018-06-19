package br.ocjp.interfaceFuncional;

@FunctionalInterface
public interface Separador {

    void callBack();

    default void print(String titulo){
        System.out.println("-------------------");
        System.out.println(titulo);
        System.out.println("-------------------");
        this.callBack();
    }
}
