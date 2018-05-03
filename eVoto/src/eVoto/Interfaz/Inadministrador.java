package eVoto.Interfaz;

import eVoto.cod.Votante;
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
import java.util.ArrayList;

public class Inadministrador extends JFrame {

    private JPanel contentPane;

    public ArrayList<Votante> listaVotantes;

    public Inadministrador() {
        inicializarInterfaz();
    }

    /**
     * Create the frame.
     */
    public Inadministrador(ArrayList<Votante> lista) {

        //se copia la lista del programa principal
        listaVotantes = lista;
        inicializarInterfaz();
        
    }
    
    private void inicializarInterfaz(){
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
                RegistroVotantes nuevoRegistro = new RegistroVotantes(listaVotantes);
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
                ConsultarVotante nuevaconsulta = new ConsultarVotante(listaVotantes,1);
                nuevaconsulta.setVisible(true);
                Inadministrador.this.dispose();
            }
        });
        btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEditar.setBounds(256, 112, 99, 31);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsultarVotante nuevaconsulta = new ConsultarVotante(listaVotantes,2);
                nuevaconsulta.setVisible(true);
                Inadministrador.this.dispose();  
            }
        });
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEliminar.setBounds(256, 154, 99, 31);
        contentPane.add(btnEliminar);

        JButton btnListar = new JButton("Listar");
        btnListar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnListar.setBounds(256, 196, 99, 31);
        
         btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Listar listar = new Listar(listaVotantes);
              listar.setVisible(true);
              Inadministrador.this.dispose();  
            }
        });
         
        contentPane.add(btnListar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Login login = new Login();
                login.setListaVotantes(listaVotantes);
                login.setVisible(true);
                Inadministrador.this.dispose();
            }
        });
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalir.setBounds(256, 238, 99, 31);
        contentPane.add(btnSalir);
    }

    public ArrayList<Votante> getListaVotantes() {
        return listaVotantes;
    }

    public void setListaVotantes(ArrayList<Votante> listaVotantes) {
        this.listaVotantes = listaVotantes;
    }

}
