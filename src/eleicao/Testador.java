package eleicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.*;


public class Testador {
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = IO.le_arquivo();
		
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
			if (!(data.getListaColigacoes().getColigacoes().contains(c.getColigacao())) && c.getColigacao() != null) {
				data.getListaColigacoes().getColigacoes().add(c.getColigacao());
			}
			if (!(data.getListaPartidos().getPartidos().contains(c.getPartido()))) {
				data.getListaPartidos().getPartidos().add(c.getPartido());
			}
			
			//System.out.printf("[%s] ", linha[4]);//votos
			c.setVotos( Float.parseFloat(linha[4]) );
			c.getColigacao().setVotos(c.getColigacao().getVotos()+c.getVotos());
			c.getPartido().setVotos(c.getPartido().getVotos()+c.getVotos());
			
			//System.out.printf("[%s] ", linha[5]);//validos, dado irrelevante
												 //segundo trabalhos anteriores
			
			
			data.getListaCandidatos().setCandidato(c);
			data.setVotosTotais(data.getVotosTotais()+c.getVotos());
			if(c.getSituacao() == '*') {
				data.getListaCandidatos().setEleito(c);
				c.getColigacao().setEleitos(c.getColigacao().getEleitos()+1);
				c.getPartido().setEleitos(c.getPartido().getEleitos()+1);
			}
		}
		
		data.getListaCandidatos().preencheListas();
		IO.imprimeSaida(data);
		
		//System.out.println(lista);
		s.close();
	}
	
	

}