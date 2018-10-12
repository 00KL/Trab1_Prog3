package eleicao;


import java.io.FileNotFoundException;
import java.util.*;


public class Testador {
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Informações de entradas inválidas");
			System.exit(1);
		}
		Scanner s = IO.le_arquivo(args[0], args[1]);
		Locale ptBR = new Locale("pt", "BR");
		s.useLocale(ptBR);
		s.useDelimiter(";");
		
		Dados data = new Dados();
		
		while(s.hasNext()) {
			
			//Anuncia variavel Candidato
			Candidato c = new Candidato();
			//System.out.printf("[%s] ", linha[0]);//Posicao
			c.setColocacao(s.next());
			System.out.println(c.getColocacao());
			
			//System.out.printf("[%s] ", linha[1]);//Numero
			c.setNum(s.nextInt());
			System.out.println(c.getNum());
			
			//System.out.printf("[%s] ", linha[2]);//Nome
			c.setNome(s.next());
			System.out.println(c.getNome());
			
			//System.out.printf("[%s] ", linha[3]);//Partido/coliga鈬o
			c.setPartido_colicagacao(s.next());
			boolean check = false;
			for (Coligacao col : data.getListaColigacoes().getColigacoes()) {
				if (c.getColigacao() == null) {
					check = true;
					break;
				}
				if (c.getColigacao().comparaColigacao(col)) {
					c.setColigacao(col);
					check = true;
					break;
				}
			}
			if (!check) {
				data.getListaColigacoes().getColigacoes().add(c.getColigacao());
			}
			check = false;
			for (Partido part : data.getListaPartidos().getPartidos()) {
				if (part.getNome().equals(c.getPartido().getNome())) {
					c.setPartido(part);
					check = true;
					break;
				}
			}
			if (!check) {
				data.getListaPartidos().getPartidos().add(c.getPartido());
			}
			System.out.println(c.getPartido());
			System.out.println(c.getColigacao());
			
			//System.out.printf("[%s] ", linha[4]);//votos
			c.setVotos(s.nextInt());
			if (c.getColigacao() != null) {
				c.getColigacao().setVotos(c.getColigacao().getVotos()+c.getVotos());	
			}
			c.getPartido().setVotos(c.getPartido().getVotos()+c.getVotos());
			System.out.println(c.getVotos());
			
			s.nextLine();
			
			data.getListaCandidatos().setCandidato(c);
			data.setVotosTotais(data.getVotosTotais()+c.getVotos());
			if(c.getSituacao() == '*') {
				data.getListaCandidatos().setEleito(c);
				if (c.getColigacao() != null) {
					c.getColigacao().setEleitos(c.getColigacao().getEleitos()+1);					
				}
				c.getPartido().setEleitos(c.getPartido().getEleitos()+1);
			}
			
			
		}
		
		data.getListaCandidatos().preencheListas();
		IO.imprimeSaidaPadrao(data);
		// IO.imprimeSaida(data); // Impressão em arquivo
		
		//System.out.println(lista);
		s.close();
	}
	
	

}