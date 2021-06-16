package qr.JVM.Heap;

/**
 * -XX: +PrintFlagsInitial: 设置所有参数的初始值
 * -XX: +PrintFlagsFinal: 设置所有参数的最终值
 * -Xms: 初始堆空间内存(默认物理内存的1/64)
 * -Xmx: 最大堆空间内存(默认物理内存的1/4)
 * -Xmn: 设置新生代的大小
 * -XX: NewRation: 设置老年代比新生代占堆区的比例, 默认为2, 即新生代 : 老年代 = 1:2, 新生代占堆区的1/3
 * -XX: SurvivorRation: 设置新生代中Eden:Survivor的比值, 默认为8, 即Eden : Survivor = 8:2(8:1:1)
 * -XX: MaxTenuringThreshold: 设置对象在新生代的最大年龄数, 超过这个年龄就会进入老年区
 * -XX: +PrintGCDetails: 详细输出GC处理日志
 *      -XX: +PrintGC / -verbose:gc 简要输出GC日志
 * -XX: HandlerPromotionFailure: 是否开启空间分配担保
 */
public class HeapArgs {
}
