/*
Description

n���� �ڿ��� ���ҵ�� ������ ���� U = {1, 2, ..., n}��, U�� ���� n���� �κ����� S1, S2, ..., Sn�� �־����� ��, SetCover �˰����� �̿��Ͽ� ���� Ŀ�� ������ �ٻ��ظ� ã�� ���α׷��� �ۼ��Ͻÿ�.

(���� U�� ũ��� �κ����� Si�� ������ n���� �����ϴ�.)

(U�� ũ��� 30)

(Si�� ũ��� 10)


Input
ù ��° �ٿ��� U�� ũ������ �κ����� Si���� ������ n�� �־�����.

�� ��° �ٺ��� �� �κ����� Si�� ���ҵ��� �־�����.


Output
���� U�� Ŀ���ϱ� ���� �κ����յ��� �ε������� ����� �����Ͽ� ���ٿ� ����Ѵ�.

(��½�, �ε����� ���� �ͺ��� ���� ����Ѵ�.)


Sample Input 1 

6
1 4 5
2 5
3 4 6
4
1 2 5 6
3 6
Sample Output 1

3 5
--------------------
#include <stdio.h>
#include <vector>
#include <string.h>
#include <queue>
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

struct comp {
	bool operator()(const pair<vector<int>, int>&x, const pair<vector<int>, int>&y)
	{
		return x.first.size()< y.first.size();
	}
};

int main()
{
	int n, C[31] = {};
	vector<int> C_list;
	vector<vector<int>> S;
	scanf("%d ", &n);
	for (int i = 0; i < n; i++) {
		vector<int> temp;
		string input;
		getline(cin, input);
		int t = 0;
		for (int i = 0;; i++) {
			char c = input[i];
			if (c != ' ' && c != 0) {
				if (t == 0)
					t = c - '0';
				else {
					t *= 10;
					t += c - '0';
				}
			}
			else if (c == ' ') {
				temp.push_back(t);
				t = 0;
			}
			else {
				temp.push_back(t);
				break;
			}
		}
		S.push_back(temp);

	}	
	int cnt = 0;
	while (cnt!=n) {
		if (S.empty())
			return 0;
		int size = S.size();
		int max = 0, I;
		for (int i = 0; i < size; i++) {
			vector<int> temp = S[i];
			int cnt2 = 0;
			int size2 = temp.size();
			for (int j = 0; j < size2; j++)
				if (C[temp[j]]==0)
					cnt2++;
			if (max < cnt2) {
				max = cnt2;
				I = i;
			}
		}
		size = S[I].size();
		for (int i = 0; i < size; i++)
			if (C[S[I][i]] == 0) {
				C[S[I][i]] = 1;
				cnt++;
			}
		C_list.push_back(I);
	}
	int size = C_list.size();
	sort(C_list.begin(),C_list.end());
	for (int i = 0; i < size; i++)
		printf("%d ", C_list[i]+1);
}
*/