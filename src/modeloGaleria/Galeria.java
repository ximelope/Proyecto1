package modeloGaleria;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Galeria {
	private HashMap<String, Escultura> esculturas = new HashMap<>();
	private HashMap<String, Pintura> pinturas = new HashMap<>();
	private HashMap<String, Video> videos  = new HashMap<>();
	private HashMap<String, Fotografia> fotografias = new HashMap<>();
	private HashMap<String, Impresion> impresiones = new HashMap<>();
	private HashMap<String, Pieza> piezas = new HashMap<>();
	private HashMap<String, Subasta> subastas = new HashMap<>();
	private HashMap<String, Registro> registros = new HashMap<>();
	private HashMap<String, String> usuarios = new HashMap<>();
	private HashMap<String, Comprador> clientes = new HashMap<>();
	private HashMap<String, Venta> ventas = new HashMap<>();
	private HashMap<String, Propietario> propietarios = new HashMap<>();
	private HashMap<String, Artista> artistas = new HashMap<>();
	private  Administrador administrador;
	public HashMap<String, Escultura> getEsculturas() {
		return esculturas;
	}
	public HashMap<String, Pintura> getPinturas() {
		return pinturas;
	}
	public HashMap<String, Video> getVideos() {
		return videos;
	}
	public HashMap<String, Fotografia> getFotografias() {
		return fotografias;
	}
	public HashMap<String, Impresion> getImpresiones() {
		return impresiones;
	}
	public HashMap<String, Pieza> getPiezas() {
		return piezas;
	}
	public HashMap<String, Subasta> getSubastas() {
		return subastas;
	}
	public HashMap<String, Registro> getRegistros() {
		return registros;
	}
	public HashMap<String, String> getUsuarios() {
		return usuarios;
	}
	public HashMap<String, Comprador> getClientes() {
		return clientes;
	}
	public HashMap<String, Venta> getVentas() {
		return ventas;
	}
	public HashMap<String, Propietario> getPropietarios() {
		return propietarios;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public HashMap<String, Artista> getArtistas() {
		return artistas;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador= administrador;
	}
	public Galeria() {
		Administrador administrador = new Administrador("Sofia","123");
		this.administrador= administrador;
	}
	
	 public void cargarInformacion() {
		 File videos = new File("./src/data/Videos.txt");
 		 File fotografias = new File("./src/data/Fotografias.txt");
     	 File esculturas = new File("./src/data/Esculturas.txt");
     	 File pinturas = new File("./src/data/Pinturas.txt");
     	 File impresiones = new File("./src/data/Impresiones.txt");

         cargarUsuarios();
         cargarPropietario();
         cargarPieza(videos);
         cargarPieza(fotografias);
         cargarPieza(esculturas);
         cargarPieza(pinturas);
         cargarPieza(impresiones);
         cargarComprador();
         cargarArtista();

	    }
	 public void cargarPropietario() {
		 File archivo = new File(
	         		"./src/data/Propietario.txt");
		 System.out.println("Cargando propietarios desde Archivo");
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String login = partes[0];
	                String contrasena = partes[1];
	                String correo = partes[2];
	                int numeroDeTelefono= Integer.valueOf(partes[3]);
	                String piezas= partes[4];
	                Propietario propietario = crearPropietario(login,contrasena,correo, numeroDeTelefono, piezas);
	                propietarios.put(login,propietario);
	                linea = br.readLine();
	            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	 public void cargarComprador() {
		 File archivo = new File(
	         		"./src/data/Comprador.txt");
		 System.out.println("Cargando compradores desde Archivo");
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String login = partes[0];
	                String contrasena = partes[1];
	                String correo = partes[2];
	                int numeroDeTelefono= Integer.valueOf(partes[3]);
	                int valorMax = Integer.valueOf(partes[4]);
	                String piezas= partes[5];
	                String fechas= partes[6];
	                Comprador comprador = crearComprador(login,contrasena,correo, numeroDeTelefono, valorMax, piezas, fechas);
	                clientes.put(login,comprador);
	                linea = br.readLine();
	            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	 
	 public void cargarArtista() {
		 File archivo = new File(
	         		"./src/data/Artista.txt");
		 System.out.println("Cargando artistas desde Archivo");
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String nombre = partes[0];
	                String piezasString = partes[1];
	                String[] piezasList = piezasString.split("-");
	                Collection<Pieza> piezasCollection= new ArrayList<>();
	                for (String parte: piezasList) {
		        		boolean piezakey = piezas.containsKey(parte);
		        		if (piezakey == true) {
		        			Pieza piezaObj = piezas.get(parte);
		        			piezasCollection.add(piezaObj);
		        		}
		        	}
	                Artista artista = crearArtista(nombre, piezasCollection);
	                artistas.put(nombre,artista);
	                linea = br.readLine();
	            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		 
	 public  void cargarPieza(File archivo) {
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
	                    String fechasVendidas = partes[10];
	                    String propie = partes[11];
	                    String precios = partes[12];
	                    
	                    if (tipo.equals("Escultura")) {
	                    	float alto = Float.parseFloat(partes[14]);
	                    	float ancho = Float.parseFloat(partes[15]);
	                    	float profundidad = Float.parseFloat(partes[16]);
	                    	String materialEscultura = partes[17];
	                    	float peso = Float.parseFloat(partes[18]);
	                    	boolean necesidadElectricidad = Boolean.valueOf(partes[19]);
	                    	String detallesInstalacion = partes [20];
	                    	Pieza pieza= crearPiezaEscultura(esculturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, fechasVendidas, propie, precios,alto,ancho, profundidad, materialEscultura, peso, necesidadElectricidad, detallesInstalacion);
	                    	añadirPieza(pieza, piezas);
	                    	
	                    } else if (tipo.equals("Pintura")) {
	                    	float alto = Float.parseFloat(partes[14]);
	                    	float ancho = Float.parseFloat(partes[15]);
	                    	String materialBase = partes[16];
	                    	String tipoPintura = partes[17];
	                    	Pieza pieza = crearPiezaPintura(pinturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,loginPropietario, fechasVendidas, propie,precios ,alto,ancho, materialBase, tipoPintura);
	                    	añadirPieza(pieza, piezas);

	                    }else if (tipo.equals("Video")) {
	                    	float duracion = Float.parseFloat(partes[14]);
	                    	boolean necesidadElectricidad = Boolean.valueOf(partes[15]);
	                    	Pieza pieza = crearPiezaVideo(videos, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, fechasVendidas, propie, precios,duracion,necesidadElectricidad);
	                    	añadirPieza(pieza, piezas);

	                    }else if (tipo.equals("Fotografia")) {
	                    	float resolucion = Float.parseFloat(partes[14]);
	                    	String tecnica = partes[15];
	                    	float ancho = Float.parseFloat(partes[16]);
	                    	float alto = Float.parseFloat(partes[17]);
	                    	Pieza pieza= crearPiezaFotografia(fotografias,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, fechasVendidas, propie, precios,resolucion, tecnica, ancho, alto);
	                    	añadirPieza(pieza, piezas);
	                    }else if (tipo.equals("Impresion")) {
	                    	float resolucion = Float.parseFloat(partes[14]);
	                    	String tecnica = partes[15];
	                    	float ancho = Float.parseFloat(partes[16]);
	                    	float alto = Float.parseFloat(partes[17]);
	                    	Pieza pieza= crearPiezaImpresion( impresiones,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, fechasVendidas, propie, precios ,resolucion, tecnica, ancho, alto);
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
	 
	 public Pieza crearPiezaEscultura(HashMap<String, Escultura> esculturas, String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float alto, float ancho, float profundidad, String material, float peso, boolean electricidad, 
				String otros) {
			Propietario propietario = propietarios.get(loginPropietario);
			
			Pieza pieza= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
					valorFijo, valorMinimoSubasta, propietario,propie, fechasVendidas, precios, alto, ancho, profundidad, material, peso, electricidad, otros);
			Escultura pie= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
					valorFijo, valorMinimoSubasta, propietario, propie,fechasVendidas,precios, alto, ancho, profundidad, material, peso, electricidad, otros);
			
			
			esculturas.put(pie.getTitulo(), pie);
			return(pieza);
			}
			
		public Pieza crearPiezaPintura(HashMap<String, Pintura> pinturas,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
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
		public Pieza crearPiezaVideo(HashMap<String, Video> videos,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float duracion, boolean necesidadElectricidad) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, propie,fechasVendidas, precios, duracion, necesidadElectricidad);
			Video pie = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie,fechasVendidas,precios, duracion, necesidadElectricidad);
			videos.put(pie.getTitulo(), pie);
			return pieza;
			
		}
		public Pieza crearPiezaFotografia(HashMap<String, Fotografia> fotografias,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float resolucion,String metodo, float ancho, float alto) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie, fechasVendidas,precios, resolucion, metodo, ancho,alto);
			Fotografia pie = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, propie, fechasVendidas,precios, resolucion, metodo, ancho,alto);
			fotografias.put(pie.getTitulo(), pie);
			return pieza;

			
		}
		public Pieza crearPiezaImpresion(HashMap<String, Impresion> impresiones,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String fechasVendidas,
				String propie, String precios, float resolucion,String metodo, float ancho, float alto) {
			Propietario propietario = propietarios.get(loginPropietario);
			Pieza pieza = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie,fechasVendidas,precios, resolucion, metodo, ancho,alto);
			Impresion pie = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,propie, fechasVendidas,precios, resolucion, metodo, ancho,alto);
			impresiones.put(pie.getTitulo(), pie);
			return pieza;
		}
				
		public Propietario crearPropietario(String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono, String piezas) {
			Propietario propietario = new Propietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono, piezas);
			return propietario;
		}

		public Comprador crearComprador (String loginPropietario, String contraseñaPropietario, String correo, int numeroDeTelefono, int valorMax, String piezas,String fechas) {
			Comprador comprador = new Comprador(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono, valorMax, piezas, fechas);
			return comprador;
		}
		
		public Artista crearArtista (String nombre, Collection<Pieza> piezasLista) {
			Artista artista = new Artista(nombre, piezasLista);
			return artista;
		}

		public void añadirPieza (Pieza pieza,HashMap<String, Pieza> piezas) {
			piezas.put(pieza.getTitulo(), pieza);
			
		}

	public boolean login(String usuario, String contrasena) {
	
        if (contrasena.equals(usuarios.get(usuario))) {
            return true;
        } else {
            return false;
        }

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
	 public void cargarUsuarios() {
	        System.out.println("Cargando base de datos de Usuarios");
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(new File(
	                    "./src/data/Usuarios.txt")));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String usuario = partes[0];
	                String contrasena = partes[1];

	                usuarios.put(usuario, contrasena);

	                linea = br.readLine();
	                System.out.println(linea);
	            }
	            br.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
