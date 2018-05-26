package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hanna.lab2fragments.R;


public class fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2,container,false);
        Bundle bundle = getArguments();
        String str = bundle.getString("String");
        int position = bundle.getInt("Position");
        TextView myTextView = (TextView)v.findViewById(R.id.textView2);
        myTextView.setMovementMethod(new ScrollingMovementMethod());
        myTextView.setText(str);
        myTextView.setTextSize((position+1)*4);
        Button btnExit = (Button)v.findViewById(R.id.button_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.place, new Fragment1());
                fragmentTransaction.commit();
            }
        });
        return v;
    }


}
