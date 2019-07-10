package Factory;

/**
 * CLASSE QUE VERIFICA O TIPO DE VERIFICAÇÃO
 * @author willian
 *
 */
public class FactoryTipo {
	
	/**
	 * MÉTODO QUE VERIFICA QUAL TIPO DE VERIFICAÇÃO SERÁ FEITO
	 * @param tipo TIPO DE VERIFICAÇÃO
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
