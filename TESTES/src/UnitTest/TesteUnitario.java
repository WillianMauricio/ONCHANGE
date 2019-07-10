package UnitTest;

import Factory.FactoryTipo;
import junit.framework.TestCase;

public class TesteUnitario extends TestCase{
	
	FactoryTipo tipo = new FactoryTipo();
		
	public void testaConexao() {
		assertTrue(tipo.verificaTipo(1, "https://www.youtube.com/"));
	}
	
	public void testaMudanca() {
		assertTrue(tipo.verificaTipo(2, "teste.html"));
	}
	
	public void testaConexao2() {
		assertFalse(tipo.verificaTipo(1, "www.youtube.com/"));
	}
	
	public void testaMudanca2() {
		assertFalse(tipo.verificaTipo(2, "https://www.youtube.com/"));
	}
}
