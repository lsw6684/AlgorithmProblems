/*
Description

� ��迡�� ����Ǵ� N���� �۾�(task) t1, t2, ..., tn�� �����ϰ�, �� �۾����� ������ ���۽ð� Si�� ����ð� Fi�� ���´�.

�� �۾����� �ݵ�� �־��� ���۽ð��� ���۵Ǿ�� �ϰ�, �־��� ����ð��� ����ȴ�. ����, �ϳ��� ���� ���ÿ� �ϳ��� �۾��� ������ �� �ִ�.

�� ���� ��踸�� ����Ͽ� ��ü N���� �۾��� �� ������ ���� �۾����� ó���ϰ��� �� ��, ó���� �� �ִ� �۾��� �ִ� ���� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.


Input
ù ��° �ٿ��� �۾��� �� N�� �־�����. (100 �� N��1,000,000)

�� ��° �ٺ��� �� �۾��鿡 ���� ���۽ð� Si�� ����ð� Fi�� �־�����. (Si �� Fi,  100��| Fi - Si |�� 1,000)


Output
�ִ�� ó�� ������ �۾��� ���� ����Ѵ�.


Sample Input 1 

13
7 101
121 219
216 330
1 336
72 344
156 369
7 412
42 426
229 451
63 453
197 476
214 545
568 577
Sample Output 1

4
-----------------------------
C++
#include <algorithm>
#include <cstdio>
#include <vector>
#include <utility>
using namespace std;
bool sortsec(const pair<int,int> &a, const pair<int,int> &b) 
{ 
return (a.second < b.second); 
} 
int main() 
{
int N, i, n1, m, ground, cen = 0;
scanf("%d", &N);
vector <pair <int, int> > v;

for (i = 0; i < N; i++) 
{
  scanf("%d %d", &n1, &m);
  v.push_back(make_pair(n1, m));
}
  sort(v.begin(), v.end());
  sort(v.begin(), v.end(), sortsec);

  ground = v[0].second;
  cen++;

for (i = 1; i < N; i++) 
{
  if (v[i].first >= ground) 
  {
  ground = v[i].second;
  cen++;
  }
  }
  printf("%d\n", cen);
  return 0;
  }
*/

