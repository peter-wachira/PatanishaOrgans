import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";


        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        // retrieving index page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/recipientsinfo", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/recipientsInfo.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/FAQs", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/FAQs.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        // retriving  donors    info
        get("/donorsinfo", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/donorsinfo.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        // retrieving donors form

        get("/donors/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/donorForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //retrieving recipient form
        get("/recipients/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/recipientForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

       // posting recepient details
        post("/recipients", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String bloodgroup = request.queryParams("bloodgroup");
            String name = request.queryParams("name");
            String organ = request.queryParams("organ");
            String doctor = request.queryParams("doctor");

            int doctorid = Integer.parseInt(request.queryParams("doctor"));

            Recepient recepient = new Recepient(name, bloodgroup, organ, doctorid);
            recepient.save();

            model.put("recepient", recepient );
            response.redirect("/recipients");
            return null;
        });

        get("/recipients", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            model.put("recepient", recepient.all() );
            model.put("template", "templates/recipients.vtl");

            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());














    }














}
