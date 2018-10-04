package eleicao;

public class Coligacao {
	private String coligacao[];
	private int votos;
	private int eleitos;
	
	Coligacao(String coligacao){
		if (coligacao.contains(" / ")) {
			this.coligacao = coligacao.split(" / ");
		} else {
			this.coligacao = null;
		}
	}

	public String[] getColigacao() {
		return coligacao;
	}

	public void setColigacao(String[] coligacao) {
		this.coligacao = coligacao;
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
		// TODO Auto-generated method stub
		if(coligacao == null) {
			return "";
		}
		
		String retorno = coligacao[0];
		
		for (int i = 1; i < coligacao.length; i++) {
			retorno += " / " + coligacao[i];
		}
		
		return retorno;
	}
	
	//1  -Coligação:  PPS  /  PROS,  32411  votos,  4  candidatos  eleitos
	public String imprimeColigacao() {
		String saida = "";
		saida += this.coligacao;
		
		saida += this.getVotos() + "votos, ";
		saida += Integer.toString(this.getEleitos()) + " candidatos eleitos";
		
		return saida;
	}
	
	
	
}
