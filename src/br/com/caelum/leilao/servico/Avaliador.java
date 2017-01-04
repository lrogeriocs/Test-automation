package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorpreco = Double.NEGATIVE_INFINITY;
	private double menorPreco = Double.POSITIVE_INFINITY;
	private double media = 0;
	private List<Lance> maiores;
	
	public void avalia(Leilao leilao){
		double total = 0;
		for(Lance lance: leilao.getLances()){
			if(lance.getValor()>maiorpreco){
				maiorpreco = lance.getValor();
			}
			if(lance.getValor()<menorPreco){
				menorPreco= lance.getValor();
		 	}
			total += lance.getValor();
		}
		media = total/leilao.getLances().size();
		pegaOsMaioresNo(leilao);
	}
	
	 private void pegaOsMaioresNo(Leilao leilao) {
	        maiores = new ArrayList<Lance>(leilao.getLances());
	        Collections.sort(maiores, new Comparator<Lance>() {

				public int compare(Lance o1, Lance o2) {
					if(o1.getValor() < o2.getValor()) return 1;
	                if(o1.getValor() > o2.getValor()) return -1;
	                return 0;
				}
	         
	        });
	        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	    }
	 public List<Lance> getTresMaiores() {
	        return this.maiores;
	    }
	 
	public double getMaiorpreco() {
		return maiorpreco;
	}
	public double getMedia() {
		return media;
	}
	public double getMenorPreco() {
		return menorPreco;
	}
}
