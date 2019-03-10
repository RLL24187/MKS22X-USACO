import java.util.*;
import java.io.*;
public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    int[] basics = new int[4]; //stores info from first line
    //0: rows
    //1: cols
    //2: elevation
    //3: number of instructions
    File f = new File(filename);
    Scanner s1 = new Scanner(f);
    //String l1 = s1.nextLine();
    /*
    * Line 1: Four space-separated integers: R, C, E, N
    */
    String temp = "";
    int idx = 0;
    while (idx < 4){ //stores first line
      temp = s1.next();
      basics[idx]=Integer.parseInt(temp);
      idx++;
    }
    int[][] map = new int[basics[0]][basics[1]]; //instantiate map
    temp = "";
    /*
    * Lines 2..R+1: Line i+1 describes row of squares i with C
        space-separated integers
    */
    int r = 0;
    int c = 0;
    //^^^ vars for storing in map
    while (r < basics[0]){
      c=0;
      while (c < basics[1]){
        temp = s1.next();
        map[r][c]=Integer.parseInt(temp); //store values into map
        c++; //new column
      }
      r++; //new row
    }
    //testing
    System.out.println("Row: "+basics[0]);
    System.out.println("Col: "+basics[1]);
    System.out.println(toString(map));
    /*
    * Lines R+2..R+N+1: Line i+R+1 describes stomp-digging instruction i
        with three integers: R_s, C_s, and D_s
    */
    return 0; //dummy
  }

  public static int silver(String filename){
    //storeArray(filename);
    return 0; //dummy
  }

/*
  //stores values into an int array
  public static void storeArray(String filename) throws FileNotFoundException{

  }

  public static int[][] getMap(){
    return map;
  }

  public static int[] getBasics(){
    return basics;
  }*/

  public static String toString(int[][] ary){
    String output = "";
    for (int i = 0; i < ary.length; i++){
      for (int j = 0; j < ary[0].length; j++){
        output += ary[i][j] + " ";
      }
      output += "\n";
    }
    return output;
  }
}
