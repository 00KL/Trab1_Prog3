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
		Scanner s = IO.leArquivo(args[0], args[1]);
		Locale ptBR = new Locale("pt", "BR");
		s.useLocale(ptBR);
		s.useDelimiter(";");
		
		Dados data = new Dados();

		//Pula a primeria linha
		s.nextLine();
		
		while(s.hasNext()) {
			//Anuncia variavel Candidato
			Candidato c = new Candidato();
			c.setColocacao(s.next());
			
			c.setNum(s.nextInt());
			
			c.setNome(s.next());
			
			c.setPartido_colicagacao(s.next());
			c.arrumaPartidoEColigacao(data);
			
			c.setVotos(s.nextInt());
			c.arrumaVotosPartidoEColigacao();
			
			s.nextLine();
			
			c.arrumaEleito(data);
		}
		
		data.getListaCandidatos().preencheListas();
		
		IO.imprimeSaidaPadrao(data);
		
		s.close();
	}
}