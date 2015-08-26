import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/hello.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("/form", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("/greeting_card", (request, response) -> {
      String recipient = request.queryParams("recipient");
      String sender = request.queryParams("sender");
      HashMap model = new HashMap();
      model.put("recipient", recipient);
      model.put("sender", sender);
      model.put("template", "templates/greeting_card.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("/favorite_photos", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/favorite_photos.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("/addresses", (request, response) -> {
      HashMap<String, Object> addressBook = new HashMap<String, Object>();
      addressBook.put("Jenny", "503-867-5309");
      addressBook.put("Legal Help", "444-444-4444");
      addressBook.put("Emergency", "911");
      for ( Object contact : addressBook.keySet() ) {
        // Do something
      }
      HashMap model = new HashMap();
      model.put("template", "templates/addresses.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}