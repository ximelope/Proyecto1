package modeloGaleria;
import java.io.*;
import java.util.HashMap;


public class Administrador extends Usuario {
	
	
	public Administrador (String login, String contraseña) {
		super(login, contraseña);
	}
		public  void pedir_crearPieza(HashMap<String, Propietario> propietarios,HashMap<String, Pieza> piezas,HashMap<String, Escultura> esculturas, HashMap<String, Pintura> pinturas, HashMap<String, Fotografia> fotografias, HashMap<String, Video> videos, HashMap<String, Impresion> impresiones) {
		
        System.out.println("Crear Pieza, Digite la info necesaria");
        
        String tipo = input("Ingrese el Tipo (Escultura, Fotografia, Impresion, Pintura o Video)");
        String titulo = input("Ingrese el nombre del titulo de la Pieza");
        int ano= Integer.parseInt(input("Ingrese el año en la que fue creada"));
        String lugarCreacion = input(" Ingrese el lugar de Creacion");
        String autor = input("Ingrese el nombre de su autor");
        boolean exhibida = Boolean.valueOf(input("Ingrese si es para exhibir (true o false) "));
        boolean permisoVenta = Boolean.valueOf(input("Ingrese si permite que sea vendida (true o false) "));
        int valorFijo= Integer.parseInt(input("Ingrese el valor fijo para la venta "));
        int valorMinimoSubasta = Integer.parseInt(input("Ingrese el valor minimo de subasta "));
        String loginPropietario= input("Ingrese el usuario de el propietario ");
        String contrasenaPropietario = input("Ingrese las fechas en que se ha vendido la piezas (separados por - ) ");
        String correo = input("Ingrese los propietarios que ha tenido la piezas (separados por - ) ");
        String  numeroDeTelefono= input("Ingrese los preciios de las ventas ");
        
        if (tipo.equals("Escultura")) {
        	float alto = Float.parseFloat(input("Ingrese la altura de la estatua"));
        	float ancho = Float.parseFloat(input("Ingrese el ancho de la estatua"));
        	float profundidad = Float.parseFloat(input("Ingrese la profundidad de la estatua"));
        	String materialEscultura = input("Ingrese el material de la escultura");
        	float peso = Float.parseFloat(input("Ingrese el peso de la Pieza"));
        	boolean necesidadElectricidad = Boolean.valueOf(input("Ingese si  la escultura necesita electricidad (true o false) "));
        	String detallesInstalacion = input("Ingrese los detalles de la instalación (personal o espacioextra");
        	Pieza pieza= crearPiezaEscultura(propietarios,esculturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, profundidad, materialEscultura, peso, necesidadElectricidad, detallesInstalacion);
        	añadirPieza(pieza, piezas);
        	
        } else if (tipo.equals("Pintura")) {
        	float alto = Float.parseFloat(input("Ingrese la altura de la pintura: "));
        	float ancho = Float.parseFloat(input("Ingrese el ancho de la pintura "));
        	String materialBase = input("Ingrese el material de la base de la pintura: ");
        	String tipoPintura = input("Ingrese el tipo de pintura");
        	Pieza pieza = crearPiezaPintura(propietarios,pinturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, materialBase, tipoPintura);
        	añadirPieza(pieza, piezas);

        }else if (tipo.equals("Video")) {
        	float duracion = Float.parseFloat(input("Ingrese la duración del video: "));
        	boolean necesidadElectricidad = Boolean.valueOf(input ("Ingrese si necesita de electricidad (true o false) : "));
        	Pieza pieza = crearPiezaVideo(propietarios, videos, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,duracion,necesidadElectricidad);
        	añadirPieza(pieza, piezas);

        }else if (tipo.equals("Fotografia")) {
        	float resolucion = Float.parseFloat(input("Ingrese la resolucion de la imagen: "));
        	String tecnica = input("Ingrese la técnica usada para la fotografia: ");
        	float ancho = Float.parseFloat(input("Ingrese e ancho de la fotografia :  "));
        	float alto = Float.parseFloat(input("Ingrese el alto de la fotografia: "));
        	Pieza pieza= crearPiezaFotografia(propietarios,fotografias,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
        	añadirPieza(pieza, piezas);
        }else if (tipo.equals("Impresion")) {
        	float resolucion = Float.parseFloat(input("Ingrese la resolucion de la impresión: "));
        	String tecnica = input("Ingrese la técnica usada para la impresión: ");
        	float ancho = Float.parseFloat(input("Ingrese el ancho de la impresion: "));
        	float alto = Float.parseFloat(input("Ingrese el alto de la impresión: "));
        	Pieza pieza= crearPiezaImpresion( propietarios, impresiones,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
        	añadirPieza(pieza, piezas);
        }
       
	}
		
		protected Pieza crearPiezaEscultura(HashMap<String, Propietario> propietarios,HashMap<String, Escultura> esculturas, String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float alto, float ancho, float profundidad, String material, float peso, boolean electricidad, 
				String otros) {
			Propietario propietario = propietarios.get(loginPropietario);
			
			Pieza pieza= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
					valorFijo, valorMinimoSubasta, propietario,propie, fechasVendidas,precios,  alto, ancho, profundidad, material, peso, electricidad, otros);
			Escultura pie= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
					valorFijo, valorMinimoSubasta, propietario, propie,fechasVendidas,precios,  alto, ancho, profundidad, material, peso, electricidad, otros);
			
			
			esculturas.put(pie.getTitulo(), pie);
			return(pieza);
			}
			
