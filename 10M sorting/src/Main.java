/*
10M sorting
Description

주어진 임의의 숫자 10,000,000개를 오름차순으로 정렬하세요.


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
5
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String args[]) throws Exception {
//	     Scanner sc = new Scanner(System.in);
//	     int index = sc.nextInt();
//	     int[] nums = new int[index];
//	     for(int i=0;i<index;i++)
//	         nums[i]=sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		quickSort(arr, 0, arr.length - 1);
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < N; i++) {
			bw.write((arr[i]) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void quickSort(int[] nums, int left, int right) {
		int pl = left;
		int pr = right;
		int x = nums[(pl + pr) / 2];

		do {
			while (nums[pl] < x)
				pl++;
			while (nums[pr] > x)
				pr--;
			if (pl <= pr)
				swap(nums, pl++, pr--);

		} while (pl <= pr);
		if (left < pr)
			quickSort(nums, left, pr);
		if (right > pl)
			quickSort(nums, pl, right);
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}