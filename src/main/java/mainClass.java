import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class mainClass {

public static void main (String args[]) throws Exception {
    Frontend f = new Frontend();

    Server srv = new Server (8080);
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    srv.setHandler(context);

    context.addServlet(new ServletHolder(f), "/mirror");

    srv.start();
    srv.join();


    }

}