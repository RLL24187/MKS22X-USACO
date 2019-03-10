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
    int row = 0;
    int col = 0;
    //^^^ vars for storing in map
    while (row < basics[0]){
      col=0;
      while (col < basics[1]){
        map[row][col]=Integer.parseInt(s1.next()); //store values into map
        col++; //new column
      }
      row++; //new row
    }
    //testing
    //System.out.println("Row: "+basics[0]);
    //System.out.println("Col: "+basics[1]);
    //System.out.println(toString(map));
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
    //System.out.println("Number of instructions: "+basics[3]);
    //System.out.println(toString(directions));

    for (int i = 0 ; i < directions.length; i++){ //loop thru directions and stomp the map
      stomp(map, directions[i][0], directions[i][1], directions[i][2]);
    }
    //System.out.println("After Stomping: \n"+toString(map));

    int depth = 0; //total aggregated depth
    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[0].length; c++) {
        map[r][c] = basics[2] - map[r][c]; //squares are replaced with difference between elevation (basics[2]) minus their values
        if (map[r][c] <= 0){
          map[r][c] = 0; //turn negatives into 0s so it doesn't affect the total depth
        }
        depth += map[r][c]; //add to total depth
      }
    }
    depth*= (72*72); //multiply by 6 feet x 6 feet or 72 inches by 72 inches
    //System.out.println("Elevation: "+basics[2]);
    //System.out.println("After elevation change: \n"+toString(map));
    //System.out.println("Total depth: "+depth);
    return depth;
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

  //prints out the array of ints
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

  //prints out the array of chars
  public static String toString(char[][] ary){
    String output = "";
    for (int i = 0; i < ary.length; i++){
      for (int j = 0; j < ary[0].length; j++){
        output += ary[i][j] + " ";
      }
      output += "\n";
    }
    return output;
  }

    public static int silver(String filename) throws FileNotFoundException{
      File f = new File(filename);
      Scanner s = new Scanner(f);
      //* Line 1: Three space-separated integers: N, M, and T
      int[] basics = new int[3];
      //0: N - rows
      //1: M - columns
      //2: T - seconds
      for (int i = 0; i < 3; i++){
        basics[i]=Integer.parseInt(s.next()); //stores basic info from first line
      }
      s.nextLine(); //go to second line
      char[][] map= new char[basics[0]][basics[1]]; //instantiate the map
      for (int n = 0; n < basics[0]; n++){ //fill in values for the map
        String str = s.nextLine();
        for (int c = 0; c < basics[1]; c++){
          map[n][c]=str.charAt(c);
        }
      }
      //'.' is open pasture
      //'*' is trees
      System.out.println("Rows: "+basics[0]);
      System.out.println("Cols: "+basics[1]);
      System.out.println(toString(map));

      //* Lines 2..N+1: Line i+1 describes row i of the pasture with exactly M
      //        characters that are each '.' or '*'

      int[] coors = new int[4];
      //0: R1
      //1: C1
      //2: R2
      //3: C2
      for (int i = 0; i < 4; i++){ //store before and after coordinates
        coors[i]=Integer.parseInt(s.next());
      }
      //* Line N+2: Four space-separated integers: R1, C1, R2, and C2.

      
      return 0; //dummy
    }
}
