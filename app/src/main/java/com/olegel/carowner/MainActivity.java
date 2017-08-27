package com.olegel.carowner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.olegel.carowner.db.DriverStorage;
import com.olegel.carowner.models.DriverModel;
import com.olegel.carowner.util.AppConstants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private DriverStorage db;
    private Unbinder unbinder;
    private DriverModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        model = new DriverModel();
        model.setDriverName("Dima");
        model.setDriverLastName("Kirpichop");
        model.setCarOwn("Ikarus 256");
        model.setDriverCategory("D");
        model.setId(5);
        db = new DriverStorage(getApplicationContext());
        db.write(model);
    }
    @OnClick(R.id.read_all)
    public void read(){
        db.readAll();
    }
    @OnClick(R.id.select_by)
    public void select(){
        db.selectBy(AppConstants.DRIVER_NAME,model.getDriverName());
    }
    @OnClick(R.id.delete)
    public void delete(){
        db.delete(model);
    }
    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
