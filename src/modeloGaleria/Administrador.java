package modeloGaleria;
import java.io.*;
import java.util.HashMap;


public class Administrador extends Usuario {
	
	
	public Administrador (String login, String contraseña) {
		super(login, contraseña);
	}
	public  void cargarPieza(File archivo,  HashMap<String, Pieza> piezas,HashMap<String, Escultura> esculturas, HashMap<String, Pintura> pinturas, HashMap<String, Fotografia> fotografias, HashMap<String, Video> videos, HashMap<String, Impresion> impresiones) {
        System.out.println("Cargando piezas desde Archivo");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String tipo = partes[0];
                String titulo = partes[1];
                if (piezas.get(titulo)== null) {
                	int ano= Integer.valueOf(partes[2]);
                    String lugarCreacion = partes[3];
                    String autor = partes[4];
                    boolean exhibida = Boolean.valueOf(partes[5]);
                    boolean permisoVenta = Boolean.valueOf(partes[6]);
                    int valorFijo= Integer.valueOf(partes[7]);
                    int valorMinimoSubasta = Integer.valueOf(partes[8]);
                    String loginPropietario= partes[9];
                    String contrasenaPropietario = partes[10];
                    String correo = partes[11];
                    int numeroDeTelefono= Integer.valueOf(partes[12]);
                    
                    if (tipo.equals("Escultura")) {
                    	float alto = Float.parseFloat(partes[14]);
                    	float ancho = Float.parseFloat(partes[15]);
                    	float profundidad = Float.parseFloat(partes[16]);
                    	String materialEscultura = partes[17];
                    	float peso = Float.parseFloat(partes[18]);
                    	boolean necesidadElectricidad = Boolean.valueOf(partes[19]);
                    	String detallesInstalacion = partes [20];
                    	Pieza pieza= crearPiezaEscultura(esculturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, profundidad, materialEscultura, peso, necesidadElectricidad, detallesInstalacion);
                    	añadirPieza(pieza, piezas);
                    	
                    } else if (tipo.equals("Pintura")) {
                    	float alto = Float.parseFloat(partes[14]);
                    	float ancho = Float.parseFloat(partes[15]);
                    	String materialBase = partes[16];
                    	String tipoPintura = partes[17];
                    	Pieza pieza = crearPiezaPintura(pinturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, materialBase, tipoPintura);
                    	añadirPieza(pieza, piezas);

                    }else if (tipo.equals("Video")) {
                    	float duracion = Float.parseFloat(partes[14]);
                    	boolean necesidadElectricidad = Boolean.valueOf(partes[15]);
                    	Pieza pieza = crearPiezaVideo(videos, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,duracion,necesidadElectricidad);
                    	añadirPieza(pieza, piezas);

                    }else if (tipo.equals("Fotografia")) {
                    	float resolucion = Float.parseFloat(partes[14]);
                    	String tecnica = partes[15];
                    	float ancho = Float.parseFloat(partes[16]);
                    	float alto = Float.parseFloat(partes[17]);
                    	Pieza pieza= crearPiezaFotografia(fotografias,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
                    	añadirPieza(pieza, piezas);
                    }else if (tipo.equals("Impresion")) {
                    	float resolucion = Float.parseFloat(partes[14]);
                    	String tecnica = partes[15];
                    	float ancho = Float.parseFloat(partes[16]);
                    	float alto = Float.parseFloat(partes[17]);
                    	Pieza pieza= crearPiezaImpresion( impresiones,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
                    	añadirPieza(pieza, piezas);
                    }
                }

                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	protected  void pedir_crearPieza(HashMap<String, Pieza> piezas,HashMap<String, Escultura> esculturas, HashMap<String, Pintura> pinturas, HashMap<String, Fotografia> fotografias, HashMap<String, Video> videos, HashMap<String, Impresion> impresiones) {
		
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
        String contrasenaPropietario = input("Ingrese la contraseña de el propietario ");
        String correo = input("Ingrese el correo de el propietario ");
        int numeroDeTelefono= Integer.valueOf(input("Ingrese el número de telefono del propietario:  "));
        
        if (tipo.equals("Escultura")) {
        	float alto = Float.parseFloat(input("Ingrese la altura de la estatua"));
        	float ancho = Float.parseFloat(input("Ingrese el ancho de la estatua"));
        	float profundidad = Float.parseFloat(input("Ingrese la profundidad de la estatua"));
        	String materialEscultura = input("Ingrese el material de la escultura");
        	float peso = Float.parseFloat(input("Ingrese el peso de la Pieza"));
        	boolean necesidadElectricidad = Boolean.valueOf(input("Ingese si  la escultura necesita electricidad (true o false) "));
        	String detallesInstalacion = input("Ingrese los detalles de la instalación (personal o espacioextra");
        	Pieza pieza= crearPiezaEscultura(esculturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, profundidad, materialEscultura, peso, necesidadElectricidad, detallesInstalacion);
        	añadirPieza(pieza, piezas);
        	
        } else if (tipo.equals("Pintura")) {
        	float alto = Float.parseFloat(input("Ingrese la altura de la pintura: "));
        	float ancho = Float.parseFloat(input("Ingrese el ancho de la pintura "));
        	String materialBase = input("Ingrese el material de la base de la pintura: ");
        	String tipoPintura = input("Ingrese el tipo de pintura");
        	Pieza pieza = crearPiezaPintura(pinturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, materialBase, tipoPintura);
        	añadirPieza(pieza, piezas);

        }else if (tipo.equals("Video")) {
        	float duracion = Float.parseFloat(input("Ingrese la duración del video: "));
        	boolean necesidadElectricidad = Boolean.valueOf(input ("Ingrese si necesita de electricidad (true o false) : "));
        	Pieza pieza = crearPiezaVideo(videos, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,duracion,necesidadElectricidad);
        	añadirPieza(pieza, piezas);

        }else if (tipo.equals("Fotografia")) {
        	float resolucion = Float.parseFloat(input("Ingrese la resolucion de la imagen: "));
        	String tecnica = input("Ingrese la técnica usada para la fotografia: ");
        	float ancho = Float.parseFloat(input("Ingrese e ancho de la fotografia :  "));
        	float alto = Float.parseFloat(input("Ingrese el alto de la fotografia: "));
        	Pieza pieza= crearPiezaFotografia(fotografias,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
        	añadirPieza(pieza, piezas);
        }else if (tipo.equals("Impresion")) {
        	float resolucion = Float.parseFloat(input("Ingrese la resolucion de la impresión: "));
        	String tecnica = input("Ingrese la técnica usada para la impresión: ");
        	float ancho = Float.parseFloat(input("Ingrese el ancho de la impresion: "));
        	float alto = Float.parseFloat(input("Ingrese el alto de la impresión: "));
        	Pieza pieza= crearPiezaImpresion( impresiones,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
        			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
        	añadirPieza(pieza, piezas);
        }
       
	}
	protected Pieza crearPiezaEscultura(HashMap<String, Escultura> esculturas, String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float alto, float ancho, float profundidad, String material, float peso, boolean electricidad, 
			String otros) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
				valorFijo, valorMinimoSubasta, propietario,  alto, ancho, profundidad, material, peso, electricidad, otros);
		Escultura pie= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
				valorFijo, valorMinimoSubasta, propietario,  alto, ancho, profundidad, material, peso, electricidad, otros);
		
		
		esculturas.put(pie.getTitulo(), pie);
		return(pieza);
		}
		
	protected Pieza crearPiezaPintura(HashMap<String, Pintura> pinturas,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			int  valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float alto, float ancho, String materialBase, String tipoPinturas) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, alto, ancho, materialBase,
				tipoPinturas);
		Pintura pintura = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,alto, ancho, materialBase,
				tipoPinturas);
		pinturas.put(pintura.getTitulo(), pintura);
		return pieza;
		
	}
	protected Pieza crearPiezaVideo(HashMap<String, Video> videos,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float duracion, boolean necesidadElectricidad) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, duracion, necesidadElectricidad);
		Video pie = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, duracion, necesidadElectricidad);
		videos.put(pie.getTitulo(), pie);
		return pieza;
		
	}
	protected Pieza crearPiezaFotografia(HashMap<String, Fotografia> fotografias,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float resolucion,String metodo, float ancho, float alto) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
		Fotografia pie = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
		fotografias.put(pie.getTitulo(), pie);
		return pieza;

		
	}
	protected Pieza crearPiezaImpresion(HashMap<String, Impresion> impresiones,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float resolucion,String metodo, float ancho, float alto) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
		Impresion pie = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
		impresiones.put(pie.getTitulo(), pie);
		return pieza;
	}
			
	private Propietario crearPropietario(String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono) {
		Propietario propietario = new Propietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		return propietario;
	}
	private void añadirPieza (Pieza pieza,HashMap<String, Pieza> piezas) {
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
}





