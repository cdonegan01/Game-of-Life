/**
 * 
 */
package theGameOfLife;

/**
 * @author Cormac Donegan
 * This class creates and maintains the Game of Life for a first and second iteration of the grid. 
 */
public class Game {
	
	public static void main(String[] args) { 
        int gridWidth = 8, gridLength = 8; 
        
        int[][] firstGrid = { { 0, 0, 0, 0, 0, 0, 0, 0}, 
            { 0, 0, 0, 0, 0, 0, 0, 0}, 
            { 0, 0, 0, 1, 0, 0, 0, 0}, 
            { 0, 0, 0, 1, 0, 0, 0, 0}, 
            { 0, 0, 0, 1, 0, 0, 0, 0}, 
            { 0, 0, 0, 0, 0, 0, 0, 0}, 
            { 0, 0, 0, 0, 0, 0, 0, 0}, 
            { 0, 0, 0, 0, 0, 0, 0, 0}
        }; 
  
        // Displaying the grid 
        System.out.println("Grid One"); 
        for (int outerCount = 0; outerCount < gridWidth; outerCount++) { 
            for (int innerCount = 0; innerCount < gridLength; innerCount++) 
            { 
                if (firstGrid[outerCount][innerCount] == 0) {
                	System.out.print("-"); 
                } else {
                    System.out.print("X");
                }
            } 
            System.out.println(); 
        } 
        System.out.println(); 
        secondGridCreator(firstGrid, gridWidth, gridLength); 
    } 
	
	/**
	 * This method creates a new grid based on the cells alive in a previous grid.
	 * @param firstGrid
	 * @param gridWidth
	 * @param gridLength
	 */
    static void secondGridCreator(int firstGrid[][], int gridWidth, int gridLength) { 
        int[][] secondGrid = new int[gridWidth][gridLength]; 
  
        // Loop through every cell 
        for (int outerCount = 1; outerCount < gridWidth - 1; outerCount++) { 
            for (int innerCount = 1; innerCount < gridLength - 1; innerCount++) { 
                // Finding living neighbours of each cell
                int neighbourCount = 0; 
                for (int neighbourCountOuter = -1; neighbourCountOuter <= 1; neighbourCountOuter++) {
                	for (int neighbourCountInner = -1; neighbourCountInner <= 1; neighbourCountInner++) {
                		neighbourCount += firstGrid[outerCount + neighbourCountOuter][innerCount + neighbourCountInner]; 
                	}
                }
                
                // Eliminating Current Cell from neighbourCount to maintain accuracy 
                neighbourCount -= firstGrid[outerCount][innerCount]; 
  
                // Scenario 1: Underpopulation
                if ((firstGrid[outerCount][innerCount] == 1) && (neighbourCount < 2)) {
                	secondGrid[outerCount][innerCount] = 0;
                }
                     
                // Scenario 2: Overcrowding 
                else if ((firstGrid[outerCount][innerCount] == 1) && (neighbourCount > 3)) {
                	secondGrid[outerCount][innerCount] = 0; 
                }
                    
                // Scenario 4: Creation of Life
                else if ((firstGrid[outerCount][innerCount] == 0) && (neighbourCount == 3)) {
                	 secondGrid[outerCount][innerCount] = 1; 
                }    
                
                // Scenario 3: Survival + Dead Cell
                else {
                	secondGrid[outerCount][innerCount] = firstGrid[outerCount][innerCount]; 
                }
            }
        } 
  
        System.out.println("Grid Two"); 
        for (int gridPrintOuter = 0; gridPrintOuter < gridWidth; gridPrintOuter++) 
        { 
            for (int gridPrintInner = 0; gridPrintInner < gridLength; gridPrintInner++) 
            { 
                if (secondGrid[gridPrintOuter][gridPrintInner] == 0) 
                    System.out.print("-"); 
                else
                    System.out.print("X"); 
            } 
            System.out.println(); 
        } 
    } 

}
