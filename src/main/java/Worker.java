public class Worker {

    private Worker(){}
    private Worker(String name) {
        this.mName = name;
    }

    public static Worker getInstance(String mName) {
        return new Worker(mName);
    }

    private String mName;

    public void methodA(Object obj) throws InterruptedException {
        synchronized (obj) {
            System.out.println(mName + ": method A has started.");
            Thread.sleep(5000);
            System.out.println(mName + ": method A has completed.");
        }
    }

}
