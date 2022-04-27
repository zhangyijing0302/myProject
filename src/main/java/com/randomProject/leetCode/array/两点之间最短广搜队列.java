package com.randomProject.leetCode.array;

import java.util.*;

/**
 * 初步想法，在java中定义一个二维数组表示平面地图，有x和y坐标，我们可以约定一个起点（x1, y1） 约定一个终点（x2, y2）,
 * 从起点开始。可以进行上下左右移动，移动就是对应的坐标轴x或者y加减1，
 * 1.因为有障碍物，所以可能出现场景我想下一步左移但是我发现左边是障碍物，所以我就不能左移
 * 2.还有一种场景我左边没有障碍物但是我已经到达地图的最左边了，所以我不能左移，
 * 3.因为是要找出一点到另外一点的距离，所以我不能第一步往前走第二步往后走，如此循环没有意义，所以已经走过的路就不能再走了
 * 以上三点就相当于是决定下一个目标能不能走的判定条件
 * 所以在代码实现上需要一个循环，循环截至的条件就是起点和终点坐标的重合，循环的过程中我不能一次循环考虑一种情况。应该对于一个起点而言。
 * 开始循环时就四个方向同时开花，从起点开始我需要考虑到上下左右的四个选择，我的这四个选择又面临的各自的上下左右的选择
 * 所以实现上可以一次循环中记录下次循环中需要循环的可能，这种功能应该也可以通过组装一个map记录减少循环的次数，（应该）
 *
 * 然后通过上网查询认识到两种搜寻最短点的方式，一个叫广度优先一个叫深度优先,我的初步思路应该偏向于广度优先这个方向的，
 *
 * 然后深度搜索的方式的思路的话我理解的时他是需要一次一条行得通的路走到头，直到把所有的可能都走遍然后找出最短的那条，
 * 所以这个在实现过程中，上下左右移动肯定都是一样的，只不过是当我尝试按照约定的一个方向走，走着走着我发现这条路行不通，我是需要倒回去重新走的，
 * “倒回去”这步操作我觉得应该考虑的点是倒回到哪里去？比如我第一步有三个方向我选择了第一个方向，第二步的时候也有三个方向，我又选择了第一个方向，
 * 第三步的时候发现走不通，那我是需要回退的，我觉得应该把这条路做一个标记，然后"倒回去"到第二步，选择第二个方向继续尝试。
 * 与广度思路一样的是，同样我需要准备一个集合来记录确定走不通的坐标点。初步的想法，研究不太深入不敢十分肯定。
 *
 */
public class 两点之间最短广搜队列 {
    public static String[][] getInput(String a) {
        String[] b = a.split("\n");
        int n = 0, m = 0;
        m = b.length;
        for (int i = 0; i < b.length; i++) {
            String[] c = b[i].split("  ");
            n = c.length;
            break;
        }
        String[][] x = new String[m][n];
        for (int i = 0; i < b.length; i++) {
            String[] c = b[i].split("  ");
            for (int j = 0; j < c.length; j++) {
                x[i][j] = c[j];
            }
        }
        return x;
    }

    public static Boolean canAdd(String[][] a, Integer x, Integer y, Set<Integer> cache) {
        int m = a[0].length;
        int n = a.length;
        if (x < 0 || x >= m) {
            return false;
        }
        if (y < 0 || y >= n) {
            return false;
        }
        if (a[y][x].equals("0") && !cache.contains(x * 100000 + y)) {
            cache.add(x * 100000 + y);
            return true;
        }
        return false;
    }

    public static Integer bfsQueue(String[][] a) {
        Queue<Integer> queue = new LinkedList<>();
        int m = a[0].length;
        int n = a.length;
        int rux = -1, ruy = 0;
        int chux = -1, chuy = n - 1;
        for (int i = 0; i < m; i++) {
            if (a[0][i].equals("0")) {
                    rux = i;
            }
            if (a[n - 1][i].equals("0")) {
                    chux = i;
            }
        }
        Integer ans = 0;
        Set<Integer> cache = new HashSet<>();
        cache.add(rux * 100000 + ruy);
        queue.add(rux * 100000 + ruy);
        Map<Integer, Integer> buzi = new HashMap<>();
        buzi.put(rux * 100000 + ruy, 0);
        int flag = 0;
        while (!queue.isEmpty()) {
            Integer val = queue.poll();
            int x = val / 100000;
            int y = val % 100000;
            if (x == chux && y == chuy) {
                    flag = 1;
                ans = buzi.get(x * 100000 + y);
                break;
            }
            // TODO: 2022/1/11 根据现在的坐标，上下左右走
            if (canAdd(a, x - 1, y, cache)) {
                buzi.put((x - 1) * 100000 + y, buzi.get(x * 100000 + y)+1);
                queue.add((x - 1) * 100000 + y);
            }
            if (canAdd(a, x + 1, y, cache)) {
                buzi.put((x + 1) * 100000 + y, buzi.get(x * 100000 + y)+1);
                queue.add((x + 1) * 100000 + y);
            }
            if (canAdd(a, x, y - 1, cache)) {
                buzi.put(x * 100000 + (y - 1), buzi.get(x * 100000 + y)+1);
                queue.add(x * 100000 + (y - 1));
            }
            if (canAdd(a, x, y + 1, cache)) {
                buzi.put(x * 100000 + y + 1, buzi.get(x * 100000 + y)+1);
                queue.add(x * 100000 + (y + 1));
            }
        }
        if (flag == 1){
            return ans;
        }
        return -1;
    }

    public static void demo() {
        String a =  "1  1  1  1  1  1  1  0  1\n" +
                    "1  0  0  0  0  0  0  0  1\n" +
                    "1  0  0  0  0  0  0  0  1\n" +
                    "1  0  0  0  0  0  0  0  1\n" +
                    "1  0  0  0  0  0  0  0  1";
        String[][] b = getInput(a);

        Integer ans = bfsQueue(b);
        System.out.println(ans == -1 ? "不可达" : "可达，最短距离为" + ans + "步");
    }

    public static void main(String[] args) {
        demo();
    }
}