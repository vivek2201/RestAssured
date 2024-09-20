package builder;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


public class JsonBuild {
	static String jsonOutput;
	public static String updatePayload(Map<String, String> data,String filename) {
	// Step 1: Create FreeMarker configuration
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
   cfg.setClassForTemplateLoading(JsonBuild.class, "/");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    
    // Step 3: Load the template and process it
    try {
        Template template = cfg.getTemplate(filename);
        StringWriter out = new StringWriter();
        template.process(data, out);
        jsonOutput = out.toString();
        System.out.println(jsonOutput);
    } catch (IOException | TemplateException e) {
        e.printStackTrace();
    }
	return jsonOutput;
}
}