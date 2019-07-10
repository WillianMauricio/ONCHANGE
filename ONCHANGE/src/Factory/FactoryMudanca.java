package Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * CLASSE QUE É RESONSÁVEL POR VERIFICAR MUDANÇA NO SITE
 * @author WILLIAN
 *
 */
public class FactoryMudanca implements ITipo {
	
	static private StringBuilder ret;
	static private StringBuilder ret2;
	
	static {
		ret2 = new StringBuilder("");
	}

	@Override
	public boolean verifica(String url) {
		if(read(url) != null) {
			if(!ret2.toString().equals(ret.toString())) {
				return true;
			}
			ret2 = ret;
		}
		return false;
	}

	/**
	 * MÉTODO ESTÁTICO QUE RETORNA HTML DO SITE EM UM STRINGBUILDER
	 * @param endereco URL DO SITE
	 * @return RETORNA UM STRINGBUILDER COM O HTML DO SITE
	 */
	public static StringBuilder read(String endereco) {
		BufferedReader in = null;
		ret = new StringBuilder("");
		try {
			URL url = new URL(endereco);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				ret.append(str);
			}
		} catch (MalformedURLException ex) {
			//System.out.println("Erro");
		} catch (IOException ex) {
			//System.out.println("Erro");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}
}
