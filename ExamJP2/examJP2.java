import java.sql.*;
import java.util.Scanner;

public class examJP2 {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/exam", "root", "");
                PreparedStatement pstmtInsert = conn.prepareStatement("insert into RapChieuPhim values (?, ?, ?, ?, ?)");
                PreparedStatement pstmtUpdate = conn.prepareStatement("update RapChieuPhim set MaSoPhim = ? where TenPhim = ?");
                PreparedStatement pstmtDelete = conn.prepareStatement("delete from RapChieuPhim where TenPhim = ?");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from RapChieuPhim where TenPhim = ?");
                PreparedStatement pstmtUpdate1 = conn.prepareStatement("update RapChieuPhim set ThoiGianKhoiChieu = ? where TenPhim = ?")
        ) {

            conn.setAutoCommit(false);


            try {
                int chon;
                int chon1;
                String MaSoPhim;
                String TenPhim;
                String  Date;
                String DaoDien;
                int DoDai;
                Scanner ip = new Scanner(System.in);
                do {
                    System.out.println("Chon muc muon thuc hien: ");
                    System.out.println("1.Them\n2.Sua\n3.Xoa\n4.Tim kiem");
                    chon = ip.nextInt();
                    if (chon == 1 ){
                        System.out.println("-------Them-------");
                        System.out.println("Nhap thong tin: ");
                        ip.nextLine();
                        System.out.println("\nMa phim: ");
                        MaSoPhim = ip.nextLine();
                        System.out.println("\nTen phim: ");
                        TenPhim = ip.nextLine();
                        System.out.println("\nThoi gian khoi chieu:  ");
                        Date = ip.nextLine();
                        System.out.println("\nDao dien: ");
                        DaoDien = ip.nextLine();
                        System.out.println("\nDo Dai: ");
                        DoDai = ip.nextInt();
                        pstmtInsert.setString(1, MaSoPhim);
                        pstmtInsert.setString(2, TenPhim);
                        pstmtInsert.setString(3, Date);
                        pstmtInsert.setString(4, DaoDien);
                        pstmtInsert.setInt   (5, DoDai);
                        pstmtInsert.executeUpdate();
                        System.out.println("Them phim thanh cong.");
                    }
                    else if (chon == 2){
                        System.out.println("-------Sua-------");
                        ip.nextLine();
                        System.out.println("Nhap ten phim muon sua: ");
                        TenPhim = ip.nextLine();
                        System.out.println("\nBan muon sua thong tin gi:");
                        System.out.println("1.Ma So Phim\n2.Thoi Gian Khoi Chieu\n3.Dao Dien\n4.Do Dai");
                        chon1 = ip.nextInt();
                        if (chon1 == 1){
                            System.out.println("-------Sua Ma phim-------");
                            ip.nextLine();
                            System.out.println("Nhap ma phim: ");
                            MaSoPhim = ip.nextLine();
                            pstmtUpdate.setString(1, MaSoPhim);
                            pstmtUpdate.setString(2, TenPhim);
                            pstmtUpdate.executeUpdate();
                        }
                        if (chon1 == 2){
                            System.out.println("Sua Thoi Gian Khoi Chieu");
                            ip.nextLine();
                            System.out.println("Nhap thoi gian khoi chieu: ");
                            Date = ip.nextLine();
                            pstmtUpdate1.setString(1,Date);
                            pstmtUpdate1.setString(2,TenPhim);
                            pstmtUpdate1.executeUpdate();
                        }
                        if (chon1 == 3){
                            System.out.println("Sua Ten Dao Dien: ");
                            ip.nextLine();
                            System.out.println("Nhap ten dao dien: ");
                            DaoDien = ip.nextLine();
                            pstmtUpdate1.setString(1,DaoDien);
                            pstmtUpdate1.setString(2,TenPhim);
                        }
                        if (chon1 == 4){
                            System.out.println("Sua Do Dai Phim: ");
                            ip.nextLine();
                            System.out.println("Nhap do dai phim: ");
                            DoDai = ip.nextInt();
                            pstmtUpdate1.setInt(1,DoDai);
                            pstmtUpdate1.setString(2,TenPhim);
                        }
                    }
                    else if (chon == 3){
                        System.out.println("-------Xoa-------");
                        ip.nextLine();
                        System.out.println("\nNhap ten phim muon xoa: ");
                        TenPhim = ip.nextLine();
                        pstmtDelete.setString(1, TenPhim);
                        pstmtDelete.executeUpdate();
                    }
                    else if (chon == 4){
                        System.out.println("-------Tim Kiem-------");
                        ip.nextLine();
                        System.out.println("\nNhap ten phim muon tim: ");
                        TenPhim = ip.nextLine();
                        pstmtSelect.setString(1, TenPhim);
                        ResultSet rset = pstmtSelect.executeQuery();
                        while (rset.next()){
                            System.out.println(rset.getString("MaSoPhim") + ", "
                                    + rset.getString("TenPhim") + ", "
                                    + rset.getString("ThoiGianKhoiChieu") + ", "
                                    + rset.getString("DaoDien") + ", "
                                    + rset.getInt("DoDai"));
                        }
                    }
                    conn.commit();
                    System.out.println("Ban co muon tiep tuc khong: ");
                    System.out.println("5.Co\n6.Khong");
                    chon = ip.nextInt();
                    if (chon == 6){
                        break;
                    }
                }while (chon != 1 || chon != 2 || chon != 3 || chon != 4 || chon != 5);

            } catch (SQLException ex) {
                System.out.println("Chon sai.");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}