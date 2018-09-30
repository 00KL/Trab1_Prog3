package eleicao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;

public class Testador {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("test.txt"));
		
		Lista_candidatos lista = new Lista_candidatos();
		
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
			c.setNum( Integer.parseInt(linha[1]) );
			
			//System.out.printf("[%s] ", linha[2]);//Nome
			c.setNome(linha[2]);
			
			//System.out.printf("[%s] ", linha[3]);//Partido/coligação
			c.setPartido_colicagacao(linha[3]);
			
			//System.out.printf("[%s] ", linha[4]);//votos
			c.setVotos( Float.parseFloat(linha[4]) );
	
			
			//System.out.printf("[%s] ", linha[5]);//validos, dado irrelevante
												 //segundo trabalhos anteriores
			
			
			lista.setCandidato(c);
		}
		
		System.out.println(lista);

	}

}