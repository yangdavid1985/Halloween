import java.util.Date;

/**
 * Created by David on 4/3/17.
 */
public class TrickOrTreaters implements Runnable {
    String name;
    Date inTime;

    House house;

    public TrickOrTreaters(House house){
        this.house = house;
    }

    public String getName(){
        return name;
    }

    public Date getInTime(){
        return inTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setInTime(Date inTime){
        this.inTime = inTime;
    }


    public void run(){
        getCandy();
    }

    private synchronized void getCandy(){
        house.add(this);
    }
}
