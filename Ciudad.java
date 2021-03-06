import java.util.LinkedHashMap;

public class Ciudad {
	public String nombre;
	public LinkedHashMap<Ciudad, Integer> colindantes = new LinkedHashMap<>();
	public int contador = 0;
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarColindante(Ciudad ciudadColindante, int distancia) {
		this.colindantes.put(ciudadColindante, distancia);
	}
	
	public Ciudad colindanteSiguiente() {
		Ciudad sucesor = (Ciudad) colindantes.keySet().toArray()[contador];
		contador++;
		if (contador >= colindantes.size()) {
			contador = 0;
		}
		return sucesor;
	}
	
	public int distanciaColindante(Ciudad colindante) {
		int distancia = -1;
		if (colindantes.containsKey(colindante)) {
			distancia = colindantes.get(colindante);
		}
		return distancia;
	}
	
}
