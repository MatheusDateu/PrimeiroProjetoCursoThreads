package Banheiro;

public class Principal {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Convidado1");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Convidado2");

        convidado1.start();
        convidado2.start();
    }
}
