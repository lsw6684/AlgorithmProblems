/*
Task(Job) Scheduling
Description

� ��迡�� ����Ǵ� N���� �۾�(task)  t1, t2, ..., tn�� �����ϰ�, �� �۾����� ���۽ð� Si�� ����ð� Fi�� ���´�.

�� �۾����� �ݵ�� �־��� ���۽ð��� ���۵Ǿ�� �ϰ�, ����ð��� ����ȴ�.

����, �ϳ��� ���� ���ÿ� �ϳ��� �۾��� ������ �� �ִ�.

���� ���� ��踦 �̿��� N���� �۾����� ��� �������� �� ��, �ּҷ� �ʿ��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.


Input
ù ��° �ٿ��� �۾��� �� N�� �־�����. (100 �� N��10,000,000)

�� ��° �ٺ��� �� �۾��鿡 ���� ���۽ð� Si�� ����ð� Fi�� �־�����. (Si �� Fi,  100��| Fi - Si |�� 1,000)


Output
�ּҷ� �ʿ��� ����� ���� ����Ѵ�.


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

// �� ��谡 ���� ������ �ð��� �־��.
// �׸��� �˰������� �����ϱ� ���� ���� ���� �����ִ� ��(�켱���� ť�� ž)�� ����.
// ���� ���� ������ ��赵 �۵� �ȵǸ� ���ο� ��� �̿�.
priority_queue<int, vector<int>, greater<int>> fastestMachinesTime;
void solve3(){
    fastestMachinesTime.push(lec[0].second);
    for(int i = 1; i < n; i++){
        // ���� ������ �̿밡���� ��踦 ���� �� ����.
        if(fastestMachinesTime.top() <= lec[i].first){
            // �̿��� ����� ������ �ð��� �ٲ���.
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