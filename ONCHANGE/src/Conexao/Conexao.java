package Conexao;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * CLASSE RESPONSÁVEL POR REALIZAR O TESTE DE CONEXÃO
 * @author willi
 *
 */
public class Conexao {
	
	/**
	 * MÉTODO QUE TESTA A CONEXÃO
	 * @param address URL DO SITE
	 * @return RETORNA SE O SITE ESTÁ DISPONÍVEL OU NÃO
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