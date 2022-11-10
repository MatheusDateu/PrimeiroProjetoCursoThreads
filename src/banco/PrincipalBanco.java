package banco;

public class PrincipalBanco {

    public static void main(String[] args) {
        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao poolDeConexao = new PoolDeConexao();

        new Thread(new TarefaAcessaBanco(poolDeConexao,tx)).start();
        new Thread(new TarefaAcessaBancoProcedimento(poolDeConexao,tx)).start();
    }
}
