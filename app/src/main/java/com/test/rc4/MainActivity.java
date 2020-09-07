package com.test.rc4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     static final  String TAG = "RC4JAVA";
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        String Data = "rc4Test";
        String key = "12345678";
        Log.d(TAG, "before encrypt key: "+ key +",Data : " + Data);
        RC4.rc4_encrypt(key,Data);
        Log.d(TAG, "after encrypt key: "+ key +",Data : " + Data);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
