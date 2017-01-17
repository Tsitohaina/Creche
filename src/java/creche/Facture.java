
package creche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Facture {
        public int idFacture;
        public String numeroFacture;
        public String dateFacture;
        public Facture(){}
        public Facture[] getAllfacture(){
                Facture[] rep = new Facture[1];
                ConnexionJDBC conn = new ConnexionJDBC();
                try{
                      int nb = 0;
                      Connection c = conn.getConnPostgre();
                      String req = "select count(*) from factureg where payer = false";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      while(res.next()){
                          nb = Integer.parseInt(res.getString(1));
                      }
                      rep = new Facture[nb];
                      req = "select * from factureg  where payer = false";
                      stmt2 = c.createStatement();
                      res = stmt2.executeQuery(req);
                      int i = 0;
                      while(res.next()){
                          rep[i] = new Facture();
                          rep[i].idFacture  = res.getInt("idFactureg");
                          rep[i].numeroFacture  = res.getString("numero");
                          rep[i].dateFacture  = res.getString("datet");
                          i++;
                     } 
                     c.close();
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public String getNumero(int idFacture){
                String rep = "";
                ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select numero from factureg where idfactureg = "+idFacture;
                    Statement stmt1 = c.createStatement();
                    ResultSet res = stmt1.executeQuery(req);
                    while(res.next()){
                      rep = res.getString(1);
                    }
                    c.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return rep;
        }
        public int getIdEnfant(int idFacture){
            int rep = 0;
            ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select idenfant from factureg where idfactureg = "+idFacture;
                    Statement stmt1 = c.createStatement();
                    ResultSet res = stmt1.executeQuery(req);
                    while(res.next()){
                      rep = res.getInt(1);
                    }
                    c.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            return rep;
        }
        public void payer(String numero,int id){
                ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();    
                    String req = "update factureg set payer = true where numero = '"+numero+"'";
                    Statement stmt = c.createStatement();
                    ResultSet res = stmt.executeQuery(req);
                    req = "update Consommation set facturer =true where idenfant = '"+id+"'";
                    stmt = c.createStatement();
                    res = stmt.executeQuery(req);   
                    c.close();
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }  
        }
        public static void main(){
                Facture f = new Facture();
                Facture[] ft = f.getAllfacture();
        }
}