		protected Pieza crearPiezaPintura(HashMap<String, Propietario> propietarios,HashMap<String, Pintura> pinturas,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int  valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float alto, float ancho, String materialBase, String tipoPinturas) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, propie, fechasVendidas,precios, alto, ancho, materialBase,
					tipoPinturas);
			Pintura pintura = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, propie,fechasVendidas,precios, alto, ancho, materialBase,
					tipoPinturas);
			pinturas.put(pintura.getTitulo(), pintura);
			return pieza;
			
		}
		protected Pieza crearPiezaVideo(HashMap<String, Propietario> propietarios,HashMap<String, Video> videos,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float duracion, boolean necesidadElectricidad) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, propie,fechasVendidas,precios, duracion, necesidadElectricidad);
			Video pie = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie,fechasVendidas,precios,  duracion, necesidadElectricidad);
			videos.put(pie.getTitulo(), pie);
			return pieza;
			
		}
		protected Pieza crearPiezaFotografia(HashMap<String, Propietario> propietarios,HashMap<String, Fotografia> fotografias,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float resolucion,String metodo, float ancho, float alto) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie, fechasVendidas,precios,  resolucion, metodo, ancho,alto);
			Fotografia pie = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, propie, fechasVendidas, precios,resolucion, metodo, ancho,alto);
			fotografias.put(pie.getTitulo(), pie);
			return pieza;

			
		}
		protected Pieza crearPiezaImpresion(HashMap<String, Propietario> propietarios,HashMap<String, Impresion> impresiones,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float resolucion,String metodo, float ancho, float alto) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie,fechasVendidas,precios,  resolucion, metodo, ancho,alto);
			Impresion pie = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie, fechasVendidas,precios,  resolucion, metodo, ancho,alto);
			impresiones.put(pie.getTitulo(), pie);
			return pieza;
		}	private void añadirPieza (Pieza pieza,HashMap<String, Pieza> piezas) {
		piezas.put(pieza.getTitulo(), pieza);
		
	}
	public String input (String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
	
	public void verificacionDeCliente (Comprador comprador) {
		int numero= comprador.getNumeroDeTelefono();
		int digitos = String.valueOf(numero).length();
		String devolver = "Negado";
		if (digitos==8) {
			devolver ="Verificado";
		}
		comprador.cambiarEstado(devolver);
		
	}
	@SuppressWarnings("unlikely-arg-type")
	public void historiaCliente(Comprador comprador,HashMap<String, Propietario> propietarios,HashMap<String, Pieza> piezas ) {
		String piezasHistorial = comprador.getPiezas();
		String[] partes = piezasHistorial.split("-");
		System.out.println("Las piezas que ha comprado: ");
		for (String parte : partes) {
		    System.out.println(parte);
		}
		String fechasHistorial = comprador.getFechas();
		String [] dates = fechasHistorial.split(",");
		System.out.println("Las fechas de las piezas que ha comprado: ");
		for (String parte : dates) {
		    System.out.println(parte);
		}
		String nombre = comprador.getLogin();
		int total= 0;
		if(propietarios.containsKey(nombre)){
			Propietario encontrados = propietarios.get(nombre);
			String pieza = encontrados.getPiezas();
			String[] piezass = pieza.split("-");
			System.out.println("Las piezas que tiene ahorita son: ");
			for (String pedazo : piezass) {
				total+= piezas.get(piezass).getValorFijo();
			    System.out.println(pedazo);
			}
		}else {
			System.out.println("El comprador no es propietario de nada: ");
		}
		System.out.println("El precio total de su colección es de: ");
		System.out.println(total);
		
	}
	
}





