import java.util.*;
import java.io.*;

public class SwingTable {
    private ArrayList<SwingSample> swingSamples;
    private Map<Integer, Integer> indexMap;
    private SwingSample sample;
    private Scanner scan;
    private int row_size;


    public SwingTable(File swingData) throws FileNotFoundException{
        int rowNum = 0;
        scan = new Scanner(swingData);
        swingSamples = new ArrayList<SwingSample>();
        indexMap = new HashMap<Integer, Integer>();

        while(scan.hasNextLine()){
            String[] row = scan.nextLine().split(",");
            row_size = row.length;
            sample = new SwingSample(
                    Integer.decode(row[0]),
                    Double.parseDouble(row[1]),
                    Double.parseDouble(row[2]),
                    Double.parseDouble(row[3]),
                    Double.parseDouble(row[4]),
                    Double.parseDouble(row[5]),
                    Double.parseDouble(row[6]));
            swingSamples.add(sample);
            indexMap.put(sample.getTimestamp(), swingSamples.size()-1);
        }
        rowNum++;
        System.out.println("row: " + rowNum);
    }


    /*
    * from indexBegin to indexEnd, search data for values that are higher than threshold.
    * Return the first index where data has values that meet this criteria for at least winLength samples.
    * */
    public int searchContinuityAboveValue(String data, int indexBegin, int indexEnd,
                                          double threshold, int winLength){
        int foundIndex = -1;
        double value = 0;

        for(int i = indexBegin; i <= indexEnd; i++){
            value = swingSamples.get(i).getXYZ(data);
            if(value > threshold) {
              if(foundIndex == -1){
                  foundIndex = i;
              }
            } else {
                if(i - foundIndex >= winLength){
                    return foundIndex;
                }
                foundIndex = -1;
            }
        }

        return foundIndex;
    }

    /*
    * from indexBegin to indexEnd (where indexBegin is larger than indexEnd), search data for values that
    * are higher than thresholdLo and lower than thresholdHi. Return the first index where data has values
    * that meet this criteria for at least winLength samples.
    * */
    public int backSearchContinuityWithinRange(String data, int indexBegin, int indexEnd,
                                               double thresholdLo, double thresholdHi, int winLength){
        String column = data;
        int begin = indexBegin;
        int end = indexEnd;
        int winL = winLength;
        double value = 0;
        double threshLo = thresholdLo;
        double threshHi = thresholdHi;
        int foundIndex = -1;

        if (indexBegin < indexEnd) {
            return -1;
        }

        for(int i = begin; i >= end; i--){
            value = swingSamples.get(i).getXYZ(column);
            if(value > threshLo && value < threshHi) {
                if(foundIndex == -1){
                    foundIndex = i;
                }
            } else {
                if(i - foundIndex >= winLength){
                    return foundIndex;
                }
                foundIndex = -1;
            }
        }

        return foundIndex;

    }

    /*
    * from indexBegin to indexEnd, search data1 for values that are higher than threshold1 and also search
    * data2 for values that are higher than threshold2. Return the first index where both data1 and data2
    * have values that meet these criteria for at least winLength samples.
    * */
    public int searchContinuityAboveValueTwoSignals(String data1, String data2, int indexBegin,
                                         int indexEnd, double threshold1, double threshold2, int winLength){
        String column1 = data1;
        String column2 = data2;
        int begin = indexBegin;
        int end = indexEnd;
        int winL = winLength;
        double value1 = 0;
        double value2 = 0;
        double thresh1 = threshold1;
        double thresh2 = threshold2;
        int foundIndex = -1;


        for(int i = begin; i <= end; i--){
            value1 = swingSamples.get(i).getXYZ(column1);
            value2 = swingSamples.get(i).getXYZ(column2);
            if(value1 > thresh1 && value2 > thresh2) {
                if(foundIndex == -1){
                    foundIndex = i;
                }
            } else {
                if((i - 1) - foundIndex >= winLength){
                    return foundIndex;
                }
                foundIndex = -1;
            }
        }

        return foundIndex;

    }

    /*
    * from indexBegin to indexEnd, search data for values that are higher than thresholdLo and lower than
    * thresholdHi. Return the the starting index and ending index of all continuous samples that meet this
    * criteria for at least winLength data points.
    * */
    public int[] searchMultiContinuityWithinRange(String data, int indexBegin, int indexEnd,
                                                double thresholdLo, double thresholdHi, int winLength){
        String column = data;
        int begin = indexBegin;
        int end = indexEnd;
        int winL = winLength;
        double value = 0;
        double threshLo = thresholdLo;
        double threshHi = thresholdHi;
        int[] foundIndex = {-1,-1};


        for(int i = begin; i <= end; i++){
            value = swingSamples.get(i).getXYZ(column);
            if(value > threshLo && value < threshHi) {
                if(foundIndex[0] == -1){
                    foundIndex[0] = i;
                }
            } else {
                if(i - foundIndex[0] >= winLength){
                    foundIndex[1] = i-1;
                    break;
                }
                foundIndex[0] = -1;
            }
        }

        return foundIndex;

    }

    public void printSwing(){
        for(int i = 0; i < swingSamples.size(); i++){
            System.out.println();
            System.out.print(swingSamples.get(i).getTimestamp());
            System.out.print(", " + swingSamples.get(i).getXYZ("ax"));
            System.out.print(", " + swingSamples.get(i).getXYZ("ay"));
            System.out.print(", " + swingSamples.get(i).getXYZ("az"));
            System.out.print(", " + swingSamples.get(i).getXYZ("wx"));
            System.out.print(", " + swingSamples.get(i).getXYZ("wy"));
            System.out.print(", " + swingSamples.get(i).getXYZ("wz"));
        }
    }




}
