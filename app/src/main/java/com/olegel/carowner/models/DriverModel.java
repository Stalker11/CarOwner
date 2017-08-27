package com.olegel.carowner.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.olegel.carowner.util.AppConstants;

/**
 * Created by Oleg on 27.08.2017.
 */
@DatabaseTable(tableName = "Driver")
public class DriverModel {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField (columnName = AppConstants.DRIVER_NAME)
    private String driverName;
    @DatabaseField (columnName = AppConstants.DRIVER_LAST_NAME)
    private String driverLastName;
    @DatabaseField (columnName = AppConstants.DRIVER_CATEGORY)
    private String driverCategory;
    @DatabaseField (columnName = AppConstants.CAR_OWN)
    private String carOwn;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public String getDriverCategory() {
        return driverCategory;
    }

    public void setDriverCategory(String driverCategory) {
        this.driverCategory = driverCategory;
    }

    public String getCarOwn() {
        return carOwn;
    }

    public void setCarOwn(String carOwn) {
        this.carOwn = carOwn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
