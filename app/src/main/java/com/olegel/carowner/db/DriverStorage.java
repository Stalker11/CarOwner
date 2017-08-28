package com.olegel.carowner.db;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.olegel.carowner.models.DriverModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleg on 27.08.2017.
 */

public class DriverStorage {
    private Context context;
    private PreparedQuery<DriverModel> prepared;
    private QueryBuilder<DriverModel, Long> searchBy;
    private static final String TAG = DriverStorage.class.getSimpleName();

    public DriverStorage(Context context) {
        this.context = context;
    }

    /**
     * Method write or update info in db
     *
     * @param driver object for writing
     */
    public void write(DriverModel driver) {
        try {
            HelperFactory.getHelper().getDaoDriver().createOrUpdate(driver);
            Log.d(TAG, "write:driver ");
        } catch (SQLException e) {
            Log.d(TAG, "write error: ");
            e.printStackTrace();
        }
    }

    /**
     * Read all data from table
     *
     * @return list objects
     */
    public List<DriverModel> readAll() {
        List<DriverModel> drivers = null;
        try {
            drivers = HelperFactory.getHelper().getDaoDriver().queryForAll();
            Log.d(TAG, "readAll: driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    /**
     * Select object using query parameters
     *
     * @param columnName columnName
     * @param parameter  parameter for sorting data
     * @return list objects
     */
    public List<DriverModel> selectBy(String columnName, String parameter) {
        List<DriverModel> drivers = null;
        try {
            searchBy = HelperFactory.getHelper().getDaoDriver().queryBuilder();
            searchBy.where().like(columnName, generateRequestString(parameter));
            prepared = searchBy.prepare();
            drivers = HelperFactory.getHelper().getDaoDriver().query(prepared);
            Log.d(TAG, "selectBy: driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    /**
     * Delete object from db
     *
     * @param driver object then will be deleting
     */
    public void delete(DriverModel driver) {
        try {
            int deleted = HelperFactory.getHelper().getDaoDriver().delete(driver);
            Log.d(TAG, "deleteFilm: " + deleted);
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
