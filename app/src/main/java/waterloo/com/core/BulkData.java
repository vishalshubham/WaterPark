package waterloo.com.core;

import java.util.ArrayList;

/**
 * Created by Vishal on 25/10/2015.
 */
public class BulkData {
    ArrayList<LocationData> bulkData = new ArrayList<LocationData>();

    public ArrayList<LocationData> getBulkData() {
        return bulkData;
    }

    public void setBulkData(ArrayList<LocationData> bulkData) {
        this.bulkData = bulkData;
    }
}
