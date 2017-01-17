
package creche;

import java.sql.Connection;
import java.sql.Statement;

public class ContactParent {
        public int idContactParent;
        public String contact;
        public Connection  c;
        public Parent p;
        public ContactParent(){}
        public ContactParent(String contact){
                this.contact = contact;
        }
        public void addContact(ContactParent cP){
            ConnexionJDBC conn = new ConnexionJDBC();
            Parent p = new Parent();
            int id =  p.getIdParent();
            try{   
                    c = conn.getConnPostgre();
                    String req = "insert into contactparent (idparent,contactparent) values ("+id+",'"+cP.contact+"')";
                    Statement stmt = c.createStatement();
                    System.out.println("test");
                    stmt.executeUpdate(req);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
        }
}
