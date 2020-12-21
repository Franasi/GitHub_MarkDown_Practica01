package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * 
 * Clase PanelExtraNinos que extiende de JPanel
 *
 */
public class PanelExtraNinos extends JPanel{

	/**
	 * Atributos de la clase
	 */
	public static JSpinner edadNinos= new JSpinner();
	public static JTextField extras=new JTextField("Extras: ");
	
	private JLabel edadTexto=new JLabel("Edad niños");
	
	/**
	 * Constructor
	 */
	public PanelExtraNinos() {
		
		/**
		 * Cambiamos el color del fondo
		 */
		setBackground(new Color(237,207,179));
		
		/**
		 * Cambiamos el tipo de fuente
		 */
		
		edadTexto.setFont(new Font("Times New Roman", Font.BOLD, 13));
		extras.setFont(new Font("Times New Roman", Font.BOLD, 13));
		/**
		 * Seleccionamos el modelo de nuestro spinner
		 */
		edadNinos.setModel(new SpinnerNumberModel(0, 0, 14, 1));
		
		/**
		 * Hacemos que no se pueda modificar
		 */
		edadNinos.setEditor(new JSpinner.DefaultEditor(edadNinos));
		
		/**
		 * Le damos un tamanio
		 */
		Component editor = edadNinos.getEditor();
		JFormattedTextField tamanio = ((JSpinner.DefaultEditor) editor).getTextField();
		tamanio.setColumns(3);
		
		/**
		 * Le damos un tamanio a nuestor textfield
		 */
		extras.setPreferredSize(new Dimension(200,30));
		
		/**
		 * Hacemos que no se pueda editar
		 */
		extras.setEditable(false);
		
		/**
		 * Aniadimos los componentes al panel
		 */
		add(edadTexto);
		add(edadNinos);
		add(extras);
		
		
		/**
		 * Cuando el campo de texto "extras" reciba el foco nos escribira el tipo de extra
		 * segun la edad del ninio seleccionada
		 */
		
		extras.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					
					int edad= Integer.parseInt(edadNinos.getValue().toString());
					
					if(edad>=0 && edad<=3)
						extras.setText("Extras: Cuna");
					if (edad>=4 && edad<=10)
						extras.setText("Extras: Cama supletoria pequeña");
					if(edad>=11 && edad<=14)
						extras.setText("Extras: Cama supletoria normal");
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				    
				}

	 			
	 		});
		
		
	}
}
