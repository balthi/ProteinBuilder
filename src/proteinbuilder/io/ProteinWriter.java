package proteinbuilder.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;

import static proteinbuilder.config.SessionConfig.PROTEIN_FILE_DIRECTORY;
import static proteinbuilder.config.SessionConfig.PROTEIN_LIST_URI;
import static proteinbuilder.config.SessionConfig.FORMAT;

public abstract class ProteinWriter
{
   private static final String EXTENSION = "." + FORMAT;
   
   public void writeToFile(Protein protein)
   {
      String out = getString(protein);
      File f = new File(PROTEIN_FILE_DIRECTORY + protein.getName() + EXTENSION);
      try
      {
         f.createNewFile();
         URI safe = f.toURI();
         writeFile(out, protein.getName(), safe);
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   protected abstract String getString(Protein protein);
   
   private void writeFile(String protein, String name, URI file)
   {
      File f = new File(file);
      try
      {
         FileWriter fw = new FileWriter(f);
         fw.write(protein);
         fw.close();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
}