package com.example.groot.firehell;

/**
 * Created by groot on 20/3/18.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Belal on 18/09/16.
 */


public class NewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //fragment_change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.frament_new, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("New Schedule");


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference("users");



        Button button=(Button) getView().findViewById(R.id.push);
        final EditText e1=(EditText) getView().findViewById(R.id.text1);
        final EditText e2=(EditText) getView().findViewById(R.id.text2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1=e1.getText().toString();
                //int t2=Integer.parseInt(e1.getText().toString());
                User u1= new User(ref.child("users").push().getKey(),t1);

                //note.setUid(database.child("notes").push().getKey());


                ref.child(u1.getId()).setValue(u1);
                // DatabaseReference pushedPostRef = ref.push();
                //database.child("notes").child(note.getUid()).setValue(note);
                e1.setText("");
               // e1.setText("");

                //  int PLACE_PICKER_REQUEST = 1;
                // PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                //  startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);

            }
        });




    }
}
