package eleicao;

public class Dados {
	private Lista_candidatos listaCandidatos = new Lista_candidatos();
	private Lista_coligacoes listaColigacoes = new Lista_coligacoes();
	private Lista_partidos listaPartidos = new Lista_partidos();
	private int votosTotais;
	
	public Lista_candidatos getListaCandidatos() {
		return listaCandidatos;
	}
	
	public void setListaCandidatos(Lista_candidatos listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}

	public Lista_coligacoes getListaColigacoes() {
		return listaColigacoes;
	}

	public void setListaColigacoes(Lista_coligacoes listaColigacoes) {
		this.listaColigacoes = listaColigacoes;
	}

	public Lista_partidos getListaPartidos() {
		return listaPartidos;
	}

	public void setListaPartidos(Lista_partidos listaPartidos) {
		this.listaPartidos = listaPartidos;
	}

	public int getVotosTotais() {
		return votosTotais;
	}

	public void setVotosTotais(int votosTotais) {
		this.votosTotais = votosTotais;
	}
	
	
}
