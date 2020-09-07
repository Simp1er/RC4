//
// Created by Simp1er on 2020-09-07.
//

#include <cstring>
#include "RC4.h"

void RC4::rc4_init(unsigned char *s, unsigned char *key, unsigned long Len) {
    int i=0,j=0;
    unsigned char k[256] = {0};
    unsigned char tmp;
    for(i=0;i<256;i++){
        s[i] = i;
        k[i] = key[i%Len];
    }

    for (int i = 0; i < 256; ++i) {
        j = (j + s[i] + s[j]) % 256;

        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

}

void RC4::rc4_crypt(unsigned char *s, unsigned char *Data, unsigned long Len) {
    int i=0,j=0,t=0;
    unsigned long k =0 ;
    unsigned char  tmp;
    for (int k = 0; k < Len; ++k) {
        i = (i+1)%256;
        j = (j+s[i]) % 256;
        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;

        t= (s[i] + s[j] ) % 256;
        Data[k] ^=s[t];
    }
}

void
RC4::rc4_encrypt(const char *key, unsigned char *Data
                 ) {
    unsigned char s[256] = {0};
   // memset(s,0, sizeof(char)*256);
    unsigned long key_Len = strlen(reinterpret_cast<const char *>(key));
    rc4_init(s, (unsigned char *) key, key_Len);
    auto Data_copy = Data;
    unsigned long Data_Len = strlen(reinterpret_cast<const char *>(Data));
    rc4_crypt(s,Data_copy,Data_Len);
}
