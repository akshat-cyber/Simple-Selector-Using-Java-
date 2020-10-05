package rcylv.fatdevs.uxandui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    String val=null;
    static Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        Switch swit = findViewById(R.id.switch1);
        final TextView textView =findViewById(R.id.textView);
        ArrayAdapter<CharSequence> _arrayAdap = ArrayAdapter
                .createFromResource(MainActivity.this, R.array.names,
                android.R.layout.simple_spinner_item);
        spinner.setAdapter(_arrayAdap);
        swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                MainActivity.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        val = parent.getItemAtPosition(position).toString();
                        view.setElevation(211);
                        textView.setText(val);
                        if (isChecked) {
                            Toast.makeText(MainActivity.this, "Selected position => " + position, Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        if (isChecked) {
                            Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}