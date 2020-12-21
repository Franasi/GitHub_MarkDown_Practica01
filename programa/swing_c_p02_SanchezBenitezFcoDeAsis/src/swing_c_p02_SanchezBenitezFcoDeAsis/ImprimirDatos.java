package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * Clase ImprimirDatos que extiende de JTabbedPane
 *
 */
public class ImprimirDatos extends JTabbedPane{

	/**
	 * Atributos de la clase
	 */
	private JPanel datosCliente= new JPanel();
	private JPanel datosHabitacion= new JPanel();
	
	public static JLabel nombre= new JLabel("Nombre: ");
	public static JLabel apellidos= new JLabel("Apellidos: ");
	public static JLabel dni= new JLabel("DNI: ");
	public static JLabel telefono= new JLabel("Teléfono: ");
	public static JLabel fechaSalida= new JLabel("Fecha Entrada: ");
	public static JLabel fechaEntrada= new JLabel("Fecha Salida: ");
	public static JLabel diasEstancia= new JLabel("Dias de estancia: ");
	
	public static JLabel nombreCampo=new JLabel("No se ha introducido nombre");
	public static JLabel apellidosCampo=new JLabel("No se ha introducido apellidos");
	public static JLabel dniCampo=new JLabel("No se ha introducido DNI");
	public static JLabel telefonoCampo=new JLabel("No se ha introducido telefono");
	public static JLabel fechaSalidaCampo=new JLabel("No se ha introducido fecha");
	public static JLabel fechaEntradaCampo=new JLabel("No se ha introducido fecha");
	public static JLabel diasEstanciaCampo=new JLabel("Sin resultado");
	
	public static JLabel tipoHabitacion= new JLabel("Tipo de habitación: ");
	public static JLabel tipoHabitacionCampo= new JLabel("No se ha introducido tipo de habitación");
	
	public static JLabel numHabitaciones= new JLabel("Número de habitaciones: ");
	public static JLabel numHabitacionesCampo= new JLabel("No se ha introducido el número de habitaciones");
	
	public static JLabel ninos= new JLabel("Niños: ");
	public static JLabel edadNinos= new JLabel("Edad niños: ");
	public static JLabel extras= new JLabel("Extras: ");
	
	/**
	 * Constructor
	 */
	
	public ImprimirDatos() {
		
		/**
		 * Le damos a los paneles un color de fondo
		 */
		datosCliente.setBackground(new Color(222,175,149));
		datosHabitacion.setBackground(new Color(222,175,149));
		
		/**
		 * Le damos al panel datosCliente un boxLayout con orientacion vertical
		 */
		datosCliente.setLayout(new BoxLayout(datosCliente, BoxLayout.Y_AXIS));
		
		/**
		 * Colocamos los componentes en el panel
		 */
		datosCliente.add(nombre);
		datosCliente.add(nombreCampo);
		
		datosCliente.add(apellidos);
		datosCliente.add(apellidosCampo);
		
		datosCliente.add(dni);
		datosCliente.add(dniCampo);
		
		datosCliente.add(telefono);
		datosCliente.add(telefonoCampo);
		
		datosCliente.add(fechaSalida);
		datosCliente.add(fechaSalidaCampo);
		
		datosCliente.add(fechaEntrada);
		datosCliente.add(fechaEntradaCampo);
		
		datosCliente.add(diasEstancia);
		datosCliente.add(diasEstanciaCampo);
		
		/**
		 * Le damos al panel datosHabitacion un BoxLayout con orientacion vertical
		 */
		datosHabitacion.setLayout(new BoxLayout(datosHabitacion,BoxLayout.Y_AXIS));
		
		/**
		 * Colocamos los componentes en el panel
		 */
		datosHabitacion.add(tipoHabitacion);
		datosHabitacion.add(tipoHabitacionCampo);
		
		datosHabitacion.add(numHabitaciones);
		datosHabitacion.add(numHabitacionesCampo);
		
		datosHabitacion.add(ninos);
		datosHabitacion.add(edadNinos);
		datosHabitacion.add(extras);
		
		/**
		 * Aniadimos los paneles a la clase ImprimirDatos
		 */
		addTab("Datos Cliente",datosCliente);
		addTab("Datos Habitacion",datosHabitacion);
	
	}
}
