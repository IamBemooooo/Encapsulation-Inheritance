package org.example;

import Models.BanDoc;
import Models.QLMuonSach;
import Models.Sach;

import java.io.Console;
import java.util.Scanner;

public class Main {
    private static BanDoc[] banDocs = new BanDoc[100];
    private static Sach[] sachs = new Sach[100];
    private static QLMuonSach[] qlMuonSachs = new QLMuonSach[100];
    private static int IndexSach = 0;
    private static int IndexBanDoc = 0;
    private static int IndexQLMS = 0;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    ThemSach();
                    InSach();
                    break;
                case 2:
                    ThemBanDoc();
                    InBanDoc();
                    break;
                case 3:
                    ThemSachMuon();
                    InSachMuon();
                    break;
                case 4:
                    sapXepTheoTen();
                    InSachMuon();
                    break;
                case 5:
                    sapXepTheoSoLuong();
                    InSachMuon();
                    break;
                case 6:
                    TimKiem();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Nhập danh sách đầu sách mới . In ra danh sách các đầu sách đã có.");
        System.out.println("2. Nhập danh sách bạn đọc mới. In ra danh sách bạn đọc đã có.");
        System.out.println("3. Lập bảng QL mượn sách.");
        System.out.println("5. Sắp xếp danh sách Quản lý mượn sách theo tên bạn đọc.");
        System.out.println("5. Sắp xếp danh sách Quản lý mượn sách theo số lượng.");
        System.out.println("6. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc.");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void ThemSach()
    {
        System.out.print("Số lượng sách muốn nhập: ");
        int soluong = sc.nextInt();
        for (int i = 0; i < soluong; i++)
        {
            System.out.println("Nhập sách thứ " + (i+1) + ": ");
            System.out.println("Tên sách: ");
            String tenSach = sc.nextLine();
            if(tenSach.equals(""))
            {
                tenSach = sc.nextLine();
            }
            System.out.println("Tác giả: ");
            String tacGia = sc.nextLine();
            System.out.println("Chuyên ngành: ");
            String chuyenNganh = sc.nextLine();
            System.out.println("Năm xuất bản: ");
            int namXuatBan = Integer.parseInt(sc.nextLine());
            IndexSach++;
            sachs[IndexSach] = new Sach(tenSach,tacGia,chuyenNganh,namXuatBan);
        }
    }

    private static void InSach()
    {
        System.out.println("Danh sách đầu sách hiện có");
        for(int i = 0; i < sachs.length; i++)
        {
            if(sachs[i] != null)
            {
                System.out.println(sachs[i].toString());
            }
        }
    }

    public static void ThemBanDoc()
    {
        System.out.print("Số lượng bạn đọc muốn nhập: ");
        int soluong = sc.nextInt();
        for (int i = 0; i < soluong; i++)
        {
            System.out.println("Nhập bạn đọc thứ " + (i+1) + ": ");
            System.out.print("Họ tên: ");
            String hoTen = sc.nextLine();
            if(hoTen.equals(""))
            {
               hoTen = sc.nextLine();
            }
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("SĐT: ");
            String sdt = sc.nextLine();
            System.out.print("Loại bạn đọc (sinh viên, học viên cao học, giáo viên): ");
            String loaiBanDoc = sc.nextLine();
            IndexBanDoc++;
            banDocs[IndexBanDoc] = new BanDoc(hoTen,diaChi,sdt,loaiBanDoc);
        }
    }

    private static void InBanDoc()
    {
        System.out.println("Danh sách bạn đọc hiện có");
        for(int i = 0; i < banDocs.length; i++)
        {
            if(banDocs[i] != null)
            {
                System.out.println(banDocs[i].toString());
            }
        }
    }

    private static Sach getSach(int maS)
    {
        for(int i = 0; i < sachs.length; i++)
        {
            if(sachs[i] != null)
            {
                if(sachs[i].getMaSach() == maS)
                {
                    return sachs[i];
                }
            }
        }
        return null;
    }

    private static BanDoc getBanDoc(int maS)
    {
        for(int i = 0; i < banDocs.length; i++)
        {
           if(banDocs[i] != null)
           {
               if(banDocs[i].getMaBanDoc()== maS)
               {
                   return banDocs[i];
               }
           }
        }
        return null;
    }

