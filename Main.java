import java.util.ArrayList;

public class Main {
	static Ciudad[] ciudades = ciudades();
	static Ciudad origen;
	static Ciudad destino;
	static ArrayList<Camino> caminos;
	
	public static void main(String[] args) {
		origen = ciudades[0];
		destino = ciudades[12];
		
		caminos = new ArrayList<>();
		Camino caminoAuxiliar = new Camino();
		caminoAuxiliar.agregarCiudad(origen, 0);
		mostrarCamino(profundidad(origen, caminoAuxiliar));
	}
	
	public static void mostrarCamino(Camino camino) {
		System.out.println("Ciudad\t\tCosto");
		for (int i = 0; i < camino.ciudades.size(); i++) {
			System.out.println(camino.ciudades.get(i).nombre + "\t\t" + camino.costos.get(i));
		}
		System.out.println("Costo total\t" + camino.costoTotal);
	}
	
	public static Camino costoUniforme(Ciudad ciudad, Camino caminoActual) {
		Camino caminoAuxiliar = null;
		if (ciudad.nombre.equals(destino.nombre)) {
			return caminoActual;
		}
		return caminoAuxiliar;
	}
	
	public static Camino profundidad(Ciudad ciudad, Camino caminoActual) {
		Camino caminoAuxiliar;
		if (ciudad.nombre.equals(destino.nombre)) {
			return caminoActual;
		}
		for (int i = 0; i < ciudad.colindantes.size(); i++) {
			Ciudad siguiente = ciudad.colindanteSiguiente();
			if (!caminoActual.contieneCiudad(siguiente)) {
				Camino nuevoCamino = new Camino(caminoActual);
				nuevoCamino.agregarCiudad(
					siguiente,
					ciudad.distanciaColindante(siguiente)
				);
				caminoAuxiliar = profundidad(siguiente, nuevoCamino);
				if (caminoAuxiliar != null) {
					return caminoAuxiliar;
				}
			}
		}
		return caminoActual;
	}
	
	public static Ciudad[] ciudades() {
		Ciudad[] ciudades = new Ciudad[20];
		Ciudad arad = new Ciudad("Arad");
		Ciudad zerind = new Ciudad("Zerind");
		Ciudad oradea = new Ciudad("Oradea");
		Ciudad timisoara = new Ciudad("Timisoara");
		Ciudad lugoj = new Ciudad("Lugoj");
		Ciudad mehadia = new Ciudad("Mehadia");
		Ciudad dobreta = new Ciudad("Dobreta");
		Ciudad sibiu = new Ciudad("Sibiu");
		Ciudad rimnicu = new Ciudad("Rimnicu Vilcea");
		Ciudad fagaras = new Ciudad("Fagaras");
		Ciudad craiova = new Ciudad("Craiova");
		Ciudad pitesti = new Ciudad("Pitesti");
		Ciudad bucarest = new Ciudad("Bucarest");
		Ciudad urziceni = new Ciudad("Urziceni");
		Ciudad hirsova = new Ciudad("Hirsova");
		Ciudad eforie = new Ciudad("Eforie");
		Ciudad vaslui = new Ciudad("Vaslui");
		Ciudad iasi = new Ciudad("Iasi");
		Ciudad neamt = new Ciudad("Neamt");
		Ciudad giurgiu = new Ciudad("Giurgiu");
		
		arad.agregarColindante(zerind, 75);
		arad.agregarColindante(timisoara, 118);
		arad.agregarColindante(sibiu, 140);
		
		zerind.agregarColindante(arad, 75);
		zerind.agregarColindante(oradea, 71);
		
		oradea.agregarColindante(zerind, 71);
		oradea.agregarColindante(sibiu, 151);
		
		timisoara.agregarColindante(arad, 118);
		timisoara.agregarColindante(lugoj, 111);
		
		lugoj.agregarColindante(timisoara, 111);
		lugoj.agregarColindante(mehadia, 70);
		
		mehadia.agregarColindante(lugoj, 70);
		mehadia.agregarColindante(dobreta, 75);
		
		dobreta.agregarColindante(mehadia, 75);
		dobreta.agregarColindante(craiova, 120);
		
		craiova.agregarColindante(rimnicu, 146);
		craiova.agregarColindante(pitesti, 138);
		craiova.agregarColindante(dobreta, 120);
		
		sibiu.agregarColindante(arad, 140);
		sibiu.agregarColindante(oradea, 151);
		sibiu.agregarColindante(fagaras, 99);
		sibiu.agregarColindante(rimnicu, 80);
		
		fagaras.agregarColindante(sibiu, 99);
		fagaras.agregarColindante(bucarest, 211);
		
		rimnicu.agregarColindante(sibiu, 80);
		rimnicu.agregarColindante(pitesti, 97);
		rimnicu.agregarColindante(craiova, 146);
		
		pitesti.agregarColindante(rimnicu, 97);
		pitesti.agregarColindante(craiova, 138);
		pitesti.agregarColindante(bucarest, 101);
		
		bucarest.agregarColindante(pitesti, 101);
		bucarest.agregarColindante(fagaras, 211);
		bucarest.agregarColindante(giurgiu, 90);
		bucarest.agregarColindante(urziceni, 85);
		
		urziceni.agregarColindante(hirsova, 98);
		urziceni.agregarColindante(vaslui, 142);
		
		vaslui.agregarColindante(urziceni, 142);
		vaslui.agregarColindante(iasi, 92);
		
		iasi.agregarColindante(vaslui, 92);
		iasi.agregarColindante(neamt, 87);
		
		neamt.agregarColindante(iasi, 87);
		
		hirsova.agregarColindante(urziceni, 98);
		hirsova.agregarColindante(eforie, 86);
		
		eforie.agregarColindante(hirsova, 86);
		
		giurgiu.agregarColindante(bucarest, 90);
		
		ciudades[0] = arad;
		ciudades[1] = zerind;
		ciudades[2] = oradea;
		ciudades[3] = timisoara;
		ciudades[4] = lugoj;
		ciudades[5] = mehadia;
		ciudades[6] = dobreta;
		ciudades[7] = sibiu;
		ciudades[8] = rimnicu;
		ciudades[9] = fagaras;
		ciudades[10] = craiova;
		ciudades[11] = pitesti;
		ciudades[12] = bucarest;
		ciudades[13] = urziceni;
		ciudades[14] = hirsova;
		ciudades[15] = eforie;
		ciudades[16] = vaslui;
		ciudades[17] = iasi;
		ciudades[18] = neamt;
		ciudades[19] = giurgiu;
		return ciudades;
	}
	
}
