package Factory;


/**
 * INTERFACE DAS F�BRICAS
 * @author willian
 *
 */
public interface ITipo {

	/**
	 * M�TODO EM COMUM ENTRE AS CLASSES QUE IMPLEMENTAM A INTERFACE
	 * @param url URL DO SITE
	 * @return RETORNA VALOR BOOLEANO
	 */
	public boolean verifica(String url);
}
