package proteinbuilder.io;

import static proteinbuilder.config.SessionConfig.FORMAT;
import static proteinbuilder.config.SessionConfig.JSON;
import static proteinbuilder.config.SessionConfig.XML;
import static proteinbuilder.config.SessionConfig.PLAIN;

public class ProteinWriterFactory
{
   public static ProteinWriter getProteinWriter()
   {
      switch (FORMAT)
      {
         case JSON:
            return new JSONProteinWriter();
         case XML:
            return new XMLProteinWriter();
         case PLAIN:
            return new PTProteinWriter();
         default:
            return new JSONProteinWriter();
      }
   }
}