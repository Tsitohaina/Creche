package creche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Parent {
    	public int idParent;
	public String nomParent;
	public String prenomParent;
        public Parent(){}
        public int getIdParent(){
            int rep = 1;
            ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select max(idparent) from parent";
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
        public void addParent(String nom,String prenom) throws Exception{	
                ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "insert into parent (nomparent,prenomparent) values ('"+nom+"','"+prenom+"')";
                    Statement stmt = c.createStatement();
                    stmt.executeUpdate(req);
                    c.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
        }
        public int getnbEnfant(int idParent){
                ConnexionJDBC conn = new ConnexionJDBC();
                 int rep = 0;
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select count(*) from enfant where idparent = "+idParent;
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
        public Enfant[] getAllEnfant(int idParent){
                Enfant[] rep = new Enfant[this.getnbEnfant(idParent)];
                ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    Connection c = conn.getConnPostgre();
                    String req = "select * from enfant where idparent = "+idParent;
                    Statement stmt1 = c.createStatement();
                    ResultSet res = stmt1.executeQuery(req);
                    int i = 0;
                    while(res.next()){
                      rep[i] = new Enfant();
                      rep[i].nomEnfant = res.getString("nomenfant");
                      rep[i].prenomEnfant = res.getString("prenomenfant");
                      rep[i].sexeEnfant = res.getString("sexeenfant");
                      i++;
                    }
                    c.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return rep;
        }
        public  int supprimerParent(int idParent){
                int rep = 1;
                try{
                    ConnexionJDBC conn = new ConnexionJDBC();
                    Connection c = conn.getConnPostgre();
                    
                    String req = "delete from  adressparent where idParent = '"+idParent+"'";
                    Statement stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  contactparent where idParent = '"+idParent+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  Parent where idParent = '"+idParent+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    c.close();
                    rep = 0;
                }
                catch(Exception e){
                    rep = 1;
                    System.out.println(e.getMessage());
                }
                return rep;
        }
        public  void supprimerTout(int idParent){
                try{
                    ConnexionJDBC conn = new ConnexionJDBC();
                    Connection c = conn.getConnPostgre();                  
                    String req = "delete from  adressparent where idParent = '"+idParent+"'";
                    Statement stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  contactparent where idParent = '"+idParent+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  enfant where idParent = '"+idParent+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  parent where idParent = '"+idParent+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    c.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
        }
        public int getNbParent(){
            int nb=0;
            Statement stmt1 = null;
            ConnexionJDBC conn = new ConnexionJDBC();
            try{
                 Connection c = conn.getConnPostgre();
                 String req = "select count(*) from parent";
                 stmt1 = c.createStatement();
                 ResultSet res = stmt1.executeQuery(req);
                 while(res.next()){
                        nb = res.getInt(1);
                 }
            }
            catch(Exception e){
                        System.out.println(e.getMessage());
            }
            return nb;
        }
        public Parent getParent(int idParent){
                Parent rep = new Parent();
                ConnexionJDBC conn = new ConnexionJDBC(); 
                try{
                      Connection c = conn.getConnPostgre();
                      String req = "select * from parent where idParent = "+idParent;
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      String nom = "";
                      while(res.next()){
                          rep = new Parent();
                          rep.idParent = Integer.parseInt(res.getString("idParent"));
                          rep.nomParent = res.getString("nomParent");
                          rep.prenomParent = res.getString("prenomParent"); 
                     }                 
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public Parent[] getAllParent(){
                int nb = this.getNbParent();
                Parent[] rep = new Parent[nb];
                ConnexionJDBC conn = new ConnexionJDBC(); 
                try{
                      Connection c = conn.getConnPostgre();
                      String req = "select * from parent";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      int i = 0;
                      String nom = "";
                      while(res.next()){
                          rep[i] = new Parent();
                          rep[i].idParent = Integer.parseInt(res.getString("idParent"));
                          rep[i].nomParent = res.getString("nomParent");
                          rep[i].prenomParent = res.getString("prenomParent"); 
                          i++; 
                     }                 
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public static void main(String[] arg){
                Parent p = new Parent();
                Enfant[] id = p.getAllEnfant(5);
                System.out.println(id.length);
                for(int i=0;i<id.length;i++){
                    System.out.println(id[i].nomEnfant);
                }
        }
}
