package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * Clase PanelDatosCliente que extiende de JPanel
 *
 */
public class PanelDatosCliente extends JPanel {

	/**
	 * Atributos de la clase
	 */
	private JLabel nombre=new JLabel("Nombre: ");
	private JLabel apellidos=new JLabel("Apellidos: ");
	private JLabel dni=new JLabel("DNI: ");
	private JLabel telefono=new JLabel("Teléfono: ");
	private JLabel fechaEntrada=new JLabel("Fecha Entrada: ");
	private JLabel fechaSalida=new JLabel("Fecha Salida: ");
	
	public static JLabel diasEstancia=new JLabel("Dias de estancia: 1");
	
	public static JTextField nombreCampo=new JTextField();
	public static JTextField apellidosCampo= new JTextField();
	
	private MaskFormatter mascaraDni;
	private MaskFormatter mascaraTelf;
	public static JFormattedTextField dniCampo;
	public static JFormattedTextField telefonoCampo;
	
	public static JTextField fechaEntradaCampo=new JTextField();
	public static JTextField fechaSalidaCampo=new JTextField();
	
	/**
	 * Constructor
	 */
	
	public PanelDatosCliente() {
		
		/**
		 * Le damos un borde al panel
		 */
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26,128,130)));
		
		/**
		 * Cambiamos el color de fondo del panel
		 */
		setBackground(new Color(237,207,179));
		
		/**
		 * Cambiamos las fuentes
		 */
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 13));
		apellidos.setFont(new Font("Times New Roman", Font.BOLD, 13));
		dni.setFont(new Font("Times New Roman", Font.BOLD, 13));
		telefono.setFont(new Font("Times New Roman", Font.BOLD, 13));
		fechaEntrada.setFont(new Font("Times New Roman", Font.BOLD, 13));
		fechaSalida.setFont(new Font("Times New Roman", Font.BOLD, 13));
		diasEstancia.setFont(new Font("Times New Roman", Font.BOLD, 13));

		/**
		 * Instanciamos el maskFormatter para que solo se puedan aniadir 8 numeros y 1 caracter al final
		 */
		try {
			mascaraDni=new MaskFormatter("########U");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**
		 * Le pasamos a nuestro FormattedTextField el maskFormatter
		 */
		dniCampo=new JFormattedTextField(mascaraDni);
		
		
		/**
		 * Instanciamos el masFormatter para que solo se puedan aniadir 9 numeros
		 */
		try {
			mascaraTelf=new MaskFormatter("#########");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**
		 * Le pasamos a nuestro FormattedTextField el maskFormatter
		 */
		telefonoCampo=new JFormattedTextField(mascaraTelf);
		
		/**
		 * Le damos tamanio a nuestros textfields
		 */
		nombreCampo.setPreferredSize(new Dimension(200,30));
		apellidosCampo.setPreferredSize(new Dimension(200,30));
		dniCampo.setPreferredSize(new Dimension(200,30));
		telefonoCampo.setPreferredSize(new Dimension(200,30));
		fechaEntradaCampo.setPreferredSize(new Dimension(100,30));
		fechaSalidaCampo.setPreferredSize(new Dimension(100,30));
		
		
		/**
		 * Creamos un panel donde colocaremos nuestros campos
		 */
		JPanel campos=new JPanel();
		
		/**
		 * Le damos a nuestro panel campos un flowlayout
		 */
		campos.setLayout(new FlowLayout());
		
		/**
		 * Aniadimos los componentes a nuestro panel campos
		 */
		campos.add(nombre);
		campos.add(nombreCampo);
		campos.add(apellidos);
		campos.add(apellidosCampo);
		campos.add(dni);
		campos.add(dniCampo);
		campos.add(telefono);
		campos.add(telefonoCampo);
		
		/**
		 * Creamos el formato fecha
		 */
		Calendar calen = Calendar.getInstance();
		String dia = Integer.toString(calen.get(Calendar.DATE));
		String mes = Integer.toString(calen.get(Calendar.MONTH));
		String annio = Integer.toString(calen.get(Calendar.YEAR));
		
		fechaEntradaCampo.setText(dia+"/"+mes+"/"+annio);
		fechaEntradaCampo.setEditable(false);
		
		fechaSalidaCampo.setText((Integer.parseInt(dia)+1)+"/"+mes+"/"+annio);
		fechaSalidaCampo.setEditable(false);
		
		/**
		 * Aniadimos los componentes que continen las fechas a nuestro panel
		 */
		campos.add(fechaEntrada);
		campos.add(fechaEntradaCampo);
		campos.add(fechaSalida);
		campos.add(fechaSalidaCampo);
		
		/**
		 * Aniadimos el campo diasEstacia al panel
		 */
		campos.add(diasEstancia);
		
		/**
		 * Aniadimos el panel campos a nuestro panel principal
		 */
		add(campos);
		
	
		
		
		
	}
	
}
