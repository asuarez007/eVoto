package eVoto.Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Interfaz {

	private JFrame frmprincipal;

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmprincipal = new JFrame();
		frmprincipal.setTitle("eVoto");
		frmprincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/Images/logo.jpg")));
		frmprincipal.getContentPane().setBackground(new Color(255, 255, 255));
		frmprincipal.getContentPane().setLayout(null);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(Interfaz.class.getResource("/Images/logo.jpg")));
		lbllogo.setBounds(20, 11, 414, 130);
		frmprincipal.getContentPane().add(lbllogo);
		
		JButton btnNewButton = new JButton("Administrador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login nuevoLogin=new Login();
				nuevoLogin.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(86, 197, 130, 32);
		frmprincipal.getContentPane().add(btnNewButton);
		
		JButton btnJurado = new JButton("Jurado");
		btnJurado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJurado nuevoJurado=new LoginJurado() ;
				nuevoJurado.setVisible(true);
			}
		});
		btnJurado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnJurado.setBounds(241, 197, 130, 32);
		frmprincipal.getContentPane().add(btnJurado);
		frmprincipal.setBounds(100, 100, 450, 300);
		frmprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
