package com.cs.project.chocofire.retreivefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MainActivity extends AppCompatActivity {

    TextView a,b,c,d;
    Button btn;
    DatabaseReference reff;

    //StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Firebase Connection success",Toast.LENGTH_LONG).show();
        //set textview
        a=(TextView)findViewById(R.id.nameview);
        b=(TextView)findViewById(R.id.ageview);
        c=(TextView)findViewById(R.id.htview);
        d=(TextView)findViewById(R.id.phview);
        //set load data button
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reff= FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name=dataSnapshot.child("name").getValue().toString();
                        String age=dataSnapshot.child("age").getValue().toString();
                        String ht=dataSnapshot.child("ht").getValue().toString();
                         String ph=dataSnapshot.child("ph").getValue().toString();
                        a.setText(name);
                        b.setText(age);
                        c.setText(ht);
                        d.setText(ph);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }



}
