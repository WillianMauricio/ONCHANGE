package Factory;


/**
 * INTERFACE DAS FÁBRICAS
 * @author willian
 *
 */
public interface ITipo {

	/**
	 * MÉTODO EM COMUM ENTRE AS CLASSES QUE IMPLEMENTAM A INTERFACE
	 * @param url URL DO SITE
	 * @return RETORNA VALOR BOOLEANO
	 */
	public boolean verifica(String url);
}
