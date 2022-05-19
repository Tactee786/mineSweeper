import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TileTest {
    Tile myTile = new Tile(false, true, false, "O",0);

    @Test
    public void testGetState(){
        Assertions.assertEquals("O", myTile.getTileState(),"incorrect state.");
    }

}
