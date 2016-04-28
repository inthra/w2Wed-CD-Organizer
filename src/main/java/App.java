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
      model.put("template", "templates/cdForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/albumName", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String name = request.queryParams("cd-name");
      CD newCD = new CD(name);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cdList", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("allCDs", CD.all());
      model.put("template", "templates/allcds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/eachCD/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      CD name = CD.find(Integer.parseInt(request.params(":id")));
      model.put("cd", name);
      model.put("template", "templates/cd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
