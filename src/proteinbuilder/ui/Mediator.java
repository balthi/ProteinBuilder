package proteinbuilder.ui;

public abstract class Mediator
{
   public static final String SAVE = "Save";
   public static final String UNDO = "Undo";
   public static final String TRANSFER_RIGHT = ">>";
   public static final String TRANSFER_LEFT = "<<";
   
   /**
   * Determines the behavior of pressing the ok button
   */
   public abstract void ok();
   
   /**
   * Determines the behavior of pressing the cancel button
   */
   public abstract void cancel();
   
   /**
   * Determines the behavior of pressing the save button
   */
   public abstract void save();
   
   /**
   * Determines the behavior of pressing the undo button
   */
   public abstract void undo();
   
   /**
   * Determines the behavior of pressing the transfer right button
   */
   public abstract void transferRight();
   
   /**
   * Determines the behavior of pressing the transfer left button
   */
   public abstract void transferLeft();
}