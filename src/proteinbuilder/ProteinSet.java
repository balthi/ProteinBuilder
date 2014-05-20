package proteinbuilder;

import java.util.TreeSet;
import java.util.Iterator;
import java.lang.Iterable;

public class ProteinSet implements Iterable<Protein>
{
   public ProteinSet()
   {
      set = new TreeSet();
   }
   
   private TreeSet<Protein> set;
   
   /**
   * Returns true if the protein was successfully
   * added to the set.
   */
   public boolean add(Protein protein)
   {
      return set.add(protein);
   }
   
   /**
   * Returns true if tbe set contains protein
   */
   public boolean contains(Protein protein)
   {
      return set.contains(protein);
   }
   
   /**
   * Returns an iterator for this protein set
   */
   public Iterator<Protein> iterator()
   {
      return set.iterator();
   }
   
   /**
   * Returns true if the protein was removed
   * from the set
   */
   public boolean remove(Protein protein)
   {
      return set.remove(protein);
   }
   
   /**
   * Returns the number of elements in this set
   */
   public int size()
   {
      return set.size();
   }
}