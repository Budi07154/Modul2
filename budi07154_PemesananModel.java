
package Model;

import Entity.budi07154_SalesEntity;
import Entity.budi07154_ApartemenEntity;
import java.util.ArrayList;
public class budi07154_PemesananModel {
    private String id_pesan,nama;
    private budi07154_SalesEntity sales;
    private ArrayList <budi07154_ApartemenEntity> TotalSewa = new ArrayList();
    
    public budi07154_PemesananModel(String id_pesan, String nama, budi07154_SalesEntity sales, ArrayList<budi07154_ApartemenEntity> TotalSewa) {
        this.id_pesan = id_pesan;
        this.nama = nama;
        this.sales = sales;
        this.TotalSewa = TotalSewa;
    }

    public String getId_pesan() {
        return id_pesan;
    }

    public String getNama() {
        return nama;
    }

    public budi07154_SalesEntity getSales() {
        return sales;
    }

    public ArrayList<budi07154_ApartemenEntity> getTotalSewa() {
        return TotalSewa;
    }
    public double total_harga(){
        double total = 0;
        for(int i=0;i<TotalSewa.size();i++){
            total = total + TotalSewa.get(i).getHarga_apartemen();
        }
        return total;
    }
}

