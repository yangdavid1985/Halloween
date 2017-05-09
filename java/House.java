import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by David on 4/3/17.
 */
public class House {
    int atDoor;
    List<TrickOrTreaters> trickOrTreatersList;

    public House(){
        atDoor = 4;
        trickOrTreatersList = new LinkedList<TrickOrTreaters>();
    }

    public void passCandy(){
        TrickOrTreaters trickOrTreaters;
        System.out.println("Riley waiting for kids..");
        synchronized (trickOrTreatersList){
            while(trickOrTreatersList.size() == 0){
                System.out.println("Riley watches TV..");
                try{
                    trickOrTreatersList.wait();
                } catch (InterruptedException interrupted) {
                    interrupted.printStackTrace();
                }
            }
            System.out.println("Riley sees kids..");
            trickOrTreaters = (TrickOrTreaters) ((LinkedList<?>)trickOrTreatersList).poll();
        }
        long wait = 0;
        try{
            System.out.println("Riley is giving candy to " + trickOrTreaters.getName());
            wait = (long)(Math.random() * 5);
            TimeUnit.SECONDS.sleep(wait);
        } catch (InterruptedException interrupted){
            interrupted.printStackTrace();
        }
        System.out.println("Riley gave candy to " + trickOrTreaters.getName() + " in " + wait + "sec");
    }

    public void add(TrickOrTreaters trickOrTreaters){
        System.out.println("Trick or Treaters " + trickOrTreaters.getName() + " is at the door..");

        synchronized (trickOrTreatersList){
            if(trickOrTreatersList.size() == atDoor){
                System.out.println(trickOrTreaters.getName() + " is waiting..");
                return;
            }

            ((LinkedList<TrickOrTreaters>)trickOrTreatersList).offer(trickOrTreaters);
            System.out.println(trickOrTreaters.getName() + " gets candy..");

            if(trickOrTreatersList.size() == 1) {
                trickOrTreatersList.notify();
            }
        }
    }
}
