package proteinbuilder.ui.listlistener;

import proteinbuilder.ui.ProteinMediator;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

public final class ListListenerFactory
{  
   private static final String AMINO_ACID = "AminoAcid";
   private static final String PROTEIN = "Protein";
   
   public static ListSelectionListener getListListener(ProteinMediator pm, String elementType)
   {
      switch (elementType)
      {
         case AMINO_ACID:
               return new AAListener(pm);
         case PROTEIN:
            return new ProteinListener(pm);
         default:
            throw new IllegalArgumentException("No listener found for list.");
      }
   }
}