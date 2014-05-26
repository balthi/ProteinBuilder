package proteinbuilder.io;

import java.io.File;
import java.lang.IllegalArgumentException;

import static proteinbuilder.config.SessionConfig.JSON;
import static proteinbuilder.config.SessionConfig.XML;
import static proteinbuilder.config.SessionConfig.PLAIN;

public final class ProteinReaderFactory
{
   private static final String DOT = ".";
   
   /**
   * Returns the appropriate ProteinReader for the
   * given file type
   */
   public static ProteinReader getReader(File f)
   {
      String path = f.getPath();
      if(path.contains(DOT + JSON))
      {
         return new JSONProteinReader();
      }
      else if(path.contains(DOT + XML))
      {
         return new XMLProteinReader();
      }
      else if(path.contains(DOT + PLAIN))
      {
         return new PTProteinReader();
      }
      else
      {
         throw new IllegalArgumentException("File type not supported");
      }
   }
}