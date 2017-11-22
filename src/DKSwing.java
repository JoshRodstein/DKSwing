import java.io.*;

public class DKSwing {
    private static SwingTable aSwing;


    public static void main(String[] args){
        try {
            File swingFile = new File(args[0]);
            aSwing = new SwingTable(swingFile);
            aSwing.printSwing();
        } catch(FileNotFoundException fn) {
            System.err.println("File not found");
        }
    }
}
