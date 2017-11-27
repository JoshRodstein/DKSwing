import java.io.*;
import java.util.ArrayList;

public class DKSwing {
    private static SwingTable aSwing;


    public static void main(String[] args){
        aSwing = null;
        try {
            File swingFile = new File(args[0]);
            aSwing = new SwingTable(swingFile);
            //aSwing.printSwing();
        } catch(FileNotFoundException fn) {
            System.err.println("File not found");
        }

        int i = aSwing.searchContinuityAboveValue("wz", 1,1200, 1, 20);
        System.out.println("From index [1 - 1200] for sensor 'wz', Above Value 1 of length >= " + 20 + ": Index["+i+"]");

        int x = aSwing.backSearchContinuityWithinRange("ax", 860,1, 1,
                16, 20 );
        System.out.println("From index [860 - 1] for sensor 'ax', Above Value 1 and below value 16 of length >= 20 : Index["+x+"]");

        int y = aSwing.searchContinuityAboveValueTwoSignals("ax", "wx", 1, 1200, 0,
                0, 5);
        System.out.println("From index [1 - 1200] for sensor 'ax' above value 0 and for sensor wx above value 0 of length >= 5 : Index["+y+"]");

        ArrayList<IndexPair> testList = aSwing.searchMultiContinuityWithinRange("ay", 1, 1200,
                2, 3, 3);

        System.out.println("All runs of continuous values between 2-3 of length >= 3 from index[1 - 1200]");
        for(int z = 0; z < testList.size(); z++){
            System.out.println("\tStart["+testList.get(z).getStartIndex() + "] : End[" + testList.get(z).getEndIndex()+"]");
        }

        System.exit(0);

    }
}
