package eVoto.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eVoto.cod.Principal;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField fcontrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblinicio = new JLabel("INICIAR SESION");
		lblinicio.setForeground(new Color(102, 153, 51));
		lblinicio.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblinicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblinicio.setBounds(5, 5, 424, 45);
		contentPane.add(lblinicio);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(174, 89, 109, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblusuario = new JLabel(" Usuario");
		lblusuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblusuario.setBounds(85, 93, 74, 14);
		contentPane.add(lblusuario);
		
		JLabel label = new JLabel(" Usuario");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label.setBounds(209, 189, 74, -24);
		contentPane.add(label);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblContrasenia.setBounds(72, 150, 87, 14);
		contentPane.add(lblContrasenia);
		
		Principal principal = new Principal();
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char clave[]=fcontrasenia.getPassword();
				String clavedef=new String(clave);
				
				if (txtUsuario.getText().trim().equals("Administrador") && clavedef.trim().equals("12345")
					|| txtUsuario.getText().trim().equals("Jurado") && clavedef.trim().equals("12345")){

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
		
		//metodo para generar evento por teclado
		btnIngresar.addKeyListener(new KeyAdapter() {
			
		});
		
		btnIngresar.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent ke)
			{
				char clave[]=fcontrasenia.getPassword();
				String clavedef=new String(clave);
				
				if (ke.getKeyCode() == KeyEvent.VK_TAB)
				{
					if (txtUsuario.getText().trim().equals(null) || txtUsuario.getText().trim().length()<0)
					{
						JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
				                + "El campo usuario es obligatorio", "Campo obligatorio",
				                JOptionPane.ERROR_MESSAGE);
					}
					
					if (fcontrasenia.getText().trim().equals(null) || fcontrasenia.getText().trim().length()<0)
					{
						JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
				                + "El campo contrase�a es obligatorio", "Campo obligatorio",
				                JOptionPane.ERROR_MESSAGE);
					}
				}
				
				//login jurado o administrador
				if (txtUsuario.getText().trim().equals("Administrador") && clavedef.trim().equals("12345")
					|| txtUsuario.getText().trim().equals("Jurado") && clavedef.trim().equals("12345")){
					
					dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema eVoto",   "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    if (txtUsuario.getText().trim().equals("Administrador"))
                    {
                    	Inadministrador nuevoAdmin=new Inadministrador();
        				nuevoAdmin.setVisible(true);
                    }
                    else if (txtUsuario.getText().trim().equals("Jurado"))
                    {	
                    	Ijurado nuevoJurado=new Ijurado();
                    	nuevoJurado.setVisible(true);
                    }
                    
	            }
				else 
	            {
	                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
	                + "Por favor ingrese un usuario y/o contrase�a correctos", "Acceso denegado",
	                JOptionPane.ERROR_MESSAGE);
	                txtUsuario.setText("");
	                fcontrasenia.setText("");
	            }
			}
		});
		btnIngresar.setBounds(135, 207, 94, 26);
		contentPane.add(btnIngresar);
		
		fcontrasenia = new JPasswordField();
		fcontrasenia.setBounds(174, 149, 109, 26);
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
		btnSalir.setBounds(239, 207, 87, 26);
		contentPane.add(btnSalir);
	}
}
