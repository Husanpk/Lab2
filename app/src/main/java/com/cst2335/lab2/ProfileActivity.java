package com.cst2335.lab2;

import static android.content.ContentValues.TAG;
import static com.cst2335.lab2.R.id.button;
import static com.cst2335.lab2.R.id.imageButton;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
ImageView imgbutton;


   EditText editText;
    public static final String TAG = "PROFILE_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//
//        Intent fromMain = getIntent();
//        fromMain.getStringExtra(MainActivity.str);
//   editText = findViewById(R.id.editText1);
//        editText.setText(MainActivity.msg);
   imgbutton = findViewById(R.id.imageButton);
imgbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent inten = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(inten,0);
    }
});


Button chatButton;
chatButton = findViewById(button);
chatButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intern = new Intent(ProfileActivity.this,ChatRoomActivity.class);
        startActivity(intern);
    }
});
    }
  @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
super.onActivityResult(requestCode, resultCode, data);


            Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");
            imgbutton.setImageBitmap(imgbitmap);

}
//    public void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            myPictureTakerLauncher.launch(takePictureIntent);
//        }
//
//
//        ActivityResultLauncher<Intent> myPictureTakerLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult()
//                , new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//
//                        imgbutton = findViewById(R.id.imageButton);
//                        ;
//                        if (result.getResultCode() == Activity.RESULT_OK) {
//                            Intent data = result.getData();
//                            Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");
//                            imgbutton.setImageBitmap(imgbitmap);
//                        } else if (result.getResultCode() == Activity.RESULT_CANCELED)
//                            Log.i(TAG, "User refused to capture a picture.");
//                    }
//                });
//    }
    @Override
    protected void onStart() {
        super.onStart();

       Log.e(TAG, "in function : onStart()" );

    }
    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "in function : onResume()" );

    }
    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "in function : onPause()" );

    }
    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "in function : onStop()" );

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "in function : onDestroy()" );

    }

}