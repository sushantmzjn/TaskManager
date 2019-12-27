package com.sushant.taskmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private Button signup;
    private EditText fname, lname, uname, password, cpassword;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageView = findViewById(R.id.image);
        signup = findViewById(R.id.btnsignup);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        uname = findViewById(R.id.username1);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(fname.getText().toString().trim())){fname.setError("enter your first name"); return;}
                if (TextUtils.isEmpty(lname.getText().toString().trim())){lname.setError("enter your last name");return;}
                if (TextUtils.isEmpty(uname.getText().toString().trim())){uname.setError("enter username");return;}
                if (TextUtils.isEmpty(password.getText().toString().trim())){password.setError("enter password");return;}
                if (TextUtils.isEmpty(cpassword.getText().toString().trim())){cpassword.setError("Confirm your password ");return;}


            }
        });





    }

    public void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imageView.setImageURI(uri);
        //   String imagePath = getRealPathFromUri(uri);
    }

//    private String getRealPathFromUri(Uri uri) {
//        String[] projection = {MediaStore.Images.Media.DATA};
//        CursorLoader loader = new CursorLoader(getApplicationContext(), uri, projection, null, null, null);
//        Cursor cursor = loader.loadInBackground();
//        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        String result = cursor.getString(colIndex);
//        cursor.close();
//        return result;
//
//    }
}
