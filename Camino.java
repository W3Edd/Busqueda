import java.util.ArrayList;

public class Camino {
	public int costoTotal = 0;
	public ArrayList<Ciudad> ciudades = new ArrayList<>();
	public ArrayList<Integer> costos = new ArrayList<>();
	
	public Camino() {
	}
	
	public Camino(Camino camino) {
		this.costoTotal = camino.costoTotal;
		this.ciudades = camino.ciudades;
		this.costos = camino.costos;
	}
	
	public void agregarCiudad(Ciudad ciudad, int costo) {
		this.ciudades.add(ciudad);
		this.costos.add(costo);
		this.costoTotal += costo;
	}
	
	public boolean contieneCiudad(Ciudad ciudad) {
		return this.ciudades.contains(ciudad);
	}
}
