解决cup缓存不一致
1、总线(数据总线、地址总线、控制总线)加锁
2、CPU高速缓存一致性协议 MESI

并发编程三个重要概念
1、原子性
    一个操作或者多个操作，要么都成功，要么都失败
    java对基本数据类型的变量读取和赋值是保证原子性的
    a = 10 满足
    b = a 不满足 1、read a  2、assign b;
    c++ 不满足 1、read 2、add 3、assign c
2、可见性
    Thread-1            Thread-2
    int i = 0;          int j = i;
    i = 10; cache       j = 0;
    java关键字volatile可以保证
3、有序性
    int i = 0
    boolean flag = false;
    flag = true
    i = 1
    ====> 重排序 -> 保证单线程最终一致性
    int i = 0
    i = 1
    boolean flag = false
    flag = true
    java关键字volatile可以保证可见性和有序性，不能保证原子性
    => happens-before 关系
    代码执行顺序，编写在前面的发生在编写在后面的
    unlock必须发生在lock
    volatile修饰的变量，对这个变量的写操作先于对该变量的读操作
    传递规则，操作A先于B,B先于C,A先于C
    线程启动规则，start方法肯定先于线程run
    线程的中断规则，interrupt必须发生在捕获在该动作之前
    对象的销毁规则，初始化必须发生在finalize之前
    线程终结规则，所有的程序操作都必须在线程死亡之前

volatile关键字：
1、保证重排序的时候不会把后面的指令放到屏障的前面，也不会把前面的放到后面
2、强制对缓存的修改操作立刻写入主存
3、如果是写操作，它会导致其他cpu的缓存失效

使用场景：
1、状态量标记 volatile boolean start = true
2、保证屏障前后的一致性：double check方式单例模式
