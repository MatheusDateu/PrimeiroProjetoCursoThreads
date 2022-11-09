package MeusTestes;

public class Main {
    public static final int LIMIT = 1000;
    public static final int MAXIMO = 100000;
    public static void main(String[] args) throws InterruptedException{

        for(int i = 0; i < LIMIT; i++) {
            new Thread(()->{
                for(int j = 0; j < MAXIMO; j++)
                    System.out.printf("%d; ", j+1);
            }).start();
            System.out.printf("%d; ", i);
        }



    }
}