//
// Created by Simp1er on 2020-09-07.
//

#ifndef RC4_RC4_H
#define RC4_RC4_H


class RC4 {
private:
    void rc4_init(unsigned char* s,unsigned char * key,unsigned long Len);
    void rc4_crypt(unsigned char* s,unsigned char * Data,unsigned long Len);

public:
    void rc4_encrypt( const char * key, unsigned char * Data);

};


#endif //RC4_RC4_H
