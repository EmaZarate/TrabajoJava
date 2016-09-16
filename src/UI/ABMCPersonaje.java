package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ABMCPersonaje {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(38, 35, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(38, 73, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(38, 111, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(38, 145, 46, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(38, 188, 46, 14);
		frame.getContentPane().add(lblAtaque);
		
		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(38, 219, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		JLabel lblTotalrestante = new JLabel("Total/Restante");
		lblTotalrestante.setBounds(38, 257, 94, 14);
		frame.getContentPane().add(lblTotalrestante);
		
		textField = new JTextField();
		textField.setBounds(108, 32, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 70, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 108, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 142, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
