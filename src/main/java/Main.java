public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.startWorkers();
        main.startFriendShip();
    }

    private void startFriendShip() {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println("Thread 1");
                alphonse.bow(gaston);
                // System.out.println("Th: gaston bowed to alphonse");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //  System.out.println("Thread 2");
                gaston.bow(alphonse);
                //  System.out.println("2.gaston waiting alph bowed");
            }
        }).start();
    }

    private void startWorkers() throws InterruptedException {
        Worker firstWorker = Worker.getInstance("First");
        Worker secondWorker = Worker.getInstance("Second");

        Object obj = new Object();

        // System.out.println("Two workers has started.");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    firstWorker.methodA(obj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    secondWorker.methodA(obj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
