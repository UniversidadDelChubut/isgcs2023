package practicagcs2023;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import practicagcs2023.Principal.Entrada;
import practicagcs2023.Principal.Salida;

public class Procesador {
	public static List<Salida>procesarEntrada(List<Entrada>datos) {
		LinkedList<Salida> listaSalida = new LinkedList<Salida>();
		HashMap <String, Double> map = new HashMap <String, Double> ();
		
		for (Entrada recorrido : datos) {
		    if (map.containsKey(recorrido.getCampo())) {
		    	Double suma = map.get(recorrido.getCampo());
		    	suma = recorrido.getValor() + suma;
		    	map.put(recorrido.getCampo(), suma);
		    } else {
		    	map.put(recorrido.getCampo(), recorrido.getValor());
		    }
		}
		
		Integer contador = 0;
		for (Map.Entry<String, Double> elementos : map.entrySet()) {
            Salida salida = new Salida(contador.toString(), elementos.getKey(), elementos.getValue());
            contador++;
            listaSalida.add(salida);
        }
		
		return listaSalida;
	}

}
