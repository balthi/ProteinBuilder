package proteinbuilder.ui.listlistener;

import proteinbuilder.ui.ProteinMediator;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

public class ListListenerFactory
{  
   private static final String AMINO_ACID = "proteinbuilder.AminoAcid";
   private static final String PROTEIN = "proteinbuilder.Protein";
   
   public static ListSelectionListener getListListener(ProteinMediator pm, JList list)
   {
      Class <?> type = list.getModel().getElementAt(0).getClass();
      if(type.getName().equals(AMINO_ACID))
      {
         return new AAListener(pm);
      }
      else if(type.getName().equals(PROTEIN))
      {
         return new ProteinListener(pm);
      }
      else
      {
         throw new IllegalArgumentException("No listener found for list.");
      }
   }
}