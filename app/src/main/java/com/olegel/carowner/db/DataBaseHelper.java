package com.olegel.carowner.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.olegel.carowner.models.DriverModel;
import com.olegel.carowner.models.VehicleModel;
import com.olegel.carowner.util.AppConstants;

import java.sql.SQLException;

/**
 * Created by Oleg on 27.08.2017.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private Dao<DriverModel, Long> driverDao;
    private Dao<VehicleModel, Long> vehicleDao;

    public DataBaseHelper(Context context) {
        super(context, AppConstants.DB_NAME, null, AppConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, DriverModel.class);
            TableUtils.createTable(connectionSource, VehicleModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    /**
     * Create DAO for driver table
     *
     * @return DAO
     */
    public Dao<DriverModel, Long> getDaoDriver() throws SQLException {
        if (driverDao == null) {
            driverDao = getDao(DriverModel.class);
        }
        return driverDao;
    }

    /**
     * Create DAO for vehicle table
     *
     * @return DAO
     */
    public Dao<VehicleModel, Long> getDaoVehicle() throws SQLException {
        if (vehicleDao == null) {
            vehicleDao = getDao(VehicleModel.class);
        }
        return vehicleDao;
    }

    @Override
    public void close() {
        super.close();

    }
}
