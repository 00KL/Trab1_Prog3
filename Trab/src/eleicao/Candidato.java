package eleicao;

public class Candidato {
	
	private char situacao;//eleito, invalido, nenhum
	private int colocacao;//colocaçao nas eleições
	private int num;//numero do candidato
	private String nome;
	private Partido partido;
	private Coligacao coligacao;
	private int votos;
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = new Partido(partido);
	}
	public void setPartido(Partido part) {
		this.partido = part;
	}
	
	public Coligacao getColigacao() {
		return coligacao;
	}
	public void setColigacao(String coligacao) {
		if (coligacao.contains(" / ")) {
			this.coligacao = new Coligacao(coligacao);			
		} else {
			this.coligacao = new Coligacao(this.partido.getNome());
		}
	}
	public void setColigacao(Coligacao col) {
		this.coligacao = col;
	}

	public void setPartido_colicagacao(String partido_colicagacao) {
		if (partido_colicagacao.contains(" - ")) {
			String divide[] = partido_colicagacao.split(" - ");
			this.setPartido(divide[0]);
			this.setColigacao(divide[1]);
		} else {
			this.setPartido(partido_colicagacao);
			this.coligacao = new Coligacao(partido_colicagacao);
		}
	}
	
	
	public char getSituacao() {
		return situacao;
	}
	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
	
	public int getColocacao() {
		return colocacao;
	}
	public void setColocacao(String colocacao) {
		if(colocacao.length() == 5) {//caso o tamanho da string seja 5 
									 //havera um char de status na primeira
									 //posicao
			this.setSituacao(colocacao.charAt(0));//pegando o status do candidato
			
			this.colocacao = Integer.parseInt(colocacao.substring(1, 5));// as demais
													//posiçoes serão necessariamente
													//um inteiro
		} else {
			this.setSituacao('n');//caso não haja situação relevante a ser 
								  //setada 'n' significa nenhuma
			this.colocacao = Integer.parseInt(colocacao);// no caso de não haver
													//status basta converter de
													//string para int
		}
		
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public void setVotos(int entrada) {
		this.votos = entrada;
	}
	
	@Override
	public String toString() {
		String saida = this.getNome();
		saida += " ("+this.partido.imprimeNomePartido()+", "+this.getVotos()+" votos)";


		if (this.getColigacao().getColigacao().get(0) != this.getPartido().getNome()) {
			saida += " - Coligação: "+this.getColigacao();						
		}
		saida += "\n";
		
		return saida;
	}
	
	public void arrumaPartidoEColigacao (Dados data) {
		boolean check = false;
		for (Coligacao col : data.getListaColigacoes().getColigacoes()) {
			if (this.getColigacao() == null) {
				check = true;
				break;
			}
			if (this.getColigacao().comparaColigacao(col)) {
				this.setColigacao(col);
				check = true;
				break;
			}
		}
		if (!check) {
			data.getListaColigacoes().getColigacoes().add(this.getColigacao());
		}
		check = false;
		for (Partido part : data.getListaPartidos().getPartidos()) {
			if (part.getNome().equals(this.getPartido().getNome())) {
				this.setPartido(part);
				check = true;
				break;
			}
		}
		if (!check) {
			data.getListaPartidos().getPartidos().add(this.getPartido());
		}	
	}
	
	public void arrumaVotosPartidoEColigacao() {
		if (this.getColigacao() != null) {
			this.getColigacao().setVotos(this.getColigacao().getVotos()+this.getVotos());	
		}
		this.getPartido().setVotos(this.getPartido().getVotos()+this.getVotos());
	}
	
	public void arrumaEleito(Dados data) {
		data.getListaCandidatos().setCandidato(this);
		data.setVotosTotais(data.getVotosTotais()+this.getVotos());
		if(this.getSituacao() == '*') {
			data.getListaCandidatos().setEleito(this);
			if (this.getColigacao() != null) {
				this.getColigacao().setEleitos(this.getColigacao().getEleitos()+1);					
			}
			this.getPartido().setEleitos(this.getPartido().getEleitos()+1);
		}
	}
}