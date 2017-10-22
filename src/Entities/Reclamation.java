/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ss
 */
public class Reclamation {
  
    public int idRec;
    public String domaine;
    public String Categorie;
    public String sujet;
    public String contenu;
    public String etatrec;

    //public String reponse;
    public int cin_citoyen;
    public int cin_responsable;

    public Reclamation(int idRec, String domaine, String Categorie, String sujet, String contenu, String etatrec, int cin_citoyen, int cin_responsable) {
        this.idRec = idRec;
        this.domaine = domaine;
        this.Categorie = Categorie;
        this.sujet = sujet;
        this.contenu = contenu;
        this.etatrec = etatrec;
        this.cin_citoyen = cin_citoyen;
        this.cin_responsable = cin_responsable;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idRec=" + idRec + ", domaine=" + domaine + ", Categorie=" + Categorie + ", sujet=" + sujet + ", contenu=" + contenu + ", etatrec=" + etatrec + ", cin_citoyen=" + cin_citoyen + ", cin_responsable=" + cin_responsable + '}';
    }



    public Reclamation() {
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    

    public int getIdRec() {
        return idRec;
    }



    public String getDomaine() {
        return domaine;
    }

    public String getCategorie() {
        return Categorie;
    }

    public String getEtatrec() {
        return etatrec;
    }



    public int getCin_citoyen() {
        return cin_citoyen;
    }

    public int getCin_responsable() {
        return cin_responsable;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }



    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public void setEtatrec(String etatrec) {
        this.etatrec = etatrec;
    }



    public void setCin_citoyen(int cin_citoyen) {
        this.cin_citoyen = cin_citoyen;
    }

    public void setCin_responsable(int cin_responsable) {
        this.cin_responsable = cin_responsable;
    }

    
    
}
