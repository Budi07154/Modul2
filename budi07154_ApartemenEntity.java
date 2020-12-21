
package Entity;

public class budi07154_ApartemenEntity {
    protected String nama_apartemen;
    protected double harga_apartemen;

    public budi07154_ApartemenEntity(String nama_apartemen, double harga_apartemen) {
        this.nama_apartemen = nama_apartemen;
        this.harga_apartemen = harga_apartemen;
    }

    public String getNama_apartemen() {
        return nama_apartemen;
    }

    public double getHarga_apartemen() {
        return harga_apartemen;
    }
    
}
