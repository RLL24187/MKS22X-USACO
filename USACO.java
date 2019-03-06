import java.util.*;
public class USACO{
  private int[][] map;
  private int[] basics = new int[4];
  public static int bronze(String filename){
    storeArray(filename);
    return 0; //dummy
  }

  public static int silver(String filename){
    storeArray(filename);
    return 0; //dummy
  }

  //stores values into an int array
  public static storeArray(String filename){
    File f = new File(filename);
    Scanner s1 = new Scanner(f);
    Scanner s2 = new Scanner(f);
    String l1 = s1.nextLine();
    s2.nextLine();
    /*
    * Line 1: Four space-separated integers: R, C, E, N
    */
    String temp = "";
    for (int i = 0; i < l1.length(); i++){
      if (l1.charAt(i)==' '){

      }
    }
    /*
    * Lines 2..R+1: Line i+1 describes row of squares i with C
        space-separated integers

    * Lines R+2..R+N+1: Line i+R+1 describes stomp-digging instruction i
        with three integers: R_s, C_s, and D_s
        */
  }
}
