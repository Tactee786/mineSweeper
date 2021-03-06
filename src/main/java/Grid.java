import java.security.SecureRandom;
import java.util.Objects;
import java.util.Scanner;

public class Grid {
    // Attributes
    int rowCount;
    int columnCount;
    int difficulty;
    int flagAndBomb;
    int tilesLeft;
    Tile[][] myGrid;

    // Constructor
    public Grid(int myRowCount, int myColumnCount, int myDifficulty, int myFlagAndBomb){
        this.rowCount = myRowCount;
        this.columnCount = myColumnCount;
        this.difficulty = myDifficulty;
        this.flagAndBomb = myFlagAndBomb;
        this.myGrid = new Tile[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                Tile myTile = new Tile(false,false,false, ".",0);
                myGrid[i][j] = myTile;
            }
        }
    }

    // Methods
    public void getMyGrid() {
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                System.out.print(myGrid[i][j].getTileState() + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("- - - - - - - - - - - - - - -");
    }

    @SuppressWarnings("PointlessBooleanExpression")
    public void setBombLocation(int difficulty){
        int a = 0;
        while (a < difficulty){
            for (int i = 0; a < difficulty; i++){
                SecureRandom rand = new SecureRandom();
                int x = rand.nextInt(this.rowCount);
                int y = rand.nextInt(this.columnCount);
                if (myGrid[x][y].bomb==false){
                    myGrid[x][y].setBomb();
                    a++;
                }
            }
        }

    }

    @SuppressWarnings({"PointlessBooleanExpression", "ConstantConditions"})
    public void setTileValues(){
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                if (myGrid[i][j].bomb == false){
                    int bombCount = 0;
                    if ((i-1 >= 0 && i-1 <= this.rowCount-1) && (j >= 0 && j <= columnCount-1)){
                        if (myGrid[i-1][j].bomb == true){
                            bombCount++;
                        }
                    }//1
                    if ((i-1 >= 0 && i-1 <= rowCount-1) && (j-1 >= 0 && j-1 <= columnCount-1)){
                        if (myGrid[i-1][j-1].bomb == true){
                            bombCount++;
                        }
                    }//2
                    if ((i >= 0 && i <= rowCount-1) && (j-1 >= 0 && j-1 <= columnCount-1)){
                        if (myGrid[i][j-1].bomb == true){
                            bombCount++;
                        }
                    }//3
                    if ((i+1 >= 0 && i+1 <= rowCount-1) && (j-1 >= 0 && j-1 <= columnCount-1)){
                        if (myGrid[i+1][j-1].bomb == true){
                            bombCount++;
                        }
                    }//4
                    if ((i+1 >= 0 && i+1 <= rowCount-1) && (j >= 0 && j <= columnCount-1)){
                        if (myGrid[i+1][j].bomb == true){
                            bombCount++;
                        }
                    }//5
                    if ((i+1 >= 0 && i+1 <= rowCount-1) && (j+1 >= 0 && j+1 <= columnCount-1)){
                        if (myGrid[i+1][j+1].bomb == true){
                            bombCount++;
                        }
                    }//6
                    if ((i >= 0 && i <= rowCount-1) && (j+1 >= 0 && j+1 <= columnCount-1)){
                        if (myGrid[i][j+1].bomb == true){
                            bombCount++;
                        }
                    }//7
                    if ((i-1 >= 0 && i-1 <= rowCount-1) && (j+1 >= 0 && j+1 <= columnCount-1)){
                        if (myGrid[i-1][j+1].bomb == true){
                            bombCount++;
                        }
                    }//8
                    myGrid[i][j].bombCount=(bombCount);
                }
            }
        }
    }

    public void setFlags (int x, int y){
        x -= 1;
        y -= 1;
        myGrid[x][y].setFlag();
    }

    @SuppressWarnings("PointlessBooleanExpression")
    public boolean clickSpot(int x, int y){
        x -= 1;
        y -= 1;
        if ((x >= 0 && x <= this.rowCount - 1) && (y >= 0 && y <= columnCount - 1)){
            if (myGrid[x][y].getBomb() == true){
                System.out.println("Wow you are bad!!!");
                return false;
            } else if (myGrid[x][y].getBomb() == false){
                revealEmptyTiles(x,y);
                //System.out.println("after reveal");
            }
        } else {
            clickOrFlag();
        }
        return true;
    }

    public boolean clickOrFlag(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("type 1 for clicking a tile or 2 for placing a flag | 3 to leave the game: ");
        int leftOrRight = myScanner.nextInt();
        if (leftOrRight == 1){
            System.out.print("type the X coordinate of the tile you would like to click: ");
            int y = myScanner.nextInt();
            System.out.print("type the Y coordinate of the tile you would like to click: ");
            int x = myScanner.nextInt();
            return clickSpot(x,y);
        } else if (leftOrRight == 2) {
            System.out.print("type the X coordinate of the tile you would like to set a flag: ");
            int y = myScanner.nextInt();
            System.out.print("type the Y coordinate of the tile you would like to set a flag: ");
            int x = myScanner.nextInt();
            setFlags(x,y);
        } else if (leftOrRight == 3) {
            System.out.println("why you leave the game?");
            return false;
        } else {
            clickOrFlag();
        }
        return true;
    }

    @SuppressWarnings({"ConstantConditions", "PointlessBooleanExpression"})
    public void revealEmptyTiles(int x, int y){
        if  (myGrid[x][y].visible == false) {
            if (myGrid[x][y].getBombCount() == 0) {
                myGrid[x][y].setVisible();
                myGrid[x][y].setState(myGrid[x][y].getBombCount());
                if ((x - 1 >= 0 && x - 1 <= this.rowCount - 1) && (y >= 0 && y <= columnCount - 1)) {
                    myGrid[x - 1][y].setState(myGrid[x - 1][y].getBombCount());
                    revealEmptyTiles(x - 1, y);
                }//1
                if ((x - 1 >= 0 && x - 1 <= rowCount - 1) && (y - 1 >= 0 && y - 1 <= columnCount - 1)) {
                    myGrid[x - 1][y - 1].setState(myGrid[x - 1][y - 1].getBombCount());
                    revealEmptyTiles(x - 1, y - 1);
                }//2
                if ((x >= 0 && x <= rowCount - 1) && (y - 1 >= 0 && y - 1 <= columnCount - 1)) {
                    myGrid[x][y - 1].setState(myGrid[x][y - 1].getBombCount());
                    revealEmptyTiles(x, y - 1);
                }//3
                if ((x + 1 >= 0 && x + 1 <= rowCount - 1) && (y - 1 >= 0 && y - 1 <= columnCount - 1)) {
                    myGrid[x + 1][y - 1].setState(myGrid[x + 1][y - 1].getBombCount());
                    revealEmptyTiles(x + 1, y - 1);
                }//4
                if ((x + 1 >= 0 && x + 1 <= rowCount - 1) && (y >= 0 && y <= columnCount - 1)) {
                    myGrid[x + 1][y].setState(myGrid[x + 1][y].getBombCount());
                    revealEmptyTiles(x + 1, y);
                }//5
                if ((x + 1 >= 0 && x + 1 <= rowCount - 1) && (y + 1 >= 0 && y + 1 <= columnCount - 1)) {
                    myGrid[x + 1][y + 1].setState(myGrid[x + 1][y + 1].getBombCount());
                    revealEmptyTiles(x + 1, y + 1);
                }//6
                if ((x >= 0 && x <= rowCount - 1) && (y + 1 >= 0 && y + 1 <= columnCount - 1)) {
                    myGrid[x][y + 1].setState(myGrid[x][y + 1].getBombCount());
                    revealEmptyTiles(x, y + 1);
                }//7
                if ((x - 1 >= 0 && x - 1 <= rowCount - 1) && (y + 1 >= 0 && y + 1 <= columnCount - 1)) {
                    myGrid[x - 1][y + 1].setState(myGrid[x - 1][y + 1].getBombCount());
                    revealEmptyTiles(x - 1, y + 1);
                }//8
            } else if ((myGrid[x][y].getBombCount() != 0) && (!Objects.equals(myGrid[x][y].getTileState(), "X"))) {
                myGrid[x][y].setVisible();
                myGrid[x][y].setState(myGrid[x][y].getBombCount());
            }
        }
    }

    public int flagsOnBombs() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (myGrid[i][j].bomb == true && myGrid[i][j].flag == true) {
                    flagAndBomb++;
                }
            }
        }
        return flagAndBomb;
    }

    public int allTilesRevealed() {
        tilesLeft = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (myGrid[i][j].visible == true && myGrid[i][j].bomb == false) {
                    tilesLeft++;
                }
            }
        }
        return tilesLeft;
    }

}