package eVoto.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inadministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Inadministrador() {
		setTitle("ADMINISTRAR DATOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRAR VOTANTES");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(102, 153, 51));
		lblNewLabel.setBounds(20, 0, 414, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Inadministrador.class.getResource("/Images/registrar_datos.png")));
		lblNewLabel_1.setBounds(20, 70, 173, 160);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroVotantes nuevoRegistro=new RegistroVotantes();
				nuevoRegistro.setVisible(true);
				Inadministrador.this.dispose();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(256, 70, 99, 31);
		contentPane.add(btnRegistrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarVotante nuevaconsulta=new ConsultarVotante();
				nuevaconsulta.setVisible(true);
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditar.setBounds(256, 112, 99, 31);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVotante nuevaconsulta=new ConsultarVotante();
				nuevaconsulta.setVisible(true);
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminar.setBounds(256, 154, 99, 31);
		contentPane.add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListar.setBounds(256, 196, 99, 31);
		contentPane.add(btnListar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(256, 238, 99, 31);
		contentPane.add(btnSalir);
	}

}
