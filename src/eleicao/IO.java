package eleicao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class IO {
	public static Scanner le_arquivo(String nomeArquivo, String tipoArquivo) {
		try {
			BufferedReader arqIn = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), tipoArquivo));
			Scanner s = new Scanner(arqIn);
			//s.useLocale(new Locale("pt", "BR"));
			return s;
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception	
			System.out.println("ERROR\n");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void imprimeSaidaPadrao(Dados data) {
		String impressao = new String();
		
		impressao = "Número de vagas: "+data.getListaCandidatos().getVagas()+"\n";
		System.out.println(impressao);
		
		impressao = "Vereadores Eleitos:\n";
		impressao += data.getListaCandidatos().toStringListaEleitos(data.getListaCandidatos().getEleitos());
		System.out.println(impressao);
		
		impressao = "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):\n";
		impressao += data.getListaCandidatos().toStringListaMaisVotados(data.getListaCandidatos().getMaisVotados());
		System.out.println(impressao);
		
		impressao = "Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos\n";
		impressao += "(com sua posição no ranking de mais votados)\n";
		impressao += data.getListaCandidatos().toStringListaEleitosMajoritaria(data.getListaCandidatos());
		System.out.println(impressao);
		
		impressao = "Eleitos, que se beneficiaram no sistema proporcional:\n";
		impressao += "(com sua posição no ranking de mais votados)\n";
		impressao += data.getListaCandidatos().toStringListaBeneficiados(data.getListaCandidatos());
		System.out.println(impressao);
		
		impressao = "Votação (nominal) das coligações e número de candidatos eleitos:\n";
		impressao += data.getListaColigacoes().toString();
		System.out.println(impressao);
		
		impressao = "Votação (nominal) dos partidos e número de candidatos eleitos:\n";
		impressao += data.getListaPartidos().toString();
		System.out.println(impressao);
		
		impressao = "Total de votos nominais: "+data.getVotosTotais()+"\n";
		System.out.println(impressao);
		
	}
	
}
