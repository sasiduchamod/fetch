package com.example.sasidu.fetch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dataMainActivity extends AppCompatActivity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_main);

        click = findViewById(R.id.button);
        data = findViewById(R.id.fetcheddata);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchData process = new fetchData();
                process.execute();

            }
        });
    }
}
