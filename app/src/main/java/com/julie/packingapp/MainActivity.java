package com.julie.packingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView fee;
    Button calculate;
    RadioGroup vehicleType;
    EditText hours;

    RadioButton lorry,car,nissan,bus,motorcycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vehicleType = (RadioGroup) findViewById(R.id.vehicle_type);
        lorry = (RadioButton) findViewById(R.id.lorry);
        car = (RadioButton) findViewById(R.id.car);
        bus =  (RadioButton) findViewById(R.id.bus);
        motorcycle = (RadioButton) findViewById(R.id.motorcycle);
        nissan = (RadioButton) findViewById(R.id.nissan);
        calculate = (Button)findViewById(R.id.calculate);
        fee = (TextView) findViewById(R.id.fee);
        hours =(EditText)findViewById(R.id.hours);


         //checks which radio button is checked on
        vehicleType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.lorry){

                    Toast.makeText(MainActivity.this,"Lorry selected",Toast.LENGTH_LONG).show();
                }else if(checkedId == R.id.car){
                    Toast.makeText(MainActivity.this,"Car selected",Toast.LENGTH_LONG).show();
                }else if(checkedId == R.id.nissan){
                    Toast.makeText(MainActivity.this,"Nissan selected",Toast.LENGTH_LONG).show();
                }else if(checkedId == R.id.motorcycle){
                    Toast.makeText(MainActivity.this,"MotorCycle selected",Toast.LENGTH_LONG).show();
                }else if (checkedId == R.id.bus){
                    Toast.makeText(MainActivity.this,"Bus selected",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"Nothing selected",Toast.LENGTH_LONG).show();
                }

            }
        });
      //specifies action to perform once checked
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!hours.getText().toString().isEmpty()){
                    //gives radio button selected and number of hours
                    //typecasting
                    int selectedId = vehicleType.getCheckedRadioButtonId();
                    int  parkinghours = Integer.parseInt(hours.getText().toString().trim());

                    if(selectedId == lorry.getId()){
                       fee.setText("Parking Fees :" + (500*parkinghours));
                    }else if(selectedId == bus.getId()){
                        fee.setText("Parking Fees :" + (400*parkinghours));
                    }else if(selectedId == motorcycle.getId()){
                        fee.setText("Parking Fees :" + (50*parkinghours));
                    }else if(selectedId == nissan.getId()){
                        fee.setText("Parking Fees :" + (300*parkinghours));
                    }else if(selectedId == car.getId()){
                        fee.setText("Parking Fees :" + (200*parkinghours));
                    }else{
                        fee.setText("Parking Fees :" + (0));
                    }

                }else {
                    Toast.makeText(MainActivity.this,"Enter hours",Toast.LENGTH_LONG).show();
                }
            }
        });

    }




}
