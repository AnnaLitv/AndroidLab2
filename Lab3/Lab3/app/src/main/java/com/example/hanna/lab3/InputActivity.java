package com.example.hanna.lab3;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputActivity extends AppCompatActivity {
    private static  final String filename = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button myButton = (Button)findViewById(R.id.button);
        final EditText myEdit = (EditText)findViewById(R.id.editText);
        final Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        Button myCancelButton = (Button)findViewById(R.id.button2);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= myEdit.getText().toString();
                int position = mySpinner.getSelectedItemPosition();

                Bundle bundle = new Bundle();
                bundle.putInt("Position",position);

                FileOutputStream fos = null;

                try {
                    fos=openFileOutput(filename,getApplicationContext().MODE_PRIVATE);
                    try {
                        fos.write(str.getBytes());
                        Toast.makeText(getApplicationContext(),"Saved to " + getFilesDir() + "/" + filename,Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }}
                catch (FileNotFoundException e){e.printStackTrace();}
                finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
               open(position);
            }
        });


        myCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.setText("");
            }
        });
    }

    private void open(int position){
        Intent intent = new Intent(this,OutputActivity.class);
        intent.putExtra("Position",position);
        startActivity(intent);
    }
}
