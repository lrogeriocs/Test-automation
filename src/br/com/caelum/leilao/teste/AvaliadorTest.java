package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente(){
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Violao");
		leilao.propoe(new Lance(maria,100.0 ));
		leilao.propoe(new Lance(jose,300.0 ));
		leilao.propoe(new Lance(joao,500.0 ));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 500;
		double menorEsperado = 100;
		double mediaEsperada = 300;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorpreco(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorPreco(), 0.0001);
		assertEquals(mediaEsperada, leiloeiro.getMedia(), 0.0001);
		
	}
	
	@Test
	public void deveEntenderApenasUmLance(){
		Usuario joao = new Usuario("joao");
		Leilao leilao = new Leilao("PS3");
		leilao.propoe(new Lance(joao, 200.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(200, leiloeiro.getMaiorpreco(), 0.00001);
		assertEquals(200, leiloeiro.getMenorPreco(), 0.00001);
	}
	 @Test
	    public void deveEncontrarOsTresMaioresLances() {
	        Usuario joao = new Usuario("João");
	        Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 100.0));
	        leilao.propoe(new Lance(maria, 200.0));
	        leilao.propoe(new Lance(joao, 300.0));
	        leilao.propoe(new Lance(maria, 400.0));

	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);

	        List<Lance> maiores = leiloeiro.getTresMaiores();

	        assertEquals(3, maiores.size());
	        assertEquals(400, maiores.get(0).getValor(), 0.00001);
	        assertEquals(300, maiores.get(1).getValor(), 0.00001);
	        assertEquals(200, maiores.get(2).getValor(), 0.00001);
	    }
	 
	 @Test
	 public void deveEntenderLeilaoEmOrdemRandomica(){
		 	Usuario joao = new Usuario("João");
	        Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 900.0));
	        leilao.propoe(new Lance(maria, 1000.0));
	        leilao.propoe(new Lance(joao, 530.0));
	        leilao.propoe(new Lance(maria, 120.0));
	        leilao.propoe(new Lance(maria, 12.0));
	        leilao.propoe(new Lance(maria, 1200.0));
	        leilao.propoe(new Lance(maria, 70000.0));
	        
	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);
	        
	        
	        double maiorPreco = 70000.0;
	        double menorPreco = 12.0;
	        List<Lance> maiores = leiloeiro.getTresMaiores();
	        
	        assertEquals(maiorPreco, leiloeiro.getMaiorpreco(), 0.0001);
	        assertEquals(menorPreco, leiloeiro.getMenorPreco(), 0.0001);
	        assertEquals(3, maiores.size());
	        assertEquals(maiorPreco, maiores.get(0).getValor(), 0.00001);
	        assertEquals(1200, maiores.get(1).getValor(), 0.00001);
	        assertEquals(1000, maiores.get(2).getValor(), 0.00001);
	        
	        		
	 }
	 
	 @Test
	 public void deveEntenderEmOrdemDecrescente(){
		 Usuario joao = new Usuario("João");
		    Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 9000.0));
	        leilao.propoe(new Lance(maria, 1000.0));
	        leilao.propoe(new Lance(joao, 530.0));
	        
	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);
	        
	        assertEquals(9000, leiloeiro.getMaiorpreco(), 0.11111);
	        assertEquals(530, leiloeiro.getMenorPreco(), 0.11111);
		 
	 }
	 
	 @Test
	 public void deveEncontrarTresMaioresEmCincoLances(){
		 Usuario joao = new Usuario("João");
	        Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 900.0));
	        leilao.propoe(new Lance(maria, 1000.0));
	        leilao.propoe(new Lance(joao, 530.0));
	        leilao.propoe(new Lance(maria, 120.0));
	        leilao.propoe(new Lance(maria, 12.0));
	        
	        Avaliador l = new Avaliador();
	        
	        l.avalia(leilao);
	        List<Lance> maiores = l.getTresMaiores();
	        
	        assertEquals(3, maiores.size());
	        assertEquals(1000, maiores.get(0).getValor(), 0.00001);
	        assertEquals(900, maiores.get(1).getValor(), 0.00001);
	        assertEquals(530, maiores.get(2).getValor(), 0.00001);
	 }

	 @Test
	 public void deveEncontrarTresMaioresEmDoisLances(){
		 Usuario joao = new Usuario("João");
	        Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 900.0));
	        leilao.propoe(new Lance(maria, 1000.0));
	        
	        
	        Avaliador l = new Avaliador();
	        
	        l.avalia(leilao);
	        List<Lance> maiores = l.getTresMaiores();
	        assertEquals(2, maiores.size());
	        assertEquals(1000, maiores.get(0).getValor(), 0.00001);
	        assertEquals(900, maiores.get(1).getValor(), 0.00001);
	 }
	 
	 @Test
	 public void deveEncontrarTresMaioresEmNenhumLance(){
		 Usuario joao = new Usuario("João");
	        Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        
	        Avaliador l = new Avaliador();
	        
	        l.avalia(leilao);
	        List<Lance> maiores = l.getTresMaiores();
	        assertEquals(0, maiores.size());
	 }
}
