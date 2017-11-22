import java.io.*;

public class DKSwing {


    public static void main(String[] args){

        if(args[0] != null) {
            File swingFile = new File(args[0]);
        } else {
            System.err.println("File not found");
        }


    }
}
