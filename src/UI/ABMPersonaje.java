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
import Data.DataPersonaje;
public class ABMPersonaje extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtDefensa;
	private JTextField txtNombre;
	private JTextField txtAtaque;
	private JTextField txtEnergia;
	private JTextField txtEvasion;
	private Component frame;
	ControladorABM ctrl= new ControladorABM();
	private JTextField txtVida;
	private JTextField txtPuntos;

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
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear();
				JOptionPane.showMessageDialog(null, "Personaje registrada!");
			}
		});
		
		btnCrear.setBounds(10, 347, 88, 23);
	
		contentPane.add(btnCrear);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar();
				
			}
		});
		button.setBounds(104, 347, 81, 23);
		contentPane.add(button);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();

				JOptionPane.showMessageDialog(null, "Personaje modificada!");

			}
		});
		btnModificar.setBounds(195, 347, 84, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();

				JOptionPane.showMessageDialog(null, "Personaje Eliminado!");
				

			}
		});
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
		
		txtPuntos = new JTextField();
		txtPuntos.setBounds(236, 156, 86, 51);
		contentPane.add(txtPuntos);
		txtPuntos.setColumns(10);
		
		
		
	}
	
	
	
	
	
	
	public boolean datosValidos(){
		boolean valido=true;
		if(txtID.getText().trim().length()==0
			|| txtNombre.getText().trim().length()==0|| txtAtaque.getText().trim().length()==0 || 
			txtDefensa.getText().trim().length()==0 || txtEnergia.getText().trim().length()==0 
			|| txtEvasion.getText().trim().length()==0 || txtVida.getText().trim().length()==0
			){
			valido=false;
			notifyUser("Complete todos los campos");
		}
		if(valido && !txtID.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("DNI inválido");
		}
		if( ((Integer.parseInt(txtEnergia.getText()))+(Integer.parseInt(txtVida.getText()))+(Integer.parseInt(txtAtaque.getText()))
				+(Integer.parseInt(txtDefensa.getText())) +(Integer.parseInt(txtEvasion.getText()))>200))
				
		{
		valido=false;
		notifyUser("Los atributos energia, vida, evasión,defensa y ataque superan los 200 puntos ");
		}
				
			
		return valido;
	}
	
	
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
	
	
	public Personaje MapearDeFormulario(int punto){
		Personaje p = new Personaje();
		if(!txtID.getText().isEmpty())
		p.setId(Integer.parseInt(txtID.getText()));
		p.setNombre(txtNombre.getText());
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setAtaque(Integer.parseInt(txtAtaque.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setPuntos(punto);
		
		
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
		txtPuntos.setText(String.valueOf(p.getPuntos()));
	
		//txtTotalRestante(String.valueOf(p.getTotalRestante()));
	}

	
	private void limpiarCampos() {
		txtID.setText("");
		txtNombre.setText("");
		txtVida.setText("");
		txtEnergia.setText("");
		txtAtaque.setText("");
		txtDefensa.setText("");
		txtEvasion.setText("");
	}
	
	protected void crear() {
		if(datosValidos()){
			
				Personaje p = MapearDeFormulario(200);
				
				ctrl.agregar(p);
				
				limpiarCampos();
				
			}
	}
	
	public Personaje buscar(){
		
		Personaje per =  new Personaje();
		per.setId(Integer.parseInt(txtID.getText()));
		Personaje p=ctrl.Buscar(per);
		if(p!= null)
			{MapearAFormulario(p);
			
			}
	    return p;
	}
	
	public void modificar(){
		
		Personaje p=buscar();
		if( ((Integer.parseInt(txtEnergia.getText()))+(Integer.parseInt(txtVida.getText()))+(Integer.parseInt(txtAtaque.getText()))
				+(Integer.parseInt(txtDefensa.getText())) +(Integer.parseInt(txtEvasion.getText()))>p.getPuntos()))
				
		{
			notifyUser("Los atributos energia, vida, evasión,defensa y ataque superan los 200 puntos ");
		}
		else{
		ctrl.Modificar(MapearDeFormulario(p.getPuntos()));
		limpiarCampos();
		}
	}
	
	public void eliminar(){
		ctrl.Eliminar(MapearDeFormulario(0));
		limpiarCampos();
	}

}
