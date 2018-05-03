package eVoto.cod;

public class Jurado {

	 // ---------------------------------------------------------------------------------------------------------
    // Atributos Publicos
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela los que votaron por senado
     */
    public final static int NO = 0;
    /**
     * Atributo que modela los que  votaron por camara
     */
    public final static int SI = 1;

		

    /**
     * Atributo que modela la interacci�n
     */
    private int interaccion;

    private  Votante votante;

    public Jurado (Votante pvotante, int pInteraccion) throws Exception{
        votante = pvotante;
        interaccion = pInteraccion;
        switch(pInteraccion){
            case 0:
                // Senado
                break;
            case 1:
                // Camara
                break;

            default:
                throw new Exception("Interacci�n no v�lida");
        }
    }
    /**
     * M�todo que obtiene un votante
     * @return String - votante
     */
    public Votante getVotante() {
        return votante;
    }
    /**
     * M�todo que obtiene interacciones
     * @return String - interaccion
     */
    public int getInteraccion() {
        return interaccion;
    }


    public String toString(){
        return this.interaccion == 0 ? "voto por senado." : (this.interaccion == 1 ? "voto por camara." : ".");
    }


}
