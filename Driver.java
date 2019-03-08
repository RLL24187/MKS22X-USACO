import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String[] args){
    if (args.length == 0){
      System.out.println("Please enter a file name");
    }
    else{
      try{
        USACO u = new USACO(args[0]);
        System.out.println(u.toString());
      }
      catch (FileNotFoundException e){
        System.out.println("File not found");
      }
    }
  }
}
