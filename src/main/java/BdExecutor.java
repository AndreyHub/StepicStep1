import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BdExecutor  {

    public int execUpdate (Connection conn, String updateRequest) throws SQLException {
        conn.setAutoCommit(false);
        Statement update =  conn.createStatement();
        update.execute(updateRequest);
        int updated = update.getUpdateCount();
        update.close();
        conn.commit();
        return updated;
    }

    public <T> T execQuery  (Connection conn, String query, iresultHandler <T> handler) throws SQLException {

        Statement stm;
        stm = conn.createStatement();
        ResultSet result = stm.executeQuery(query);
        T out= handler.handle(result);

        stm.close();
        return out;
    }

}
