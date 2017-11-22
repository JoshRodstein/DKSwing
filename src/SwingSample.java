

public class SwingSample {
    private int timeStamp;
    private double aX, aY, aZ, wX, wY, wZ;


    public SwingSample(){
        this.timeStamp = 0;
        this.aX = 0;
        this.aY = 0;
        this.aZ = 0;
        this.wX = 0;
        this.wY = 0;
        this.wZ = 0;
    }
    public SwingSample(int time, double ax, double ay, double az,
                  double wx, double wy, double wz){
        this.timeStamp = time;
        this.aX = ax;
        this.aY = ay;
        this.aZ = az;
        this.wX = wx;
        this.wY = wy;
        this.wZ = wz;
    }

    public int getTimestamp(){
        return this.timeStamp;
    }

    public double getXYZ(String xyz) throws IllegalArgumentException {
        if(xyz.equalsIgnoreCase("ax")){
            return this.aX;
        } else if (xyz.equalsIgnoreCase("ay")){
            return this.aY;
        } else if (xyz.equalsIgnoreCase("az")){
            return this.aZ;
        } else if (xyz.equalsIgnoreCase("wx")){
            return this.wX;
        } else if(xyz.equalsIgnoreCase("wy")){
            return this.wY;
        } else if(xyz.equalsIgnoreCase("wz")) {
            return this.wZ;
        } else {
            throw new IllegalArgumentException("Invalid argument: " + xyz);
        }
    }



}

