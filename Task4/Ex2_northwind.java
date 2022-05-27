import java.beans.Customizer;
import java.sql.*;
import java.util.Scanner;

public class Ex2_northwind {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            //Ex1//
            System.out.println("Ex 1: ");
            String strSelect = "select * from customers";
            System.out.println("The SQL statement is: " + strSelect);
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records select are: ");
            while (rset.next()) {
                String CustomerID = rset.getString("CustomerID");
                String CompanyName = rset.getString("CompanyName");
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                String Address = rset.getString("Address");
                String  City= rset.getString("City");
                String Region = rset.getString("Region");
                String  PostalCode= rset.getString("PostalCode");
                String Country = rset.getString("Country");
                String Phone = rset.getString("Phone");
                String Fax = rset.getString("Fax");
                System.out.println(CustomerID+", "+CompanyName+", "+ContactName+", "+ContactTitle+", "+Address+", "+City+", "+Region+", "+PostalCode+", "+Country+", "+Phone+", "+Fax);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n");

            //Ex2//
            System.out.println("Ex2: ");
            Scanner searchName = new Scanner(System.in);
            System.out.println("Nhap ten khach hang muon tim kiem: ");
            String srchName = searchName.nextLine();
            strSelect = "select * from customers where ContactName like '%"+srchName+"%'";
            System.out.println("The SQL statement is: " + strSelect);
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records select are: ");
            while (rset.next()) {
                String CustomerID = rset.getString("CustomerID");
                String CompanyName = rset.getString("CompanyName");
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                String Address = rset.getString("Address");
                String  City= rset.getString("City");
                String Region = rset.getString("Region");
                String  PostalCode= rset.getString("PostalCode");
                String Country = rset.getString("Country");
                String Phone = rset.getString("Phone");
                String Fax = rset.getString("Fax");
                System.out.println(CustomerID+", "+CompanyName+", "+ContactName+", "+ContactTitle+", "+Address+", "+City+", "+Region+", "+PostalCode+", "+Country+", "+Phone+", "+Fax);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n");

            //Ex3//
            System.out.println("Ex 3: ");
            strSelect = "select * from products";
            System.out.println("The SQL statement is: " + strSelect);
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records select are: ");
            while (rset.next()) {
                int ProductID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");
                int SupplierID = rset.getInt("SupplierID");
                int CategoryID = rset.getInt("CategoryID");
                String QuantityPerUnit = rset.getString("QuantityPerUnit");
                double  UnitPrice = rset.getDouble("UnitPrice");
                int UnitsInStock = rset.getInt("UnitsInStock");
                int UnitsOnOrder = rset.getInt("UnitsOnOrder");
                int ReorderLevel = rset.getInt("ReorderLevel");
                int Discontinued = rset.getInt("Discontinued");
                System.out.println(ProductID+", "+ProductName+", "+SupplierID+", "+CategoryID+", "+QuantityPerUnit+", "+UnitPrice+", "+UnitsInStock+", "+UnitsOnOrder+", "+ReorderLevel+", "+Discontinued);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n");

            //Ex4//
            System.out.println("Ex 4: ");
            System.out.println("Nhap vao gia nho nhat: ");
            Scanner gia1 = new Scanner(System.in);
            double min = gia1.nextDouble();
            System.out.println("Nhap vao gia lon nhat: ");
            Scanner gia2 = new Scanner(System.in);
            double max = gia2.nextDouble();
            strSelect = "select * from products where UnitPrice >= "+min+" and UnitPrice <= "+max;
            System.out.println("The SQL statement is: " + strSelect);
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records select are: ");
            while (rset.next()) {
                int ProductID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");
                double  UnitPrice = rset.getDouble("UnitPrice");
                int UnitsInStock = rset.getInt("UnitsInStock");
                int UnitsOnOrder = rset.getInt("UnitsOnOrder");
                int ReorderLevel = rset.getInt("ReorderLevel");
                int Discontinued = rset.getInt("Discontinued");
                System.out.println(ProductID+", "+ProductName+", "+UnitPrice+", "+UnitsInStock+", "+UnitsOnOrder+", "+ReorderLevel+", "+Discontinued);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n");

            //Ex5//
            System.out.println("Ex 5: ");
            strSelect = "select * from order";
            System.out.println("The SQL statement is: " + strSelect);
            rset = stmt.executeQuery(strSelect);
            System.out.println("The records select are: ");
            while (rset.next()) {
                int OrderID = rset.getInt("OrderID");
                String CustomerID = rset.getString("CustomerID");
                int EmployeeID = rset.getInt("EmployeeID");
                String OrderDate = rset.getString("OrderDate");
                String RequiredDate = rset.getString("RequiredDate");
                String  ShippedDate = rset.getString("ShippedDate");
                int ShipVia = rset.getInt("ShipVia");
                double Freight = rset.getDouble("Freight");
                String ShipName = rset.getString("ShipName");
                String ShipAddress = rset.getString("ShipAddress");
                String ShipCity = rset.getString("ShipCity");
                String ShipRegion = rset.getString("ShipRegion");
                String ShipPostalCode  = rset.getString("ShipPostalCode ");
                String ShipCountry  = rset.getString("ShipCountry ");
                System.out.println(OrderID+", "+CustomerID+", "+EmployeeID+", "+OrderDate+", "+RequiredDate+", "+ShippedDate+", "+ShipVia+", "+Freight+", "+ShipName+", "+ShipAddress+", "+ShipCity+", "+ShipRegion+", "+ShipPostalCode+", "+ShipCountry);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}