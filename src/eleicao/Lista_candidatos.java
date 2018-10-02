package eleicao;

import java.util.LinkedList;

public class Lista_candidatos {
	private int vagas = 0;
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private LinkedList<Candidato> eleitos = new LinkedList<Candidato>();
	private LinkedList<Candidato> maisVotados = new LinkedList<Candidato>();
	
	
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
	
//	public void setMaisVotado(Candidato c) {
//		if(this.maisVotados.size() == this.vagas) {
//			
//		}
//		
//		if(this.maisVotados.isEmpty()) {
//			this.maisVotados.add(c);
//		}
//		else if(this.maisVotados.getLast().getVotos() )
//	}
	
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
	
	public String eleitos() {
		String saida = "Vereadores eleitos:\n";
		int cont = 0;
		for (Candidato c : this.eleitos) {
			cont++;
			saida += Integer.toString(cont) + " - " + c;
		}
		
		return saida;
	}
	
	
}