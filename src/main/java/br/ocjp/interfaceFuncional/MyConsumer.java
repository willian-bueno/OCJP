package br.ocjp.interfaceFuncional;

@FunctionalInterface
public interface MyConsumer{

    void callBack();

    default void print(String titulo){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(titulo);
        System.out.println("------------------------------------------------------------------------------------------");
        this.callBack();
        System.out.println('\n');
    }
}
