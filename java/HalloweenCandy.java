/**
 * Created by David on 4/3/17.
 */
public class HalloweenCandy {
    public static void main(String[] args) {
        House house = new House();

        Riley riley = new Riley(house);
        GenerateTrickOrTreaters generateTrickOrTreaters = new GenerateTrickOrTreaters(house);

        Thread threadRiley = new Thread(riley);
        Thread threadGenerateTrickOrTreaters = new Thread(generateTrickOrTreaters);

        threadGenerateTrickOrTreaters.start();
        threadRiley.start();
    }

}
