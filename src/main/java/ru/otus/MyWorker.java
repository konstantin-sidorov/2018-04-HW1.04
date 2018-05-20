package ru.otus;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class MyWorker {
    private int size = 0;
    private static List<GarbageCollectorMXBean> gcmxb;
    @SuppressWarnings("InfiniteLoopStatement")
    void run() throws InterruptedException {

        System.out.println("Starting the loop");
        while (true) {
            if(gcmxb == null){
                gcmxb = ManagementFactory.getGarbageCollectorMXBeans();
            }
            for(GarbageCollectorMXBean ob: gcmxb) {
                System.out.println("---------");
                System.out.println("name of memory manager:" + ob.getName());
                System.out.println("CollectionTime:" + ob.getCollectionTime());
                System.out.println("CollectionCount:" + ob.getCollectionCount());
                String[] str = ob.getMemoryPoolNames();
                for (int i = 0; i < str.length; i++) {
                    System.out.println(str[i].intern());
                }
            }
            int local = size;
            Object[] array = new Object[local];
            System.out.println("Array of size: " + array.length + " created");

            for (int i = 0; i < local; i++) {
                array[i] = new String(new char[0]);
            }
            System.out.println("Created " + local + " objects.");

            Thread.currentThread().sleep(5000);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
