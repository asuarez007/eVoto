package eVoto.Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.internal.IActionBean;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import eVoto.cod.Votante;
import javafx.scene.control.ComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroVoto extends JFrame{

	private JPanel contentPane;
	private JFrame frame;
	private JComboBox comboBox;
	private Ijurado ijurado;
	private Login login;
	private ArrayList<Votante> listaVotantes;
	
	private Votante votanteSeleccionado;
	public int contSenado=0;
	public int contCamara=0;
	public int contNoVoto=0;
	public int totalVotos;
	private String itemSeleecionado;
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	public RegistroVoto(ArrayList<Votante> lista) {

        //se copia la lista del programa principal
		inicioRegistrar();
        listaVotantes = lista;
        ijurado = new Ijurado(lista);
        login = new Login();
        
    }
	
	public void inicioRegistrar() {

		setTitle("REGISTRAR VOTO");
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR VOTO");
		lblNewLabel.setForeground(new Color(51, 153, 51));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 21, 251, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegistroVoto.class.getResource("/Images/vote-checkmark-green.png")));
		lblNewLabel_1.setBounds(0, 0, 278, 262);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Senado", "Camara", "No Voto"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(223, 121, 166, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				itemSeleecionado = (String)comboBox.getSelectedItem();
				
				
				if(ijurado.listaVotantes!=null && !ijurado.listaVotantes.isEmpty()){
					for (Votante votante: ijurado.listaVotantes)
					{
						if ("Senado".equals(itemSeleecionado)) {
							contSenado++;
							JOptionPane.showMessageDialog(null, "El ciudadano ha escogido voto por Senado","Informacion voto",JOptionPane.INFORMATION_MESSAGE);
							System.out.println(contSenado);
						}
						else if ("Camara".equals(itemSeleecionado))
						{
							contCamara++;
							JOptionPane.showMessageDialog(null, "El ciudadano ha escogido voto por Camara","Informacion voto",JOptionPane.INFORMATION_MESSAGE);
							System.out.println(contCamara);
						}
						else if ("No Voto".equals(itemSeleecionado))
						{
							contNoVoto++;
							JOptionPane.showMessageDialog(null, "El ciudadano opto por no votar","Informacion voto",JOptionPane.INFORMATION_MESSAGE);
							System.out.println(contNoVoto);
						}
					}
					dispose();
					//login.setVisible(true);
					//login.setListaVotantes(listaVotantes);
					ijurado.setVisible(true);
				}
			}
        });
		contentPane.add(comboBox);
		
	}
	
	public ArrayList<Votante> getListaVotantes() {
	        return listaVotantes;
	    }
	    
    public void setListaVotantes(ArrayList<Votante> listaVotantes) {
        this.listaVotantes = listaVotantes;
    }
    
    //metodos para contra los votos
    public int contarSenado()
    {	
    	setListaVotantes(listaVotantes);
    	if (listaVotantes != null && !listaVotantes.isEmpty()){
    		//for (Votante votante: listaVotantes)
    		//{
    			if ("Senado".equals(itemSeleecionado)) {
					contSenado++;
				}
    		//}
    	}
    	return contSenado;
    }
    
    public int contarCamara()
    {	
    	setListaVotantes(listaVotantes);
    	if (listaVotantes != null && !listaVotantes.isEmpty()){
    		//for (Votante votante: listaVotantes)
    		//{
    			if ("Camara".equals(itemSeleecionado)) {
    				contCamara++;
				}
    		//}
    	}
    	return contCamara;
    }
    
    public int contarNulos()
    {	
    	setListaVotantes(listaVotantes);
    	if (listaVotantes != null && !listaVotantes.isEmpty()){
    		//for (Votante votante: listaVotantes)
    		//{
    			if ("No Voto".equals(itemSeleecionado)) {
    				contNoVoto++;
				}
    		//}
    	}
	return contNoVoto;
    }
    
    public int totalVotos()
    {
    	totalVotos = contSenado+contCamara;
    	return totalVotos;
    }
    
}
