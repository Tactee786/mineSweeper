public class Main {
    public static void main(String[] args) {
        Grid myGrid = new Grid(10, 10, 10);
        myGrid.getMyGrid();
        myGrid.setBombLocation(10);
        myGrid.setTileValues();
        myGrid.getMyGrid();

        /*myGrid.setFlags(4,4);
        myGrid.getMyGrid();

        myGrid.setFlags(4,4);
        myGrid.getMyGrid();*/

        /*myGrid.clickOrFlag();
        myGrid.getMyGrid();
        myGrid.clickOrFlag();
        myGrid.getMyGrid();
        myGrid.clickOrFlag();
        myGrid.getMyGrid();*/
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
