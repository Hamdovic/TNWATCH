
import DAO.ReclamationDAO;
import Entities.Reclamation;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HAMDI
 */
public class ReclamtableModel extends AbstractTableModel{

    List<Reclamation> listereclam ;
    String []entetes = {"ID Rec","Domaine","Catégorie","Sujet","Contenu de reclamation","etat","Citoyen","Responsable"}; 
    
    
    public ReclamtableModel(){
        listereclam = new ReclamationDAO().DisplayAllReclamation();
    }
    @Override
    public int getRowCount() {
        return listereclam.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

    switch (columnIndex){
            case 0 :
                return listereclam.get(rowIndex).getIdRec();
            case 1 :
                return listereclam.get(rowIndex).getDomaine();
            case 2:
                return listereclam.get(rowIndex).getCategorie();
            case 3 :
                return listereclam.get(rowIndex).getSujet();
            case 4 :
                return listereclam.get(rowIndex).getContenu();
            case 5 :
                return listereclam.get(rowIndex).getEtatrec();
            case 6 :
                return listereclam.get(rowIndex).getCin_citoyen();
            case 7:
                return listereclam.get(rowIndex).getCin_responsable();
            
                
                
           default:
               throw  new IllegalArgumentException();
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        return entetes[column];
    }
    
}
