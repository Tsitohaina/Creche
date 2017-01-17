/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ITU
 */
public class Niveau {
           public String nomNiveau;
           public int ageMin;
           public int ageMax;
           public Niveau(){}
           public Niveau(String nomNiveau,int ageMin,int ageMax){
               this.nomNiveau = nomNiveau;
               this.ageMin = ageMin;
               this.ageMax = ageMax;
           }
           public int getNbNiveau(){
                int rep = 0;
                try{
                    ConnexionJDBC conn  = new ConnexionJDBC();
                    Connection c = conn.getConnPostgre();
                    String req = "select count(*) from niveau";
                    Statement stmt1 = c.createStatement();
                    ResultSet res = stmt1.executeQuery(req);
                    while(res.next()){
                          rep = res.getInt(1);
                    }
                }
                 catch(Exception e){
                    System.out.println(e.getMessage());
                }
                 return rep;
           }
           public int getIdNiveau(String nomNiveau){
               ConnexionJDBC conn = new ConnexionJDBC();
               Statement stmt1 = null;
               int rep = 1;
               try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select idniveau from niveau where  nomniveau ='"+nomNiveau+"'";
                    stmt1 = c.createStatement();
                    ResultSet res = stmt1.executeQuery(req);
                    while(res.next()){
                        rep = res.getInt(1);
                        //nb = res.getString(1);
                    }
                     
                }
                catch(Exception e){
                            System.out.println(e.getMessage());
                }
               return rep;
           }
           public String getNiveau(int idEnfant){
                ConnexionJDBC conn = new ConnexionJDBC();
               Statement stmt1 = null;
               String rep = "";
               try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select nomniveau from niveau join enfant on niveau.idniveau = enfant.idniveau where  idEnfant ='"+idEnfant+"'";
                    stmt1 = c.createStatement();
                    ResultSet res = stmt1.executeQuery(req);
                    while(res.next()){
                        rep = res.getString(1);
                    }                    
                }
                catch(Exception e){
                            System.out.println(e.getMessage());
                }
               return rep;
           }
           public String[] getNomNiveau(){
               ConnexionJDBC conn = new ConnexionJDBC();
               Statement stmt1 = null;
               String[] rep = new String[this.getNbNiveau()];
               try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select nomniveau from niveau";
                    stmt1 = c.createStatement();
                    int i = 0;
                    ResultSet res = stmt1.executeQuery(req);
                    while(res.next()){
                        rep[i] = res.getString(1);
                        i++;
                        
                        //nb = res.getString(1);
                    }
                     
                }
                catch(Exception e){
                            System.out.println(e.getMessage());
                }
               return rep;
           }
           /*public static void main(String[] arg){
                Niveau n = new Niveau();
                int t = n.getIdNiveau("petite section");
                System.out.println(t);
                String[] s = n.getNomNiveau();
                for(int i=0;i<t;i++){
                   // System.out.println(s[i]);
                }
           }*/
}
