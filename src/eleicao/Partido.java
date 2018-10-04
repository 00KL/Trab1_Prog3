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

	//1 -PPS,  31036  votos,  4  candidatos  eleito
	@Override
	public String toString() {
		String saida = this.nome + ", ";
		
		saida += this.getVotos() + "votos, ";
		saida += Integer.toString(this.getEleitos()) + " candidatos eleitos";
		
		return saida;
	}
	

}
