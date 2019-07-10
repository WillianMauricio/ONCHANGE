package Factory;

/**
 * CLASSE QUE VERIFICA O TIPO DE VERIFICA��O
 * @author willian
 *
 */
public class FactoryTipo {
	
	/**
	 * M�TODO QUE VERIFICA QUAL TIPO DE VERIFICA��O SER� FEITO
	 * @param tipo TIPO DE VERIFICA��O
	 * @param url URL DO SITE
	 * @return RETORNA TRUE OU FALSE
	 */
	public boolean verificaTipo(int tipo, String url) {
		if(tipo == 1) {
			FactoryTesta testa = new FactoryTesta();
			return testa.verifica(url);
		}else if(tipo == 2){
			FactoryMudanca muda = new FactoryMudanca();
			return !muda.verifica(url);
		} else {
			return false;
		}
	}
}
