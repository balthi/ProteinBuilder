package proteinbuilder;

import junit.framework.TestCase;

public final class Protein_Test extends TestCase
{
   private Protein protein;
   private static final String TEST = "test";
   private static final String NEW_NAME = "New name";
   private static AminoAcid LEU = AminoAcid.LEUCINE;
   private static AminoAcid PRO = AminoAcid.PROLINE;
   
   public void setUp()
   {
      this.protein = new Protein(TEST);
   }
   
   public void testAdd()
   {
      protein.add(LEU);
      assertEquals("Wrong size given in testAdd", 1, protein.size());
   }
   
   public void testGetName()
   {
      assertEquals("Wrong String returned in testGetName", TEST, protein.getName());
   }
   
   public void testPop()
   {
      protein.add(PRO);
      assertEquals("Wrong amino acid returned in testPop()", PRO, protein.pop());
   }
   
   public void testSetName()
   {
      protein.setName(NEW_NAME);
      assertEquals("Wrong String returned in testSetName", NEW_NAME, protein.getName());
   }
}