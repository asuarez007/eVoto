package eVoto.cod;

import javax.swing.JTextField;

public class Votante {
	 /**
     * Atributo que modela el nombre del
     */
    protected String nombre;
    /**
     * Atributo que modela el apellido del votante
     */
    protected String apellido;
    /**
     * Atributo que modela la cedula del votante
     */
    public String cedula;
    /**
     * Atributo que modela el sexo del votante
     */
    protected String sexo;

    /**
     * Constructor de un votante 
     * @param cedula - cedula del votante
     * @param pNombre - String, nombre del votante
     * @param pApellido -String, apellido del votante
     * @param pSexo -String, sexo del votante
     */
    public Votante(String Cedula,String pNombre, String pApellido, String pSexo) {
        this.cedula = Cedula;
    	this.nombre = pNombre;
        this.apellido = pApellido;
        this.sexo = pSexo;
    }
    /**
     * Método que obtiene la cedula del votante /
     * @param txtCedula **
     * @return icedula -cedula del votante
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Método que cambia la cedula del votante
     * @param cedula - String no nulo .
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
   
    
     /**
     * Método que obtiene el nombre del votante
     * @return nombre - nombre del Votante
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que cambia el nombre del votante
     * @param nombre - String no nulo .
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que obtiene el apellido del votante
     * @return apellido - apellido del votante
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Método que cambia el el apellido del votante
     * @param apellido - String no nulo .
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
     /**
     * Método que obtiene el sexo del votante
     * @return sexo- sexo del votante
     */
    public String getSexo() {
        return sexo;
    }
     /**
     * Método que cambia el sexo del votante
     * @param sexo - String no nulo .
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   
  
    public String toString(){
        return  "Numero de documento: "+this.getCedula()+"\nNombres: "+this.getNombre() + "\nApellidos: " + this.getApellido()+ "\nSexo: " + this.getSexo();
    }
}


