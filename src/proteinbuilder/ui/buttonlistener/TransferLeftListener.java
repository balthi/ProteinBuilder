package proteinbuilder.ui.buttonlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import proteinbuilder.ui.Mediator;

public class TransferLeftListener implements ActionListener
{
   public TransferLeftListener(Mediator mediator)
   {
      this.mediator = mediator;
   }
   
   Mediator mediator;
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.transferLeft();
   }
}