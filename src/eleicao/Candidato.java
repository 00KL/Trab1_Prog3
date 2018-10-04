package eleicao;

public class Candidato {
//Seq.(i);N伹.;Candidato;Partido/Coliga鈬o;Vota鈬o;% V疝idos
//	N伹ero de vagas;
//	� Candidatos eleitos (sempre indicado partido, n伹ero de votos e coliga鈬o, se houver)
//	� Candidatos mais votados dentro do n伹ero de vagas;
//	� Candidatos n縊 eleitos e que seriam eleitos se a vota鈬o fosse majorit疵ia;
//	� Candidatos eleitos no sistema proporcional vigente, e que n縊 seriam eleitos se a vota鈬o fosse
//	majorit疵ia, isto �, pelo n伹ero de votos apenas que um candidato recebe diretamente;
//	� Votos totalizados por coliga鈬o ou partido (quando um partido n縊 estiver em coliga鈬o), n伹ero de
//	candidatos eleitos;
//	� Votos totalizados por partido, n伹ero de candidatos eleitos;
//	� Total de votos nominais.
	
	//a escolha do formato int foi feita pois na leitura de int 
	//� converter Strings com '.' e ','
	
	private char situacao;//eleito, invalido, nenhum
	private int colocacao;//coloca鈬o nas elei鋏es
	private int num;//numero do candidato
	private String nome;
	//private String partido;
	private Partido partido;
	//private String coligacao;
	private Coligacao coligacao;
	private int votos;
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = new Partido(partido);
	}
	
	public Coligacao getColigacao() {
		return coligacao;
	}
	public void setColigacao(String coligacao) {
		
		this.coligacao = new Coligacao(coligacao);
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
													//posi鋏es ser縊 necessariamente
													//um inteiro
		} else {
			this.setSituacao('n');//caso n縊 haja situa鈬o relevante a ser 
								  //setada 'n' significa nenhuma
			this.colocacao = Integer.parseInt(colocacao);// no caso de n縊 haver
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
								//E regularizar com as sa冝as futuras
		this.votos = (int) ret;
	}
	
	@Override
	//FABRﾍCIO GANDINI (PPS, 7611 votos) - Coliga鈬o: PPS / PROS
	public String toString() {
		String saida = this.getNome();
		saida += " ("+this.getPartido()+", "+this.getVotos()+" votos)";
		saida += " - Coliga鈬o: "+this.getColigacao();			
		saida += "\n";
		//System.out.println("algo\n");
		return saida;
	}
	
}