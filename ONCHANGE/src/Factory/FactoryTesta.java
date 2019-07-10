package Factory;

import Conexao.Conexao;

/**
 * CLASSE QUE INSTANCIA O OBJETO CONEXAO
 * @author willi
 *
 */
public class FactoryTesta implements ITipo{
	
	@Override
	public boolean verifica(String url) {
		Conexao con = new Conexao();
		return con.testaConexao(url);
	}
	
	

}
