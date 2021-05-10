import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface iresultHandler <T>{

     public  T handle (ResultSet rSet) throws SQLException;

}
