package cst8284.generics;

import java.util.ArrayList;



public final class Table {

	public static <E> void displayEqualityTable(ArrayList<E> arList){
		
	      // Print out column header
		  	System.out.print("\n");
		  System.out.print("\t\t");
		  int i = 0;
		  for (E columnHeader: arList)
			  System.out.print("\t" + columnHeader.getClass().getSimpleName()+ (i++) +" ");
			
		 // Print out each row,starting with the name of the object
		  i = 0; 
		 for (E solidObjRow: arList){
		    System.out.println();	// Next line
		    int length = solidObjRow.getClass().getSimpleName().length();
		    System.out.print(solidObjRow.getClass().getSimpleName()+(i++));
		    for (int rl = length; rl < 12 ; rl++){
	    		System.out.print(" ");
}
		    
		    
	            for (E solidObjColumn: arList)
	               System.out.print("\t\t" + solidObjColumn.equals(solidObjRow));
	         }   
		 	System.out.print("\n");
    }
	
}
