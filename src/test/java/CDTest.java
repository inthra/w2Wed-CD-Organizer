import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

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

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    CD myCD = new CD("Songs of Innocence");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myCD.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOf_CD_true() {
    CD firstName = new CD("Songs of Innocence");
    CD secondName = new CD("No Line on the Horizon");
    assertTrue(CD.all().contains(firstName));
    assertTrue(CD.all().contains(secondName));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    CD myCD = new CD("Songs of Innocence");
    CD.clear();
    assertEquals(CD.all().size(), 0);
  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    CD.clear();  // THIS TEST WILL FAIL WITHOUT THIS LINE!
    CD myCD = new CD("Songs of Innocence");
    assertEquals(1, myCD.getId());
  }

  @Test
  public void find_returnsCD_WithSameId_secondCD() {
    CD firstName = new CD("Songs of Innocence");
    CD secondName = new CD("No Line on the Horizon");
    assertEquals(CD.find(secondName.getId()), secondName);
  }

  @Test
  public void find_returnsNullWhenNo_CD_Found_null() {
    assertTrue(CD.find(999) == null);
  }
}
