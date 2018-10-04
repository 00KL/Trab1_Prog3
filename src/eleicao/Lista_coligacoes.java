package eleicao;

import java.util.*;

public class Lista_coligacoes {
	private LinkedList<Coligacao> coligacoes = new LinkedList<Coligacao>();

	public LinkedList<Coligacao> getColigacoes() {
		return coligacoes;
	}

	public void setColigacoes(LinkedList<Coligacao> coligacoes) {
		this.coligacoes = coligacoes;
	}
	
	public void ordena_coligacoes() {
		Collections.sort(this.coligacoes, new Comparator<Coligacao>() {
			@Override
			public int compare(Coligacao a, Coligacao b) {
				return a.getVotos() - b.getVotos();
			}
		});
	}
	
	public String toString() {
		ordena_coligacoes();
		int i = 0;
		String saida = "";
		
		for (Coligacao c : coligacoes) {
			i++;
			saida += Integer.toString(i) + " - " + c.imprimeColigacao() + "\n";
		}
		
		return saida;
	}
	    
	    

	

}
