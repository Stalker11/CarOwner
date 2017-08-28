package com.olegel.carowner.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.olegel.carowner.R;
import com.olegel.carowner.db.DriverStorage;
import com.olegel.carowner.db.VehicleStorage;
import com.olegel.carowner.models.DriverModel;
import com.olegel.carowner.models.VehicleModel;
import com.olegel.carowner.util.AppConstants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private DriverStorage driverStorage;
    private VehicleStorage vehicleStorage;
    private Unbinder unbinder;
    private DriverModel driver;
    private VehicleModel vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        save();
    }

    @OnClick(R.id.read_all)
    public void read() {
        driverStorage.readAll();
        vehicleStorage.readAll();
    }

    @OnClick(R.id.select_by)
    public void select() {
        driverStorage.selectBy(AppConstants.DRIVER_NAME, driver.getDriverName());
        vehicleStorage.selectBy(AppConstants.DRIVER_NAME, vehicle.getDriverName());
    }

    @OnClick(R.id.delete)
    public void delete() {
        driverStorage.delete(driver);
        vehicleStorage.delete(vehicle);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    private void save() {
        driver = new DriverModel();
        driver.setDriverName("Dima");
        driver.setDriverLastName("Kirpichop");
        driver.setCarOwn("Ikarus 256");
        driver.setDriverCategory("D");
        driver.setId(5);
        driverStorage = new DriverStorage(getApplicationContext());
        driverStorage.write(driver);

        vehicle = new VehicleModel();
        vehicle.setId(1);
        vehicle.setDriverName("Dima");
        vehicle.setVehicleType("Bus");
        vehicleStorage = new VehicleStorage(getApplicationContext());
        vehicleStorage.write(vehicle);
    }

}
