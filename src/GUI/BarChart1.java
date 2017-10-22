
import Util.MyConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class BarChart1 extends ApplicationFrame {
    public BarChart1(final String title) throws IOException {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart graphe = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(graphe);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);
    }
public CategoryDataset createDataset() {
        // 0. Création d'un diagramme.
     try 
         {int a = 0;
         int b=0;
       int c=0;
             String requete="select count(*) from citoyens ";
         String requete1="select count(*) from responsable";
 
            Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             while(resultat.next())
        {
   a= resultat.getInt(1);
        }
            ResultSet resultat1 = statement.executeQuery(requete1);
               while(resultat1.next())
        {
   b= resultat1.getInt(1);
        }
/*ResultSet resultat2 = statement.executeQuery(requete2);        
          while(resultat2.next())
        {
  c= resultat2.getInt(1);
        }
        */
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       //Valeurs statiques
        dataset.addValue(a, "Taux des citoyens validé", " ");
        dataset.addValue(b, " Taux des citoyens non confirmé", " ");
       // dataset.addValue(c, "Taux de couverture Indoor", " ");
     //   dataset.addValue(19, "Taux de couverture Incar", " ");
       return dataset;}
      catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            
        }
        return null;
    }
	public JFreeChart createChart(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                " le taux des citoyens ", // chart title
                " ", // domain axis label
                "  Le nombre des citoyens ", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                true // urls
                );

 final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 2.0));
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true); 
        return chart;
    }
    public static void main(final String[] args) throws IOException {
        final BarChart1 demo = new BarChart1("Test de la couverture ");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
}
