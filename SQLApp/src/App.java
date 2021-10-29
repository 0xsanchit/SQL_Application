import java.sql.Connection;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        SQLConnection sqlConnection = new SQLConnection();
        boolean status = sqlConnection.connect("root", "rootpassword");
        if (status == true) {
            ResultSet resultSet = sqlConnection.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            sqlConnection.closeConnection();
        } else {
            System.out.println("Connection Failed");
        }

    }
}
