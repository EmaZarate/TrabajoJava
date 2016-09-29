package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.ApplicationException;

import com.sun.glass.events.MouseEvent;
import com.sun.glass.ui.Window.Level;

import Entidades.Personaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import Controlador.*;
import javax.swing.JTextArea;

public class ABMPersonaje extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtDefensa;
	private JTextField txtNombre;
	private JTextField txtAtaque;
	private JTextField txtEnergia;
	private JTextField txtEvasion;
	private JTextField txtTotalRestante;
	private Component frame;
	ControladorABM ctrl= new ControladorABM();
	private JTextField txtVida;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMPersonaje frame = new ABMPersonaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABMPersonaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setFont(new Font("Super Mario 256", Font.PLAIN, 24));
		lblOpciones.setBounds(120, 11, 164, 41);
		contentPane.add(lblOpciones);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(38, 67, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(195, 67, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(38, 213, 46, 14);
		contentPane.add(lblDefensa);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(38, 176, 46, 14);
		contentPane.add(lblAtaque);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(38, 139, 46, 14);
		contentPane.add(lblEnergia);
		
		JLabel lblTotalrestante = new JLabel("Evasion");
		lblTotalrestante.setBounds(38, 250, 72, 14);
		contentPane.add(lblTotalrestante);
		
		JLabel label = new JLabel("Total/Restante");
		label.setBounds(38, 290, 72, 14);
		contentPane.add(label);
		
		txtID = new JTextField();
		txtID.setBounds(81, 65, 72, 17);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(246, 65, 110, 17);
		contentPane.add(txtNombre);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(120, 211, 72, 17);
		contentPane.add(txtDefensa);
	
		txtAtaque = new JTextField();
		txtAtaque.setColumns(10);
		txtAtaque.setBounds(120, 174, 72, 17);
		contentPane.add(txtAtaque);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(120, 137, 72, 17);
		contentPane.add(txtEnergia);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(120, 247, 72, 17);
		contentPane.add(txtEvasion);
		
				
		txtTotalRestante = new JTextField();
		txtTotalRestante.setColumns(10);
		txtTotalRestante.setBounds(120, 287, 72, 17);
		contentPane.add(txtTotalRestante);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear();
			}
		});
		
		btnCrear.setBounds(10, 347, 88, 23);
	
		contentPane.add(btnCrear);
		
		JButton button = new JButton("Buscar");
		button.setBounds(104, 347, 81, 23);
		contentPane.add(button);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(195, 347, 84, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(289, 347, 83, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(38, 99, 72, 17);
		contentPane.add(lblVida);
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(120, 98, 72, 17);
		contentPane.add(txtVida);
		
		JLabel lblPoints = new JLabel("PUNTOS");
		lblPoints.setBounds(257, 137, 65, 14);
		contentPane.add(lblPoints);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 156, 86, 51);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
	}
	
	
	protected void crear() {
		if(datosValidos()){
			
				try{
					Personaje p = MapearDeFormulario();
				
				ctrl.agregar(p);
				MapearAFormulario(p);
				//limpiarCampos();
				} 
				catch (ApplicationException ae) {
					notifyUser(ae.getMessage(),ae, Level.DEBUG);
				}
			}
	}
	
	
	
	public boolean datosValidos(){
		boolean valido=true;
		if(txtID.getText().trim().length()==0
			|| txtNombre.getText().trim().length()==0){
			valido=false;
			notifyUser("Complete todos los campos");
		}
		if(valido && !txtID.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("DNI inválido");
		}
			
		return valido;
	}
	
	
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
	
	
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		if(!txtID.getText().isEmpty()) p.setId(Integer.parseInt(txtID.getText()));
		p.setNombre(txtNombre.getText());
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setAtaque(Integer.parseInt(txtAtaque.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		//p.setTotalRestante(Integer.parseInt(txtTotalRestante.getText());
		
		return p;
	}


	public void MapearAFormulario(Personaje p){
		if(p.getId()>0)
		txtID.setText(String.valueOf(p.getId()));
		txtNombre.setText(p.getNombre());
		txtVida.setText(String.valueOf(p.getVida()));
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtAtaque.setText(String.valueOf(p.getAtaque()));
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		//txtTotalRestante(String.valueOf(p.getTotalRestante()));
	}



}
