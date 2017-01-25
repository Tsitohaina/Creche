
package creche;

import java.sql.Connection;
import java.sql.Statement;

public class Personnel {
            private String nom;
            private String prenom;
            private String dateNaissance;
            private String sexe;
            private String email;
            private String password;
            public Personnel(){}
            public Personnel(String nom,String prenom,String dateNaissance,String sexe,String email,String password)throws Exception{
                        setNom(nom);
                        setPrenom(prenom);
                        setDateNaissance(dateNaissance);
                        setSexe(sexe);
                        setEmail(email);
                        setPassword(password);
            }
            public void setNom(String nom) {
                this.nom = nom;
            }

            public void setPrenom(String prenom) {
                this.prenom = prenom;
            }

            public void setDateNaissance(String dateNaissance) {
                this.dateNaissance = dateNaissance;
            }

            public void setSexe(String sexe) {
                this.sexe = sexe;
            }

            public void setEmail(String email)throws Exception {
                    boolean mail = false;
                    Control c = new Control();
                    String[] text1 = c.spliter(email,"@");
                    if(text1.length>=2){
                        String[] text2 = c.spliter(text1[1],".");
                        if(text2.length>=2) this.email = email;
                        else throw new Exception ("format mail invalide");
                    }
                    else throw new Exception ("format mail invalide");
            }

            public void setPassword(String password)throws Exception{
                    boolean majuscule = false;
                    boolean chiffre = false;
                    boolean taille = false;
                    boolean spec = false;
                    char[] c = {'&','é','(','-','è','_','ç',';',',',':','!'};
                    for(int i=0;i<password.length();i++){
                        if(Character.isUpperCase(password.charAt(i)))  majuscule = true;                           
                        if(Character.isDigit(password.charAt(i))) chiffre = true; 
                        if(password.length()>8) taille = true;
                        for(int j=0;j<c.length;j++){
                            if(password.charAt(i)==c[j]){
                                    spec = true;
                            }
                        }
                    }
                    if(majuscule==false) throw new Exception ("Au moins 1 majuscule");
                    if(chiffre==false) throw new Exception ("Au moins 1 chiffre");
                    if(taille==false) throw new Exception ("Au moins 8 caracteres");
                    if(spec==false) throw new Exception ("Au moins 1 caractere special");
                    if(majuscule==true&&chiffre==true&&taille==true&&spec==true){        
                            this.password = password;
                    }
            }
            public String getNom() {
                return nom;
            }

            public String getPrenom() {
                return prenom;
            }

            public String getDateNaissance() {
                return dateNaissance;
            }

            public String getSexe() {
                return sexe;
            }

            public String getEmail() {
                return email;
            }

            public String getPassword() {
                return password;
            }
            public void inscription(Personnel p)throws Exception{
                ConnexionJDBC conn = new ConnexionJDBC();   
                Connection  c = conn.getConnPostgre();
                String req = "insert into personnel (nompersonnel,prenompersonnel,datenaissancepersonnel,sexepersonnel,passwordpersonnel,emailpersonnel) values ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getDateNaissance()+"','"+p.getSexe()+"','"+p.getPassword()+"','"+p.getEmail()+"')";
                Statement stmt = c.createStatement();
                stmt.executeUpdate(req);
                
            }
            public static void main(String[] args){
                Personnel p = new Personnel();
                try{
                     p = new Personnel("nom","prenom","1980-12-01","Masculin","adfgjsg@gmail.com","1dfggj_dJsfh");
                     p.inscription(p);
                     //System.out.println(b);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
}
