package proteinbuilder.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.RuntimeException;
import java.net.URI;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;

import static proteinbuilder.config.SessionConfig.PROTEIN_FILE_DIRECTORY;
import static proteinbuilder.config.SessionConfig.PROTEIN_LIST_URI;
import static proteinbuilder.config.SessionConfig.FORMAT;
import static proteinbuilder.config.SessionConfig.DELIMITER;

public abstract class ProteinWriter
{
   private static final String EXTENSION = "." + FORMAT;
   
   public final void writeToFile(Protein protein)
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
         throw new RuntimeException("Error creating file.");
      }
   }
   
   protected abstract String getString(Protein protein);
   
   private void writeFile(String protein, String name, URI file)
   {
      File f = new File(file);
      try
      {
         FileWriter fw = new FileWriter(f);
         try
         {
            fw.write(protein);
         }
         catch(IOException i)
         {
            throw new RuntimeException("Error writing to file.");
         }
         finally
         {
            try
            {
               fw.close();
            }
            catch(IOException close)
            {
               throw new RuntimeException("Error writing to file.");
            }
         }
      }
      catch(IOException ioe)
      {
         throw new RuntimeException("Could not write protein to file.");
      }
      
      if(!name.equals("test"))
         {
         try
         {
            FileWriter fr = new FileWriter(new File(PROTEIN_LIST_URI), true);
            try
            {
               fr.write(name + EXTENSION + DELIMITER);
            }
            catch(IOException write)
            {
               throw new RuntimeException("Error appending protein to list.");
            }
            finally
            {
               try
               {
                  fr.close();
               }
               catch(IOException close)
               {
                  throw new RuntimeException("Error appending protein to list.");
               }
            }
         }
         catch(IOException io)
         {
            throw new RuntimeException("Could not write protein to protein list file.");
         }
      }
   }
}