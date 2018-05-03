package eVoto.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eVoto.cod.Principal;
import eVoto.cod.Votante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.PrimitiveIterator;
import java.awt.event.ActionEvent;

public class RegistroVotantes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private ButtonGroup botones =new  ButtonGroup();
	private String documento;

	/**
	 * Create the frame.
	 */
	public RegistroVotantes() {
		setTitle("REGISTRO DE VOTANTES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR VOTANTE");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(102, 153, 51));
		lblNewLabel.setBounds(136, 11, 424, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCedula = new JLabel("Cedula :");
		lblCedula.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCedula.setBounds(136, 69, 68, 22);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNombre.setBounds(136, 114, 68, 22);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblApellido.setBounds(136, 168, 68, 22);
		contentPane.add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo : ");
		lblSexo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblSexo.setBounds(136, 214, 68, 22);
		contentPane.add(lblSexo);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(221, 68, 130, 29);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(221, 113, 130, 29);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(221, 167, 130, 29);
		contentPane.add(txtApellido);
		
		JRadioButton rdbFemenino = new JRadioButton("Femenino");
		rdbFemenino.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		rdbFemenino.setBackground(new Color(255, 255, 255));
		rdbFemenino.setBounds(221, 240, 109, 23);
		contentPane.add(rdbFemenino);
		
		JRadioButton rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		rdbMasculino.setBackground(new Color(255, 255, 255));
		rdbMasculino.setBounds(221, 214, 109, 23);
		contentPane.add(rdbMasculino);
		
		botones.add(rdbFemenino);
		botones.add(rdbMasculino);
		
		//se instancian las clases
		ConsultarVotante consultarVotante = new ConsultarVotante();
		Principal principal = new Principal();
		Login login = new Login();
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula = txtCedula.getText();
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String sexo = null;
				Votante votos = new Votante(cedula,nombre,apellido,sexo);
				
				
				if (rdbMasculino.isSelected())
				{
					sexo="Masculino";
				}
				else if (rdbFemenino.isSelected())
				{
					sexo="Femenino";
				}
				
				votos.setCedula(cedula);
				votos.setNombre(nombre);
				votos.setApellido(apellido);
				votos.setSexo(sexo);

				principal.votantes.add(votos);
				JOptionPane.showMessageDialog(null, "Ingreso exitoso\n" +votos.toString());
				
				//retornar a la pantalla de login para consultar y registrar el voto
				dispose();
				login.setVisible(true);
				
				
				
				
				
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(136, 300, 100, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(262, 300, 100, 23);
		contentPane.add(btnSalir);
	}
}
