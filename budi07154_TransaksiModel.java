
package Model;

import Entity.budi07154_KasirEntity;
import Entity.budi07154_PembayaranEntity;
public class budi07154_TransaksiModel {
    budi07154_KasirEntity kasir;
    int index_bayar;

    public budi07154_KasirEntity getKasir() {
        return kasir;
    }

    public int getIndex_bayar() {
        return index_bayar;
    }

    public budi07154_TransaksiModel(budi07154_KasirEntity kasir, int index_bayar) {
        this.kasir = kasir;
        this.index_bayar = index_bayar;
    }
    public double kembalian(double harga,double bayar){
        double kembali;
        kembali = bayar-harga;
        return kembali;
    }
}
