import java.sql.*;
public class jdbcSelectTest {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ) {
            //1//
            String strSelect = "select * from book";
            System.out.println("The SQL statement is: "+strSelect);

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(id+", "+title+", "+author+", "+price+", "+qty);
            }
            System.out.println("\n");

            //2//
            strSelect = "select title,author,price from book where author = 'CodeLean VN'";
            System.out.println("The SQL statement is: "+strSelect);

            rset = stmt.executeQuery(strSelect);

            System.out.println("The records select are: ");
            while (rset.next()){
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                System.out.println(title+", "+author+", "+price+", ");
            }
            System.out.println("\n");

            //3//
            strSelect = "SELECT title,author,price,qty FROM book WHERE author = 'CodeLean VN' OR price >=30 ORDER BY price DESC,id ASC;";
            System.out.println("The SQL statement is: "+strSelect);

            rset = stmt.executeQuery(strSelect);

            System.out.println("The records select are: ");
            while (rset.next()){
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title+", "+author+", "+price+", "+qty);
            }
            System.out.println("\n");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

