import java.sql.*;
public class insert_delete_search {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ) {

            String sqlDelete = "delete from book where id>= 1002 and id<=1004";
            System.out.println("The SQL statement is: "+sqlDelete);
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted+" record delete\n");


            String sqlInsert = "insert into book values "+"(3002,'Gone Fishing 2','Kumar',22.22,22),"
                    +"(3003,'sGone Fishing 3','Kumar',33.33,33)";
            System.out.println("The SQL statement is: "+sqlInsert);
            int coutInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(coutInserted+" records inserted\n");

            String strSelect = "select * from book";
            System.out.println("The SQL statement is: "+strSelect);
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                System.out.println(rset.getInt("id")+", "
                +rset.getString("author")+", "
                +rset.getString("title")+", "
                +rset.getDouble("price")+", "
                +rset.getInt("qty"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

