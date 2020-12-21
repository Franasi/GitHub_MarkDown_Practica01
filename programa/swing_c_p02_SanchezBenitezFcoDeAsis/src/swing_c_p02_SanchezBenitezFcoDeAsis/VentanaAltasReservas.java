package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * 
 * Clase VentanaAltasReservas que extiende de JDialog
 *
 */
public class VentanaAltasReservas extends JDialog {

	/**
	 * Atributos de la clase
	 */
	private Image icon=new ImageIcon(getClass().getResource("/recursos/LogoHotel.png")).getImage();
	
	private PanelNombreHotel panelNombreHotel = new PanelNombreHotel();
	private PanelDatosCliente panelDatosCliente= new PanelDatosCliente();
	private PanelDatosHabitacion panelDatosHabitacion= new PanelDatosHabitacion();
	private ImprimirDatos imprimirDatos= new ImprimirDatos();
	
	private JButton imprimir= new JButton();
	private JButton nuevo= new JButton();
	private JButton guardar=new JButton();
	
	
	private ImageIcon imprimirImagen;
	private ImageIcon nuevoImagen;
	private ImageIcon guardarImagen;
	
	private JLabel progresoTexto= new JLabel("CAMPOS OBLIGATORIOS RELLENADOS: ");
	private JProgressBar progreso=new JProgressBar(0,100);
	
	
	private JPanel panelSur=new JPanel();
	private JPanel panelCentral=new JPanel();
	
