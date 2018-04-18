package com.example.admin.lactes;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.lactes.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText editphone,editpassword,editname;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editname = (MaterialEditText)findViewById(R.id.editNamesignup);
        editpassword = (MaterialEditText)findViewById(R.id.editPasswordsignup);
        editphone = (MaterialEditText)findViewById(R.id.editphonesignup);

        SignUp = (Button)findViewById(R.id.SignUpbtn);

        //Initilize Firebase.....!

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDilog = new ProgressDialog(SignUp.this);
                mDilog.setMessage("Please Wait");
                mDilog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(editphone.getText().toString()).exists())
                        {
                            mDilog.dismiss();
                            Toast.makeText(SignUp.this, "Phone Number already exists !!!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDilog.dismiss();
                            User user = new User(editname.getText().toString(),editpassword.getText().toString());
                            table_user.child(editphone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Sign Up successfull", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