    private static void ThemSachMuon()
    {
        int maS =  Integer.parseInt(sc.nextLine());
        int maBD =  Integer.parseInt(sc.nextLine());
        int soluong =  Integer.parseInt(sc.nextLine());

        try {
            if(getSach(maS) == null || getBanDoc(maBD) == null)
            {
                throw new Error("Sách hoặc bạn đọc không tồn tại");
            }
            if(soluong > 3){
                throw new Error("Mỗi đầu sách không được mượn quá 3 cuốn");
            }
            for(int i = 0; i < IndexQLMS; i++){
                if(qlMuonSachs[i].getIdSach()==maS && qlMuonSachs[i].getIdBanDoc()==maBD){
                    throw new Error("Bản ghi đã tồn tại");
                }
            }
            for(int i = 0; i < IndexQLMS; i++){
                int dem = 0;
                for(int j = 0; j < IndexQLMS; j++){
                    if(qlMuonSachs[i].getIdBanDoc()==qlMuonSachs[j].getIdBanDoc()){
                        dem++;
                    }

                }
                if(dem > 5) throw new Error("Mỗi bạn đọc không được mượn quá 5 đầu sách khác nhau");
            }
            QLMuonSach sm = new QLMuonSach(maS, maBD, soluong);
            qlMuonSachs[IndexQLMS++] = sm;
        }catch (Error e){
            System.out.println(e);
        }
    }

    private static void InSachMuon()
    {
        Sach s = new Sach();
        BanDoc bd = new BanDoc();
        for(int i = 0; i < IndexQLMS; i++){
           if(qlMuonSachs[i] != null)
           {
               s = getSach(qlMuonSachs[i].getIdSach());
               bd = getBanDoc(qlMuonSachs[i].getIdBanDoc());
               System.out.println(bd.getHoTen()+" "+ s.getTenSach()+" "+ qlMuonSachs[i].getSoLuong());
           }
        }
    }

    private static void TimKiem()
    {
        int count = 0;
        String Ten = sc.nextLine();
        BanDoc[] bd = new BanDoc[100];
        for(int i = 0; i < banDocs.length; i++)
        {
            if(banDocs[i] != null)
            {
                if(banDocs[i].getHoTen() == Ten)
                {
                    count++;
                    bd[count] = banDocs[i];
                }
            }
        }

        for(int i = 0; i < bd.length; i++)
        {
            if(bd[i] != null)
            {
                System.out.println("Ban doc "+ bd[i].getHoTen()+" da muon nhung cuon sach sau:");
                for(int j = 0; j < IndexQLMS; j++){
                    if(qlMuonSachs[j].getIdBanDoc()== bd[j].getMaBanDoc()){
                        Sach s = getSach(qlMuonSachs[j].getIdSach());
                        System.out.println(s.getTenSach()+" , so luong muon:"+qlMuonSachs[j].getSoLuong());
                    }
                }
            }
        }
    }

    public static void sapXepTheoSoLuong(){
        for(int i = 0; i < IndexQLMS-2; i++){
            for(int j = i+1; j < IndexQLMS-1; j++){
                if(qlMuonSachs[i].getSoLuong() < qlMuonSachs[j].getSoLuong()){
                    QLMuonSach tmp = qlMuonSachs[i];
                    qlMuonSachs[i] = qlMuonSachs[j];
                    qlMuonSachs[j] = tmp;
                }
            }
        }
    }

    public static void sapXepTheoTen(){
        for(int i = 0; i < IndexQLMS-2; i++){
            BanDoc bd = getBanDoc(qlMuonSachs[i].getIdBanDoc());
            for(int j = i+1; j < IndexQLMS-1; j++){
                BanDoc bd1 = getBanDoc(qlMuonSachs[j].getIdBanDoc());
                if(bd.getHoTen().compareToIgnoreCase(bd1.getHoTen()) > 0){
                    QLMuonSach tmp = qlMuonSachs[i];
                    qlMuonSachs[i] = qlMuonSachs[j];
                    qlMuonSachs[j] = tmp;
                }
            }
        }
    }
}