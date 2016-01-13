
public class SingletonLock {
    private volatile static SingletonLock uniqueInstance;

    private SingletonLock() {
    }

    public static SingletonLock getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonLock.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonLock();
                }
            }
        }
        return uniqueInstance;
    }
}
