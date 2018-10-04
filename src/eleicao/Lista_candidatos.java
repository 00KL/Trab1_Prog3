package eleicao;

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
			//System.out.printf("Tentando imprimir %s\n", c.getNome());
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
	

	public void preencheListas () {
		int aux = this.getVagas()+1;
		for(int indice = 0; indice < this.candidatos.size() && aux < this.candidatos.size(); indice++) {
		    if (this.candidatos.get(indice).getVotos() >= this.candidatos.get(aux).getVotos() && indice <= this.getVagas()) {
		        this.maisVotados.add(this.candidatos.get(indice));
		        if (indice > this.getVagas()) {
		        	this.beneficiados.add(this.candidatos.get(indice));
		        } else {
		        	this.eleitosMajoritaria.add(this.candidatos.get(indice));
		        }
		    } else {
		    	this.maisVotados.add(this.candidatos.get(aux));
		        aux ++;
		        indice -= 1;
		        if (indice <= this.getVagas()) {
		        	this.eleitosMajoritaria.add(this.candidatos.get(indice));
		        }
		    }
		}
		
	}
	
	public String toStringLista(LinkedList<Candidato> lista) {
		String saida = new String();
		int cont = 0;
		for (Candidato c : lista) {
			cont++;
			saida += Integer.toString(cont) + " - " + c;
		}
		return saida;
	}
	
	public String toStringListaAteVagas(LinkedList<Candidato> lista) {
		String saida = new String();
		int cont = 0;
		for (int i = 0; i < this.getVagas(); i++) {
			cont++;
			saida += Integer.toString(cont) + " - " + lista.get(i);
		}
		return saida;
	}
	
	
	
}