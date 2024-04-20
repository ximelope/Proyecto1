package modeloGaleria;
import java.io.*;
import java.io.File;
import java.util.HashMap;

public class Administrador extends Usuario {
	private Inventario inventario;
	public Inventario getInventario() {
		return inventario;
	}
	
	public Administrador (String login, String contraseña) {
		super(login, contraseña);
		this.inventario = new Inventario();
	}
	protected void cargarPieza(File documento) {
		
	}
	public void cargarPieza(File archivo,  HashMap<String, Pieza> piezas,HashMap<String, Escultura> esculturas, HashMap<String, Pintura> pinturas, HashMap<String, Fotografia> fotografias, HashMap<String, Video> videos, HashMap<String, Impresion> impresiones) {
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
                    float valorFijo= Float.parseFloat(partes[7]);
                    float valorMinimoSubasta = Float.parseFloat(partes[8]);
                    String estadoPieza = partes[9];
                    String loginPropietario= partes[10];
                    String contrasenaPropietario = partes[11];
                    String correo = partes[12];
                    int numeroDeTelefono= Integer.valueOf(partes[13]);
                    
                    if (tipo == "Escultura") {
                    	float alto = Float.parseFloat(partes[14]);
                    	float ancho = Float.parseFloat(partes[15]);
                    	float profundidad = Float.parseFloat(partes[16]);
                    	String materialEscultura = partes[17];
                    	float peso = Float.parseFloat(partes[18]);
                    	boolean necesidadElectricidad = Boolean.valueOf(partes[19]);
                    	String detallesInstalacion = partes [20];
                    	Pieza pieza= crearPiezaEscultura(esculturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			estadoPieza,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, profundidad, materialEscultura, peso, necesidadElectricidad, detallesInstalacion);
                    	añadirPieza(pieza, piezas);
                    	
                    } else if (tipo=="Pintura") {
                    	float alto = Float.parseFloat(partes[14]);
                    	float ancho = Float.parseFloat(partes[15]);
                    	String materialBase = partes[16];
                    	String tipoPintura = partes[17];
                    	Pieza pieza = crearPiezaPintura(pinturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			estadoPieza,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, materialBase, tipoPintura);
                    	añadirPieza(pieza, piezas);

                    }else if (tipo=="Video") {
                    	float duracion = Float.parseFloat(partes[14]);
                    	boolean necesidadElectricidad = Boolean.valueOf(partes[15]);
                    	Pieza pieza = crearPiezaVideo(videos, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			estadoPieza,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,duracion,necesidadElectricidad);
                    	añadirPieza(pieza, piezas);

                    }else if (tipo == "Fotografia") {
                    	float resolucion = Float.parseFloat(partes[14]);
                    	String tecnica = partes[15];
                    	float ancho = Float.parseFloat(partes[16]);
                    	float alto = Float.parseFloat(partes[17]);
                    	Pieza pieza= crearPiezaFotografia(fotografias,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			estadoPieza,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
                    	añadirPieza(pieza, piezas);
                    }else if (tipo == "Impresion") {
                    	float resolucion = Float.parseFloat(partes[14]);
                    	String tecnica = partes[15];
                    	float ancho = Float.parseFloat(partes[16]);
                    	float alto = Float.parseFloat(partes[17]);
                    	Pieza pieza= crearPiezaImpresion( impresiones,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
                    			estadoPieza,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
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
	protected void pedir_crearPieza() {
		
	}
	protected Pieza crearPiezaEscultura(HashMap<String, Escultura> esculturas, String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta,String estado, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float alto, float ancho, float profundidad, String material, float peso, boolean electricidad, 
			String otros) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
				valorFijo, valorMinimoSubasta, propietario,estado,  alto, ancho, profundidad, material, peso, electricidad, otros);
		Escultura pie= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
				valorFijo, valorMinimoSubasta, propietario,estado,  alto, ancho, profundidad, material, peso, electricidad, otros);
		
		
		esculturas.put(pie.getTitulo(), pie);
		return(pieza);
		}
		
	protected Pieza crearPiezaPintura(HashMap<String, Pintura> pinturas,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta,String estado, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float alto, float ancho, String materialBase, String tipoPinturas) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado,alto, ancho, materialBase,
				tipoPinturas);
		Pintura pintura = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado,alto, ancho, materialBase,
				tipoPinturas);
		pinturas.put(pintura.getTitulo(), pintura);
		return pieza;
		
	}
	protected Pieza crearPiezaVideo(HashMap<String, Video> videos,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta,String estado, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float duracion, boolean necesidadElectricidad) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado,duracion, necesidadElectricidad);
		Video pie = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado,duracion, necesidadElectricidad);
		videos.put(pie.getTitulo(), pie);
		return pieza;
		
	}
	protected Pieza crearPiezaFotografia(HashMap<String, Fotografia> fotografias,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta,String estado, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float resolucion,String metodo, float ancho, float alto) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado, resolucion, metodo, ancho,alto);
		Fotografia pie = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado, resolucion, metodo, ancho,alto);
		fotografias.put(pie.getTitulo(), pie);
		return pieza;

		
	}
	protected Pieza crearPiezaImpresion(HashMap<String, Impresion> impresiones,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta,String estado, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float resolucion,String metodo, float ancho, float alto) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado, resolucion, metodo, ancho,alto);
		Impresion pie = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, estado, resolucion, metodo, ancho,alto);
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
	private void confirmarVenta () {
		
	}
}
