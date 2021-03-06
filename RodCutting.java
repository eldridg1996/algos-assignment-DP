/**
//ELDRID GONSALVES CS323
 * Rod cutting problem described in Chapter 15 of textbook
 */
public class RodCutting {

  // Do not change the parameters!
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
    int[] r = new int[rodLength + 1];
    for (int i = 0; i <= rodLength; i++) {
      r[i] = Integer.MIN_VALUE;
    }
    return rodCuttingRecurAux(rodLength, lengthPrices, r);
  }

  public int rodCuttingRecurAux(int rodLength, int[] lengthPrices, int[] r) {
    if (r[rodLength] >= 0) {
      return r[rodLength];
    }
    int q = Integer.MIN_VALUE;
    if (rodLength == 0) {
      q = 0;
    } else {
      for (int i = 0; i < rodLength; i++) {
        q = Math.max(q, lengthPrices[i] + rodCuttingRecurAux(rodLength - i - 1, lengthPrices, r));
      }
    }
    r[rodLength] = q;
    return q;
  }

  // Do not change the parameters!
  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
    int[] r = new int[rodLength + 1];
    r[0] = 0;
    int q = Integer.MIN_VALUE;
    for (int j = 1; j <= rodLength; j++) {
        q = Integer.MIN_VALUE;
        for (int i = 0; i < j; i++) {
            q = Math.max(q, lengthPrices[i] + r[j - i - 1]);
        }
        r[j] = q;
    }
    return r[rodLength];
  }

  public static void main(String args[]) {
    RodCutting rc = new RodCutting();

    // In your turned in copy, do not touch the below lines of code.
    // Make sure below is your only output.
    int length1 = 7;
    int[] prices1 = { 1, 4, 7, 3, 19, 5, 12 };
    int length2 = 14;
    int[] prices2 = { 2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26 };
    int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
    int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
    int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
    int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
    System.out.println(maxSell1Recur + " " + maxSell1Bottom);
    System.out.println(maxSell2Recur + " " + maxSell2Bottom);
  }
}
