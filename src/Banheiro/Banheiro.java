package Banheiro;

public class Banheiro {
    public void fazNumero1() {

        String nome = Thread.currentThread().getName();
        System.out.println(nome + " esta batendo na porta\n");

        synchronized (this) {

            System.out.println(nome + " esta Entrando no banheiro");
            System.out.println(nome + " esta Fazendo coisa rapida");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nome + " esta Dando descarga");
            System.out.println(nome + " esta Lavando a mao");
            System.out.println(nome + " esta Saindo do banheiro\n");
        }
    }
    public void fazNumero2() {

        String nome = Thread.currentThread().getName();
        System.out.println(nome + " esta batendo na porta\n");
        synchronized (this) {

            System.out.println(nome + " esta Entrando no banheiro");
            System.out.println(nome + " esta Fazendo coisa demorada");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nome + " esta Dando descarga");
            System.out.println(nome + " esta Lavando a mao");
            System.out.println(nome + " esta Saindo do banheiro\n");
        }
    }
}
