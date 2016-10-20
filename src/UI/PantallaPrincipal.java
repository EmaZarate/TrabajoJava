package UI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;


import Imagenes.*;


import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPrincipal() {
	
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 269, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marvel vs DC");
		lblNewLabel.setFont(new Font("Friday13 Bonus NFI", Font.PLAIN, 29));
		lblNewLabel.setBounds(55, 11, 194, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCargarPersonaje = new JButton("Opciones");
		btnCargarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ABMPersonaje ap=new ABMPersonaje();
				ap.setVisible(true);
				
			}
		});
		btnCargarPersonaje.setBounds(65, 147, 130, 23);
		frame.getContentPane().add(btnCargarPersonaje);
		
		JButton btnjugar = new JButton("\u00A1JUGAR!");
		btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionarPersonajes sp=new SeleccionarPersonajes();
				sp.setVisible(true);
			}
		});
		btnjugar.setBounds(65, 95, 130, 23);
		frame.getContentPane().add(btnjugar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(66, 196, 130, 23);
		frame.getContentPane().add(btnSalir);
			
	

	}
}
