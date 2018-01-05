package jiyun.com.keepcar.ui.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.ui.TuPian;
import jiyun.com.keepcar.ui.homepage.fragment.PersonalFragment;
import jiyun.com.keepcar.ui.login.xiangji.PhotoUtils;
import jiyun.com.keepcar.ui.login.xiangji.ToastUtils;

/**
 * Created by Administrator on 2018/1/2.
 */

public class PersonalcenterActivity extends BaseActivity implements View.OnClickListener{
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    long time=System.currentTimeMillis()/1000;//获取系统时间的10位的时间戳
    String  str=String.valueOf(time);
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;

//    private ImageView touxiang_updata;
    private RelativeLayout touxiang_liner;
    private TextView nicheng_updata;
    private LinearLayout nicheng_liner;
    private TextView name_updata;
    private LinearLayout name_liner;
    private TextView youxiang_updata;
    private LinearLayout youxiang_liner;
    private LinearLayout liner;
    private Button ok;
     List<TuPian> arrimage = new ArrayList<>();
    private TuPian touxiang_updata;
    private Bitmap bit;

    @Override
    protected void initView() {
        ok= (Button) findViewById(R.id.ok);

        touxiang_updata= (TuPian) findViewById(R.id.touxiang_updata);
        touxiang_liner= (RelativeLayout) findViewById(R.id.touxiang_liner);
        nicheng_updata= (TextView) findViewById(R.id.nicheng_updata);
        nicheng_liner= (LinearLayout) findViewById(R.id.nicheng_liner);
        youxiang_liner= (LinearLayout) findViewById(R.id.youxiang_liner);
        name_liner= (LinearLayout) findViewById(R.id.name_liner);
        name_updata= (TextView) findViewById(R.id.name_updata);
        youxiang_updata= (TextView) findViewById(R.id.youxiang_updata);
        liner = (LinearLayout) findViewById(R.id.liner);
        touxiang_liner.setOnClickListener(this);
        youxiang_liner.setOnClickListener(this);
        nicheng_liner.setOnClickListener(this);
        name_liner.setOnClickListener(this);
        ok.setOnClickListener(this);
    }
    @Override
    protected void initData() {
    }
    @Override
    protected int getLayoutID() {
        return R.layout.activity_personalcenter;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            //调用系统相机申请拍照权限回调
            case CAMERA_PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(PersonalcenterActivity.this, "com.zz.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                } else {

                    ToastUtils.showShort(this, "请允许打开相机！！");
                }
                break;


            }
            //调用系统相册申请Sdcard权限回调
            case STORAGE_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {

                    ToastUtils.showShort(this, "请允许打操作SDCard！！");
                }
                break;
            default:
        }
    }

    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99&&resultCode==99){
            String stringExtra = data.getStringExtra("2");
            youxiang_updata.setText(stringExtra);
        }
        if (requestCode==98&&resultCode==98){
            String stringExtra = data.getStringExtra("3");
            nicheng_updata.setText(stringExtra);
        }
        if (requestCode==97&&resultCode==97){
            String stringExtra = data.getStringExtra("4");
            name_updata.setText(stringExtra);
        }
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //拍照完成回调
                case CODE_CAMERA_REQUEST:
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", new File(newUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
                default:
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                if (bit!=null){ bit.compress(Bitmap.CompressFormat.PNG, 100, baos);
                    byte[] bytes = baos.toByteArray();

                    if(bytes.length>0){
                        Intent intent2 = new Intent(PersonalcenterActivity.this, PersonalFragment.class);
                        intent2.putExtra("image",bytes);
                        setResult(200,intent2);
                        finish();
                    }else {

                    }
                }else {

                    ToastUtils.show(PersonalcenterActivity.this,"你爸爸的吻换了头像!草你个爹!", Toast.LENGTH_LONG);
                }






                break;
            case R.id.touxiang_liner:
                ok.setVisibility(View.GONE);
                View inflate = LayoutInflater.from(this).inflate(R.layout.pop_touxiang, null);
                TextView tv_photo = (TextView) inflate.findViewById(R.id.tv_photo);

                TextView tv_photograph = (TextView) inflate.findViewById(R.id.tv_photograph);
                TextView tv_cancle = (TextView) inflate.findViewById(R.id.tv_cancle);

                final PopupWindow p=new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                p.setFocusable(true);
                p.setTouchable(true);
                p.setBackgroundDrawable(new BitmapDrawable());
                p.showAtLocation(liner, Gravity.BOTTOM,0,0);
                tv_photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoObtainStoragePermission();
                    }
                });
                tv_photograph.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoObtainCameraPermission();
                    }
                });
                tv_cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ok.setVisibility(View.VISIBLE);
                        p.dismiss();
                    }
                });
                break;
            case R.id.youxiang_liner:
                Intent intent = new Intent(PersonalcenterActivity.this, YouxiangActivity.class);
                intent.putExtra("1",youxiang_updata.getText().toString());
                startActivityForResult(intent,99);
                break;
            case R.id.nicheng_liner:
                Intent intent1 = new Intent(PersonalcenterActivity.this, NiChengActivity.class);
              intent1.putExtra("8", nicheng_updata.getText().toString());
                startActivityForResult(intent1,98);
                break;
            case R.id.name_liner:
                Intent intent3 = new Intent(PersonalcenterActivity.this, NameActivity.class);
                intent3.putExtra("7",name_updata.getText().toString());
                startActivityForResult(intent3,97);
                break;
        }
    }
    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShort(this, "您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                //通过FileProvider创建一个content类型的Uri
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(PersonalcenterActivity.this, "com.zz.fileprovider", fileUri);
                }
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }
    }
    /**
     * 自动获取sdk权限
     */
    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }
    private void showImages(Bitmap bitmap) {
        touxiang_updata.setImageBitmap(bitmap);
        bit = bitmap;
    }
    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }
}
