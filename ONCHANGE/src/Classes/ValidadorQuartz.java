package Classes;

/**
 * CLASSE RESPONSÁVEL POR ARMAZENAR VALOR NAS VARIÁVEIS ESTÁTICAS TIPO E URL
 * @author WILLIAN
 *
 */
public class ValidadorQuartz {
	
	static private int tipo;
	static private String url;
	
	public ValidadorQuartz() {
		
	}
	
	public ValidadorQuartz(int tipo,String url) {
		setTipo(tipo);
		setUrl(url);
	}
	
	public static int getTipo() {
		return tipo;
	}

	public static void setTipo(int tipo) {
		ValidadorQuartz.tipo = tipo;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ValidadorQuartz.url = url;
	}

	/**
	 * MÉTODO QUE PEGA O OBJETO VALIDADORQUARTZ
	 * @return RETORNA UM NOVO OBJETO RECEBENDO OS VALORES DAS VARIÁVEIS ESTÁTICAS
	 */
	public static ValidadorQuartz getValidador() {
		return new ValidadorQuartz(tipo,url);
	}
}
