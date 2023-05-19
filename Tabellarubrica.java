public class Tabellarubrica {
 private Contatto rubrica[]; // vettore di contatti
 private int persone; //numero di contatti salvati
 
 public Tabellarubrica(int dimensione) {
   rubrica = new Contatto[dimensione];
   persone=0;
 }
// funzione hash
 private int hash (String chiave) {//ciao    c=6 i = 5 a=9 o=0
   int p = 0;
   for (int i=0; i<chiave.length(); i++) {
     p += chiave.charAt(i);// 6+5+9+0 = 20
   }
   return (p % rubrica.length);
 }
 
// operazione R = ricerca per informazioni
// operazione I = ricerca per inserimento
 private int cercaContatto(String chiave, char operazione) throws TabellaException {
     int p = hash(chiave);
     if (operazione == 'R') {
         // ricerca per informazioni
          if (rubrica[p] == null)
           throw new TabellaException( "Elemento "+chiave+ " non esistente");
          if (rubrica[p].getNumeroTelefono().equals(chiave))
           return p;
          if(rubrica[p].getIndirizzoMail().equals(chiave))
              return p;
     }else {
         // ricerca per inserimento
          if (rubrica[p] == null)
           return p;
           if (rubrica[p].getNumeroTelefono().equals(chiave))
            throw new TabellaException( "Elemento "+rubrica[p].getNumeroTelefono()+ " preesistente");
          if (rubrica[p].getIndirizzoMail().equals(chiave))
            throw new TabellaException( "Elemento "+rubrica[p].getIndirizzoMail()+ " preesistente");
    
     }
     // collisione -> scansione lineare
     p = scansioneLineare(p, chiave, operazione);
     return p;
 }
 public Contatto cerca(String parolachiave) throws TabellaException {
   int p = cercaContatto(parolachiave,'R');
   return new Contatto(rubrica[p]);
 }
 public int getNumeroPersone() {
  return persone;
 }
 public int inserisciContattoTelefono(Contatto Contatto) throws TabellaException {
  String chiave = Contatto.getNumeroTelefono();
  int p = cercaContatto(chiave, 'I');
  rubrica[p] = new Contatto(Contatto);
  persone++;
  return p;
}
public int inserisciContattoEmail(Contatto Contatto) throws TabellaException {
  String chiave = Contatto.getIndirizzoMail();
  int p = cercaContatto(chiave, 'I');
  rubrica[p] = new Contatto(Contatto);
  persone++;
  return p;
}
public int eliminaContatto(String informazioni) throws TabellaException {
  int p = cercaContatto(informazioni, 'R');
  rubrica[p] = null;
  persone--;
  return p;
}
// funzione di visualizzazione dello stato corrente
// utilizzata a scopo di test
public void visualizzaStatoTabella() {
  for (int i=0; i<rubrica.length; i++)
  if (rubrica[i] != null)
  System.out.println("Posizione "+i+"->"+rubrica[i].toString()+"(hash: "+hash(rubrica[i].getNumeroTelefono())+")"+"\n");
}

private int scansioneLineare ( int posizioneIniziale, String chiave, char operazione) throws TabellaException {
  int p = posizioneIniziale;
  while (true) {
   p++;
   p = p % rubrica.length;
   if (operazione == 'R') {
   // ricerca per informazione
    if (rubrica[p] == null)
     throw new TabellaException( "Elemento "+chiave+ " non esistente");
    if (rubrica[p].getNumeroTelefono().equals(chiave))
    return p;
   }
   else {
   // ricerca per inserimento
    if (rubrica[p] == null)
    return p;
    if (rubrica[p].getNumeroTelefono().equals(chiave))
      throw new TabellaException( "Elemento "+rubrica[p].getNumeroTelefono()+ " preesistente");
  }
  if (p == posizioneIniziale)
   if (operazione == 'R')
    throw new TabellaException( "Elemento "+chiave+ " non esistente");
   else
   throw new TabellaException("Tabella piena");
  }
}
public static void main (String[] args) {
    //String codice_barre, String descrizione, double prezzo, int quantita
 Contatto p1 = new Contatto("Costantini","Viola","viola.costantini@salesianiverona.it","3318888312");
 Contatto p2 = new Contatto("Pasti","Francesco","francesco.pasti@salesianiverona.it","3926934118");
 Contatto p4 = new Contatto("Manzini","Daniele","daniele.manzini@salesianiverona.it","3512024120");
 Contatto p5 = new Contatto("Lypomani","Francesco","francesco.lypomani@salesianiverona.it","3920356788");
 Tabellarubrica t = new Tabellarubrica(100);
 try {
   System.out.println("Inserimento Contatto " +p1.toString()+" posizione: "+t.inserisciContattoTelefono(p1)+"\n\n");
   System.out.println("Inserimento Contatto " +p2.toString()+" posizione: "+t.inserisciContattoTelefono(p2)+"\n\n");
   System.out.println("Inserimento Contatto " +p4.toString()+" posizione: "+t.inserisciContattoEmail(p4)+"\n\n");
   System.out.println("Inserimento Contatto " +p5.toString()+" posizione: "+t.inserisciContattoEmail(p5)+"\n\n");
 }
 catch (TabellaException e) {
  System.out.println(e.getError());
 }
 System.out.println("Stato tabella:");
 t.visualizzaStatoTabella();
 try {
   System.out.println("Ricerca p2: "+ t.cerca(p2.getNumeroTelefono()));
 }
 catch (TabellaException e) {
   System.out.println(e.getError());
 }
 try {
   System.out.println( "Eliminazione Contatto p5 in posizione: "+t.eliminaContatto(p5.getIndirizzoMail()));
 }
 catch (TabellaException e) {
   System.out.println(e.getError());
 }
 System.out.println("Stato tabella:");
 t.visualizzaStatoTabella();
 }

}