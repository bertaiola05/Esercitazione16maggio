public class TabellaException extends Exception {
 private String error="";
 
 TabellaException(String error) {
   this.error = error;
 }
 String getError() {
   return error;
 }
}