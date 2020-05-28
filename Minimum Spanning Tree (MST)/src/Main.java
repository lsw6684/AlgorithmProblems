/*
Description

�� N���� ����(node)�� M���� ����(edge)�� ������ ������ ����ġ ����׷��� G�� �����Ѵ�.

G�� �����׷���(fully connected graph)�̸�, �� ������ �����ϴ� ������ 1���̰�, ��� �������� ����ġ w�� ���� �ٸ� ������ �������̴�.

�׷��� G�� �ּ� ���� Ʈ��(MST)�� �����ϴ� ��� �������� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.


Input
ù° �ٿ��� ������ ���� N�� ������ ���� M�� �־�����. (100�� N�� 200,  4,950�� M�� 19,900)

��° �ٺ��� M���� �ٿ� �� ������ �� �� ���� �ε��� x, y�� ����ġ w�� �־�����.(w �� 1,000,000)


Output
�ּ� ���� Ʈ���� �����ϴ� ��� �������� ����ġ�� ���� ����Ѵ�.


Sample Input 1 

6 15
5 6 361
3 4 768
1 2 946
1 6 185
2 6 956
4 5 124
2 4 747
3 6 886
3 5 601
4 6 258
2 3 497
1 4 482
1 5 639
1 3 916
2 5 237
Sample Output 1

1301
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

class Main {
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(sc.readLine().trim());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		arr = new int[V + 1];
		for (int i = 1; i <= V; i++)
			arr[i] = i;

		Edge[] edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(sc.readLine().trim());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edge[i] = new Edge(s, e, c);
		}

		Arrays.sort(edge, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.c - e2.c;
			}
		});

		int an = 0;
		for (int i = 0; i < E; i++) {
			int p = find(edge[i].s);
			int q = find(edge[i].e);

			if (p == q)
				continue;
			arr[q] = p;
			an += edge[i].c;
		}

		System.out.println(an);
	}

	private static int find(int n) {
		if (arr[n] == n)
			return n;
		return arr[n] = find(arr[n]);
	}

}

class Edge {
	int s;
	int e;
	int c;

	Edge(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
}