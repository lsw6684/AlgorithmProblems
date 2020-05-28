/*Description

���� ���� ������� ���� ġŲ�� �غ��Ϸ��� �Ѵ�.

�Ǻ���ġ ����(Fibonacci Numbers)�� ���˵����� ����(Zeckendorf's Theorem)�� �̿��Ͽ�, �ο� ���� �־����� �� �ʿ��� ġŲ�� ���� ���Ͽ���.


Input
�־��� ����� ��

(�ԷµǴ� ���� ���ڿ� ������ ����. ����ȯ �� ����� ��)

�Է� ���� �ִ� 300,000,000 ������ �ڿ���


Output
�ʿ��� ġŲ�� ���� ��


Sample Input 1 

17
Sample Output 1

11
*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

   public static void main(String[] args){
      // TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      int n = Integer.parseInt(sc.nextLine());
      int answer =0;
      if(n == 2) {
         answer =1;
      }else {
         answer = get_chicken(n);

      }
      System.out.println(answer);
      //System.out.println(get_chicken(101));

   }
   
   static public ArrayList<Integer> get_fibo_list(int num){
      ArrayList<Integer> list = new ArrayList<Integer>();
      int i = num;
      int first = 1;
      int second =1;
      int third = 0;
      list.add(first);
      list.add(second);
      while(true) {
         third = first + second;
         if(third < i) {
            list.add(third);
            first = second;
            second = third;
         }else {
            break;
         }
         
         
      }
      
      return list;
      
   }
   
   static public int get_chicken(int num) {
      int sum =0;
      ArrayList<Integer> list = new ArrayList<Integer>();
      list = get_fibo_list(num);
      list.sort(Comparator.reverseOrder());//�������� ū�ź��� ������ ��
      for (int i = 0; i < list.size(); i++) {
         if(list.get(i)<=num) {
            num = num-list.get(i);
            sum += list.get(i+1);
            
         }
      }
      
      return sum;
      
   }

}
