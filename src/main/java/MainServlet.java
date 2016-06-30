import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties resource;
        try (InputStream in = getClass().getResourceAsStream("resource.properties")) {
            resource = new Properties();
            resource.load(in);
        }

        response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            out.println("this is coming from a servlet in a war file: " + resource.getProperty("war.file"));
        }
    }

}
