package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * 
 * Clase PanelDatosHabitacion que extiende de JPanel
 *
 */
public class PanelDatosHabitacion extends JPanel{
	
	/**
	 * Atributos de la clase
	 */
	private JLabel tipoHabitacionTexto=new JLabel("Tipo habitación");
	public static String[] tipoHabitacion = {"Simple", "Double", "Suite"};
	public static JComboBox<String> habitaciones = new JComboBox<String>(tipoHabitacion);
	
	private JLabel numHabitacionesTexto=new JLabel("Num Habitaciones");
	public static JSpinner numHabitaciones = new JSpinner();
	
	public static JCheckBox ninos=new JCheckBox("¿Niños?");
	
	private JTextField importe=new JTextField("Importe total: ");
	
	public static PanelExtraNinos panelExtraNinos=new PanelExtraNinos();
	
	private PanelImagenes panelImagenes=new PanelImagenes();

	/**
	 * Constructor
	 */
	
	public PanelDatosHabitacion() {
	
		/**
		 * Le damos un borde al panel
		 */
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26,128,130)));
		
		/**
		 * Cambiamos el color del fondo
		 */
		setBackground(new Color(237,207,179));
		
		/**
		 * Le damos un modelo a nuestro spinner
		 */
		numHabitaciones.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		
		/**
		 * Hacemos que no se pueda editar nuestro spinner
		 */
		numHabitaciones.setEditor(new JSpinner.DefaultEditor(numHabitaciones));
		
		/**
		 * Le damos un tamanio a nuestro spinner
		 */
		Component editor = numHabitaciones.getEditor();
		JFormattedTextField tamanio = ((JSpinner.DefaultEditor) editor).getTextField();
		tamanio.setColumns(3);
		
		/**
		 * Le damos una fuente a nuestro componentes
		 */
		tipoHabitacionTexto.setFont(new Font("Times New Roman", Font.BOLD, 13));
		numHabitacionesTexto.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ninos.setFont(new Font("Times New Roman", Font.BOLD, 13));
		importe.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		/**
		 * Le damos un tamanio a nuestro textfield y hacemos que no se pueda editar
		 */
		importe.setPreferredSize(new Dimension(200,30));
		importe.setEditable(false);
		
		/**
		 * Cambiamos el color de fondo del componente
		 */
		ninos.setBackground(new Color(237,207,179));
		
		/**
		 * Aniadimos los componentes al panel
		 */
		add(tipoHabitacionTexto);
		add(habitaciones);
		add(numHabitacionesTexto);
		add(numHabitaciones);
		add(ninos);
		
		
		/**
		 * Hacemos invisible el panelExtraNinos
		 */
		panelExtraNinos.setVisible(false);
		
		/**
		 * Lo colocamos en el centro
		 */
		add(panelExtraNinos,BorderLayout.CENTER);
		
		/**
		 * aniadimos el textField importe
		 */
		add(importe);
		
		/**
		 * Amiadimos el panelImagenes
		 */
		add(panelImagenes);
		
		/**
		 * Al seleccionar el checkBox ninos nos mostrara el panelExtraNinos
		 */
		ninos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(ninos.isSelected())
					panelExtraNinos.setVisible(true);
				else
					panelExtraNinos.setVisible(false);
				
			}
		});
		
		/**
		 * Al seleccionar un tipo de habitacion se nos mostrara una imagen de la habitación seleccionada
		 */
		habitaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(habitaciones.getSelectedItem().equals("Simple")) {
					PanelImagenes.habitacion1.setVisible(true);
					PanelImagenes.habitacion2.setVisible(false);
					PanelImagenes.habitacion3.setVisible(false);
				}
				
				if(habitaciones.getSelectedItem().equals("Double")) {
					PanelImagenes.habitacion1.setVisible(false);
					PanelImagenes.habitacion2.setVisible(true);
					PanelImagenes.habitacion3.setVisible(false);
				}
				
				if(habitaciones.getSelectedItem().equals("Suite")) {
					PanelImagenes.habitacion1.setVisible(false);
					PanelImagenes.habitacion2.setVisible(false);
					PanelImagenes.habitacion3.setVisible(true);
				}
				
				
			
			}
		});
		
		
		/**
		 * Cuando el textField tenga el foco hara el calculo total de la estancia en el hotel
		 */
		importe.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				double importeHab=0;
				double importeNinos=20;
				
				if(habitaciones.getSelectedItem().toString().equals("Simple"))
					importeHab=50;
				if(habitaciones.getSelectedItem().toString().equals("Double"))
					importeHab=75;
				if(habitaciones.getSelectedItem().toString().equals("Suite"))
					importeHab=120;
				
				if(ninos.isSelected())
					importe.setText("Importe total: "+(importeHab+importeNinos)+" euros");
				else
					importe.setText("Importe total: "+importeHab+" euros");
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			    
			}

 			
 		});
		
		
		
		
	}

}
