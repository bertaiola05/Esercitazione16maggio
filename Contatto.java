
/**
 * Aggiungi qui una descrizione della classe Contatto
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Contatto
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private String cognome;
    private String nome;
    private String indirizzoMail;
    private String numeroTelefono;

    /**
     * Costruttore degli oggetti di classe  Contatto
     */
    public Contatto()
    {
        cognome = "";
        nome = "";
        indirizzoMail ="";
        numeroTelefono="";
    }
    
    public Contatto(String cognome,String nome ,String indirizzoMail, String numeroTelefono )
    {
        this.cognome = cognome;
        this.nome = nome ;
        this.indirizzoMail =indirizzoMail;
        this.numeroTelefono=numeroTelefono;
    }
    
    public Contatto(Contatto p)
    {
        setCognome(p.getCognome());
        setNome(p.getNome());
        setIndirizzoMail(p.getIndirizzoMail());
        setNumeroTelefono(p.getNumeroTelefono());
    }
    /**
     * Un esempio di metodo - aggiungi i tuoi commenti
     * 
     * @param  y   un parametro d'esempio per un metodo
     * @return     la somma di x e y
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setIndirizzoMail(String indirizzoMail){
        this.indirizzoMail = indirizzoMail;
    }
    public void setNumeroTelefono(String numeroTelefono){
        this.numeroTelefono = numeroTelefono;
    }
    
    public String getCognome(){
        return cognome;
    }
    public String getNome(){
        return nome;
    }
    public String getIndirizzoMail(){
        return indirizzoMail;
    }
    public String getNumeroTelefono(){
        return numeroTelefono;
    }
    
    public String toString(){
        return nome+" "+cognome+"\nMail: "+indirizzoMail+"\nTelefono: "+numeroTelefono;
    }
}

