1.JVM分两种情况 
    client VM: On platforms typically used for client applications.reducing start-up time and memory footprint.
    server VM:On all platforms,designed for maximum program execution speed    default
   hot spot code Adaptive compiler
2.Optionse
    Standard Options: are guaranteed to be supported by all implementations of the Java Virtual Machine (JVM).
    Non—Standard Options: -X are general purpose options that are specific to the Java HotSpot Virtual Machine
    Advanced Runtime Options
    Advanced JIT Compiler Options
    Advanced Serviceability Options
    Advanced Garbage Collection Options
        They are also not guaranteed to be supported by all JVM implementations, and are subject to change. Advanced options start with -XX.
       
       
    Non—Standard Options:
        -Xms:Sets the initial size (in bytes) of the heap, must be a multiple of 1024 and greater than 1 MB.If you do not set this option, then the initial size will be set as the sum of the sizes allocated for the old generation and the young generation. The initial size of the heap for the young generation can be set using the -Xmn option or the -XX:NewSize option.
        -Xmx:This value must be a multiple of 1024 and greater than 2 MB.The default value is chosen at runtime based on system configuration. For server deployments, -Xms and -Xmx are often set to the same value.The -Xmx option is equivalent to -XX:MaxHeapSize.
        -Xmn:Sets the initial and maximum size (in bytes) of the heap for the young generation (nursery),Instead of the -Xmn option to set both the initial and maximum size of the heap for the young generation, you can use -XX:NewSize to set the initial size and -XX:MaxNewSize to set the maximum size.
        -XX:NewSize 设置年轻代大小    -XX:MaxNewSize
        —Xss: Sets the thread stack size (in bytes), default value   Linux/ARM (32-bit): 320 KB   Linux/i386 (32-bit): 320 KB Linux/x64 (64-bit): 1024 KB