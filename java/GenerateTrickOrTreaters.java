import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by David on 4/3/17.
 */
public class GenerateTrickOrTreaters implements Runnable {
    House house;

    public GenerateTrickOrTreaters(House house){
        this.house = house;
    }

    public void run() {
        while (true){
            TrickOrTreaters trickOrTreaters = new TrickOrTreaters(house);
            trickOrTreaters.setInTime(new Date());
            Thread threadCustomer = new Thread(trickOrTreaters);
            trickOrTreaters.setName("TrickOrTreater : " + threadCustomer.getId());
            threadCustomer.start();

            try{
                TimeUnit.SECONDS.sleep((long)(Math.random() * 5));
            } catch (InterruptedException interrupted) {
                interrupted.printStackTrace();
            }
        }
    }
}
