package proteinbuilder;

import junit.framework.TestCase;

public class ProteinSet_Test extends TestCase
{
   private Protein p1, p2;
   private AminoAcid GLY;
   private AminoAcid LEU;
   private ProteinSet set;
   
   private static final String ONE = "one";
   private static final String TWO = "two";
   
   public void setUp()
   {
      p1 = new Protein(ONE);
      p2 = new Protein(TWO);
      set = new ProteinSet();
      set.add(p1);
   }
   
   public void testAdd()
   {
      set.add(p2);
      assertTrue("Protein not found in testAdd.", set.contains(p2));
   }
   
   public void testRemove()
   {
      set.remove(p1);
      assertTrue("Protein found in testRemove.", !set.contains(p1));
   }
}