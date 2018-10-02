package eleicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

public class IO {
	public static Scanner le_arquivo() {
		try {
			BufferedReader arqIn = new BufferedReader(new InputStreamReader(new FileInputStream("test.csv"), "UTF-8"));
			Scanner s = new Scanner(arqIn);
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
	
	public static void imprimeSaida(Dados data) {
		try (Writer saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("saida.txt"), "utf-8"))) {
			imprimeVagas(data.listaCandidatos, saida);
			saida.write('\n');
			imprimeEleitos(data.listaCandidatos, saida);
			saida.write('\n');
			imprimeMaisVotados(data.listaCandidatos, saida);
			saida.write('\n');
			imprimeEleitosMajoritaria(data.listaCandidatos, saida);
			saida.write('\n');
			imprimeBeneficiados(data.listaCandidatos, saida);
			saida.write('\n');
			imprimeColigacoes(data.listaColigacoes, saida);
			saida.write('\n');
			imprimePartidos(data.listaPartidos, saida);
			saida.write('\n');
			
	  	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Número de vagas
	private static void imprimeVagas(Lista_candidatos lista, Writer saida) {
		String string = "Número de vagas: "+lista.getVagas()+"\n";
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Candidatos eleitos (sempre indicado partido, número de votos e coligação, se houver)
	private static void imprimeEleitos(Lista_candidatos lista, Writer saida) {
		String string = "Vereadores Eleitos:\n";
		string += lista.eleitos();
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Candidatos mais votados dentro do número de vagas
	private static void imprimeMaisVotados(Lista_candidatos lista, Writer saida) {
		String string = "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):\n";
		string += lista.maisVotados();
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Candidatos não eleitos e que seriam eleitos se a votação fosse majoritária
	private static void imprimeEleitosMajoritaria(Lista_candidatos lista, Writer saida) {
		String string = "Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos\n";
		string += "(com sua posição no ranking de mais votados)\n";
		string += lista.eleitosMajoritaria();
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Candidatos eleitos no sistema proporcional vigente, e que não seriam eleitos se a votação fosse  
	// majoritária, isto é, pelo número de votos apenas que um candidato recebe diretamente
	private static void imprimeBeneficiados(Lista_candidatos lista, Writer saida) {
		String string = "Eleitos, que se beneficiaram no sistema proporcional:\n";
		string += "(com sua posição no ranking de mais votados)\n";
		string += lista.eleitosMajoritaria();
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Votos totalizados por coligação ou partido (quando um partido não estiver em coligação), número de
	// candidatos eleitos;
	private static void imprimeColigacoes(Lista_coligacoes lista, Writer saida) {
		String string = "Votação (nominal) das coligações e número de candidatos eleitos:\n";
		string += lista.coligacoes();
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Votos totalizados por partido, número de candidatos eleitos
	private static void imprimePartidos(Lista_partidos lista, Writer saida) {
		String string = "Votação (nominal) dos partidos e número de candidatos eleitos:\n";
		string += lista.partidos();
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Total de votos nominais
	private static void imprimeVotos(Dados data, Writer saida) {
		String string = "Total de votos nominais: "+data.votosTotais+"\n";
		
		try {
			saida.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
