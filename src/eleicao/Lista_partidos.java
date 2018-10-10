package eleicao;

import java.util.*;

public class Lista_partidos {
	private LinkedList<Partido> partidos = new LinkedList<Partido>();

	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public void ordena_partido() {
		Collections.sort(this.partidos, new Comparator<Partido>() {
			@Override
			public int compare(Partido a, Partido b) {
				return b.getVotos() - a.getVotos();
			}
		});
	}
	

	public String toString() {
		ordena_partido();
		int i = 0;
		String saida = "";
		
		for (Partido p : partidos) {
			i++;
			saida += Integer.toString(i) + " - " + p + "\n";
		}
		
		return saida;
	}
}
