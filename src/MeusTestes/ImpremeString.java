package MeusTestes;

public class ImpremeString {
    public static Runnable runna() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("T1 esta rodando");
            }
        };
        return r1;
    }

    public static void main(String[] args) {
        Runnable rodavel = runna();
        new Thread(rodavel, "Imprime String").start();
    }
}
