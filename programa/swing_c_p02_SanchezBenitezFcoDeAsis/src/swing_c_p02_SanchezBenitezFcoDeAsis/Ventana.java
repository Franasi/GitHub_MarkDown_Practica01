package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 *
 * Clase Ventana que extiende de JFrame
 */
public class Ventana extends JFrame {

	/**
	 * Atributos de la clase
	 */
	private Image icon=new ImageIcon(getClass().getResource("/recursos/LogoHotel.png")).getImage();
	private JMenuBar barraMenu= new JMenuBar();

	private JMenu archivo=new JMenu("Archivo");
	private JMenuItem salir=new JMenuItem("Salir");
	
	private JMenu registro=new JMenu("Registro");
	private JMenuItem altas=new JMenuItem("Altas Reservas");
	private JMenuItem bajas=new JMenuItem("Bajas Reservas");
	
	private JMenu ayuda=new JMenu("Ayuda");
	private JMenuItem acercaDe= new JMenuItem("Acerca de...");
	
	private JButton botonAltas=new JButton("ALTAS RESERVAS");
	private JButton botonBajas=new JButton("BAJAS RESERVAS");
	
	private VentanaAltasReservas ventanaReservas=new VentanaAltasReservas(this,true);
	
	
	/**
	 * Constructor
	 */
	public Ventana() {
		
		/**
		 * Le damos un tamanio a la ventana y la centramos
		 */
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    setSize(width/2, height/2);
	    setLocationRelativeTo(null);
	    
	    /**
	     * Le damos un FlowLayout
	     */
	    setLayout(new FlowLayout(1,20,140));
	    
	    /**
	     * Le damos un titulo
	     */
	    setTitle("Gestión Hotel Francisco de Asís");
	    
	    /**
	     * Cambiamos el icono
	     */
	    setIconImage(icon);
	    
	    /**
	     * Hacemos que se cierre la aplicacion al hacer click en cerrar
	     */
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    /**
	     * Cambiamos el color del fondo
	     */
	    getContentPane().setBackground(new Color(237,207,179));
	    
	    /**
	     * Aniadimos los componentes del menu
	     */
	    archivo.add(salir);
	    barraMenu.add(archivo);
	    
	    registro.add(altas);
	    registro.add(bajas);
	    barraMenu.add(registro);
	    
	    ayuda.add(acercaDe);
	    barraMenu.add(ayuda);
	    
	    /**
	     * Aniadimos el menu
	     */
	    setJMenuBar(barraMenu);
	    
	    /**
	     * Cambiamos el tamanio de los botones
	     */
	    botonAltas.setPreferredSize(new Dimension(300,150));
	    botonBajas.setPreferredSize(new Dimension(300,150));
	    
	    /**
	     * Cambiamos el color de los botones
	     */
	    botonAltas.setBackground(new Color(90,146,145));
	    botonBajas.setBackground(new Color(90,146,145));
	    
	    /**
	     * Cambiamos el tipo de fuente de los botones
	     */
	    botonAltas.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    botonBajas.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    
	    /**
	     * Aniadimos los botones a la ventana
	     */
	    add(botonAltas);
	    add(botonBajas);
	    
	    
	    /**
	     * Creamos atajos de teclado 
	     */
	    registro.setMnemonic(KeyEvent.VK_R);
	    botonAltas.setMnemonic(KeyEvent.VK_A);
	    botonBajas.setMnemonic(KeyEvent.VK_B);
	    
	    /**
	     * Hacemos visible la ventana
	     */
	    setVisible(true);
	    
	    /**
	     * Al hacer click en salir se nos cerrara la aplicacion
	     */
	    salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
	    
	    /**
	     * Al hacer click en altas se nos abrira la ventana de reservas
	     */
	    altas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ventanaReservas.setVisible(true);
				
			}
		});
	    
	    /**
	     * Al hacer click en el boton altas se nos abrira la ventana de reservas
	     */
	    botonAltas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ventanaReservas.setVisible(true);
				
			}
		});
	    
	    /**
	     * Al hacer click en el boton bajas se nos abrira la ventana de bajas
	     */
	    botonBajas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 JOptionPane.showMessageDialog(null, "Esta opción aún esta en desarrollo. Disculpe las molestias.","AÚN EN DESARROLLO",JOptionPane.ERROR_MESSAGE);
				
			}
		});
	    
	    /**
	     * Al hacer click en bajas se nos abrira la ventana de bajas
	     */
	    bajas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 JOptionPane.showMessageDialog(null, "Esta opción aún esta en desarrollo. Disculpe las molestias.","AÚN EN DESARROLLO",JOptionPane.ERROR_MESSAGE);
				
			}
		});
	    
	    /**
	     * Al hacer click en acercaDe se nos abrira un mensaje dandonos información sobre el hotel
	     */
	    acercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Hotel Francisco de Asís\n"
						+ "Teléfono: 950 999 999\n"
						+ "Dirección: Calle Dio Num 7\n"
						+ "Email: hotelfranciscodeasis@hotel.com\n"
						+ "Web: https://www.HotelFranciscoDeAsis.com","INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	    
	    
	    
	}
	
}
