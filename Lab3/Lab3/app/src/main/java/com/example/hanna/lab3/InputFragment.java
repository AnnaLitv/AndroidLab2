package com.example.hanna.lab3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_APPEND;

public class InputFragment extends Fragment {

    private static  final String filename = "data.txt";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input,container,false);
        Button myButton = (Button)v.findViewById(R.id.button);
        final EditText myEdit = (EditText)v.findViewById(R.id.editText);
        final Spinner mySpinner = (Spinner)v.findViewById(R.id.spinner);
        Button myCancelButton = (Button)v.findViewById(R.id.button2);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= myEdit.getText().toString();
                int position = mySpinner.getSelectedItemPosition();

                Bundle bundle = new Bundle();
                bundle.putInt("Position",position);

                FileOutputStream fos = null;

                try {
                    fos=getActivity().openFileOutput(filename,getActivity().MODE_PRIVATE);
                    try {
                        fos.write(str.getBytes());
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

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                OutputFragment fragment2 = new OutputFragment();
                fragment2.setArguments(bundle);
               // fragmentTransaction.replace(R.id.place, fragment2);
                fragmentTransaction.commit();
            }
        });

        myCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.setText("");
            }
        });
        return v;
    }
}
