public class Main {
    public static void main(String[] args) {
        Grid myGrid = new Grid(10,10,10);
        myGrid.getMyGrid();
        myGrid.setBombLocation(10);
        myGrid.setTileValues();
        myGrid.getMyGrid();
        myGrid.setFlags(4,4);
        myGrid.getMyGrid();
        myGrid.setFlags(4,4);
        myGrid.getMyGrid();
    }
}
