package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {
    private final ExecutorService threadPool;
    private final ServerSocket serverSocket;
    private boolean estaRodando;

    public ServidorTarefas() throws IOException {
        System.out.println("--- Iniciando servidor ---");

        this.serverSocket = new ServerSocket(12345);
        this.threadPool = Executors.newCachedThreadPool();
        this.estaRodando = true;
    }

    public void rodar() throws IOException {
        while(this.estaRodando) {
            try {

                Socket socket = serverSocket.accept();
                System.out.println("Aceitando novo cliente na porta: " + socket.getPort());

                DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket, this);
                threadPool.execute(distribuirTarefas);
            } catch (SocketException e){
                System.out.println("SocketException, esta rodando? " + this.estaRodando);
            }
        }
    }

    public void parar() throws IOException {
        serverSocket.close();
        threadPool.shutdown();
        estaRodando = false;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ServidorTarefas servidorTarefas = new ServidorTarefas();
        servidorTarefas.rodar();
        servidorTarefas.parar();
    }
}
