package proteinbuilder.ui.listlistener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import proteinbuilder.AminoAcid;
import proteinbuilder.ui.ProteinMediator;

public final class AAListener implements ListSelectionListener
{
   public AAListener(ProteinMediator pm)
   {
      this.pm = pm;
   }
   
   private ProteinMediator pm;
   
   @Override
   public void valueChanged(ListSelectionEvent e)
   {
      JList source = (JList) e.getSource();
      if(!e.getValueIsAdjusting() && !source.isSelectionEmpty())
      {
         pm.listItemSelected((AminoAcid) source.getSelectedValue());
      }
   }
}