package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.Course;;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,14,14,14,14,15,15,15,16,16,16,18,18,18,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\"\n          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n    <title>Document</title>\n</head>\n<body>\n<h3>Курс № ");
		jteOutput.setContext("h3", null);
		jteOutput.writeUserContent(page.getCourse().getId());
		jteOutput.writeContent("</h3>\n    <h5>");
		jteOutput.setContext("h5", null);
		jteOutput.writeUserContent(page.getCourse().getTitle());
		jteOutput.writeContent("</h5>\n    <h5>");
		jteOutput.setContext("h5", null);
		jteOutput.writeUserContent(page.getCourse().getDescription());
		jteOutput.writeContent("</h5>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
