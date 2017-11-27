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

        int i = aSwing.searchContinuityAboveValue("ax", 20,1200, 13, 1);
        System.out.println(i);

        i = aSwing.backSearchContinuityWithinRange("ax", 881,0, 0,
                16, 5 );
        System.out.println(i);

        i = aSwing.searchContinuityAboveValueTwoSignals("ax", "wx", 0, 1200, 0,
                0, 5);
        System.out.println(i);

        ArrayList<IndexPair> testList = aSwing.searchMultiContinuityWithinRange("ay", 0, 1200,
                2, 3, 5);
        for(i = 0; i < testList.size(); i++){
            System.out.println(testList.get(i).getStartIndex() + " : " + testList.get(i).getEndIndex());
        }

        System.exit(0);

    }
}
