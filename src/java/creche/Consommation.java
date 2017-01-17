
package creche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consommation {
        public Consommation(){}
        public String dateConsommation;
        public String nomProduit;
        public Double prixProduit;
        public Consommation[] getConsommation(int idEnfant){
                Consommation[] rep = new Consommation[1];
                ConnexionJDBC conn = new ConnexionJDBC();
                try{
                      int nb = 0;
                      Connection c = conn.getConnPostgre();
                      String req = "select count(*) from Consommation join Produit on Produit.idProduit = Consommation.idProduit join Enfant on Consommation.idEnfant = Enfant.idEnfant where Consommation.idEnfant ="+idEnfant+" and Consommation.facturer=false;";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      while(res.next()){
                          nb = Integer.parseInt(res.getString(1));
                      }
                      rep = new Consommation[nb];
                      req = "select dateConsommation,nomProduit,prixProduit from Consommation join Produit on Produit.idProduit = Consommation.idProduit join Enfant on Consommation.idEnfant = Enfant.idEnfant where Consommation.idEnfant ="+idEnfant+" and Consommation.facturer=false";
                      stmt2 = c.createStatement();
                      res = stmt2.executeQuery(req);
                      int i = 0;
                      while(res.next()){
                          rep[i] = new Consommation();
                          rep[i].dateConsommation = res.getString("dateConsommation");
                          rep[i].nomProduit = res.getString("nomProduit");
                          rep[i].prixProduit = res.getDouble("prixProduit"); 
                          i++;
                     } 
                     c.close();
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public void ajouterConsommation(int idEnfant,int idProduit,String date,int tC){
                ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "insert into Consommation (idEnfant,idProduit,dateConsommation,facturer) values ('"+idEnfant+"','"+idProduit+"','"+date+"',false)";
                    Statement stmt = c.createStatement();
                    stmt.executeUpdate(req);
                    c.close();
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
        }
        public void addFact(int id,String numero){
                ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "insert into factureg (idEnfant,numero,datet,payer) values ('"+id+"','"+numero+"','22-12-2016',false)";
                    Statement stmt = c.createStatement();
                    stmt.executeUpdate(req);
                    c = conn.getConnPostgre();                    
                    c.close();
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }    
        }
        public static void main(String[] args){
                /*Consommation c = new Consommation();
                Consommation[] ct = c.getConsommation(1);
                for(int i = 0;i<ct.length;i++){
                    System.out.println(ct[i].nomProduit);
                }*/
        }
}
