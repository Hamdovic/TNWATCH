
package Entities;

import java.sql.Date;

public class Citoyens extends Personne {
  
    private String login ;
    private String securite ;
    private String type_question;
  
    
    public Citoyens() {
    }

    public Citoyens(String login, String securite, String type_question, String pwd, int cin, String nom, String prenom, Date dateNaissance, String email, int telephone, String sexe) {
        super(pwd, cin, nom, prenom, dateNaissance, email, telephone, sexe);
        this.login = login;
        this.securite = securite;
        this.type_question = type_question;
    }

    
    


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSecurite() {
        return securite;
    }

    public void setSecurite(String securite) {
        this.securite = securite;
    }

    public String getType_question() {
        return type_question;
    }

    public void setType_question(String type_question) {
        this.type_question = type_question;
    }

   
    
    
}
