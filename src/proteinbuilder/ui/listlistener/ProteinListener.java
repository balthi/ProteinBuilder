package proteinbuilder.ui.listlistener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import proteinbuilder.Protein;
import proteinbuilder.ui.ProteinMediator;

public class ProteinListener implements ListSelectionListener
{
   public ProteinListener(ProteinMediator pm)
   {
      this.pm = pm;
   }
   
   private ProteinMediator pm;
   
   @Override
   public void valueChanged(ListSelectionEvent e)
   {
      if(!e.getValueIsAdjusting())
      {
         JList source = (JList) e.getSource();
         pm.listItemSelected((Protein) source.getSelectedValue());
      }
   }
}