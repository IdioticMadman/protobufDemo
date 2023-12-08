#include <jni.h>
#include <string>
#include "proto/base.pb.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_rober_protobufdemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    std::string hello = "Hello from c++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_rober_protobufdemo_MainActivity_generateByteArray(JNIEnv *env, jobject thiz) {
    mmbizapp::Person person;
    std::string name = "zhangsan";
    person.set_name(name);
    person.set_age(25);
    // 创建jbyteArray并填充数据
    int length = person.ByteSize();
    jbyteArray byteArray = env->NewByteArray(length);

    // 序列化Person对象到数组
    jbyte* bytes = env->GetByteArrayElements(byteArray, nullptr);
    person.SerializeToArray(bytes, length);
    env->ReleaseByteArrayElements(byteArray, bytes, 0);
    return byteArray;
}