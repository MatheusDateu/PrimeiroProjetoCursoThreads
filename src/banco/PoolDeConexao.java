package banco;public class PoolDeConexao {

    public String getConnection() {
        System.out.println("Emprestando conexao");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "connection";
    }
}
