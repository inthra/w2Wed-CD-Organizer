import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void newCD_instantiatesCorrectly_true() {
    CD myCD = new CD("Songs of Innocence");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void newCD_instantiatesWithName_String() {
    CD myCD = new CD("Songs of Innocence");
    assertEquals("Songs of Innocence", myCD.getName());
  }


}
