public class Radix{
  public static int nth(int n, int col){
    n = n / (int)Math.pow(10, col);
    return Math.abs(n % 10);
  }

  public static int length(int n){
    if(n == 0){
      return 1;
    }
    else{
      return (int) (Math.log10(n) + 1);
    }
  }

  public static void main(String[]args){
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2));
    System.out.println(nth(-123,2));
    System.out.println("-----------");
    System.out.println(length(2));
    System.out.println(length(27));
    System.out.println(length(532));
    System.out.println(length(1234));
  }
}
