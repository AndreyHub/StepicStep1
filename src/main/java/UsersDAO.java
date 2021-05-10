import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private Connection conn;
    private BdExecutor BdExec;

    public UsersDAO() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        conn = DataBaseService.createPsgConnection();
        BdExec = new BdExecutor();
    }
    void close () throws SQLException {
        conn.close();
    }

    public UserInfo getUserByLogin(String login) throws SQLException {
        String query = "SELECT * FROM \"tUsers\" WHERE login = " + "\'" + login + "\'";
      //  System.out.println("select by login query = " + query);
        List<UserInfo> userInfos =
                BdExec.execQuery(conn, query, new iresultHandler<List<UserInfo>>() {
                            public List<UserInfo> handle(ResultSet res) throws SQLException {
                                ArrayList<UserInfo> users = new ArrayList<>();
                                res.next();
                                while (!res.isAfterLast()) {
                                    UserInfo ui = new UserInfo();
                                    ui.setLogin(res.getString("login"));
                                    ui.setPassword(res.getString("password"));
                                    ui.setEmail(res.getString("email"));
                                    ui.setComment(res.getString("comment"));
                                    ui.setId(res.getInt("id"));
                                    users.add(ui);
                                    res.next();
                                }
                                return users;
                            }
                        }
                );
        return userInfos.get(0);

    }

    void printAllUsers () throws SQLException {
        String query = "SELECT * FROM \"tUsers\" ";
        //  System.out.println("query = " + query);
        BdExec.execQuery(conn, query, new iresultHandler() {

            public Integer handle(ResultSet rSet) throws SQLException {
                rSet.next();
                while (!rSet.isAfterLast()) {
                    UserInfo ui = new UserInfo();
                    ui.setLogin(rSet.getString("login"));
                    ui.setPassword(rSet.getString("password"));
                    ui.setEmail(rSet.getString("email"));
                    ui.setComment(rSet.getString("comment"));
                    ui.setId(rSet.getInt("id"));
                    System.out.println(ui.toString());
                    rSet.next();
                }
                return Integer.valueOf(1);
            }
        });
    }
        void addUser (UserInfo user ) throws SQLException {
            String insertUser = "INSERT INTO \"tUsers\" (login, password,email,comment)VALUES ( \'" +user.getLogin() +"\', \'" + user.getPassword() + "\', \'" + user.getEmail()+"\', \'"+user.getComment()+"\')";
            System.out.println("query = " + insertUser);
            BdExec.execUpdate(conn,insertUser);

        }

        int delUserById (int id) throws SQLException {
            String query = "DELETE FROM \"tUsers\" WHERE id = " +id;
            int r = BdExec.execUpdate(conn, query);
            return r;
        }
}