	/**
	 * Constructor 
	 * 
	 */
	public VentanaAltasReservas(Ventana ventana, boolean modal) {
		
		
		super(ventana,modal);
		
		
		/**
		 * Le damos tamanio a la ventana
		 */
		setSize(this.getToolkit().getScreenSize());
		
		/**
		 * Le damos un icono a la ventana
		 */
		setIconImage(icon);
		
		/**
		 * Le damos un titulo a la ventana
		 */
		setTitle("Altas Reservas");
		
		/**
		 * Cambiamos el color del fondo
		 */
		getContentPane().setBackground(new Color(237,207,179));
		
		/**
		 * Creamos un ImageIcon y se lo aniadimos al boton
		 */
		imprimirImagen=new ImageIcon(getClass().getResource("/recursos/imprimir.png"));
		Image imagen=imprimirImagen.getImage();
		ImageIcon imagenImprimir= new ImageIcon(imagen.getScaledInstance(150, 80, Image.SCALE_SMOOTH));
		imprimir.setIcon(imagenImprimir);
		
		/**
		 * Creamos un imageIcon y se lo aniadimos al boton
		 */
		nuevoImagen=new ImageIcon(getClass().getResource("/recursos/nuevo.png"));
		imagen=nuevoImagen.getImage();
		ImageIcon imagenNuevo= new ImageIcon(imagen.getScaledInstance(150, 80, Image.SCALE_SMOOTH));
		nuevo.setIcon(imagenNuevo);
		
		/**
		 * Creamos un ImageIcon y se lo aniadimos al boton
		 */
		guardarImagen=new ImageIcon(getClass().getResource("/recursos/guardar.png"));
		imagen=guardarImagen.getImage();
		ImageIcon imagenGuardar= new ImageIcon(imagen.getScaledInstance(150, 80, Image.SCALE_SMOOTH));
		guardar.setIcon(imagenGuardar);
		
		/**
		 * Le damos un color de fondo a los botones
		 */
		imprimir.setBackground(new Color(90,146,145));
		nuevo.setBackground(new Color(90,146,145));
		guardar.setBackground(new Color(90,146,145));

		/**
		 * Le damos un color de fondo a la barra de progreso, le damos un tamanio y le damos un tooltiptext
		 */
		progreso.setBackground(new Color(90,146,145));
		progreso.setPreferredSize(new Dimension(200,30));
		progreso.setToolTipText("Barra de progreso que al hacer click en ella se rellena según la cantidad de campos obligatorios rellenados");
		
		/**
		 * Al panel sur de damos un flowlayout
		 */
		panelSur.setLayout(new FlowLayout());
		
		/**
		 * Cambiamos el color de fondo del panel
		 */
		panelSur.setBackground(new Color(237,207,179));
		

		/**
		 * Colocamos los botones y el ProgressBar en el panel sur
		 */
		panelSur.add(imprimir);
		panelSur.add(nuevo);
		panelSur.add(guardar);
		panelSur.add(progresoTexto);
		panelSur.add(progreso);
		
		/**
		 * Le damos al panelCentral un flowLayout
		 */
		panelCentral.setLayout(new FlowLayout());
		
		/**
		 * Aniadimos el panelDatosCliente y el panelDatosHabitacion al panelCentral
		 */
		panelCentral.add(panelDatosCliente);
		panelCentral.add(panelDatosHabitacion);
		
		/**
		 * Le damos un color de fondo al panelCentral
		 */
		panelCentral.setBackground(new Color(237,207,179));
		
		/**
		 * Aniadimos los paneles a la ventana
		 */
		add(panelNombreHotel,BorderLayout.NORTH);
		add(panelCentral,BorderLayout.CENTER);
		add(imprimirDatos,BorderLayout.WEST);
		add(panelSur,BorderLayout.SOUTH);
		
		
		/**
		 * Al hacer click en el boton imprimir se nos escribira los datos introducidos en el panel ImprimirDatos
		 */
		imprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(PanelDatosCliente.nombreCampo.getText().trim().equals(""))
					ImprimirDatos.nombreCampo.setText("No se ha introducido nombre");
				else
					ImprimirDatos.nombreCampo.setText(PanelDatosCliente.nombreCampo.getText().trim());
				
				if(PanelDatosCliente.apellidosCampo.getText().trim().equals(""))
					ImprimirDatos.apellidosCampo.setText("No se ha introducido apellidos");
				else
					ImprimirDatos.apellidosCampo.setText(PanelDatosCliente.apellidosCampo.getText());
				
				if(PanelDatosCliente.dniCampo.getText().trim().equals(""))
					ImprimirDatos.dniCampo.setText("No se ha introducido DNI");
				else
					ImprimirDatos.dniCampo.setText(PanelDatosCliente.dniCampo.getText());
				
				if(PanelDatosCliente.telefonoCampo.getText().trim().equals(""))
					ImprimirDatos.telefonoCampo.setText("No se ha introducido teléfono");
				else
					ImprimirDatos.telefonoCampo.setText(PanelDatosCliente.telefonoCampo.getText());
				
				
				ImprimirDatos.fechaEntradaCampo.setText(PanelDatosCliente.fechaSalidaCampo.getText());
				ImprimirDatos.fechaSalidaCampo.setText(PanelDatosCliente.fechaEntradaCampo.getText());
				ImprimirDatos.diasEstanciaCampo.setText("1");
				
				ImprimirDatos.tipoHabitacionCampo.setText(PanelDatosHabitacion.habitaciones.getSelectedItem().toString()+ " habitacion/es añadida/as      ");
				ImprimirDatos.numHabitacionesCampo.setText(PanelDatosHabitacion.numHabitaciones.getValue().toString()+ " habitación/es añadida/as         ");
				
				boolean verificarNinos= PanelDatosHabitacion.ninos.isSelected();
				
				ImprimirDatos.ninos.setText("Niños: "+(verificarNinos?"Si":"No"));
				ImprimirDatos.edadNinos.setText("Edad niños: "+(verificarNinos?PanelExtraNinos.edadNinos.getValue().toString():"No"));
				ImprimirDatos.extras.setText("Extras: "+(verificarNinos?PanelExtraNinos.extras.getText():"No"));
				
			}
		});
		
		/**
		 * Al hacer click en el boton nuevo los campos tendran sus valores por defecto y el foco estara en el campo nombre
		 */
		nuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				PanelDatosCliente.nombreCampo.setText("");
				PanelDatosCliente.apellidosCampo.setText("");
				PanelDatosCliente.dniCampo.setText("");
				PanelDatosCliente.telefonoCampo.setText("");
				PanelDatosCliente.diasEstancia.setText("Dias estancia: 1");

				ImprimirDatos.nombreCampo.setText("No se ha introducido nombre");
				ImprimirDatos.apellidosCampo.setText("No se ha introducido apellidos");
				ImprimirDatos.dniCampo.setText("No se ha introducido DNI");
				ImprimirDatos.telefonoCampo.setText("No se ha introducido teléfono");
				ImprimirDatos.diasEstanciaCampo.setText("Sin resultado");
				
				PanelDatosHabitacion.habitaciones.setSelectedIndex(0);
				PanelDatosHabitacion.numHabitaciones.setValue(1);
				PanelDatosHabitacion.ninos.setSelected(false);
				PanelDatosHabitacion.panelExtraNinos.setVisible(false);
				
				ImprimirDatos.tipoHabitacionCampo.setText("No se ha seleccionado tipo de habitación");
				ImprimirDatos.numHabitacionesCampo.setText("No se ha seleccionado el número de habitaciones");
				
				PanelExtraNinos.edadNinos.setValue(0);
				PanelExtraNinos.extras.setText("");
				
				PanelDatosCliente.nombreCampo.requestFocus();
				
				progreso.setValue(0);
			}
		});
		
		/**
		 * Al hacer click en el boton guardar comprobaremos si los campos estan relleno, en caso de que esten rellenos nos dira que se nos ha
		 * guardado los datos y en caso contrario nos dira que no se han rellenado todos los campos
		 */
		guardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(comprobarDatos())
					JOptionPane.showMessageDialog(null, "No ha rellenado todos los campos. Rellene los campos.","GUARDAR DATOS",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Se han guardado los datos","GUARDAR DATOS",JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		
		
		/**
		 * Al hacer click (con el boton izquierdo del raton) en la barra de progreso la barra se ira rellenando segun los campos rellenados y nos mostrara un mensaje con
		 * el porcentaje de los campos obligatorios rellenados
		 */
		
		progreso.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int camposRellenos=0;
				
				if(PanelDatosCliente.nombreCampo.getText().isEmpty())
					progreso.getValue();
				else
					camposRellenos=camposRellenos+1;
				
				if(PanelDatosCliente.apellidosCampo.getText().isEmpty())
					progreso.getValue();
				else
					camposRellenos=camposRellenos+1;
				
				if(PanelDatosCliente.dniCampo.getText().isEmpty() || PanelDatosCliente.dniCampo.getText().trim().equals(""))
					progreso.getValue();
				else
					camposRellenos=camposRellenos+1;
				
				if(PanelDatosCliente.telefonoCampo.getText().isEmpty() || PanelDatosCliente.telefonoCampo.getText().trim().equals(""))
					progreso.getValue();
				else
					camposRellenos=camposRellenos+1;
				
				if ((arg0.getModifiers()&16)!=0) {
					
					if(camposRellenos==0) {
						progreso.setValue(0);
						JOptionPane.showMessageDialog(null, "No ha rellenado ningún campo obligatorio","PROGRESO",JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(camposRellenos==1) {
						progreso.setValue(25);
						JOptionPane.showMessageDialog(null, "Ha rellenado el 25% de los campos obligatorios","PROGRESO",JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(camposRellenos==2) {
						progreso.setValue(50);
						JOptionPane.showMessageDialog(null, "Ha rellenado el 50% de los campos obligatorios","PROGRESO",JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(camposRellenos==3) {
						progreso.setValue(75);
						JOptionPane.showMessageDialog(null, "Ha rellenado el 75% de los campos obligatorios","PROGRESO",JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(camposRellenos==4) {
						progreso.setValue(100);
						JOptionPane.showMessageDialog(null, "Ha rellenado el 100% de los campos obligatorios","PROGRESO",JOptionPane.INFORMATION_MESSAGE);
					}
				} 
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		
		
	}
	
	/**
	 * 
	 * Metodo que comprueba los campos nombre,apellidos,dni,telefono. Si alguno de ellos esta vacio o no es valido devuelve verdadero si no devuelve falso
	 * 
	 */
	public boolean comprobarDatos() {
		String nombre= PanelDatosCliente.nombreCampo.getText().trim();
		String apellidos= PanelDatosCliente.apellidosCampo.getText().trim();
		String dni= PanelDatosCliente.dniCampo.getText().trim();
		String telefono= PanelDatosCliente.telefonoCampo.getText().trim();
		
		if(nombre.equals("") || apellidos.equals("") || dni.length()<9 || telefono.length()<9)
			return true;
		else
			return false;
		
	}
	
}
