
package sewaapartemen;
import java.util.ArrayList;
import java.util.Scanner;
import Model.*;
import Entity.*;


public class budi07154_SewaApartemen {

    static Scanner input = new Scanner(System.in);
    static ArrayList <budi07154_PemesananModel> pesan = new ArrayList();
    static ArrayList <budi07154_TransaksiModel> trans = new ArrayList();
    static budi07154_ModelKaryawan Karyawan = new budi07154_ModelKaryawan();
    static budi07154_StokModel stok = new budi07154_StokModel();
    static ArrayList <budi07154_ApartemenEntity> tempTotalSewa = new ArrayList(); // data temporary hanya bersifat sementara
    public static void main(String[] args) {
        int pil;
        data_karyawan();
        data_stok_apartemen();
        do{
        System.out.println("1. Sales");
        System.out.println("2. Kasir");
        System.out.println("0. Exit");
        System.out.print("Pilih -> ");
        pil = input.nextInt();
        switch (pil){
            case 1:
                pemesanan();
                break;
            case 2:
                transaksi();
                break;
        }
        }while(pil!=0);
    }
    
    //data karyawan statis
    public static void data_karyawan(){
        String id_sales[] = {"1","2"};
        String nama_sales[] = {"Budi", "Satria"};
        String pass_sales[] = {"1","1"};
        
        String id_kasir[] = {"1","2"};
        String nama_kasir[] = {"Nana", "Ruby"};
        String pass_kasir[] = {"1",""};
        
        for(int i=0;i<id_sales.length;i++){
            Karyawan.insert_karyawan(new budi07154_SalesEntity(id_sales[i],nama_sales[i],pass_sales[i]), 
                    new budi07154_KasirEntity(id_kasir[i],nama_kasir[i],pass_kasir[i]));
        }
        
    }
    
    //data apartemen statis
    public static void data_stok_apartemen(){
        String nama_apartemen[] = {"Gunawangsa","Manyar","Hills"};
        Double harga_apartemen[] = {5000000.0,7000000.0,3000000.0};
        for(int i=0;i<nama_apartemen.length;i++){
            stok.insert_stok(new budi07154_ApartemenEntity(nama_apartemen[i],harga_apartemen[i]));
        }
    }
    
 
    public static void pemesanan(){
        System.out.println("Login Sales");
        System.out.print("Nama Sales = ");
        String nama_sales = input.next();
        System.out.print("Password Sales = ");
        String pass_sales = input.next();
        int index=0,pil;
        String ulang;
        boolean ketemu = false;
        for(int i= 0;i<Karyawan.getDataSales().size();i++){
            if(nama_sales.equals(Karyawan.getDataSales().get(i).getNama())&&
                    pass_sales.equals(Karyawan.getDataSales().get(i).getPassword())){
                index = i;
                ketemu = true;
            }
        }
        if(ketemu == true){
            do{
                System.out.println("1. input data pesanan");
                System.out.println("2. logout");
                System.out.print("pilih = ");
                pil = input.nextInt();
                if (pil==1){
                    System.out.print("Id Pesan = ");
                    String id_pesan = input.next();
                    System.out.print("Nama Pelanggan = ");
                    String nama_pel = input.next();

                    do{
                    System.out.println("pilih apartemen");
                    for(int i=0;i<stok.getStok().size();i++){
                        System.out.println(i+" "+stok.getStok().get(i).getNama_apartemen()+" "+stok.getStok().get(i).getHarga_apartemen());
                    }
                        System.out.print("pilih = ");
                        int pilih = input.nextInt();
                        tempTotalSewa.add(stok.getStok().get(pilih));
                        System.out.println("sewa lagi ? (y/n) = ");
                        ulang = input.next();
                    }while(ulang.equals("y")||ulang.equals("Y"));

                    pesan.add(new budi07154_PemesananModel(id_pesan,nama_pel,Karyawan.getDataSales().get(index),tempTotalSewa));
                    tempTotalSewa = new ArrayList();
                }
            }while(pil!=2);
            view_pesan();
        }else{
            System.out.println("nama dan password tidak cocok");
        }
        
    }
    
    public static void view_pesan(){
        for(int i=0;i<pesan.size();i++){
            System.out.println("nama penyewa = "+pesan.get(i).getNama());
            System.out.println("nama sales = "+pesan.get(i).getSales().getNama());
            System.out.println("apartemen pesanan");
            for(int j=0;j<pesan.get(i).getTotalSewa().size();j++){
                System.out.println(pesan.get(i).getTotalSewa().get(j).getHarga_apartemen()+(j+1)+pesan.get(i).getTotalSewa().get(j).getNama_apartemen()+". "+" || ");
            }
            System.out.println("Total Harga = "+pesan.get(i).total_harga());
        }
    }
    public static void transaksi(){
        System.out.print("Nama Kasir = ");
        String nama_kasir = input.next();
        System.out.print("Password Kasir = ");
        String pass_kasir = input.next();
        int index=0,pil;
        boolean ketemu = false;
        double total = 0;
        for(int i= 0;i<Karyawan.getDataKasir().size();i++){
            if(nama_kasir.equals(Karyawan.getDataKasir().get(i).getNama())&&
                    pass_kasir.equals(Karyawan.getDataKasir().get(i).getPassword())){
                index = i;
                ketemu = true;
            }
        }
        if(ketemu == true){
            System.out.println("1. Transaksi");
            System.out.println("2. Logout");
            System.out.print("Pilih = ");
            pil = input.nextInt();
            if(pil==1){
                System.out.print("Id Pesan = ");
                String id_pesan = input.next();
                for(int i = 0;i<pesan.size();i++){
                    if(id_pesan.equals(pesan.get(i).getId_pesan())){
                        System.out.println("Nama Penyewa = "+pesan.get(i).getNama());
                        System.out.println("Nama Sales = "+pesan.get(i).getSales().getNama());
                        total = pesan.get(i).total_harga();
                        view_pesan();
                    }
                }
                System.out.print("Bayar = ");
                double bayar=input.nextDouble();
                System.out.println("Sistem Bayar = ");
                for(int i=0;i<budi07154_PembayaranEntity.apartemen.length;i++){
                    System.out.println(i+". "+budi07154_PembayaranEntity.apartemen[i]);
                }
                System.out.print("Pilih = ");
                int pilih = input.nextInt();
                trans.add(new budi07154_TransaksiModel(Karyawan.getDataKasir().get(index),pilih));
                System.out.println("Kembali = "+(bayar-total));
            }
        }else{
            System.out.println("nama atau password tidak cocok");
        }
    }
}

