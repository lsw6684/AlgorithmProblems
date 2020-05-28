/*1K sorting
Description

주어진 임의의 숫자들을 오름 차순으로 정렬하세요.



Input
첫 줄에는 전체 숫자의 개수 n이 주어집니다.

두 번째 줄부터 n개의 숫자가 임의로 출력됩니다.


Output
n개의 숫자들을 한줄에 하나씩 오름차순으로 출력하세요.


Sample Input 1 

5
1
4
5
2
3
Sample Output 1

1
2
3
4
5*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tempo = arr[i];
					arr[i] = arr[j];
					arr[j] = tempo;
				}
			}
		}

		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
	}

}
