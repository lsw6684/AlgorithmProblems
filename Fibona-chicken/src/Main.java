/*Description

여러 명의 사람들을 위한 치킨을 준비하려고 한다.

피보나치 수열(Fibonacci Numbers)과 제켄도르프 정리(Zeckendorf's Theorem)를 이용하여, 인원 수가 주어졌을 때 필요한 치킨의 양을 구하여라.


Input
주어진 사람의 수

(입력되는 값은 문자열 형태의 값임. 형변환 후 사용할 것)

입력 값은 최대 300,000,000 이하의 자연수


Output
필요한 치킨의 마리 수


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
      list.sort(Comparator.reverseOrder());//내림차순 큰거부터 작은거 순
      for (int i = 0; i < list.size(); i++) {
         if(list.get(i)<=num) {
            num = num-list.get(i);
            sum += list.get(i+1);
            
         }
      }
      
      return sum;
      
   }

}
