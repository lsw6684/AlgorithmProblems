/*
Description

어떤 기계에서 수행되는 N개의 작업(task) t1, t2, ..., tn이 존재하고, 각 작업들은 각자의 시작시간 Si와 종료시간 Fi를 갖는다.

각 작업들은 반드시 주어진 시작시간에 시작되어야 하고, 주어진 공료시간에 종료된다. 또한, 하나의 기계는 동시에 하나의 작업만 수행할 수 있다.

한 대의 기계만을 사용하여 전체 N개의 작업들 중 가능한 많은 작업들을 처리하고자 할 때, 처리할 수 있는 작업의 최대 수는 몇 개인지 구하는 프로그램을 작성하시오.


Input
첫 번째 줄에는 작업의 수 N이 주어진다. (100 ≤ N≤1,000,000)

두 번째 줄부터 각 작업들에 대한 시작시간 Si와 종료시간 Fi가 주어진다. (Si ＜ Fi,  100≤| Fi - Si |≤ 1,000)


Output
최대로 처리 가능한 작업의 수를 출력한다.


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

