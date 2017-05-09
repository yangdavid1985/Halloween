/**
 * Created by David on 4/3/17.
 */
public class Riley implements Runnable{

    House house;

    public Riley(House house) {
        this.house = house;
    }

    public void run() {
        try{
            Thread.sleep(1);
        } catch (InterruptedException interrupted){
            interrupted.printStackTrace();
        }
        System.out.println("Riley passes out candy..");
        while (true){
            house.passCandy();
        }
    }
}
