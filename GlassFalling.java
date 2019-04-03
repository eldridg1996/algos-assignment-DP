/**
 * Glass Falling    ELDRID GONSALVES CS323
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) { // n == floors, m == sheets
    // Fill in here and change the return
    int n = floors, m = sheets, min = Integer.MAX_VALUE, max;
    if (n == 0 || n == 1) {

       return n;
    }
    if(m == 1) return n;

    for (int i = 1; i <= n; i++) { // begin for loop
      max = Math.max(glassFallingRecur(i - 1, m - 1), glassFallingRecur(n - i, m));
      //from the recursive solution written in part a)
      min = Math.min(max, min);
    } // end for loop
    return ++min; //return min + 1
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Fill in here and change the return
    int m = sheets, n = floors, max,
    table[][] = new int[m+1][n+1];
    //create a sheets x floors sized 2d array to store values
    for(int i = 1; i <= m; i++){
      table[i][0] = 0; //no floors = no need for attempts - set to 0
      table[i][1] = 1; //1 floor = 1 attempt - set to 1
    }
    for(int i = 1; i <= n; i++){
      table[1][i] = i; //this is the worst case scenario - # of attempts = # of floors
    }
    for(int i = 2; i <= m; i++){
      for(int j = 2; j <= n; j++){
        table[i][j] = Integer.MAX_VALUE; //to be used to find the minimum value
        for(int k = 1; k <= j; k++){
          max = 1 + Math.max(table[i-1][k-1], table[i][j-k]); //added 1 to the max
          table[i][j] = Math.min(max, table[i][j]); //replace with the min
        }
      }
    }
    return table[m][n];
  }

  public static void main(String args[]) {
    GlassFalling gf = new GlassFalling();

    // Do not touch the below lines of code, and make sure
    //  in your final turned-in copy, these are the only things printed
    //  int minTrials1Recur = gf.glassFallingRecur(27, 2);
     int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
    //  int minTrials2Recur = gf.glassFallingRecur(100, 3);
     int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
    //  System.out.println(minTrials1Recur + " " + minTrials1Bottom);
    //  System.out.println(minTrials2Recur + " " + minTrials2Bottom);
     System.out.println(minTrials1Bottom + " <- Bottom(27,2), Bottom(100, 3) -> " + minTrials2Bottom);
  }
}
