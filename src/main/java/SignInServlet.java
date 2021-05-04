import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

import java.io.IOException;

public class SignInServlet extends HttpServlet {


   public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String login = req.getParameter("login");
       String password = req.getParameter("password");
      //  System.out.println("login = "+ login  + " password = " + password   );


       String isLogin = AccountService.getAccount(login,password);

       if (null != isLogin && (!isLogin.isEmpty())) {
           resp.getWriter().write("Authorized: " + isLogin);
           resp.setStatus(HttpStatus.OK_200);
       } else {

           resp.setStatus(HttpStatus.UNAUTHORIZED_401);
           resp.getWriter().write("Unauthorized");
       }

    }




}
