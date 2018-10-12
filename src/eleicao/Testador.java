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
			c.setColocacao(s.next());
			//System.out.println(c.getColocacao());
			
			c.setNum(s.nextInt());
			//System.out.println(c.getNum());
			
			c.setNome(s.next());
			//System.out.println(c.getNome());
			
			c.setPartido_colicagacao(s.next());
			c.arrumaPartidoEColigacao(data);
			//System.out.println(c.getPartido());
			//System.out.println(c.getColigacao());
			
			c.setVotos(s.nextInt());
			c.arrumaVotosPartidoEColigacao();
			//System.out.println(c.getVotos());
			
			s.nextLine();
			
			c.arrumaEleito(data);
		}
		
		data.getListaCandidatos().preencheListas();
		IO.imprimeSaidaPadrao(data);
		// IO.imprimeSaida(data); // Impressão em arquivo
		
		//System.out.println(lista);
		s.close();
	}
}