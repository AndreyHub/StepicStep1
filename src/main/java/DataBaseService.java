import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseService {

    private UsersDAO uDAO = new UsersDAO();

    public DataBaseService() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }

    static Connection createPsgConnection () throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Driver dbDrv = (Driver) Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(dbDrv);
        StringBuilder url = new StringBuilder("jdbc:postgresql://");
        url.append("localhost:" );
        url.append("5432/" );
        url.append("stepicUsersDB?");
        url.append("user=postgres&");
        url.append("password=postgres");
        Connection conn = DriverManager.getConnection(url.toString());
        return conn;
    }

    UserInfo getUserByLogin (String login) throws SQLException {
       return uDAO.getUserByLogin(login);
    }
    void printAllUsers () throws SQLException {
        uDAO.printAllUsers();
    }

    void addUser (UserInfo user) throws SQLException {
        uDAO.addUser(user);
    }

    void closeConnection () throws SQLException {
        uDAO.close();
    }

    public void delUserById(int i) throws SQLException {
        uDAO.delUserById(i);
    }
}










