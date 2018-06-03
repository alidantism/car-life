package life.car.AddCostRegistration;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.File;

import life.car.BaseActivity;
import life.car.R;

@EActivity(R.layout.activity_add_cost_registration_view)
public class AddCostRegistrationView extends BaseActivity implements AddCostRegistrationContract.View {

    AddCostRegistrationContract.Presenter presenter = new AddCostRegistrationPresenter();
    String picturePath = "";
    private Uri mCapturedImageURI;
    private static final int RESULT_LOAD_IMAGE     = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    @ViewById
    ImageView imgTakenPic;

    @ViewById
    EditText title;

    @ViewById
    EditText description;

    @ViewById
    EditText price;

    @AfterViews
    void initView() {
        presenter.attachView(this);
    }

    @Click
    void takeImage() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_custom_dialog_box);
        dialog.setTitle("انتخاب عکس");

        Button btnExit = (Button) dialog.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.btnChoosePath)
            .setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
            @Override public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (shouldShowRequestPermissionRationale(
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    }
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    return;
                }
                activeGallery(dialog);
            }
        });

        dialog.findViewById(R.id.btnTakePhoto)
            .setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override public void onClick(View v) {

                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        if (shouldShowRequestPermissionRationale(
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        }
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                        return;
                    }
                    activeTakePhoto(dialog);
                }
            });

        dialog.show();
    }

    private void activeTakePhoto(Dialog dialog) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            String fileName = "temp.jpg";
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, fileName);
            mCapturedImageURI = getContentResolver()
                    .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            values);
            takePictureIntent
                    .putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        dialog.dismiss();
    }

    private void activeGallery(Dialog dialog) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
        dialog.dismiss();
    }

    @Override protected void onActivityResult(int requestCode, int resultCode,
                                              Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (requestCode == RESULT_LOAD_IMAGE &&
                        resultCode == RESULT_OK && null != data) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver()
                            .query(selectedImage, filePathColumn, null, null,
                                    null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    picturePath = cursor.getString(columnIndex);
                    cursor.close();

                    File imgFile = new  File(picturePath);
                    if(imgFile.exists()){
                        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                        imgTakenPic.setImageBitmap(myBitmap);
                    }
                }
            case REQUEST_IMAGE_CAPTURE:
                if (requestCode == REQUEST_IMAGE_CAPTURE &&
                        resultCode == RESULT_OK) {
                    String[] projection = {MediaStore.Images.Media.DATA};
                    Cursor cursor =
                            managedQuery(mCapturedImageURI, projection, null,
                                    null, null);
                    int column_index_data = cursor.getColumnIndexOrThrow(
                            MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    picturePath = cursor.getString(column_index_data);
                    cursor.close();

                    File imgFile = new  File(picturePath);
                    if(imgFile.exists()){
                        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                        imgTakenPic.setImageBitmap(myBitmap);
                    }
                }
        }
    }

    @Click
    void save() {
        presenter.getFormData(title.getText().toString() , description.getText().toString() ,
                price.getText().toString() , picturePath);
    }

    @Override
    public void emptyFormCostRegistration() {
        title.setText("");
        description.setText("");
        price.setText("");
        imgTakenPic.setImageBitmap(null);
    }

    @Override
    public void addCostRegistrationSuccess() {
        Toast.makeText(this, "افزوده شد", Toast.LENGTH_LONG).show();
    }
}
