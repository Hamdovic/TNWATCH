/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ResponsableDAO;
import Entities.Responsable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Houssem Eddine
 */
public class MyTableModelresponsableconfirmer extends AbstractTableModel {

    List<Responsable> listResponsable = new ArrayList<Responsable>();
    String []header = {"CIN","Nom","Prenom","email","domaine","grade"};

    public MyTableModelresponsableconfirmer() { //remplissage de la liste des stocks
        listResponsable=new ResponsableDAO().DisplayAlLResponsableConf ();
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listResponsable.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
           case 0://colonne type_vetement
                return listResponsable.get(rowIndex).getCin();
            case 1://listcCitoyenses quantité
                return listResponsable.get(rowIndex).getNom();
            case 2://colonne adresse depot
                return listResponsable.get(rowIndex).getPrenom();
                 case 3://colonne adresse depot
                return listResponsable.get(rowIndex).getEmail();
                      case 4://colonne adresse depot
                return listResponsable.get(rowIndex).getDomaineTravail();
                          case 5://colonne adresse depot
                return listResponsable.get(rowIndex).getGrade();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    

}
