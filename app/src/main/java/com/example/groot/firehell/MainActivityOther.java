package com.example.groot.firehell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityOther extends AppCompatActivity {


    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("users");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button=(Button) findViewById(R.id.push);
        final EditText e1=(EditText) findViewById(R.id.text1);
        final EditText e2=(EditText) findViewById(R.id.text2);


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
                e1.setText("");

              //  int PLACE_PICKER_REQUEST = 1;
               // PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

              //  startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);

            }
        });

    }
}
