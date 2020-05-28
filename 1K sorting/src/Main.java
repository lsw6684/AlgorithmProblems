/*1K sorting
Description

�־��� ������ ���ڵ��� ���� �������� �����ϼ���.



Input
ù �ٿ��� ��ü ������ ���� n�� �־����ϴ�.

�� ��° �ٺ��� n���� ���ڰ� ���Ƿ� ��µ˴ϴ�.


Output
n���� ���ڵ��� ���ٿ� �ϳ��� ������������ ����ϼ���.


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
