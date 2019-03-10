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

    for (int i = 0 ; i < directions.length; i++){ //loop thru directions and stomp the map
      stomp(map, directions[i][0], directions[i][1], directions[i][2]);
    }
    System.out.println("After Stomping: \n"+toString(map));
    return 0; //dummy
  }

  public static int silver(String filename){
    return 0; //dummy
  }

  //cow stomp given directions
  public static void stomp(int[][] map, int row, int col, int depth){
    int[][] sqrs = new int[3][3];
    int max = 0;
    for (int r = 0; r < 3; r ++) { //find max number
      for (int c = 0; c < 3; c++) {
        sqrs[r][c] = map[row+r-1][col+c-1];
        if (sqrs[r][c] > max){
          max = sqrs[r][c];
        }
      }
    }
    int min = max - depth;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (sqrs[r][c] > min){ //let the other cows catch up
          sqrs[r][c] = min;
        }
        map[row+r-1][col+c-1] = sqrs[r][c];
      }
    }
  }

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
