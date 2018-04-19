package cst8284.solidObject;

import java.util.ArrayList;

public class TestSolidObjects {
	
   // TODO: define a new static ArrayList of type SolidObject called solidObjects.
	   public static void main(String[] args){
		   
		   ArrayList<SolidObject<BasicShape>> solidObjects = new ArrayList<>();
		     
		   solidObjects.add(new SolidObject<BasicShape>(new Circle(3.0),5.0));		  
		   solidObjects.add(new SolidObject<BasicShape>(new Rectangle(10.0, 9.0),2.0));
		   solidObjects.add(new SolidObject<BasicShape>(new Rectangle(3.0, 6.0),10.0));		   
		   solidObjects.add(new SolidObject<BasicShape>(new Square(6.0)));

		/* TODO
		 * Load the ArrayList declared above with the following four SolidObjects,
		 * which must be instantiated with the values shown below
		 * 
	     *          Type                   depth
	     *  
	     *        Circle(3.0)               5.0
	     *        Rectangle(10.0, 9.0)      2.0
	     *        Rectangle(3.0, 6.0)       10.0
	     *        Square(6.0)    
	     *        
	     * Note that the last SolidObject is a cube constructed using the Square
	     * BasicShape.  For this, use the one-arg SolidObject constructor.  For 
	     * the other three, use the two-arg constructor.
	    */
 
	  displayVolumeComparison(solidObjects); 
      displaySurfaceAreaComparison(solidObjects);

   }
	
   // TODO: Create a public static method isVolumeEqual() that takes two SolidObjects as 
   // parameters, and if they have the same volume, returns true, otherwise false.  This
   // method is called by the displayVolumeComparison method, whose code is provided below.

   public static boolean isVolumeEqual(SolidObject<BasicShape> T,SolidObject<BasicShape> S) {
	   	
	   return (T.getVolume() == S.getVolume());
		
}
   // TODO: Create a public static method isSurfaceAreaEqual() that takes two SolidObjects 
   // as parameters and if they have the same surface area, returns true, otherwise false.  
   // This method is called by the displayVolumeComparison method, whose code is provided below.

   public static boolean isSurfaceAreaEqual(SolidObject<BasicShape> T,SolidObject<BasicShape> S) {
	   
	   return (T.getSurfaceArea() == S.getSurfaceArea());
   }
	
   public static void displayVolumeComparison(ArrayList<SolidObject<BasicShape>> arList){
		
	      // Print out column header
	      System.out.println("\n\nCompare the two object's volumes.  Are they equal?");
		  System.out.print("\t\t");
	      for (SolidObject<BasicShape> columnHeader: arList)
	         System.out.print("\t" + columnHeader);
			
		 // Print out each row,starting with the name of the object
		 for (SolidObject<BasicShape> solidObjRow: arList){
		    System.out.println();	// Next line
		    System.out.print(solidObjRow);
	            for (SolidObject<BasicShape> solidObjColumn: arList)
	               System.out.print("\t\t" + isVolumeEqual(solidObjColumn, solidObjRow));
	         }   
      }
	
   public static void displaySurfaceAreaComparison(ArrayList<SolidObject<BasicShape>> arList){
	      
	   System.out.println("\n\nCompare the two object's surface areas.  Are they equal?");  
	   // Print out the header
	   System.out.print("\t\t");
       for (SolidObject<BasicShape> columnHeader: arList)
         System.out.print("\t" + columnHeader);
		
      // Print out each row,starting with the name of the object
      for (SolidObject<BasicShape> solidObjRow: arList){
         System.out.println();	// Next line
         System.out.print(solidObjRow);
         for (SolidObject<BasicShape> solidObjColumn: arList)
            System.out.print("\t\t" + isSurfaceAreaEqual(solidObjColumn, solidObjRow));  
      }
   }
}

