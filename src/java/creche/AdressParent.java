/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creche;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ITU
 */
public class AdressParent {
        public int idAdressParent;
        public String adress;
        public Connection  c;

        public AdressParent(){}
        public AdressParent(String adress){
                this.adress = adress;
        }
        public void addAdress(AdressParent aP){
            ConnexionJDBC conn = new ConnexionJDBC();
            Parent p = new Parent();
            int id =  p.getIdParent();    
            try{   
                    c = conn.getConnPostgre();
                    String req = "insert into adressparent (idparent,adressparent) values ("+id+",'"+aP.adress+"')";
                    Statement stmt = c.createStatement();
                    System.out.println("test");
                    stmt.executeUpdate(req);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
        }
        /*public static void main(String[] arg){
            Parent pt = new Parent();
            System.out.println(pt.getIdParent());
        }*/
}
