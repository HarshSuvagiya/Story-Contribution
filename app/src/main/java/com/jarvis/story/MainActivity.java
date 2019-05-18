package com.jarvis.story;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mdatabase;
    FirebaseUser current_user1;
    FirebaseAuth mAuth;
    EditText mtitle,mcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtitle = findViewById(R.id.title);
        mcontent = findViewById(R.id.story);

        FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = current_user.getUid();

        mAuth = FirebaseAuth.getInstance();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

        HashMap<String, String> usermap = new HashMap<>();

        usermap.put("title",mtitle.toString());
        usermap.put("content", mcontent.getText().toString().trim());
    }
}
