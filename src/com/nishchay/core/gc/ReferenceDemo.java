package com.nishchay.core.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
 *   Strong References > Soft References > Weak References > Phantom References > Unreachable
 *   References gets garbage collected based on above order
 * */
public class ReferenceDemo {

    public static void main(String[] args) {

        Object mainObj = new Object(); // Strong Ref

        // Make a Soft Reference on mainObj
        SoftReference<Object> softRef = new SoftReference<Object>(mainObj);
        Object strongRef1 = softRef.get();
        mainObj = null;
        System.out.println("strongRef1 = " + strongRef1);
        // while are wrapping prime strong reference into a soft reference.
        // After making that strong reference null, a mainObj object is eligible for GC
        // but will be collected only when JVM absolutely needs memory.


        mainObj = new Object();
        // Make a weak Reference on mainObj
        WeakReference<Object> weakRef = new WeakReference<Object>(mainObj);
        Object strongRef2 = weakRef.get();
        mainObj = null;
        System.out.println("strongRef2 = " + strongRef2);
        // When we made a mainObj reference null, the mainObj object will be garbage collected in the next GC cycle,
        // as there is no other strong reference pointing to it.
        // References of a WeakReference type are used as keys in WeakHashMap.


        mainObj = new Object();
        // Make a phantom Reference on mainObj
        final ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRef = new PhantomReference<>(mainObj, queue);
        Object strongRef3 = phantomRef.get();
        System.out.println("phantomRef = " + phantomRef);
        System.out.println("strongRef3 = " + strongRef3); // null

    }
}
