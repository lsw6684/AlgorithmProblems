/*
Task(Job) Scheduling
Description

어떤 기계에서 수행되는 N개의 작업(task)  t1, t2, ..., tn이 존재하고, 각 작업들은 시작시간 Si와 종료시간 Fi를 갖는다.

각 작업들은 반드시 주어진 시작시간에 시작되어야 하고, 종료시간에 종료된다.

또한, 하나의 기계는 동시에 하나의 작업만 수행할 수 있다.

여러 개의 기계를 이용해 N개의 작업들을 모두 끝내고자 할 때, 최소로 필요한 기계의 수를 구하는 프로그램을 작성하시오.


Input
첫 번째 줄에는 작업의 수 N이 주어진다. (100 ≤ N≤10,000,000)

두 번째 줄부터 각 작업들에 대한 시작시간 Si와 종료시간 Fi가 주어진다. (Si ＜ Fi,  100≤| Fi - Si |≤ 1,000)


Output
최소로 필요한 기계의 수를 출력한다.


Sample Input 1 

10
96 106
14 19
54 62
85 91
49 58
13 23
96 103
72 77
60 70
45 53
Sample Output 1

2
-------------------------------------------------
#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>
#include <queue>
using namespace std;
 
typedef pair<int, int> P;
 
int n;
vector<P> lec;

// 각 기계가 일을 끝내는 시간을 넣어둠.
// 그리디 알고리즘으로 진행하기 위해 가장 빨리 끝나있는 방(우선순위 큐의 탑)에 넣음.
// 가장 빨리 끝나는 기계도 작동 안되면 새로운 기계 이용.
priority_queue<int, vector<int>, greater<int>> fastestMachinesTime;
void solve3(){
    fastestMachinesTime.push(lec[0].second);
    for(int i = 1; i < n; i++){
        // 가장 빠르게 이용가능한 기계를 돌릴 수 있음.
        if(fastestMachinesTime.top() <= lec[i].first){
            // 이용한 기계의 끝나는 시간을 바꿔줌.
            fastestMachinesTime.pop();
            fastestMachinesTime.push(lec[i].second);
        }else{
            fastestMachinesTime.push(lec[i].second);
        }
    }
}
 
 
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    lec.resize(n);
    
    for(int i = 0; i < n; i++)
        cin >> lec[i].first >> lec[i].second;
    sort(lec.begin(), lec.end());
 
    solve3();
    cout << fastestMachinesTime.size() << '\n';
    return 0;
}
*/