package proteinbuilder.ui.buttonlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import proteinbuilder.ui.Mediator;

public class OkListener implements ActionListener
{
   public OkListener(Mediator mediator)
   {
      this.mediator = mediator;
   }
   
   Mediator mediator;
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.ok();
   }
}