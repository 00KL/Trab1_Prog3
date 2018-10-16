package eleicao;

import java.util.*;

public class Coligacao {
	private ArrayList<String> coligacao = new ArrayList<String>();
	private int votos;
	private int eleitos;
	
	Coligacao(String coligacao){
		if (coligacao.contains(" / ")) {
			String aux[] = coligacao.split(" / ");
			for (String s : aux) {
				this.coligacao.add(s);
			}			
		} else {
			this.coligacao.add(coligacao);
		}
	}
	

	public ArrayList<String> getColigacao() {
		return coligacao;
	}

	public void setColigacao(ArrayList<String> coligacao) {
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
		
		String retorno = this.coligacao.get(0);
		
		for (int i = 1; i < this.coligacao.size(); i++) {
			retorno += " / " + this.coligacao.get(i);
		}
		
		return retorno;
	}
	
	//1  -Coligação:  PPS  /  PROS,  32411  votos,  4  candidatos  eleitos
	public String imprimeColigacao() {
		if(this.coligacao == null) {
			return "";
		}
		
		String saida = this.coligacao.get(0);
		
		for (int i = 1; i < this.coligacao.size(); i++) {
			saida += " / " + this.coligacao.get(i);
		}
		
		saida += ", " + this.getVotos() + " votos, ";

		if(this.getEleitos() > 1){
			saida += Integer.toString(this.getEleitos()) + " candidatos eleitos";
		}
		else{
			saida += Integer.toString(this.getEleitos()) + " candidato eleito";
		}
		
		return saida;
	}
	
	public boolean comparaColigacao(Coligacao col) {
		for(String s : col.getColigacao()) {
			if (!(this.coligacao.contains(s))) {
				return false; 
			}
		}
		for(String s : this.getColigacao()) {
			if (!(col.coligacao.contains(s))) {
				return false; 
			}
		}
		return true;
	}
	
}
