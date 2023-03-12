#include "calc.h"

#include <jni.h>

Calc *calc;

extern "C"
JNIEXPORT jobject JNICALL
Java_com_itoria_kaliceplus_MainActivity_setOouControl(JNIEnv *env, jobject thiz, jint my_value) {
    calc -> setOouControl(my_value);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_setDotControl(JNIEnv *env, jobject thiz, jint my_value) {
    string myReturn = calc -> setDotControl(my_value);
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_myClear(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> myClear();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_myNegative(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> myNegative();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_backSpace(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> backSpace();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_memoryRead(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> memoryRead();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_itoria_kaliceplus_MainActivity_memoryWrite(JNIEnv *env, jobject thiz) {
    calc -> memoryWrite();
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_powTwo(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> powTwo();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_mySqrt(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> mySqrt();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_sendNumber(JNIEnv *env, jobject thiz, jstring my_send) {
    const char *getValue = env -> GetStringUTFChars(my_send, 0);
    string myReturn = calc -> sendNumber(getValue);
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_sendOperator(JNIEnv *env, jobject thiz, jint my_send) {
    string myReturn = calc -> sendOperator(my_send);
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_sendDot(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> sendDot();
    return env -> NewStringUTF(myReturn.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_itoria_kaliceplus_MainActivity_getResult(JNIEnv *env, jobject thiz) {
    string myReturn = calc -> getResult();
    return env -> NewStringUTF(myReturn.c_str());
}
