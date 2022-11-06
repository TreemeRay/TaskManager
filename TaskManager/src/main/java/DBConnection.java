import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    protected static Connection con = null;
    protected static DBConnection database = null;


    DBConnection(){
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stefanini", "root", "root");
            if (this.con == null){
                System.out.println("The program is not working;");
            }

        }catch (Exception var2){
            var2.printStackTrace();
        }
    }
    public static DBConnection instance(){
        if (database == null){
            database = new DBConnection();
        }
        return database;
    }
}
