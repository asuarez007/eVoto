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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.PrimitiveIterator;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RegistroVotantes extends JFrame {
    
    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private ButtonGroup botones = new ButtonGroup();
    
    private ArrayList<Votante> listaVotantes;
    private Votante votanteSeleccionado;
    private Integer index;
    
    private JRadioButton rdbMasculino;
    private JRadioButton rdbFemenino;
    
    private JButton btnEditar;
    private JButton btnRegistrar;
    private JButton btnEliminar;
    
    private Inadministrador inadministrador;
    private RegistroVoto registroVoto;
    private String cedula;

    /**
     * Create the frame.
     */
    public RegistroVotantes(ArrayList<Votante> lista) {

        //se copia la lista del programa principal
        listaVotantes = lista;
        inidializarInterfaz();
        inadministrador = new Inadministrador(lista);
        //registroVoto = new RegistroVoto(lista);
        btnRegistrar.setVisible(true);
        
    }
    
    public boolean Isnumber(String cedula) {
		try {
			this.cedula = cedula;
			Integer.parseInt(cedula);
			return true;
		}catch (NumberFormatException nfe) {
		return false;
		}
	}

    /**
     *
     * @param lista
     * @param votante
     * @param index
     * @param accion 1: Editar, 2: Eliminar
     */
    public RegistroVotantes(ArrayList<Votante> lista, Votante votante, final Integer index, Integer accion) {
        System.out.println("=============================EDITAR - ELIMINAR FUNCIONALIDAD ==============================");
        inidializarInterfaz();
        
        listaVotantes = lista;
        
        setTitle("ACTUALIZAR INFORMACION VOTANTE");
        System.out.println("Accion a realizar : " + accion);
        votanteSeleccionado = votante;
        
        txtCedula.setText(votante.getCedula());
        txtNombre.setText(votante.getNombre());
        txtApellido.setText(votante.getApellido());
        if (votante.getSexo().equals("Masculino")) {
            rdbMasculino.setSelected(true);
            rdbFemenino.setSelected(false);
        } else {
            rdbFemenino.setSelected(true);
            rdbMasculino.setSelected(false);
        }
        
        
        
        if (accion == 1) {
            inadministrador = new Inadministrador();
            btnEditar.setVisible(true);
            btnEditar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    cedula = txtCedula.getText();
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    String sexo = null;
                    
                    if (rdbMasculino.isSelected()) {
                        sexo = "Masculino";
                    } else if (rdbFemenino.isSelected()) {
                        sexo = "Femenino";
                    }
                    
                    votanteSeleccionado.setCedula(cedula);
                    votanteSeleccionado.setNombre(nombre);
                    votanteSeleccionado.setApellido(apellido);
                    votanteSeleccionado.setSexo(sexo);
                    
                    listaVotantes.set(index, votanteSeleccionado);
                    
                    JOptionPane.showMessageDialog(null, "Actualizacion exitosa\n" + votanteSeleccionado.toString());

                    //retornar a la pantalla de login para consultar y registrar el voto
                    dispose();
                    inadministrador.setVisible(true);
                    inadministrador.setListaVotantes(listaVotantes);
                    
                }
            });
            
        } else if (accion == 2) {
            inadministrador = new Inadministrador();
            txtCedula.setEnabled(false);
            txtNombre.setEnabled(false);
            txtApellido.setEnabled(false);
            rdbMasculino.setEnabled(false);
            rdbFemenino.setEnabled(false);
            
            btnEliminar.setVisible(true);
            btnEliminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    ArrayList<Votante> listatemp = new ArrayList<>();
                    
                    for (Votante votante : listaVotantes) {
                        if(!votante.getCedula().equals(votanteSeleccionado.getCedula())){
                            listatemp.add(votante);
                        }
                    }
                    
                    boolean resultado = listatemp.remove(index);
                    System.out.println("Resultado eliminacion : "+resultado);
                    System.out.println("Indice a eliminar : "+index);
                    dispose();
                    inadministrador.setVisible(true);
                    inadministrador.setListaVotantes(listatemp);
                    
                }
            });
        } else {
            inadministrador = new Inadministrador(lista);
        }
        
    }
    
    private void inidializarInterfaz() {
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
        
        rdbFemenino = new JRadioButton("Femenino");
        rdbFemenino.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        rdbFemenino.setBackground(new Color(255, 255, 255));
        rdbFemenino.setBounds(221, 240, 109, 23);
        
        contentPane.add(rdbFemenino);
        
        rdbMasculino = new JRadioButton("Masculino");
        rdbMasculino.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        rdbMasculino.setBackground(new Color(255, 255, 255));
        rdbMasculino.setBounds(221, 214, 109, 23);
        contentPane.add(rdbMasculino);
        
        botones.add(rdbFemenino);
        botones.add(rdbMasculino);
        
        Login login = new Login();
        
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
            	Registrar();   
            }
        });
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRegistrar.setBounds(136, 300, 100, 23);
        btnRegistrar.setVisible(false);
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

        //-----------------boton editar
        btnEditar = new JButton("Editar");
        
        btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEditar.setBounds(136, 300, 100, 23);
        btnEditar.setVisible(false);
        contentPane.add(btnEditar);

        //boton eliminar
        //-----------------boton editar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEliminar.setBounds(136, 300, 100, 23);
        btnEliminar.setVisible(false);
        contentPane.add(btnEliminar);
        
    }
    
    public void Registrar()
    {
    	cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String sexo = null;
        Votante votante = new Votante();
        
        if(!Isnumber(cedula)) 
        {                                                     
        	JOptionPane.showMessageDialog(null,"El numero de documento debe ser formato numerico","Error de formato",JOptionPane.ERROR_MESSAGE);
	    }
        
        if (rdbMasculino.isSelected()) {
            sexo = "Masculino";
        } else if (rdbFemenino.isSelected()) {
            sexo = "Femenino";
        }
        
        votante.setCedula(cedula);
        votante.setNombre(nombre);
        votante.setApellido(apellido);
        votante.setSexo(sexo);
        
        if (Isnumber(cedula))
        {
        	listaVotantes.add(votante);
        	JOptionPane.showMessageDialog(null, "Ingreso exitoso\n" + votante.toString());
        }
        else
        {
        	JOptionPane.showMessageDialog(null,"Error en el ingreso de datos del votante","Error de formato",JOptionPane.ERROR_MESSAGE);
        }
        
        //retornar a la pantalla de login para consultar y registrar el voto
        dispose();
        //registroVoto.setVisible(true);
        //registroVoto.setListaVotantes(listaVotantes);
        inadministrador.setVisible(true);
        inadministrador.setListaVotantes(listaVotantes);
        
    }
    
    public ArrayList<Votante> getListaVotantes() {
        return listaVotantes;
    }
    
    public void setListaVotantes(ArrayList<Votante> listaVotantes) {
        this.listaVotantes = listaVotantes;
    }
    
    public Integer getIndex() {
        return index;
    }
    
    public void setIndex(Integer index) {
        this.index = index;
    }
    
}
