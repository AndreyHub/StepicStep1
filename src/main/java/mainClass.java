import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class mainClass {

    public static void main (String args[]) throws Exception {

        /*
    AccountService accService = new AccountService();

    SignInServlet sIn = new SignInServlet();
    SignUpServlet sUp = new SignUpServlet();

    Server srv = new Server (8080);
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    srv.setHandler(context);

    context.addServlet(new ServletHolder(sUp), "/signup");
    context.addServlet(new ServletHolder(sIn), "/signin");



   // System.out.println("Server started");
    srv.start();
    System.out.println("Server started");
    srv.join();
*/

       DataBaseService dbs = new DataBaseService();
       dbs.printAllUsers();
       // UserInfo uInfo = new UserInfo("theyLogin","team", "team@mail.com","it is for joke only!");
      // dbs.addUser(uInfo);
        dbs.delUserById(12);
       System.out.println("After modify  user");
       dbs.printAllUsers();
       UserInfo uLogin = dbs.getUserByLogin("herLogin");
       System.out.println("by login = " + uLogin.toString());
       dbs.closeConnection();
    }

}