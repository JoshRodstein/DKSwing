# DKSwing

Problem Set for Diamond Kinetics:
 -Implement data structure for sample swing data in 'latestSwing.csv'
 -Implement 4 methods for searching continuous values

# Description:
SwingTable.java -
  ArrayList<SwingSample> backed ADT, with parralel mapping of timestamps to
  to corresponding ArrayList index. Makes possible O(1) search for sample 
  by timeStamp.
  
SwingSample.java - Object representing 1 sample (row) of 7 data points (in order)
      -Timestamp, ax, ay, az, wx, wy, wz
      -Data parameter is case-insensative String matching 1 of 7 data point labels
      
IndexPair.java - Object represents starting and ending index of continuous runs
                 of values. Allows for return of multiple indices. 
  

# Notes 
  -Currently SwingTable indices start at 1 to mirror logical indexing of csv spreadsheet.
  -csv file contains proprietary data, not included in public repo.  
  
