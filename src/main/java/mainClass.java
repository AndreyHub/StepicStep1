import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class mainClass {

    public static void main (String args[]) throws Exception {

    AccountService accService = new AccountService();

    SignInServlet sIn = new SignInServlet();
    SignUpServlet sUp = new SignUpServlet();

    Server srv = new Server (8080);
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    srv.setHandler(context);

    context.addServlet(new ServletHolder(sUp), "/signup");
    context.addServlet(new ServletHolder(sIn), "/signin");



   // System.out.println("Server started1");
    srv.start();
    System.out.println("Server started");
    srv.join();


    }

}