import  java.sql.*;
public class jdbcCommitCatchTest {
    public static void main(String[] args) throws SQLException {
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
            Statement stmt = conn.createStatement();
        ){
            try {
                conn.setAutoCommit(false);

                stmt.executeUpdate("insert into book values (4001,'Paul Chan','Mahjong',44.44,44)");
                stmt.executeUpdate("insert into book values (4002,'Peter Chan','Mahjong',55.55,55)");
                conn.commit();


            } catch (SQLException ex){
                System.out.println("--Rolling back changes--");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
