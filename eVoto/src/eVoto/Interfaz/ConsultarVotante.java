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
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ConsultarVotante extends JFrame {

    private JPanel contentPane;
    private JTextField txtconsultar;

    public ArrayList<Votante> listaVotantes;
   
    private Votante votanteSeleccinado;
    private Integer indexLista;

    /**
     * Create the frame.
     *
     * @param lista Lista de los votantes
     * @param accion 1: Editar, 2: Eliminar, 0:Consultar
     */
    public ConsultarVotante(ArrayList<Votante> lista, final Integer accion) {

        listaVotantes = lista;
       

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
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String cedula = txtconsultar.getText();

                boolean existe = false;
                int cont =0;
                if (listaVotantes != null && !listaVotantes.isEmpty()) {
                    for (Votante votante : listaVotantes) {
                        if (votante.getCedula().equals(cedula)) {
                            JOptionPane.showMessageDialog(null, "Datos del votante : \n" + votante.toString());
                            existe = true;
                            votanteSeleccinado = votante;
                            indexLista = cont;
                            break;
                        }
                        cont++;
                    }
                }
                if (existe) {
                    if (accion > 0) {
                        System.out.println("Votante seleccionado  "+votanteSeleccinado.toString());
                        System.out.println("Indice seleccionado  "+indexLista);
                        System.out.println("Accion  "+accion);
                        RegistroVotantes registroVotantes = new RegistroVotantes(listaVotantes, votanteSeleccinado, indexLista, accion);
                        registroVotantes.setVisible(true);
                        ConsultarVotante.this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El document ingresado no se encuentra registrado", "Error consulta", JOptionPane.ERROR_MESSAGE);
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
