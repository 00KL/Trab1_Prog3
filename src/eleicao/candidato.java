package eleicao;

public class Candidato {
//Seq.(i);Núm.;Candidato;Partido/Coligação;Votação;% Válidos
//	Número de vagas;
//	• Candidatos eleitos (sempre indicado partido, número de votos e coligação, se houver)
//	• Candidatos mais votados dentro do número de vagas;
//	• Candidatos não eleitos e que seriam eleitos se a votação fosse majoritária;
//	• Candidatos eleitos no sistema proporcional vigente, e que não seriam eleitos se a votação fosse
//	majoritária, isto é, pelo número de votos apenas que um candidato recebe diretamente;
//	• Votos totalizados por coligação ou partido (quando um partido não estiver em coligação), número de
//	candidatos eleitos;
//	• Votos totalizados por partido, número de candidatos eleitos;
//	• Total de votos nominais.
	
	//a escolha do formato int foi feita pois na leitura de int 
	//é converter Strings com '.' e ','
	
	private char situacao;//eleito, invalido, nenhum
	private int colocacao;//colocação nas eleições
	private int num;//numero do candidadto
	private String nome;
	//private String partido;
	private Partido partido;
	//private String coligacao;
	private Coligacao coligacao;
	private int votos;
	
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	public String getColigacao() {
		return coligacao;
	}
	public void setColigacao(String coligacao) {
		this.coligacao = coligacao;
	}
	

	public void setPartido_colicagacao(String partido_colicagacao) {
		if (partido_colicagacao.contains(" - ")) {
			String divide[] = partido_colicagacao.split(" - ");
			this.setPartido(divide[0]);
			this.setColigacao(divide[1]);
		} else {
			this.setPartido(partido_colicagacao);
			this.setColigacao("");
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
													//posições serão necessariamente
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
	public void setVotos(float votos) {
		float ret = votos*1000; //*1000 para tirar o ponto
								//E regularizar com as saídas futuras
		this.votos = (int) ret;
	}
	
	@Override
	//FABRÍCIO GANDINI (PPS, 7611 votos) - Coligação: PPS / PROS
	public String toString() {
		String saida = this.getNome();
		saida += " ("+this.getPartido()+", "+this.getVotos()+" votos)";
		if (this.getColigacao() != "") {
			saida += " - Coligação: "+this.getColigacao();			
		}
		saida += "\n";
		//System.out.println(saida);
		return saida;
	}
	
}