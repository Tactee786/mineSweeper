import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TileTest {
    Tile myTile = new Tile(false, true, false, "O",0);

    @Test
    public void testGetState(){
        Assertions.assertEquals("O", myTile.getTileState(),"incorrect state.");
    }

    @Test
    public void testGetBomb(){
        Assertions.assertEquals(true, myTile.getBomb(), "incorrect bomb boolean value");
    }

    @Test
    public void testSetVisible(){
        Assertions.assertEquals(true, myTile.setVisible(),"not set to visible");
    }

    @Test
    public void testSetFlag(){
        myTile.setFlag();
        Assertions.assertEquals("F", myTile.getTileState(), "flag not set");
    }

}
