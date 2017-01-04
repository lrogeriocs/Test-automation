package br.com.caelum.leilao.teste;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.servico.MatematicaMaluca;

public class MatematicaMalucaTest {

	@Test
	public void deveMultiplicarPorNumerosMaioresQue30(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(50*4, m.contaMaluca(50));
	}
	
	@Test
	public void deveMultiplicarPorNumerosMaioresQue10eMenoresQue30(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(15*3, m.contaMaluca(15));
	}
	
	@Test
	public void deveMultiplicarPorNumerosMenoresQue10(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(5*2, m.contaMaluca(5));
	}
}
