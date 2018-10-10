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
		
		Dados data = new Dados();
		
		while(s.hasNext()) {
			String linha[] = (s.nextLine().split(";")); // pega ums string em s.next
													//divide ela usando os ";"
													//cada String entre os ";"
													//ocupa uma string diferente em linha[]
			
			//Anuncia variavel Candidato
			Candidato c = new Candidato();
			//System.out.printf("[%s] ", linha[0]);//Posicao
			c.setColocacao(linha[0]);
			
			
			//System.out.printf("[%s] ", linha[1]);//Numero
			c.setNum(Integer.parseInt(linha[1]) );
			
			//System.out.printf("[%s] ", linha[2]);//Nome
			c.setNome(linha[2]);
			
			//System.out.printf("[%s] ", linha[3]);//Partido/coliga鈬o
			c.setPartido_colicagacao(linha[3]);
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
			
			//System.out.printf("[%s] ", linha[4]);//votos
			c.setVotos(linha[4]);
			if (c.getColigacao() != null) {
				c.getColigacao().setVotos(c.getColigacao().getVotos()+c.getVotos());	
				
				/*
				for (Coligacao col : data.getListaColigacoes().getColigacoes()) {
					if(col.getColigacao().equals(c.getColigacao().getColigacao())) {
						col.setVotos(col.getVotos()+c.getVotos());
					}
				}*/
			}
			c.getPartido().setVotos(c.getPartido().getVotos()+c.getVotos());
			/*
			for (Partido part : data.getListaPartidos().getPartidos()) {
				if(part.getNome().equals(c.getPartido().getNome())) {
					part.setVotos(part.getVotos()+c.getVotos());
				}
			}*/
			
			//System.out.printf("[%s] ", linha[5]);//validos, dado irrelevante
												 //segundo trabalhos anteriores
			
			
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
		IO.imprimeSaida(data);
		
		//System.out.println(lista);
		s.close();
	}
	
	

}