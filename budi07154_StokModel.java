
package Model;
import Entity.budi07154_ApartemenEntity;
import java.util.ArrayList;

public class budi07154_StokModel {
    private ArrayList <budi07154_ApartemenEntity> stok;
    
    public budi07154_StokModel(){
        stok = new ArrayList();
    }
    
    public void insert_stok(budi07154_ApartemenEntity apartemen){
        stok.add(apartemen);
    }

    public ArrayList<budi07154_ApartemenEntity> getStok() {
        return stok;
    }
}
