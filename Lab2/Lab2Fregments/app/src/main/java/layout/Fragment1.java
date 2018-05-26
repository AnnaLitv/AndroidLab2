package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hanna.lab2fragments.R;


public class Fragment1 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment1,container,false);
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
                bundle.putString("String",str);
                bundle.putInt("Position",position);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragment2 fragment2 = new fragment2();
                fragment2.setArguments(bundle);
                fragmentTransaction.replace(R.id.place, fragment2);
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
