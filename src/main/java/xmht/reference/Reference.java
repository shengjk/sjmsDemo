package xmht.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author shengjk1
 * @date 2019/11/29
 */
public class Reference {
	public static void main(String[] args) {
		/*
		软引用基本上与弱引用差不多，只是相比于弱引用，它阻止垃圾回收的能力强一些。
		如果一个对象是弱引用可到达的，那么这个对象会被垃圾回收期接下来 回收周期 销毁。但是如果是软引用可以到达，那么这个对象
		会停留在内存的时间上长一些。当内存不足时，垃圾回收器才会回收这些软引用可到达的对象。
		
		软引用非常适合创建缓存
		注意： wrf这个引用也是强引用，它是指向 SoftReference 这个对象的，
		这个的软引用指的是指向 new String("String")的引用，也就是 SoftReference 类中的 T
		 */
		SoftReference<String> wrf = new SoftReference<>("String");
		System.out.println(wrf.get());
		
		/*
		弱引用
		 */
		WeakReference<String> stringWeakReference = new WeakReference<String>("String");
		
		WeakHashMap<String, String> stringStringWeakHashMap = new WeakHashMap<>();
		stringStringWeakHashMap.put("a","a");
		
		/*
		 虚引用
		 虚引用指向的对象十分脆弱，我们不可以通过get方法得到其指向的对象。它的唯一作用就是当其指向的对象被回收之后，自己被加入到引用队列，用作
		 记录该引用指向的对象已被销毁
		 
		 虚引用使用场景主要由两个。它允许你知道具体何时其引用的对象从内存中移除。
		 而实际上这是Java中唯一的方式。这一点尤其表现在处理类似图片的大文件的情况。
		 当你确定一个图片数据对象应该被回收，你可以利用虚引用来判断这个对象回收之后在继续加载下一张图片。
		 这样可以尽可能地避免可怕的内存溢出错误。
		 第二点，虚引用可以避免很多析构时的问题。finalize方法可以通过创建强引用指向快被销毁的对象来让这些对象重新复活。
		 然而，一个重写了finalize方法的对象如果想要被回收掉，需要经历两个单独的垃圾收集周期。在第一个周期中，
		 某个对象被标记为可回收，进而才能进行析构。但是因为在析构过程中仍有微弱的可能这个对象会重新复活。
		 这种情况下，在这个对象真实销毁之前，垃圾回收器需要再次运行。因为析构可能并不是很及时，
		 所以在调用对象的析构之前，需要经历数量不确定的垃圾收集周期。这就意味着在真正清理掉这个对象的时候可能发生很大的延迟。
		 这就是为什么当大部分堆被标记成垃圾时还是会出现烦人的内存溢出错误。

使用虚引用，上述情况将引刃而解，当一个虚引用加入到引用队列时，你绝对没有办法得到一个销毁了的对象。
因为这时候，对象已经从内存中销毁了。因为虚引用不能被用作让其指向的对象重生，所以其对象会在垃圾回收的第一个周期就将被清理掉。
		 */
		
		PhantomReference<String> prf = new PhantomReference<String>(new String("str"), new ReferenceQueue<>());
	}
}
