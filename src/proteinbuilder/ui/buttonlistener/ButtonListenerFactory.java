package proteinbuilder.ui.buttonlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import proteinbuilder.ui.Mediator;

import static proteinbuilder.ui.Mediator.SAVE;
import static proteinbuilder.ui.Mediator.UNDO;
import static proteinbuilder.ui.Mediator.TRANSFER_RIGHT;
import static proteinbuilder.ui.Mediator.TRANSFER_LEFT;

public class ButtonListenerFactory
{
   
   public static ActionListener getButtonListener(Mediator pb, JButton button)
   {
      String text = button.getText();
      switch (text)
      {
         case SAVE:
            return new SaveListener(pb);
         case UNDO:
            return new UndoListener(pb);
         case TRANSFER_RIGHT:
            return new TransferRightListener(pb);
         case TRANSFER_LEFT:
            return new TransferLeftListener(pb);
         default:
            throw new IllegalArgumentException("No suitable listener found for button.");
      }
   }
}