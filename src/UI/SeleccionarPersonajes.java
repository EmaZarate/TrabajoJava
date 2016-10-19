package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.fabric.xmlrpc.base.Data;

import Entidades.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controlador.*;


public class SeleccionarPersonajes extends JFrame {

	private JPanel contentPane;
	private JTextField textId1;
	private JTextField textNombre1;
	private JTextField textVida1;
	private JTextField textEnergia1;
	private JTextField textAtaque1;
	private JTextField textDefensa1;
	private JTextField textEvasion1;
	private JTextField textId2;
	private JTextField textNombre2;
	private JTextField textVida2;
	private JTextField textEnergia2;
	private JTextField textAtaque2;
	private JTextField textDefensa2;
	private JTextField textEvasion2;
	private ControladorJuego ctrlJuego;
	private Personaje personaje1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarPersonajes frame = new SeleccionarPersonajes();
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
	public SeleccionarPersonajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscarPersonaje1 = new JButton("Buscar personaje 1");
		btnBuscarPersonaje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar1();
			}
		});
		btnBuscarPersonaje1.setBounds(10, 227, 138, 23);
		contentPane.add(btnBuscarPersonaje1);
		
		JButton btnBuscarpersonaje = new JButton("BuscarPersonaje 2");
		btnBuscarpersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar2();
			}
		});
		btnBuscarpersonaje.setBounds(288, 227, 128, 23);
		contentPane.add(btnBuscarpersonaje);
		
		JButton btnOk = new JButton("ok");
		btnOk.setBounds(170, 227, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(10, 61, 46, 14);
		contentPane.add(lblVida);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(10, 99, 46, 14);
		contentPane.add(lblEnergia);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(10, 132, 46, 14);
		contentPane.add(lblAtaque);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(10, 168, 46, 14);
		contentPane.add(lblDefensa);
		
		JLabel lblEvasin = new JLabel("Evasi\u00F3n");
		lblEvasin.setBounds(10, 193, 46, 14);
		contentPane.add(lblEvasin);
		
		textId1 = new JTextField();
		textId1.setBounds(66, 8, 86, 20);
		contentPane.add(textId1);
		textId1.setColumns(10);
		
		textNombre1 = new JTextField();
		textNombre1.setText("");
		textNombre1.setBounds(66, 36, 86, 20);
		contentPane.add(textNombre1);
		textNombre1.setColumns(10);
		
		textVida1 = new JTextField();
		textVida1.setBounds(66, 58, 86, 20);
		contentPane.add(textVida1);
		textVida1.setColumns(10);
		
		textEnergia1 = new JTextField();
		textEnergia1.setBounds(66, 96, 86, 20);
		contentPane.add(textEnergia1);
		textEnergia1.setColumns(10);
		
		textAtaque1 = new JTextField();
		textAtaque1.setBounds(66, 129, 86, 20);
		contentPane.add(textAtaque1);
		textAtaque1.setColumns(10);
		
		textDefensa1 = new JTextField();
		textDefensa1.setText("");
		textDefensa1.setBounds(66, 165, 86, 20);
		contentPane.add(textDefensa1);
		textDefensa1.setColumns(10);
		
		textEvasion1 = new JTextField();
		textEvasion1.setText("");
		textEvasion1.setBounds(66, 190, 86, 20);
		contentPane.add(textEvasion1);
		textEvasion1.setColumns(10);
		
		textId2 = new JTextField();
		textId2.setBounds(330, 8, 86, 20);
		contentPane.add(textId2);
		textId2.setColumns(10);
		
		textNombre2 = new JTextField();
		textNombre2.setText("");
		textNombre2.setBounds(330, 36, 86, 20);
		contentPane.add(textNombre2);
		textNombre2.setColumns(10);
		
		textVida2 = new JTextField();
		textVida2.setBounds(330, 58, 86, 20);
		contentPane.add(textVida2);
		textVida2.setColumns(10);
		
		textEnergia2 = new JTextField();
		textEnergia2.setBounds(330, 96, 86, 20);
		contentPane.add(textEnergia2);
		textEnergia2.setColumns(10);
		
		textAtaque2 = new JTextField();
		textAtaque2.setBounds(330, 129, 86, 20);
		contentPane.add(textAtaque2);
		textAtaque2.setColumns(10);
		
		textDefensa2 = new JTextField();
		textDefensa2.setBounds(330, 165, 86, 20);
		contentPane.add(textDefensa2);
		textDefensa2.setColumns(10);
		
		textEvasion2 = new JTextField();
		textEvasion2.setBounds(330, 190, 86, 20);
		contentPane.add(textEvasion2);
		textEvasion2.setColumns(10);
		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setBounds(274, 11, 46, 14);
		contentPane.add(lblId_1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(274, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblVida_1 = new JLabel("Vida");
		lblVida_1.setBounds(274, 61, 46, 14);
		contentPane.add(lblVida_1);
		
		JLabel lblEnergia_1 = new JLabel("Energia");
		lblEnergia_1.setBounds(274, 99, 46, 14);
		contentPane.add(lblEnergia_1);
		
		JLabel lblAtaque_1 = new JLabel("Ataque");
		lblAtaque_1.setBounds(274, 132, 46, 14);
		contentPane.add(lblAtaque_1);
		
		JLabel lblDefensa_1 = new JLabel("Defensa");
		lblDefensa_1.setBounds(274, 168, 46, 14);
		contentPane.add(lblDefensa_1);
		
		JLabel lblEvasin_1 = new JLabel("Evasi\u00F3n");
		lblEvasin_1.setBounds(274, 193, 46, 14);
		contentPane.add(lblEvasin_1);
		
		
	}
	public void MapearAFormulario1(Personaje p){
		if(p.getId()>0)
		textId1.setText(String.valueOf(p.getId()));
		textNombre1.setText(p.getNombre());
		textVida1.setText(String.valueOf(p.getVida()));
		textEnergia1.setText(String.valueOf(p.getEnergia()));
		textAtaque1.setText(String.valueOf(p.getAtaque()));
		textDefensa1.setText(String.valueOf(p.getDefensa()));
		textEvasion1.setText(String.valueOf(p.getEvasion()));
		
	}
	
	public void MapearAFormulario2(Personaje p){
		if(p.getId()>0)
		textId2.setText(String.valueOf(p.getId()));
		textNombre2.setText(p.getNombre());
		textVida2.setText(String.valueOf(p.getVida()));
		textEnergia2.setText(String.valueOf(p.getEnergia()));
		textAtaque2.setText(String.valueOf(p.getAtaque()));
		textDefensa2.setText(String.valueOf(p.getDefensa()));
		textEvasion2.setText(String.valueOf(p.getEvasion()));
		
	}
	public void buscar1(){
		Personaje per =  new Personaje();
		per.setId(Integer.parseInt(textId1.getText()));
		Personaje p=ctrlJuego.Buscar(per);
		if(p!= null){
			MapearAFormulario1(p);
			personaje1=p;
		}
	}
	public void buscar2(){
		Personaje per =  new Personaje();
		per.setId(Integer.parseInt(textId2.getText()));
		Personaje p=ctrlJuego.Buscar(per);
		if(p!= null){
			MapearAFormulario2(p);
			personaje1=p;
		}
	}
}
