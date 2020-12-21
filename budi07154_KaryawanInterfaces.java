
package Model;

import Entity.budi07154_KasirEntity;
import Entity.budi07154_SalesEntity;
import java.util.ArrayList;

public interface budi07154_KaryawanInterfaces {
    public void insert_karyawan(budi07154_SalesEntity sales,budi07154_KasirEntity kasir);
    public ArrayList<budi07154_SalesEntity> getDataSales();
    public ArrayList<budi07154_KasirEntity> getDataKasir();   
}
