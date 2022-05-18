import java.security.SecureRandom;

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
                Tile myTile = new Tile(false,false,false, "0",0);
                myGrid[i][j] = myTile;
            }
        }
    }

    // Methods

    public void getMyGrid() {
        for (int i = 0; i < rowCount; i++){
            //System.out.println(i);
            for (int j = 0; j < columnCount; j++){
                //System.out.println(j);
                Tile myTile = new Tile(false,false,false, "0",0);
                System.out.print(myGrid[i][j].getState() + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("- - - - - - - - - - - - - - - - -");
    }

    public void setBombLocation(int difficulty){
        int a = 0;
        while (a < difficulty){
            for (int i = 0; a < difficulty; i++){
                SecureRandom rand = new SecureRandom();
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);
                if (myGrid[x][y].bomb==false){
                    myGrid[x][y].setBomb();
                    System.out.println(y + " " + x);
                    System.out.println(i);
                    a++;
                } else {
                    System.out.println("already bomb or dunno.");
                }
            }
        }

    }

    public void setFlags (int x, int y){
        x -= 1;
        y -= 1;
        myGrid[x][y].setFlag();
    }

    public void setTileValues(){
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < columnCount; j++){
                if (myGrid[i][j].bomb == false){
                    int bombCount = 0;
                    if (i-1 >= 0 && i-1 <= 9){
                        bombCount++;
                    }
                    //System.out.println("there is no bomb: ");
                    myGrid[i][j].setState(bombCount);
                    //System.out.println(bombCount);
                }
                if (myGrid[i][j].bomb == true){
                    int a = 1;
                    System.out.println("there is a bomb: " + a);
                    a++;
                }
            }
            System.out.print("\n");
        }
    }


}
