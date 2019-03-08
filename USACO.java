import java.util.*;
import java.io.*;
public class USACO{
  private static int[][] map;
  private static int[] basics;
  //0: rows
  //1: cols
  //2: elevation
  //3: number of instructions

  public USACO(String filename) throws FileNotFoundException{
    try{
      basics = new int[4];
      storeArray(filename);
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
  }
  public static int bronze(String filename){
    //storeArray(filename);
    return 0; //dummy
  }

  public static int silver(String filename){
    //storeArray(filename);
    return 0; //dummy
  }

  //stores values into an int array
  public static void storeArray(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner s1 = new Scanner(f);
    String l1 = s1.nextLine();
    /*
    * Line 1: Four space-separated integers: R, C, E, N
    */
    String temp = "";
    int spaces = 0;
    for (int i = 0; i < l1.length(); i++){
      if (l1.charAt(i)==' '){
        getBasics()[spaces]=Integer.parseInt(temp); //stores the basics
        spaces++;
        temp = "";
      }
      else{
        temp+=l1.charAt(i);
      }
    }
    getBasics()[spaces]=Integer.parseInt(temp); //stores final number
    map = new int[getBasics()[0]][getBasics()[1]]; //instantiate map
    temp = "";
    spaces = 0; //reset spaces
    /*
    * Lines 2..R+1: Line i+1 describes row of squares i with C
        space-separated integers
    */
    int r = 0;
    int c = 0;
    //^^^ vars for storing in map
    while (s1.hasNextLine()){
      String s = s1.nextLine();
      for (int i = 0; i < s.length(); i++){
        if (s.charAt(i)==' '){
          map[r][c]=Integer.parseInt(temp);
          c++;
          temp = "";
        }
        else{
          temp+=s.charAt(i);
        }
      }
      map[r][c]=Integer.parseInt(temp); //stores final number
      //starting new row
      r++;
      c=0;
    }
    /*
    * Lines R+2..R+N+1: Line i+R+1 describes stomp-digging instruction i
        with three integers: R_s, C_s, and D_s
    */
  }

  public static int[][] getMap(){
    return map;
  }

  public static int[] getBasics(){
    return basics;
  }

  public String toString(){
    String output = "";
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map[0].length; j++){
        output += map[i][j] + ' ';
      }
      output += "\n";
    }
    return output;
  }
}
