public class Main {
    public static void main(String[] args) {
        Grid myGrid = new Grid(10,10,20);
        myGrid.getMyGrid();
        myGrid.setBombLocation(20);
        //myGrid.setFlags(4,4);
        //myGrid.setFlags(2,1);
        myGrid.getMyGrid();
        //myGrid.setFlags(2,1);
        //myGrid.setFlags(4,4);
        myGrid.setTileValues();
        myGrid.getMyGrid();
    }
}
