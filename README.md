protobuf 版本为3.8.0

构建安卓平台的protobuf

```shell
cmake -DCMAKE_TOOLCHAIN_FILE=/Users/rober/Applications/android-ndk-r18b/build/cmake/android.toolchain.cmake -DANDROID_ABI=arm64-v8a \
-DANDROID_NATIVE_API_LEVEL=21 \
-DCMAKE_BUILD_TYPE=Release\
-DANDROID_TOOLCHAIN=clang -Dprotobuf_BUILD_TESTS=OFF \
-Dprotobuf_BUILD_SHARED_LIBS=OFF \
-B build/arm64-v8a \
-Dprotobuf_BUILD_PROTOC_BINARIES=OFF \
-DCMAKE_INSTALL_PREFIX=install/arm64-v8a

cmake -DCMAKE_TOOLCHAIN_FILE=/Users/rober/Applications/android-ndk-r18b/build/cmake/android.toolchain.cmake -DANDROID_ABI=armeabi-v7a \
-DANDROID_NATIVE_API_LEVEL=21 \
-DCMAKE_BUILD_TYPE=Release\
-DANDROID_TOOLCHAIN=clang -Dprotobuf_BUILD_TESTS=OFF \
-Dprotobuf_BUILD_SHARED_LIBS=OFF \
-B build/armeabi-v7a \
-Dprotobuf_BUILD_PROTOC_BINARIES=OFF \
-DCMAKE_INSTALL_PREFIX=install/armeabi-v7a
```