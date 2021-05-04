import java.util.HashMap;
import java.util.Map;

public class AccountService {

   private static Map  <String,String> aService;

    public AccountService () {
        aService = new HashMap<String, String>();
    }

    public static String getAccount (String login, String password) {
        String isPassword = aService.get(login);
        if (null!=password && password.equals(isPassword)) {
           return login;
        }
        return null;
    }
    public static boolean regLogin (String login, String password) {

        if (null != aService.put(login,password)) return false;
        return true;

    }




}
