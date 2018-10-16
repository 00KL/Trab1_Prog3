package eleicao;

public class Partido {
	private String nome;
	private int votos;
	private int eleitos;
	
	Partido(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public int getEleitos() {
		return eleitos;
	}

	public void setEleitos(int eleitos) {
		this.eleitos = eleitos;
	}

	
	@Override
	public String toString() {
		String saida = this.nome + ", ";
		
		saida += this.getVotos() + " votos, ";
		
		if(this.getEleitos() > 1){
			saida += Integer.toString(this.getEleitos()) + " candidatos eleitos";
		}
		else{
			saida += Integer.toString(this.getEleitos()) + " candidato eleito";
		}
		
		
		return saida;
	}
	
	public String imprimeNomePartido () {
		String saida = this.nome;
		
		return saida;
	}
	

}
