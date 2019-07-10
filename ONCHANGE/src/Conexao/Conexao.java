package Conexao;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * CLASSE RESPONS�VEL POR REALIZAR O TESTE DE CONEX�O
 * @author willi
 *
 */
public class Conexao {
	
	/**
	 * M�TODO QUE TESTA A CONEX�O
	 * @param address URL DO SITE
	 * @return RETORNA SE O SITE EST� DISPON�VEL OU N�O
	 */
	public boolean testaConexao(String address) {
		try {
			URL url = new URL(address);
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}