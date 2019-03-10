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
    int idx = 0;
    while (idx < 4){ //stores first line
      basics[idx]=Integer.parseInt(s1.next());
      idx++;
    }
    int[][] map = new int[basics[0]][basics[1]]; //instantiate map
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
        map[r][c]=Integer.parseInt(s1.next()); //store values into map
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
    int[][] directions = new int[basics[3]][3]; //stores direction parameters
    int n = 0;
    while (n < basics[3]){
      directions[n][0]=Integer.parseInt(s1.next());
      directions[n][1]=Integer.parseInt(s1.next());
      directions[n][2]=Integer.parseInt(s1.next());
      n++;
    }
    System.out.println("Number of instructions: "+basics[3]);
    System.out.println(toString(directions));
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
