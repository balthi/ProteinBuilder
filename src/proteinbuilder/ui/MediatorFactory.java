package proteinbuilder.ui;

public class MediatorFactory
{
   /**
   * Returns a concrete mediator that extends
   * Mediator
   */
   public static Mediator getMediator()
   {
      return new PBMediator();
   }
}