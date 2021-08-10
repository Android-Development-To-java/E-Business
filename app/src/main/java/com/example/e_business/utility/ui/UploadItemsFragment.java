package com.example.e_business.utility.ui;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.e_business.R;
import com.example.e_business.utility.module.ItemsUpload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;


public class UploadItemsFragment extends Fragment implements View.OnClickListener {

    private ImageView imageViewProduct, image2, image3;

    private EditText prd_name, prd_price, prd_details;

    private Button pro_save_btn;

    private View viewU;

    private Uri imageUri;

    private ProgressBar progressBar;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    private StorageTask storageTask;

    public UploadItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewU = inflater.inflate(R.layout.fragment_upload_items, container, false);

        allFinding();

        imageViewProduct.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        pro_save_btn.setOnClickListener(this);

        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance().getReference("uploadsItems");

        return viewU;
    }

    private void allFinding() {
        imageViewProduct = viewU.findViewById(R.id.product_img);
//        image2 = viewU.findViewById(R.id.product_img2);
//        image3 = viewU.findViewById(R.id.product_img3);
        prd_name = viewU.findViewById(R.id.product_name);
        prd_price = viewU.findViewById(R.id.product_price);
        prd_details = viewU.findViewById(R.id.product_details);
        progressBar = viewU.findViewById(R.id.progress_bar);

        pro_save_btn = viewU.findViewById(R.id.save_product_btn);
    }


//    Image Selected New Method

    ActivityResultLauncher<String> myImages = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imageUri = result;
                    if (result != null) {
                        imageViewProduct.setImageURI(result);
                    }

//                    if (image2 != null){
//                        image2.setImageURI(result);
//                    }


                }
            });


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.product_img:
                myImages.launch("image/*");
                break;
//                case R.id.product_img2:
//                myImages.launch("image/*");
//                break;
//                case R.id.product_img3:
//                myImages.launch("image/*");
//                break;

            case R.id.save_product_btn:

                if (storageTask != null && storageTask.isInProgress()) {
                    Toast.makeText(getContext(), "Please Wait->>>>>>>>>>> !!!", Toast.LENGTH_LONG).show();
                } else {
                    upLoadData();
                }
                break;
        }

    }


    //For File Extension

    private String getExFile(Uri uri) {
        ContentResolver contentResolver = getContext().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }


    private void upLoadData() {
        String pro_name = prd_name.getText().toString().trim();
        String pro_price = prd_price.getText().toString().trim();
        String pro_details = prd_details.getText().toString().trim();

        if (pro_name.isEmpty()) {
            prd_name.requestFocus();
            prd_name.setError("Please Enter Product Name !!!!!!!!!");
            return;
        }

        if (pro_price.isEmpty()) {
            prd_price.requestFocus();
            prd_price.setError("Please Enter Product Price !!!!!!");
            return;
        }

        if (pro_details.isEmpty()) {
            prd_details.requestFocus();
            prd_details.setError("Please Enter Product Details !!!!!!");
            return;
        }

        if (imageUri != null) {

            //For File Name  in DataBase

            StorageReference fileRef = storageReference.child(System.currentTimeMillis() + "." + getExFile(imageUri));

            storageTask = fileRef.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                }
                            }, 500);

                            ItemsUpload itemsUpload = new ItemsUpload(taskSnapshot.getUploadSessionUri().toString(), pro_name, pro_price, pro_details);
                            String uploadItems = databaseReference.push().getKey();
                            databaseReference.child(uploadItems).setValue(itemsUpload);

                            Toast.makeText(getContext(), "Upload Success !!!!!! ", Toast.LENGTH_SHORT).show();


                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getContext(), "Something is wrong !!!  " + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                            double progress = (100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            progressBar.setProgress((int) progress);

                        }
                    });
        } else {
            Toast.makeText(getContext(), "Big Problems,Find It And Solve it , OOKKKK !!!!", Toast.LENGTH_LONG).show();
        }

    }
}