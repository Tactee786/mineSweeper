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
        Grid myGrid = new Grid(myRowCount, myColumnCount, myDifficulty);
        myGrid.getMyGrid();
        myGrid.setBombLocation(myGrid.difficulty);
        myGrid.setTileValues();
        myGrid.getMyGrid();

        boolean cont = true;
        while (cont == true) {
            cont = playTheGame(myGrid);
        }
    }

    public static boolean playTheGame(Grid myGrid){
        boolean cont = myGrid.clickOrFlag();
        myGrid.getMyGrid();
        return cont;
    }

}
