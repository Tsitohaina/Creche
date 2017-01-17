
package creche;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.Statement;

public class Enfant {
    	public int idEnfant;
        public String nomEnfant;
	public String prenomEnfant;
	public String dateNaissanceEnfant;
	public String sexeEnfant;
        public Connection  c;
        public Enfant(){}
        public Enfant(String nom,String prenom,String dateNaissance,String sexe){
            this.nomEnfant = nom;
            this.prenomEnfant = prenom;
            this.dateNaissanceEnfant =  dateNaissance;
            this.sexeEnfant = sexe;
        }
        public int getNbEnfant(){
            int nb=0;
            Statement stmt1 = null;
            ConnexionJDBC conn = new ConnexionJDBC();
            try{
                 Connection  c = conn.getConnPostgre();
                 String req = "select count(*) from enfant";
                 stmt1 = c.createStatement();
                 ResultSet res = stmt1.executeQuery(req);
                 while(res.next()){
                        nb = res.getInt(1);
                 }
                 c.close();
            }
            catch(Exception e){
                        System.out.println(e.getMessage());
            }
            return nb;
        }
        public Enfant getEnfant(int idEnfant){
                Enfant rep = new Enfant();
                ConnexionJDBC conn = new ConnexionJDBC();
                try{
                      c = conn.getConnPostgre();
                      String req = "select * from enfant where idenfant = '"+idEnfant+"'";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      while(res.next()){
                          rep.nomEnfant = res.getString("nomenfant");
                          rep.prenomEnfant = res.getString("prenomenfant");
                          rep.sexeEnfant = res.getString("sexeenfant"); 
                          rep.dateNaissanceEnfant = res.getString("datenaissanceenfant"); 
                     }                 
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public void miseAjour(int idenfant,Enfant e){
                Enfant rep = new Enfant();
                ConnexionJDBC conn = new ConnexionJDBC();
                try{
                      c = conn.getConnPostgre();
                      String req = "update Enfant set nomenfant ='"+e.nomEnfant+"' ,prenomenfant = '"+e.prenomEnfant+"' ,datenaissanceenfant = '"+e.dateNaissanceEnfant+"' ,sexeenfant = '"+e.sexeEnfant+"' where idenfant = '"+idenfant+"'";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);                
                }
                catch(Exception e1){
                        System.out.println(e1.getMessage());
                }
        }
        public Enfant[] findEnfant(){
                int nb = this.getNbEnfant();
                  Enfant[] rep = new Enfant[nb];
                ConnexionJDBC conn = new ConnexionJDBC(); 
                try{
                      c = conn.getConnPostgre();
                      String req = "select * from enfant";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      int i = 0;
                      String nom = "";
                      while(res.next()){
                          rep[i] = new Enfant();
                          rep[i].idEnfant = Integer.parseInt(res.getString("idenfant"));
                          rep[i].nomEnfant = res.getString("nomenfant");
                          rep[i].prenomEnfant = res.getString("prenomenfant");
                          rep[i].sexeEnfant = res.getString("sexeenfant");  
                          i++; 
                     }                 
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        
        public Enfant[] findEnfantSearch(String champ,String mot){
                int nb = this.getNbEnfant();
                Enfant[] rep = new Enfant[nb];
                ConnexionJDBC conn = new ConnexionJDBC(); 
                try{
                        c = conn.getConnPostgre();
                        String req1 = "select count(*) from enfant where "+champ+" ilike '%"+mot+"%'";
                        Statement stmt1 = c.createStatement();
                        ResultSet res1 = stmt1.executeQuery(req1);
                        while(res1.next()){ nb = res1.getInt(1);}
                        rep = new Enfant[nb];
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
                try{
                      c = conn.getConnPostgre();
                      String req = "select * from enfant where "+champ+" ilike '%"+mot+"%'";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      int i = 0;
                      while(res.next()){
                          rep[i] = new Enfant();
                          rep[i].idEnfant = Integer.parseInt(res.getString("idenfant"));
                          rep[i].nomEnfant = res.getString("nomenfant");
                          rep[i].prenomEnfant = res.getString("prenomenfant");
                          rep[i].sexeEnfant = res.getString("sexeenfant");  
                          i++; 
                     }                 
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public Enfant[] findEnfantSearch1(String champ,String mot,String champ1,String mot1){
                int nb = this.getNbEnfant();
                Enfant[] rep = new Enfant[nb];
                ConnexionJDBC conn = new ConnexionJDBC(); 
                try{
                        c = conn.getConnPostgre();
                        String req1 = "select count(*) from enfant where "+champ+" ilike '%"+mot+"%' and "+champ1+" ilike '%"+mot1+"%'";
                        Statement stmt1 = c.createStatement();
                        ResultSet res1 = stmt1.executeQuery(req1);
                        while(res1.next()){ nb = res1.getInt(1);}
                        rep = new Enfant[nb];
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
                try{
                      c = conn.getConnPostgre();
                      String req = "select * from enfant where "+champ+" ilike '%"+mot+"%' and "+champ1+" ilike '%"+mot1+"%'";
                      Statement stmt2 = c.createStatement();
                      ResultSet res = stmt2.executeQuery(req);
                      int i = 0;
                      while(res.next()){
                          rep[i] = new Enfant();
                          rep[i].nomEnfant = res.getString("nomenfant");
                          rep[i].prenomEnfant = res.getString("prenomenfant");
                          rep[i].sexeEnfant = res.getString("sexeenfant");  
                          i++; 
                     }                 
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                }
                return rep;
        }
        public void addEnfant(int idParent,int idNiveau,Enfant e){
		ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    c = conn.getConnPostgre();
                    String req = "insert into enfant (idparent,idniveau,nomenfant,prenomenfant,datenaissanceenfant,sexeenfant) values ('"+idParent+"','"+idNiveau+"','"+e.nomEnfant+"','"+e.prenomEnfant+"','"+e.dateNaissanceEnfant+"','"+e.sexeEnfant+"')";
                    Statement stmt = c.createStatement();
                    stmt.executeUpdate(req);
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
        }
        public int supprimerEnfant(int idEnfant){
            int rep = 1;
            ConnexionJDBC conn = new ConnexionJDBC();
                try{   
                    c = conn.getConnPostgre();
                    String req = "delete from  Consommation where idEnfant = '"+idEnfant+"'";
                    Statement stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  Facture where idEnfant = '"+idEnfant+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    req = "delete from  Enfant where idEnfant = '"+idEnfant+"'";
                    stmt = c.createStatement();
                    stmt.execute(req);
                    rep = 0;
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
            return rep;
        }
        public static void main(String[] args)throws Exception{
           /* Enfant e = new Enfant();
            Enfant p = new Enfant("Rabe","Jean","2013-02-12","M");
            p.miseAjour(5,p);     
            System.out.println(p.nomEnfant);
            System.out.println(p.prenomEnfant);
            System.out.println(p.dateNaissanceEnfant); */
        }
 }
    


  /* public void setNiveau(Niveau newNiveau) {
      if (this.niveau == null || !this.niveau.equals(newNiveau))
      {
         if (this.niveau != null)
         {
            Niveau oldNiveau = this.niveau;
            this.niveau = null;
            oldNiveau.removeEnfant(this);
         }
         if (newNiveau != null)
         {
            this.niveau = newNiveau;
            this.niveau.addEnfant(this);
         }
      }
   }
}*/
