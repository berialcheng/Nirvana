#include <jvmti.h>
#include <string.h>
#include <stdlib.h>
#include <jni_md.h>

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *vm, char *options,void *reserved){
        printf("Enter the Agent_OnLoad()\n");
        jvmtiEnv *jvmti;
        jint result = vm->GetEnv((void **) &jvmti, JVMTI_VERSION_1_1);
        if (result != JNI_OK) {
                printf("ERROR: Unable to access JVMTI!\n");
        }

        jvmtiError err = (jvmtiError) 0;
        jlong* nanos_ptr;

        err = jvmti->GetTime(nanos_ptr);
        printf("%lld\n",*nanos_ptr);


        return err;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm) {
        printf("Enter the Agent_OnUnload()\n");
}
