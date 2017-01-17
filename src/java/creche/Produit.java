package creche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Produit {
        public int idProduit;
        public String nomProduit;
        public double prixProduit;
        public Produit(){}
        public Produit[] getProduit(){
            Produit[] rep = new Produit[1];
                ConnexionJDBC conn = new ConnexionJDBC();
                try{
                      int nb = 0;
                      Connection c = conn.getConnPostgre();
                      String req = "select count(*) from Produit";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      while(res.next()){
                          nb = Integer.parseInt(res.getString(1));
                      }
                      rep = new Produit[nb];
                      req = "select * from Produit";
                      stmt2 = c.createStatement();
                      res = stmt2.executeQuery(req);
                      int i = 0;
                      while(res.next()){
                          rep[i] = new Produit();
                          rep[i].idProduit = Integer.parseInt(res.getString("idProduit"));
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
}
