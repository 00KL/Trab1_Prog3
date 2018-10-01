package eleicao;

public class Coligacao {
	private String coligacao[];
	
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
	
	
	
}
