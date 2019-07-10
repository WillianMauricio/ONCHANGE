package Classes;

/**
 * CLASSE RESPONS�VEL POR ARMAZENAR VALOR NAS VARI�VEIS EST�TICAS TIPO E URL
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
	 * M�TODO QUE PEGA O OBJETO VALIDADORQUARTZ
	 * @return RETORNA UM NOVO OBJETO RECEBENDO OS VALORES DAS VARI�VEIS EST�TICAS
	 */
	public static ValidadorQuartz getValidador() {
		return new ValidadorQuartz(tipo,url);
	}
}
