package eVoto.cod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Clase que modela la mesa
 */
public class Principal implements Serializable {

    private static final Jurado Jurado = null;

// ---------------------------------------------------------------------------------------------------------
// Atributos Privados
// ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela la ruta en el proyecto del archivo de serializaci�n
     * de la copa.
     */
    private String serializacionUrl = "src/eVOTO!/Persistencia/eVOTO.ser";

// ---------------------------------------------------------------------------------------------------------
// Atributos P�blicos
// ---------------------------------------------------------------------------------------------------------
    /**
     * Lista de votantes que votaran en la mesa.
     */
    public ArrayList<Votante> votante;
    /**
     * Lista de interacciones de los jugadores en los partidos.
     */
    public ArrayList<Jurado> interacciones;

    /**
     *
     * /**
     * Constructor de la clase principal.
     */

    // Iniciar el programa cargando el archivo de propiedades si existe.
// ---------------------------------------------------------------------------------------------------------
// Constructores
// ---------------------------------------------------------------------------------------------------------
    /**
     * Constructor de la clase principal.
     */
    public void iniciarMesa() {
        // Inicializar listas
        votantes = new ArrayList<Votante>();
    }

    public ArrayList<Votante> votantes = new ArrayList<>();

    public int menuPrincipal() {

        int op = -1;
        while (op != 0) {
            // Interacci�n inicial con el usuario
            String eVoto = JOptionPane.showInputDialog(null, "�Bienvenido a eVoto sistema de registor de votacion!\n"
                    // Opciones
                    + "A continuaci�n se lista una serie de opciones de las que tendr�s que escoger una y escribir el n�mero de la opci�n en la caja de texto.\n\n"
                    + "1. Opciones Administrador.\n"
                    + "2. Opciones de Jurados.\n"
                    + "0. Salir",
                    // T�tulo y tipo de mensaje.
                    "Men� principal", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(eVoto);
            switch (op) {
                case 1:
                    // Opciones de Administrador
                    this.menuAdministrador();
                    break;
                case 2:
                    // Opciones de jurados
                    this.menuJurados();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPcion invalida, intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return op;

    }

    /*Menu que muestra las opciones del administrador*/

    public void menuAdministrador() {
        int op = -1;
        while (op != 0) {
            String selvotantes = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Registrar Votante.\n"
                    + "2. Editar Cedula del Votante.\n"
                    + "3. Editar Nombre del Votante.\n"
                    + "4. Editar Apellido del Votante.\n"
                    + "5. Editar Sexo del Votante.\n"
                    + "6. Eliminar Votante.\n"
                    + "7. Listar Votantes Registrados"
                    + "0. Salir",
                    // T�tulo y tipo de mensaje.
                    "Men� del Administrador", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selvotantes);
            switch (op) {

                case 1:
                    // crea un votante con sus datos personales

                    String cedulaVotante = JOptionPane.showInputDialog(null,
                            "Introduce la cedula del votante: ",
                            "Creaci�n de votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (cedulaVotante == null || cedulaVotante.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;

                    }
                    int cedulaNAVotante = -1;
                    try {
                        cedulaNAVotante = Integer.parseInt(cedulaVotante);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }
                    String nombreVotante = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del votante: ",
                            "Creaci�n de votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombreVotante == null || nombreVotante.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }

                    String apellidoVotante = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del votante: ",
                            "Creaci�n de votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoVotante == null || apellidoVotante.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }

                    String sexoVotante = JOptionPane.showInputDialog(null,
                            "Introduce los partidos pitados del nuevo �rbitro: ",
                            "Creaci�n de �rbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (sexoVotante == null || sexoVotante.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }

                    Votante nuevo = new Votante(String.valueOf(cedulaNAVotante), nombreVotante, apellidoVotante, sexoVotante);

                    votantes.add(nuevo);

                    JOptionPane.showMessageDialog(null, "�Votante creado exitosamente!");

                    break;

                case 2:
                    // Edita la cedula de un votante al seleccionarlo
                    Votante votante2 = this.seleccionarVotante();
                    String CedulaVotante = JOptionPane.showInputDialog(null,
                            "Introduce la cedula del votante: ",
                            "Edici�n del votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (CedulaVotante == null || CedulaVotante.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }

                    int CedulaNAVotante = -1;
                    try {
                        CedulaNAVotante = Integer.parseInt(CedulaVotante);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }

                case 3:
                    // Edita el nombre de un votante al seleccionarlo
                    Votante votante3 = this.seleccionarVotante();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del Votanter: ",
                            "Edici�n del votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }
                    votante3.setNombre(nuevoNombre);
                    break;
                case 4:
                    // Edita el apellido de un votante al seleccionarlo
                    Votante votante4 = this.seleccionarVotante();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del votante: ",
                            "Edici�n del votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }
                    votante4.setApellido(nuevoApellido);
                    break;
                case 5:
                    // Edita el sexo de un auxiliar al seleccionarlo
                    Votante votante5 = this.seleccionarVotante();
                    String nuevosexo = JOptionPane.showInputDialog(null,
                            "Introduce el sexo del votante: ",
                            "Edici�n del votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevosexo == null || nuevosexo.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }
                    votante5.setSexo(nuevosexo);
                    break;
                case 6:
                    //Elimina un votante al seleccionarlo
                    Votante votante6 = this.seleccionarVotante();
                    String Eliminarcedula = JOptionPane.showInputDialog(null,
                            "Introduce la cedula del votante: ",
                            "Eliminar el votante",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (Eliminarcedula == null || Eliminarcedula.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                        break;
                    }
                    int EliminarNAcedula = -1;
                    try {
                        if (Eliminarcedula.equals(null) || Eliminarcedula.equals(" ")) {
                            throw new Error("No se ingreso un numero de documento");
                        }
                    } catch (Error e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(),
                                "Error", JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                    break;
                case 7:
                    // listar las personas registradas como votantes en esa mesa
                    String message = "Los votantes registrados en la mesa son:\n\n";
                    for (int i = 0; i < this.votantes.size(); i++) {
                        message += this.votantes.get(i).toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    break;

            }

        }

    }

    public void menuJurados() {
        int op = -1;
        while (op != 0) {
            String selvotantes = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Consultar Votante.\n"
                    + "2. Registar Voto.\n"
                    + "3. Contar Votos.\n"
                    + "4. Listar ciudadanos que votaron.\n"
                    + "0. Salir",
                    // T�tulo y tipo de mensaje.
                    "Men� de Jurados", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selvotantes);
            switch (op) {

                case 1:
                    // consultar un votante
                    Votante votante4 = this.seleccionarVotante();
                    break;

                case 2:
                    // registra una interaccion seleccionando un votante de la lista
                    int VotoRegistro = -1;
                    if (votante == null) {
                        Votante votante = this.seleccionarVotante();
                    }
                    Votante votanteSeleccionado = this.seleccionarVotante();

                    String interSeleccionada = JOptionPane.showInputDialog(null, "Selecciona una interacci�n : \n"
                            + "1. Camara.\n"
                            + "2. Senado.\n",
                            "Selecciona la interacci�n");
                    try {
                        VotoRegistro = Integer.parseInt(interSeleccionada);
                        Jurado nuevaInteraccion = new Jurado(votanteSeleccionado, VotoRegistro);

                        this.interacciones.add(nuevaInteraccion);

                        JOptionPane.showMessageDialog(null, "�Interacci�n registrada exitosamente!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurri� un problema al intentar guardar la interacci�n.");
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;

                case 3:
                // Contar los votos

                case 4:
                    // listar ciudadanos que votaron

                    String message = "Los ciudadanos registrados que votaron son:\n\n";
                    for (int i = 0; i < this.interacciones.size(); i++) {
                        message += this.interacciones.get(i).toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    break;

            }

        }
    }

    /**
     * M�todo que muestra la lista de los votantes registrados para que el
     * usuario los seleccione
     *
     */
    private Votante seleccionarVotante() {
        if (votante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay votantes registrados.");
            return null;
        } else {
            String message = "Selecciona un votante: \n";
            for (int i = 0; i < votante.size(); i++) {
                message += (i + 1) + ". " + votante.get(i).getCedula() + "\n";
            }
            String mesa = JOptionPane.showInputDialog(null, message, "Selecci�n del votante", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Votante) votante.get(Integer.parseInt(mesa) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar votante.");
            }
        }
        return null;
    }

    private void listarInteracciones(int interaccion) {
        String message = interaccion == 0 ? "Los votantes por Senado son: \n\n"
                : interaccion == 1 ? "Los voantes por camara son: \\n\\n"
                        : " \n\n";
        for (int i = 0; i < this.interacciones.size(); i++) {
            if (this.interacciones.get(i).getInteraccion() == interaccion) {
                message += this.interacciones.get(i).getVotante().toString() /*+ " " + this.interacciones.get(i).toString()*/;
            }
        }

        JOptionPane.showMessageDialog(null, message);
    }
//Buscar interacciones por votante

    private ArrayList<Jurado> bucsarInteraccionesPorJugador(Votante votante) {
        ArrayList<Jurado> respuesta = new ArrayList<Jurado>();
        for (int i = 0; i < interacciones.size(); i++) {
            if (interacciones.get(i).getVotante().getCedula() == votante.getCedula());
            respuesta.add(interacciones.get(i));
        }

        return respuesta;
    }

// ---------------------------------------------------------------------------------------------------------
// Main
// ---------------------------------------------------------------------------------------------------------
    /**
     * M�todo principal, es la entrada al momento de correr el proyecto.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Principal();
    }
}
