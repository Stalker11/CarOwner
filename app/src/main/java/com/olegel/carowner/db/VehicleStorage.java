package com.olegel.carowner.db;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.olegel.carowner.models.VehicleModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleg on 27.08.2017.
 */

public class VehicleStorage {
    private Context context;
    private PreparedQuery<VehicleModel> prepared;
    private QueryBuilder<VehicleModel, Long> searchBy;
    private static final String TAG = VehicleModel.class.getSimpleName();

    public VehicleStorage(Context context) {
        this.context = context;
    }

    /**
     * Method write or update info in db
     *
     * @param vehicle object for writing
     */
    public void write(VehicleModel vehicle) {
        try {
            HelperFactory.getHelper().getDaoVehicle().createOrUpdate(vehicle);
            Log.d(TAG, "write:vehicle ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read all data from table
     *
     * @return list objects
     */
    public List<VehicleModel> readAll() {
        List<VehicleModel> vehicles = null;
        try {
            vehicles = HelperFactory.getHelper().getDaoVehicle().queryForAll();
            Log.d(TAG, "readAll: vehicle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    /**
     * Select object using query parameters
     *
     * @param columnName columnName
     * @param parameter  parameter for sorting data
     * @return list objects
     */
    public List<VehicleModel> selectBy(String columnName, String parameter) {
        List<VehicleModel> vehicles = null;
        try {
            searchBy = HelperFactory.getHelper().getDaoVehicle().queryBuilder();
            searchBy.where().like(columnName, generateRequestString(parameter));
            prepared = searchBy.prepare();
            vehicles = HelperFactory.getHelper().getDaoVehicle().query(prepared);
            Log.d(TAG, "selectBy: vehicle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    /**
     * Delete object from db
     *
     * @param vehicle object then will be deleting
     */
    public void delete(VehicleModel vehicle) {
        try {
            int deleted = HelperFactory.getHelper().getDaoVehicle().delete(vehicle);
            Log.d(TAG, "deleteFilm:vehicle " + deleted);
        } catch (SQLException e) {
            Log.d(TAG, "deleteFilm error: ");
        }
    }

    /**
     * Generate special request for request
     */
    private String generateRequestString(String request) {
        StringBuilder builder = new StringBuilder();
        builder.append("%")
                .append(request)
                .append("%");
        return builder.toString();
    }
}
