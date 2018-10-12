package eleicao;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Lista_candidatos {
	private int vagas = 0;
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private LinkedList<Candidato> eleitos = new LinkedList<Candidato>();
	private LinkedList<Candidato> maisVotados = new LinkedList<Candidato>();
	private LinkedList<Candidato> eleitosMajoritaria = new LinkedList<Candidato>();
	private LinkedList<Candidato> beneficiados = new LinkedList<Candidato>();
	
	
	Lista_candidatos() {}
	
	//Entradas
	public void setCandidato(Candidato c) {
		this.candidatos.add(c);
	}
	
	public void setEleito(Candidato c) {
		this.eleitos.add(c);
		this.setVagas(this.getVagas() + 1);
	}
	
	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	
	
	//Tratamento de dados
//	public void 

	
	//Strings

	@Override
	public String toString() {
		String saida = "";
		for (Candidato c : candidatos) {
			if (c.getSituacao() == '*') {
				saida += c.getColocacao()+"- ";
			}
			saida += c.toString();
		}
		return saida;
	}
	
	
	public LinkedList<Candidato> getEleitos() {
		return eleitos;
	}	

	public LinkedList<Candidato> getMaisVotados() {
		return maisVotados;
	}

	public LinkedList<Candidato> getEleitosMajoritaria() {
		return eleitosMajoritaria;
	}

	public LinkedList<Candidato> getBeneficiados() {
		return beneficiados;
	}
	

	@SuppressWarnings("unchecked")
	public void preencheListas () {
		this.maisVotados = (LinkedList<Candidato>) this.candidatos.clone();
		Collections.sort(this.maisVotados, new Comparator<Candidato>() {
			@Override
			public int compare(Candidato a, Candidato b) {
				return b.getVotos() - a.getVotos();
			}
		});
		

		
		for(Candidato c : this.eleitos) {
			if (this.maisVotados.indexOf(c)+1 >= this.getVagas()) {
				this.beneficiados.add(c);
			}
		}
		
		int cont = 0;
		for(Candidato c : this.maisVotados) {
			if (cont < this.beneficiados.size() && !(this.eleitos.contains(c))) {
				this.eleitosMajoritaria.add(c);
				cont++;
			}
		}
		
	}
	
	public String toStringListaEleitos(LinkedList<Candidato> lista) {
		String saida = new String();
		int cont = 0;
		for (Candidato c : lista) {
			cont++;
			saida += Integer.toString(cont) + " - " + c;
		}
		return saida;
	}
	
	public String toStringListaMaisVotados(LinkedList<Candidato> lista) {
		String saida = new String();
		int cont = 0;
		for (int i = 0; i < this.getVagas(); i++) {
			cont++;
			saida += Integer.toString(cont) + " - " + lista.get(i);
		}
		return saida;
	}
	
	public String toStringListaEleitosMajoritaria(Lista_candidatos lista) {
		String saida = new String();
		for (Candidato c : lista.eleitosMajoritaria) {
			saida += Integer.toString(lista.maisVotados.indexOf(c)+1) + " - " + c;
		}
		return saida;
	}
	
	public String toStringListaBeneficiados(Lista_candidatos lista) {
		String saida = new String();
		for (Candidato c : lista.beneficiados) {
			saida += Integer.toString(lista.maisVotados.indexOf(c)+1) + " - " + c;
		}
		return saida;
	}
	

	
	
	
	
	
}