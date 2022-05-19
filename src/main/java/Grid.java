import java.security.SecureRandom;
import java.util.Scanner;

public class Grid {
    // Attributes
    int rowCount;
    int columnCount;
    int difficulty;
    //int bombCount = ((rowCount * columnCount)/100)*20;
    Tile[][] myGrid;

    // Constructor
    public Grid(int myRowCount, int myColumnCount, int myDifficulty){
        this.rowCount = myRowCount;
        this.columnCount = myColumnCount;
        this.difficulty = myDifficulty;
        this.myGrid = new Tile[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                Tile myTile = new Tile(false,false,false, "O",0);
                myGrid[i][j] = myTile;
            }
        }
    }

    // Methods
    public void getMyGrid() {
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                Tile myTile = new Tile(false,false,false, "0",0);
                System.out.print(myGrid[i][j].getState() + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("- - - - - - - - - - - - - - -");
    }

    public void setBombLocation(int difficulty){
        int a = 0;
        while (a < difficulty){
            for (int i = 0; a < difficulty; i++){
                SecureRandom rand = new SecureRandom();
                int x = rand.nextInt(this.rowCount);
                int y = rand.nextInt(this.columnCount);
                if (myGrid[x][y].bomb==false){
                    myGrid[x][y].setBomb();
                    //System.out.println(y + " " + x);
                    //System.out.println(i);
                    a++;
                } else {
                    //System.out.println("already bomb or dunno.");
                }
            }
        }

    }

    public void setTileValues(){
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                if (myGrid[i][j].bomb == false){
                    int bombCount = 0;
                    if ((i-1 >= 0 && i-1 <= 9) && (j >= 0 && j <= 9)){
                        if (myGrid[i-1][j].bomb == true){
                            bombCount++;
                        }
                    }//1
                    if ((i-1 >= 0 && i-1 <= 9) && (j-1 >= 0 && j-1 <= 9)){
                        if (myGrid[i-1][j-1].bomb == true){
                            bombCount++;
                        }
                    }//2
                    if ((i >= 0 && i <= 9) && (j-1 >= 0 && j-1 <= 9)){
                        if (myGrid[i][j-1].bomb == true){
                            bombCount++;
                        }
                    }//3
                    if ((i+1 >= 0 && i+1 <= 9) && (j-1 >= 0 && j-1 <= 9)){
                        if (myGrid[i+1][j-1].bomb == true){
                            bombCount++;
                        }
                    }//4
                    if ((i+1 >= 0 && i+1 <= 9) && (j >= 0 && j <= 9)){
                        if (myGrid[i+1][j].bomb == true){
                            bombCount++;
                        }
                    }//5
                    if ((i+1 >= 0 && i+1 <= 9) && (j+1 >= 0 && j+1 <= 9)){
                        if (myGrid[i+1][j+1].bomb == true){
                            bombCount++;
                        }
                    }//6
                    if ((i >= 0 && i <= 9) && (j+1 >= 0 && j+1 <= 9)){
                        if (myGrid[i][j+1].bomb == true){
                            bombCount++;
                        }
                    }//7
                    if ((i-1 >= 0 && i-1 <= 9) && (j+1 >= 0 && j+1 <= 9)){
                        if (myGrid[i-1][j+1].bomb == true){
                            bombCount++;
                        }
                    }//8
                    //System.out.println("there is no bomb: ");
                    myGrid[i][j].setState(bombCount);
                    myGrid[i][j].bombCount=(bombCount);
                    //System.out.println(bombCount);
                }
                /*if (myGrid[i][j].bomb == true){
                    int a = 1;
                    System.out.println("there is a bomb: " + a);
                    a++;
                }*/
            }
        }
    }

    public void setFlags (int x, int y){
        x -= 1;
        y -= 1;
        myGrid[x][y].setFlag();
    }

    public void clickSpot(){
        
    }


    public void clickOrFlag(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("type 1 for clicking a tile or 2 for placing a flag: ");
        int leftOrRight = myScanner.nextInt();
        if (leftOrRight == 1){
            
        } else if (leftOrRight == 2) {
            int x = myScanner.nextInt();
            int y = myScanner.nextInt();
            setFlags(x,y);
        }
    }


}
