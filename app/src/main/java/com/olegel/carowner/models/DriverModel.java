package com.olegel.carowner.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Oleg on 27.08.2017.
 */
@DatabaseTable(tableName = "Driver")
public class DriverModel {
    @DatabaseField
    private String driverName;
    @DatabaseField
    private String driverLastName;
    @DatabaseField
    private String driverCategory;
    @DatabaseField
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
}
