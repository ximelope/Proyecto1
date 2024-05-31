package modeloGaleria;

import java.util.ArrayList;

public abstract class Usuario {
	protected String login;
	protected String contrasena;
	
	public String getLogin() {
		return login;
	}
	public String getContrasena() {
		return contrasena;
	}
	
	
	public Usuario (String login, String contrasena) {
		this.contrasena = contrasena;
		this.login = login; 
	}
	public void historiaDePieza(Pieza pieza) {
		System.out.println("Los datos básicos de la pieza son: ");
		System.out.println("Tipo: "+ pieza.getTipo()+", Nombre: "+ pieza.getTitulo()+ ", Autor: " + pieza.getAutor()+ ", Año de creación: "+pieza.getAno()+ ", Lugar de creación: "+ pieza.getLugarCreacion()+ ", Propietario actual: " + pieza.getPropietario().getLogin()) ;
		
		String propie= pieza.getPropietarios();
		String[] partes = propie.split("-");
		System.out.println("Los dueños de esta pieza han sido: ");
		for (String parte : partes) {
		    System.out.println(parte);
		}
		System.out.println("Esta pieza ha sido vendida por : ");
		String precios= pieza.getPrecios();
		String[] precio = precios.split("-");
		for (String par : precio) {
		    System.out.println(par+ " pesos ");
		}
		System.out.println("Esta pieza ha sido vendida en estas fechas : ");
		String fechas= pieza.getFechasVendidas();
		String[] pre = fechas.split(",");
		for (String par : pre) {
		    System.out.println(par);
		}
	}
	public String historiaPiezaInterfaz(Pieza pieza) {
		String respuesta = ("Tipo: "+ pieza.getTipo()+", Nombre: "+ pieza.getTitulo()+ ", Autor: " + pieza.getAutor()+ ", Año de creación: "+pieza.getAno()+ ", Lugar de creación: "+ pieza.getLugarCreacion()+ ", Propietario actual: " + pieza.getPropietario().getLogin()+ "   "+
	"Sus dueños han sido: "+ pieza.getPropietarios()+ "   "+ "Ha sido vendida (pesos) por: "+ pieza.getPrecios()+"   "+ "Ha sido vendida en estas fechas: "+ pieza.getFechasVendidas());
		return respuesta;
	}
	public String historiaArtista(Artista artista) {
		String total = "Ninguna";
		ArrayList<String> lista = new ArrayList<String>( );
		for (Pieza pieza: artista.getPiezasLista()) {
			total = "Pieza: " + pieza.getTitulo()+ "Año: " + pieza.getAno()+"Fecha de venta: "+ pieza.getFechasVendidas()+
					"Valor de pieza: "+pieza.getPrecios();
			lista.add(total);
			}
		String respuesta= "Artista: "+ artista.getNombre() + "    " +
			"Piezas: "+total;
		return respuesta;
	}
}