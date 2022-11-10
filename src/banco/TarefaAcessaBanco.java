package banco;

public class TarefaAcessaBanco implements Runnable {
    private PoolDeConexao poolDeConexao;
    private GerenciadorDeTransacao tx;
    public TarefaAcessaBanco(PoolDeConexao poolDeConexao, GerenciadorDeTransacao tx) {
        this.poolDeConexao = poolDeConexao;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (poolDeConexao){
            System.out.println("Peguei a chave do pool");
            poolDeConexao.getConnection();

            synchronized (tx){
                System.out.println("conectando gerenciar a tx");
                tx.begin();
            }
        }
    }
}
