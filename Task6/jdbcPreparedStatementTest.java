import java.sql.*;

public class jdbcPreparedStatementTest {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop","root","");
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into book values (?, ?, ?, ?, ?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from book");
                ) {

            pstmt.setInt(1,7001);
            pstmt.setString(2,"Mahjong 101");
            pstmt.setString(3,"Kumar");
            pstmt.setDouble(4,88.88);
            pstmt.setInt(5,88);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "row affected.");

            pstmt.setInt(1,7002);
            pstmt.setString(2,"Mahjong 102");

            rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "row affected.");

            ResultSet rset = pstmtSelect.executeQuery();
            while (rset.next()){
                System.out.println(rset.getInt("id")+", "
                        +rset.getString("author")+", "
                        +rset.getString("title")+", "
                        +rset.getDouble("price")+", "
                        +rset.getInt("qty"));
            }

            //addBatch()
//            conn.setAutoCommit(false);
//            pstmt.setInt(1,8003);
//            pstmt.setString(2,"Java 123");
//            pstmt.setString(3,"kevin Jones");
//            pstmt.setDouble(4,12.34);
//            pstmt.setInt(5,88);
//            pstmt.addBatch();
//
//            pstmt.setInt(1,8004);
//            pstmt.setString(2,"Java 456");
//            pstmt.addBatch();
//
//            int[] returnCodes = pstmt.executeBatch();
//
//            System.out.println("return coes are: ");
//            for (int code:returnCodes) System.out.println(code + ", ");
//            System.out.println();
//            conn.commit();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
