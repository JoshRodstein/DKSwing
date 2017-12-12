# DKSwing

Problem Set for Diamond Kinetics Software Engineering Inernship <br /> 
 1.Implement data structure for sample swing data in 'latestSwing.csv'<br /><br />
 2.Implement 4 methods for searching continuous values

# Description:
**SwingTable.java-** <br />
  ArrayList<SwingSample> backed ADT, with parralel mapping of timestamps to
  to corresponding ArrayList index. Makes possible O(1) search for sample 
  by timeStamp.
  
**SwingSample.java**  <br />
  Object representing 1 sample (row) of 7 data points (in order)<br />
      - Timestamp, ax, ay, az, wx, wy, wz<br />
      - Parameter is case-insensative String matching 1 of 7 data point labels<br />
      
**IndexPair.java** <br /> 
  Object represents starting and ending index of continuous runs of values. 
  Allows for return of multiple indices. 
  

# Notes 
  -Currently SwingTable indices start at 1 to mirror logical indexing of csv spreadsheet.<br /><br />
  -csv file contains proprietary data, not included in public repo.  
  
