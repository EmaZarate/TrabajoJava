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

public class ABMCPersonaje {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje window = new ABMCPersonaje();
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
	public ABMCPersonaje() {
	
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagenPanel imagenPanel = new ImagenPanel();
		frame.getContentPane().add(imagenPanel);
		
		JButton btnCargarPersonaje = new JButton("Cargar Personaje");
		imagenPanel.add(btnCargarPersonaje);
		
		JLabel lblMarvelVsDc = new JLabel("Marvel vs DC");
		lblMarvelVsDc.setForeground(new Color(255, 255, 255));
		lblMarvelVsDc.setFont(new Font("Chinese Rocks Rg", Font.BOLD, 25));
		imagenPanel.add(lblMarvelVsDc);
			
	
	}
}
