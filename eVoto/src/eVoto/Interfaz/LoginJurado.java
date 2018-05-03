package eVoto.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class LoginJurado extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField fcontrasenia;

	/**
	 * Create the frame.
	 */
	public LoginJurado() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INICIAR SESION");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(102, 153, 51));
		lblNewLabel.setBounds(98, 11, 372, 53);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(193, 110, 131, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblUsuario.setBounds(98, 110, 75, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblContrasea.setBounds(86, 159, 87, 17);
		contentPane.add(lblContrasea);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char clave[]=fcontrasenia.getPassword();
				String clavedef=new String(clave);

				if (txtUsuario.getText().equals("Jurado") && clavedef.equals("12345")){

                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);

                    ConsultarVotante nuevoJurado = new ConsultarVotante();

                    nuevoJurado.setVisible(true);
	            }
				else 
	            {
	                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
	                    + "Por favor ingrese un usuario y/o contrase�a correctos", "Acceso denegado",
	                    JOptionPane.ERROR_MESSAGE);
	            }
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		//metodo para generar evento por teclado
		btningresar.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent ke)
			{
				char clave[]=fcontrasenia.getPassword();
				String clavedef=new String(clave);
				if (txtUsuario.getText().trim().equals("Jurado") && clavedef.trim().equals("12345")){

                    JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);
                    Login login = new Login();
                    login.setDefaultCloseOperation(HIDE_ON_CLOSE);

                    Inadministrador nuevoAdmin=new Inadministrador();
    				nuevoAdmin.setVisible(true);
	            }
				else 
	            {
	                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
	                + "Por favor ingrese un usuario y/o contrase�a correctos", "Acceso denegado",
	                JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
		btningresar.setBounds(142, 206, 87, 31);
		contentPane.add(btningresar);
		
		fcontrasenia = new JPasswordField();
		fcontrasenia.setBounds(193, 159, 131, 20);
		contentPane.add(fcontrasenia);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//metodo para generar evento por teclado
		btnSalir.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent ke)
			{
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(255, 206, 87, 31);
		contentPane.add(btnSalir);
	}

}
