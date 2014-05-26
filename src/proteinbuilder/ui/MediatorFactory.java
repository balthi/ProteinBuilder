package proteinbuilder.ui;

public final class MediatorFactory
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