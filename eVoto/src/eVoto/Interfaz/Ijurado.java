package eVoto.Interfaz;

import eVoto.cod.Votante;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Ijurado extends JFrame {

    private JPanel contentPane;
    private RegistroVoto registroVoto;
    private Inadministrador inadministrador;

    public ArrayList<Votante> listaVotantes;

    /**
     * Initialize the contents of the frame.
     */
    public Ijurado(ArrayList<Votante> lista) {
        
        //lista de votantes
        listaVotantes = lista;
        
        if(listaVotantes!=null && !listaVotantes.isEmpty()){
            for (Votante votante : lista) {
                System.out.println(votante.toString());
            }
        }
    
    

        setTitle("ADMINISTRAR DATOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 330);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Ijurado.class.getResource("/Images/Voto.jpg")));
        lblNewLabel.setBounds(48, 75, 155, 150);
        contentPane.add(lblNewLabel);

        JButton btnbuscar = new JButton("Consultar Votante");
        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsultarVotante nuevoRegistro = new ConsultarVotante(listaVotantes, 0);
                nuevoRegistro.setVisible(true);
            }
        });
        btnbuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnbuscar.setBounds(239, 72, 155, 30);
        contentPane.add(btnbuscar);

        JButton btnRegistraVoto = new JButton("Registrar voto");
        btnRegistraVoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	registroVoto = new RegistroVoto(listaVotantes);
            	registroVoto.setListaVotantes(listaVotantes);
            	
            	String documento = JOptionPane.showInputDialog(null,"Ingrese el numero de cedula a registrar");
            	
            	for (Votante votante : listaVotantes)
            	{
	            	if (votante.getCedula().equals(documento)){
		            	registroVoto.setVisible(true);
		            	registroVoto.setListaVotantes(listaVotantes);
	            	}
	            	else
	            	{
	        		JOptionPane.showMessageDialog(null, "El numero de documento " +documento+ " no esta registrado","Error en consulta",JOptionPane.ERROR_MESSAGE);
	            		
	            		Ijurado ijurado = new Ijurado(listaVotantes);
	            		ijurado.setVisible(true);
	            		//inadministrador = new Inadministrador(lista);
	            		//inadministrador.setVisible(true);
	            		break;
	            		
	        			//Login login = new Login();
	        			//dispose();
	        			//login.setVisible(true);
	            	}
            	}
            }
        });
        btnRegistraVoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRegistraVoto.setBounds(239, 113, 155, 30);
        contentPane.add(btnRegistraVoto);

        JButton btnContarVotos = new JButton("Contar Votos");
        btnContarVotos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            	
            	
            	if (listaVotantes != null && listaVotantes.isEmpty()){
	            	
	            	JOptionPane.showMessageDialog(null, "Total de votos registrados: " +registroVoto.totalVotos());
	            	System.out.println(registroVoto.totalVotos());
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "No existen votantes inscritos","Error en consulta",JOptionPane.ERROR_MESSAGE);
        			Login login = new Login();
        			dispose();
        			login.setVisible(true);
            	}
            }
        });
        btnContarVotos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnContarVotos.setBounds(239, 154, 155, 30);
        contentPane.add(btnContarVotos);

        JButton btnListarVotos = new JButton("Listar Votos");
        btnListarVotos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnListarVotos.setBounds(239, 195, 155, 30);
        btnListarVotos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (listaVotantes != null && !listaVotantes.isEmpty()){
	            	registroVoto.setVisible(true);
	            	registroVoto.setListaVotantes(listaVotantes);
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "No existen votantes inscritos","Error en consulta",JOptionPane.ERROR_MESSAGE);
        			Login login = new Login();
        			dispose();
        			login.setVisible(true);
            	}
            }
        });
        contentPane.add(btnListarVotos);

        JLabel lblAdministrarVotos = new JLabel("ADMINISTRAR VOTOS");
        lblAdministrarVotos.setForeground(new Color(51, 153, 51));
        lblAdministrarVotos.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblAdministrarVotos.setBounds(48, 23, 334, 22);
        contentPane.add(lblAdministrarVotos);
        contentPane.setBounds(100, 100, 450, 300);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //metodo para generar evento por teclado
        btnSalir.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                System.exit(0);
            }
        });
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalir.setBounds(239, 238, 155, 31);
        contentPane.add(btnSalir);
    }
    
    public ArrayList<Votante> getListaVotantes() {
        return listaVotantes;
    }
    
    public void setListaVotantes(ArrayList<Votante> listaVotantes) {
        this.listaVotantes = listaVotantes;
    }

}
