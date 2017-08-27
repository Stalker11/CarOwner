package com.olegel.carowner.models;

import com.j256.ormlite.field.DatabaseField;
import com.olegel.carowner.util.AppConstants;

/**
 * Created by Oleg on 27.08.2017.
 */

public class VehicleModel {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField (columnName = AppConstants.DRIVER_NAME)
    private String driverName;
    @DatabaseField (columnName = AppConstants.VEHICLE_TYPE)
    private String vehicleType;
}
