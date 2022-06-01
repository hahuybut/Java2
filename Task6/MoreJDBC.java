import java.sql.*;
public class MoreJDBC {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ) {
            conn.setAutoCommit(false); //Tắt commit tự động//
            ResultSet rset = stmt.executeQuery("select id, qty from book where id in (1001,1002)");
            System.out.println("--Before UPDATE--");
            while (rset.next()){
                System.out.println(rset.getInt("id")+", "+rset.getInt("qty"));
            }
            conn.commit();

            stmt.executeUpdate("update book set qty = qty + 1 where id = 1001");
            stmt.executeUpdate("update book set qty = qty + 1 where id = 1002");
            conn.commit();

            rset = stmt.executeQuery("select id, qty from book where id in (1001,1002)");
            System.out.println("--AFTER UPDATE--");
            while (rset.next()){
                System.out.println(rset.getInt("id")+", "+rset.getInt("qty"));
            }
            conn.commit();

            stmt.executeUpdate("update book set qty = qty - 99 where id =1001");
            stmt.executeUpdate("update book set qty = qty - 99 where id = 1002");
            conn.rollback();//bỏ qua tất cả kể từ lần commit gần nhất//

            rset = stmt.executeQuery("select id, qty from book where id in (1001,1002)");
            System.out.println("--AFTER UPDATE AND ROlLBACK--");
            while (rset.next()){
                System.out.println(rset.getInt("id")+", "+rset.getInt("qty"));
            }
            conn.commit();

            //addBatch()
            stmt.addBatch("insert into book values (8001,'Java ABC','Kevin Jones',1.1,99)");
            stmt.addBatch("insert into book values (8002,'Java XYZ','Kevin Jones',1.1,99)");
            stmt.addBatch("update book set price = 11.11 where id = 8001 and id = 8002");

            int[] returnCodes = stmt.executeBatch();

            System.out.println("Return codes are: ");
            for (int code:returnCodes){
                System.out.println(code+", ");
            }
            System.out.println();
            conn.commit();


        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}