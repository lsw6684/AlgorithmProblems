/*
Closest Pair (hard)
Description

모든 주어진 점들에 대하여, 점들 사이의 거리의 최소 값을 구하라.


Input
첫 번째 줄에는 전체 점의 개수가 주어집니다.

두 번째 줄부터 각 점들의 x좌표, y좌표가 주어지며, 이 두 숫자는 쉼표와 띄어쓰기 한 칸으로 구분됩니다.


Output
점들 사이의 거리들 중 가장 짧은 거리의 값을 소숫점 이하 6자리로 나타내시오.


Sample Input 1 

1000
971239, 121876
463918, 254404
547547, 744402
859997, 729153
115418, 603248
261717, 147646
408682, 217164
...
Sample Output 1

123.456789
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        List<Point> arr = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine(), ", ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x, y));
        }

        // x 좌표 기준 정렬
        Collections.sort(arr, new xComparator());

        // 정답 출력
        System.out.println(String.format("%.6f", closest(arr, 0, N - 1)));
    }

    static double closest(List<Point> arr, int left, int right)
    {
        int sectionSize = right - left + 1;
        // 분할된 x좌표상 크기가 3이하이면
        if (sectionSize <= 3)
        {
            // 가장 가까운 점의 거리를 구합니다.
            return bruteForce(arr, left, right);
        }

        int mid = (left + right) / 2;
        double leftSectionDistance = closest(arr, left, mid);
        double rightSectionDistance = closest(arr, mid + 1, right);

        // Left Side와 Right Side에서 구한 최소 거리 중 더 작은 값을 전체 구간 중 최소 거리로 임시 설정
        double answer = Math.min(leftSectionDistance, rightSectionDistance);

        List<Point> middleSection = new ArrayList<>(); // 왼쪽과 오른쪽 사이의 점들을 저장할 List

        for (int i = left; i <= right; i++)
        {
            // 중앙을 기준으로 거리를 비교 (제곱하기 때문에 음수는 무의미)
            int xDist = arr.get(i).x - arr.get(mid).x;
            // x 좌표간 거리가 현재 최소 거리 d 보다 작은 경우만 고려
            if (xDist * xDist < answer)
            {
                middleSection.add(arr.get(i));
            }
        }

        // y 좌표 기준으로 정렬 (이제 x좌표 기준은 무의미)
        Collections.sort(middleSection, new yComparator());
        int candidateSize = middleSection.size();
        for (int i = 0; i < candidateSize - 1; i++)
        {
            for (int j = i + 1; j < candidateSize; j++)
            {
                int yDist = middleSection.get(j).y - middleSection.get(i).y;
                if (yDist * yDist < answer)
                {
                    double dist = findDistance(middleSection.get(i), middleSection.get(j));
                    if (dist < answer)
                    {
                        answer = dist;
                    }
                }
                // y좌표 기준 오름차순 정렬했기 때문에 기준점과 가장 가까운 좌표가 answer보다 멀면
                // 다음 좌표들 비교는 무의미 하므로 break한 후, 다른 좌표를 기준으로 해서 반복
                else
                {
                    break;
                }
            }
        }
        return answer;
    }

    // 완전 탐색으로 가장 가까운 거리 찾기
    static double bruteForce(List<Point> arr, int left, int right)
    {
        double answer = Double.MAX_VALUE;
        for (int i = left; i < right; i++)
        {
            for (int j = i + 1; j <= right; j++)
            {
                double temp = findDistance(arr.get(i), arr.get(j));
                if (answer > temp)
                {
                    answer = temp;
                }
            }
        }
        return answer;
    }

    // Euclidean Distance의 제곱
    static double findDistance(Point p1, Point p2)
    {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}

class xComparator implements Comparator<Point>
{
    // x 좌표 기준 정렬
    @Override
    public int compare(Point p1, Point p2)
    {
        return p1.x - p2.x;
    }

}

class yComparator implements Comparator<Point>
{
    // y 좌표 기준 정렬
    @Override
    public int compare(Point p1, Point p2)
    {
        return p1.y - p2.y;
    }

}

class Point
{
    int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}