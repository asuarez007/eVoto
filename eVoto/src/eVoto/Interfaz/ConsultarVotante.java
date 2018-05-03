package eVoto.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eVoto.cod.Principal;
import eVoto.cod.Votante;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;

public class ConsultarVotante extends JFrame {

	private JPanel contentPane;
	private JTextField txtconsultar;

	/**
	 * Create the frame.
	 */
	public ConsultarVotante() {
		setTitle("CONSULTAR VOTANTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtconsultar = new JTextField();
		txtconsultar.setBounds(230, 90, 121, 20);
		contentPane.add(txtconsultar);
		txtconsultar.setColumns(10);
		
		Principal principal = new Principal();
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula = txtconsultar.getText();
				String nombre = null,apellido = null,sexo = null;
				Votante votante = new Votante(cedula, nombre, apellido, sexo);
				
				for (int i=0; i<principal.votantes.size(); i++)
				{
					if (!cedula.equals(votante.getCedula()))
						JOptionPane.showMessageDialog(null, "El document ingresado no se encuentra registrado","Error consulta",JOptionPane.ERROR_MESSAGE);
				}
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(247, 133, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese un numero de cedula");
		lblNewLabel_1.setForeground(new Color(51, 102, 0));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1.setBounds(193, 36, 296, 56);
		
		
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ConsultarVotante.class.getResource("/Images/buscar.jpg")));
		lblNewLabel.setBounds(0, 61, 207, 146);
		contentPane.add(lblNewLabel);
	}
}
