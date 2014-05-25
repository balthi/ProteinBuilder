package proteinbuilder.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.TestCase;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;
import proteinbuilder.config.SessionConfig;

import static proteinbuilder.config.SessionConfig.PROTEIN_FILE_DIRECTORY;
import static proteinbuilder.config.SessionConfig.NL;

public class PTProteinWriter_Test extends IO_Test
{
   private static final String EXPECTED = "test:GLYCINE (G):LEUCINE (L):";
            
   
   public void setUp()
   {
      sc = SessionConfig.getSessionConfig();
      sc.loadConfiguration();
      pw = new PTProteinWriter();
      protein = new Protein(NAME);
      protein.add(GLY);
      protein.add(LEU);
   }
   
   public void testWriteToFile()
   {
      pw.writeToFile(protein);
      File f = new File(FILE);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter("\\Z");
         String found = in.next();
         System.out.println(found);
         assertEquals("Incorrect String returned in testWriteToFile", EXPECTED, found);
         in.close();
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
}