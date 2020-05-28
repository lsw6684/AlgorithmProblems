/*
Description

n개의 자연수 원소들로 구성된 집합 U = {1, 2, ..., n}와, U에 대한 n개의 부분집합 S1, S2, ..., Sn이 주어졌을 때, SetCover 알고리즘을 이용하여 집합 커버 문제의 근사해를 찾는 프로그램을 작성하시오.

(집합 U의 크기와 부분집합 Si의 개수는 n으로 동일하다.)

(U의 크기≤ 30)

(Si의 크기≤ 10)


Input
첫 번째 줄에는 U의 크기이자 부분집합 Si들의 개수인 n이 주어진다.

두 번째 줄부터 각 부분집합 Si의 원소들이 주어진다.


Output
집합 U를 커버하기 위한 부분집합들의 인덱스들을 띄어쓰기로 구분하여 한줄에 출력한다.

(출력시, 인덱스가 작은 것부터 먼저 출력한다.)


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