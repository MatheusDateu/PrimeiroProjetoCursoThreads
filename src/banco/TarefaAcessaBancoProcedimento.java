package banco;

public class TarefaAcessaBancoProcedimento implements Runnable {

    private PoolDeConexao poolDeConexao;
    private GerenciadorDeTransacao tx;

    public TarefaAcessaBancoProcedimento(PoolDeConexao poolDeConexao, GerenciadorDeTransacao tx) {
        this.poolDeConexao = poolDeConexao;
        this.tx = tx;
    }

    @Override
    public void run() {

        synchronized (poolDeConexao) {
            System.out.println("pegue a conexao");
            poolDeConexao.getConnection();
        }
        synchronized (tx) {
            System.out.println("comecando a tx");
            tx.begin();
        }
    }
}
