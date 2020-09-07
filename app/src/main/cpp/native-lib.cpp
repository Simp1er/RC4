#include <jni.h>
#include <string>
#include "rc4.h"
#include <android/log.h>
extern "C" JNIEXPORT jstring JNICALL
Java_com_test_rc4_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
/*    void rc4_init(unsigned char* s,unsigned char * key,unsigned long key_len);
    void rc4_crypt(unsigned char* s,unsigned char * Data,unsigned long data_len);*/
   // unsigned char s[256] = {0};
    const char *key = "12345678";
    const char *Data = {"rc4Test"};
    RC4 rc4;
    __android_log_print(4,"RC4","key:%s,Data:%s",key,Data);
    unsigned char array[100] = {0};
    strcpy(reinterpret_cast<char *>(array), Data);
    rc4.rc4_encrypt( key,array);
    __android_log_print(4,"RC4","key:%s,Data:%s",key,array);


    return env->NewStringUTF(hello.c_str());
}
