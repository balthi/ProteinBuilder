package proteinbuilder;

import junit.framework.TestCase;

public class ProteinList_Test extends TestCase
{
   private Protein p1, p2;
   private AminoAcid GLY;
   private AminoAcid LEU;
   private ProteinList list;
   
   private static final String ONE = "one";
   private static final String TWO = "two";
   
   public void setUp()
   {
      p1 = new Protein(ONE);
      p2 = new Protein(TWO);
      list = new ProteinList();
      list.add(p1);
   }
   
   public void testAdd()
   {
      list.add(p2);
      assertTrue("Protein not found in testAdd.", list.contains(p2));
   }
   
   public void testRemove()
   {
      list.remove(p1);
      assertTrue("Protein found in testRemove.", !list.contains(p1));
   }
}