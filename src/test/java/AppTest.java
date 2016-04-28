import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD list!");
  }

  @Test
  public void CDIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a CD"));
    fill("#cd-name").with("Songs of Innocence");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void newCDIsDisplayedTest() {
    goTo("http://localhost:4567/cd-form/new");
    fill("#cd-name").with("Songs of Innocence");
    submit(".btn");
    click("a", withText("View CDs"));
    assertThat(pageSource()).contains("Songs of Innocence");
  }

  @Test
  public void multipleCDsAreDisplayedTest() {
    goTo("http://localhost:4567/cd-form/new");
    fill("#cd-name").with("Songs of Innocence");
    submit(".btn");
    goTo("http://localhost:4567/cd-form/new");
    fill("#cd-name").with("No Line on the Horizon");
    submit(".btn");
    click("a", withText("View CDs"));
    assertThat(pageSource()).contains("Songs of Innocence");
    assertThat(pageSource()).contains("No Line on the Horizon");
  }

  @Test
  public void CD_NotFoundMessageShown() {
    goTo("http://localhost:4567/eachCD/999");
    assertThat(pageSource()).contains("CD not found");
  }

}
