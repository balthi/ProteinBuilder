package proteinbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class OkButton extends JButton implements ActionListener
{
   private static String OK = "Ok";
   private Mediator mediator;
   
   public OkButton(Mediator mediator)
   {
      setText(OK);
      addActionListener(this);
      this.mediator = mediator;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mediator.ok();
   }
   
}