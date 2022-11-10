package banco;

public class GerenciadorDeTransacao {
    public void begin() {
        System.out.println("Comecando a transacao");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
