package proteinbuilder.io;

import java.io.File;
import proteinbuilder.Protein;

public abstract class ProteinReader
{
   protected static final String QUOTE = "\"";
   protected static final String DELIMITER = ":";
   
   /**
   * Parses the given file and returns a protein
   * based on the contents of the file
   * @throws RuntimeException if file could not be read
   */
   public abstract Protein getProteinFromFile(File f);
}