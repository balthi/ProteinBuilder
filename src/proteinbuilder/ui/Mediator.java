package proteinbuilder.ui;

public interface Mediator
{
   /**
   * Determines the behavior of pressing the ok button
   */
   public void ok();
   
   /**
   * Determines the behavior of pressing the cancel button
   */
   public void cancel();
   
   /**
   * Determines the behavior of pressing the save button
   */
   public void save();
   
   /**
   * Determines the behavior of pressing the undo button
   */
   public void undo();
   
   /**
   * Determines the behavior of pressing the transfer right button
   */
   public void transferRight();
   
   /**
   * Determines the behavior of pressing the transfer left button
   */
   public void transferLeft();
}