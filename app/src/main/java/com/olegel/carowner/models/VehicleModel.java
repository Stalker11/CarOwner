package com.olegel.carowner.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.olegel.carowner.util.AppConstants;

/**
 * Created by Oleg on 27.08.2017.
 */
@DatabaseTable(tableName = "Vehicle")
public class VehicleModel {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = AppConstants.DRIVER_NAME)
    private String driverName;
    @DatabaseField(columnName = AppConstants.VEHICLE_TYPE)
    private String vehicleType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
