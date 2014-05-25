package proteinbuilder.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.TestCase;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;
import proteinbuilder.config.SessionConfig;

import static proteinbuilder.config.SessionConfig.PROTEIN_FILE_DIRECTORY;

public class JSONProteinWriter_Test extends IO_Test
{
   private static final String EXPECTED = "{\"protein\":\"test\",\"acids\":[\"GLYCINE (G)\",\"LEUCINE (L)\"]}";
   
   public void setUp()
   {
      sc = SessionConfig.getSessionConfig();
      sc.loadConfiguration();
      pw = ProteinWriterFactory.getProteinWriter();
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