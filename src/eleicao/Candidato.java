package eleicao;

public class Candidato {
//Seq.(i);N莨ｹ.;Candidato;Partido/Coliga驤ｬo;Vota驤ｬo;% V逍拱dos
//	N莨ｹero de vagas;
//	�ｿｽ Candidatos eleitos (sempre indicado partido, n莨ｹero de votos e coliga驤ｬo, se houver)
//	�ｿｽ Candidatos mais votados dentro do n莨ｹero de vagas;
//	�ｿｽ Candidatos n邵� eleitos e que seriam eleitos se a vota驤ｬo fosse majorit逍ｵia;
//	�ｿｽ Candidatos eleitos no sistema proporcional vigente, e que n邵� seriam eleitos se a vota驤ｬo fosse
//	majorit逍ｵia, isto �ｿｽ, pelo n莨ｹero de votos apenas que um candidato recebe diretamente;
//	�ｿｽ Votos totalizados por coliga驤ｬo ou partido (quando um partido n邵� estiver em coliga驤ｬo), n莨ｹero de
//	candidatos eleitos;
//	�ｿｽ Votos totalizados por partido, n莨ｹero de candidatos eleitos;
//	�ｿｽ Total de votos nominais.
	
	//a escolha do formato int foi feita pois na leitura de int 
	//�ｿｽ converter Strings com '.' e ','
	
	private char situacao;//eleito, invalido, nenhum
	private int colocacao;//coloca驤ｬo nas elei驪銃s
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
			this.coligacao = null;
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
													//posi驪銃s ser邵� necessariamente
													//um inteiro
		} else {
			this.setSituacao('n');//caso n邵� haja situa驤ｬo relevante a ser 
								  //setada 'n' significa nenhuma
			this.colocacao = Integer.parseInt(colocacao);// no caso de n邵� haver
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
	public void setVotos(String entrada) {
		float votos = Float.parseFloat(entrada);
		float ret;
		if (entrada.contains(".")) {
			ret = votos*1000; //*1000 para tirar o ponto
			//E regularizar com as sa蜀拌s futuras			
		} else {
			ret = votos;
		}
		
		this.votos = (int) ret;
	}
	
	@Override
	//FABR�ｾ垢IO GANDINI (PPS, 7611 votos) - Coliga驤ｬo: PPS / PROS
	public String toString() {
		String saida = this.getNome();
		saida += " ("+this.partido.imprimeNomePartido()+", "+this.getVotos()+" votos)";
		if (this.getColigacao() != null) {
			saida += " - Coliga驤ｬo: "+this.getColigacao();						
		}
		saida += "\n";
		//System.out.println("algo\n");
		return saida;
	}
	
	
}