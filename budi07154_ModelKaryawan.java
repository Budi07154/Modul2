
package Model;

import Entity.budi07154_KasirEntity;
import Entity.budi07154_SalesEntity;
import java.util.ArrayList;
//relasi realization dgn interfaces
public class budi07154_ModelKaryawan implements budi07154_KaryawanInterfaces{
    ArrayList <budi07154_SalesEntity> dataSales;
    ArrayList <budi07154_KasirEntity> dataKasir;
    
    // composition dari SalesEntity dan KasirEntity membentuk satu class karyawanmodel
    public budi07154_ModelKaryawan(){
        dataSales = new ArrayList();
        dataKasir = new ArrayList();
    }
    
    //polymorphism override karena memiliki method yang sama seperti interfaces
    
    @Override
    public void insert_karyawan(budi07154_SalesEntity sales,budi07154_KasirEntity kasir){
        dataSales.add(sales);
        dataKasir.add(kasir);
    }

    @Override
    public ArrayList<budi07154_SalesEntity> getDataSales() {
        return dataSales;
    }

    @Override
    public ArrayList<budi07154_KasirEntity> getDataKasir() {
        return dataKasir;
    }

}
