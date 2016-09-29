package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class PantallaPrincipal {

	private JFrame frame;

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
		frame.setBounds(100, 100, 398, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(139, 96, 133, 23);
		frame.getContentPane().add(btnJugar);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(179, 25, 50, 39);
		frame.getContentPane().add(lblMenu);
		
		JButton btnCargarPersonaje = new JButton("Cargar Personaje");
		btnCargarPersonaje.setBounds(139, 153, 133, 23);
		frame.getContentPane().add(btnCargarPersonaje);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(139, 217, 133, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
