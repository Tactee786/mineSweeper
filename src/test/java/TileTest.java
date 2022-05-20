import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {
    @Test
    public void testGetState(){
        Tile myTileBomb = new Tile(false, true, false, "O",3);
        Assertions.assertEquals("O", myTileBomb.getTileState(),"incorrect state.");
    }
    @Test
    public void testGetBomb(){
        Tile myTileBomb = new Tile(false, true, false, "O",3);
        Assertions.assertEquals(true, myTileBomb.getBomb(), "incorrect bomb boolean value");
    }
    @Test
    public void testSetVisible(){
        Tile myTileBomb = new Tile(false, true, false, "O",3);
        Assertions.assertEquals(true, myTileBomb.setVisible(),"not set to visible");
    }
    @Test
    public void testSetFlag(){
        Tile myTileBomb = new Tile(false, true, false, "O",3);
        myTileBomb.setFlag();
        Assertions.assertEquals("F", myTileBomb.getTileState(), "flag not set");
    }
    @Test
    public void testSetState(){
        Tile myTile3 = new Tile(false, true, false, "O",3);
        myTile3.setState(myTile3.bombCount);
        Assertions.assertEquals("3", myTile3.getTileState(),"incorrect value");
    }

}
