package proteinbuilder.io;

import java.io.File;
import proteinbuilder.Protein;
import proteinbuilder.config.SessionConfig;

public class JSONProteinReader_Test extends IO_Test
{
   ProteinReader pr;
   
   public void setUp()
   {
      sc = SessionConfig.getSessionConfig();
      sc.loadConfiguration();
      pw = ProteinWriterFactory.getProteinWriter();
      protein = new Protein(NAME);
      protein.add(GLY);
      protein.add(LEU);
      pw.writeToFile(protein);
      pr = new JSONProteinReader();
   }
   
   public void testGetProteinFromFile()
   {
      File f = new File(FILE);
      Protein p = pr.getProteinFromFile(f);
      assertTrue("Unequal Proteins returnedd in testGetProteinFromFile.", p.equals(protein));
   }
}