package com.test.rc4;

import android.util.Log;

public class RC4 {

    // C和Java的区别
    // C中的unsigned char 在Java中用byte表示
    // Java 在从byte转换为int时需要先   &0xff，C则不需要
    // java中的int即可以表示C中的unsigned long
    private static void rc4_init(byte[] s, String key, int Len) {
        int i = 0, j = 0;
        byte[] k = new byte[256];
        byte tmp;
        byte[] keyArray = key.getBytes();
        for (i = 0; i < 256; i++) {
            s[i] = (byte) i;
            k[i] = keyArray[i % Len];
        }

        for (i = 0; i < 256; ++i) {
            j = (j + (s[i] &0xff) + (s[j]&0xff)) % 256;

            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }

    }

    private static void

    rc4_crypt(byte[] s, byte[] Data, int Len) {
        int i = 0, j = 0, t = 0;
        int k = 0;
        byte tmp;

        for (k = 0; k < Len; ++k) {
            i = (i + 1) % 256;
            // Java 在从byte转换为int时需要先   &0xff，C则不需要
            j = (j + (s[i] & 0xff)) % 256;
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;

            t = ((s[i] & 0xff) + (s[j] & 0xff)) % 256;
            Data[k] ^= s[t];
        }
    }

    public static  void
    rc4_encrypt(String key, String  Data
    ) {
        byte[] s = new byte[256];
        // memset(s,0, sizeof(char)*256);
        int key_Len = key.length();
        rc4_init(s, key, key_Len);
        byte[] data = Data.getBytes();
        // unsigned long Data_Len = strlen(reinterpret_cast <const char *>(Data));
        rc4_crypt(s, data, data.length);
        Log.d("RC4JAVA", "after encrypt key: "+ key  );
        int index=0;
        for (byte i:
             data) {
            Log.d("RC4JAVA", "Data["+ index++ +"]"+ (i&0xff)  );
        }
    }
}
