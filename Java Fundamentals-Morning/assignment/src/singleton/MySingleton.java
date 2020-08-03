package singleton;

// Singleton class with double check locking
// Also handles cloning
public class MySingleton implements Cloneable {

    private static MySingleton ob;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (ob == null) {
            //synchronized block provides thread safety
            synchronized (MySingleton.class) {

                if(ob==null) {
                    ob= new MySingleton();
                }

            }
        }
        return ob;
    }

    //To use clone with Singleton class without breaking the singleton property
    @Override
    public Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
