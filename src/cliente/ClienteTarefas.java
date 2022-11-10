package cliente;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);

        System.out.println("Conexao estabelecida");
        Thread threadEnviaComando = new Thread(() -> {
            try {
                System.out.println("Pode enviar comandos!");
                PrintStream saida = new PrintStream(socket.getOutputStream());

                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();

                    if (linha.trim().equals(""))
                        break;

                    saida.println(linha);
                }
                scanner.close();
                saida.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadRebendoResposta = new Thread(() -> {
            System.out.println("--- Recebendo dados do servidor ---");

            Scanner respostaServidor = null;
            try {
                respostaServidor = new Scanner(socket.getInputStream());

                while (respostaServidor.hasNextLine()) {
                    String linha = respostaServidor.nextLine();
                    System.out.println(linha);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        threadRebendoResposta.start();
        threadEnviaComando.start();

        threadEnviaComando.join();

        System.out.println("Fechando socket do cliente");
        socket.close();
    }
}
