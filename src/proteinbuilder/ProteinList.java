package proteinbuilder;

import java.util.Vector;
import java.util.Iterator;
import java.lang.Iterable;

/**
* Maintains a list of proteins. Does not allow duplicate entries
*/
public final class ProteinList implements Iterable<Protein>
{
   public ProteinList()
   {
      list = new Vector();
   }
   
   private Vector<Protein> list;
   
   /**
   * Returns true if the protein was successfully
   * added to the set.
   */
   public boolean add(Protein protein)
   {
      if(list.contains(protein))
      {  
         return false;
      }
      return list.add(protein);
   }
   
   /**
   * Returns true if tbe set contains protein
   */
   public boolean contains(Protein protein)
   {
      return list.contains(protein);
   }
   
   /**
   * Returns an iterator for this protein set
   */
   public Iterator<Protein> iterator()
   {
      return list.iterator();
   }
   
   /**
   * Returns true if the protein was removed
   * from the set
   */
   public boolean remove(Protein protein)
   {
      return list.remove(protein);
   }
   
   /**
   * Returns the number of elements in this set
   */
   public int size()
   {
      return list.size();
   }
}