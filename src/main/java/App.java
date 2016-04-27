import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cd-form/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/cd-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/albums", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cd-names", CD.all());
      model.put("template", "templates/allcds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/albums", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CD> cdList = request.session().attribute("list");
      if (cdList == null) {
        cdList = new ArrayList<CD>();
        request.session().attribute("list", cdList);
      }
      String name = request.queryParams("cd-name");
      CD newCD = new CD(name);
      cdList.add(newCD);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
