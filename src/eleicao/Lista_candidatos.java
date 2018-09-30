package eleicao;

import java.util.LinkedList;

public class Lista_candidatos {
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	
	public void setCandidato(Candidato c) {
		this.candidatos.add(c);
	}

	Lista_candidatos() {}
	
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
}