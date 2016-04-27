// import org.fluentlenium.adapter.FluentTest;
// import org.junit.ClassRule;
// import org.junit.Test;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// public class AppTest extends FluentTest {
//   public WebDriver webDriver = new HtmlUnitDriver();
//
//   @Override
//   public WebDriver getDefaultDriver() {
//     return webDriver;
//   }
//
//   @ClassRule
//   public static ServerRule server = new ServerRule();
//
//   @Test
//   public void bananasBecauseFernandaSaidSo() {
//     goTo("http://localhost:4567/");
//     fill("#side1").with("3");
//     fill("#side2").with("5");
//     fill("#side3").with("3");
//     submit(".btn");
//     assertThat(pageSource()).contains("make an isosceles triangle!");
//   }
//
// }
