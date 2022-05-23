import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Row count: ");
        int myRowCount = myScanner.nextInt();
        System.out.print("Column count: ");
        int myColumnCount = myScanner.nextInt();
        System.out.print("Difficulty lvl, number of bomb you would like to have in here: ");
        int myDifficulty = myScanner.nextInt();
        int myFlagAndBomb = 0;
        Grid myGrid = new Grid(myRowCount, myColumnCount, myDifficulty, myFlagAndBomb);
        myGrid.getMyGrid();
        myGrid.setBombLocation(myGrid.difficulty);
        myGrid.setTileValues();
        myGrid.getMyGrid();

        boolean cont = true;
        boolean win = false;
        while (cont == true) {
            if (win == false){
                //win = checkIfWon(myGrid);
                cont = playTheGame(myGrid);
                win = checkIfWon(myGrid);
            } else if (win == true) {
                System.out.println("bro you made it!!!");
                cont = false;
            }
        }
    }

    public static boolean playTheGame(Grid myGrid){
        boolean cont = myGrid.clickOrFlag();
        myGrid.getMyGrid();
        return cont;
    }

    public static boolean checkIfWon(Grid myGrid){
        int tilesLeft = ((myGrid.rowCount* myGrid.columnCount) - myGrid.difficulty);
        System.out.println(tilesLeft);
        System.out.println(myGrid.difficulty);
        System.out.println(myGrid.allTilesRevealed());
        int flagsOnBombCount = myGrid.flagsOnBombs();
        System.out.println(flagsOnBombCount);
        if ((flagsOnBombCount == myGrid.difficulty && myGrid.allTilesRevealed() == tilesLeft) || myGrid.allTilesRevealed() == tilesLeft){
            //boolean win = true;
            return true;
        }
        return false;
    }

}