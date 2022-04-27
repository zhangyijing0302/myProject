package com.randomProject.leetCode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 *
 */
public class 两点之间最短广搜粗暴 {
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

    public static Integer bfs(String[][] a) {
        // 规定入口在第一行，出口在最后一行
        int m = a[0].length;
        int n = a.length;
        int rux = -1, ruy = 0;
        int chux = -1, chuy = n - 1;
        for (int i = 0; i < m; i++) {
            if (a[0][i].equals("0")) {
                    // TODO: 2022/1/11 找到入口
                    rux = i;
            }
            if (a[n - 1][i].equals("0")) {
                    chux = i;
            }
        }
        Integer ans = 0;
        Set<Integer> cache = new HashSet<>();
        cache.add(rux * 100000 + ruy);
        List<Integer> nexts = new ArrayList<>();
        nexts.add(rux * 100000 + ruy);
        while (true) {
            if (nexts.size() == 0) {
                    ans = -1;
                break;
            }
            int flag = 0;
            List<Integer> tmpNexts = new ArrayList<>();
            for (Integer next : nexts) {
                int x = next / 100000;
                int y = next % 100000;
                if (x == chux && y == chuy) {
                        flag = 1;
                    break;
                }
                // TODO: 2022/1/11 根据现在的坐标，上下左右走
                if (canAdd(a, x - 1, y, cache))  {
                    tmpNexts.add((x - 1) * 100000 + y);
                }
                if (canAdd(a, x + 1, y, cache)) {
                    tmpNexts.add((x + 1) * 100000 + y);
                }
                if (canAdd(a, x, y - 1, cache)) {
                    tmpNexts.add(x * 100000 + (y - 1));
                }
                if (canAdd(a, x, y + 1, cache)) {
                    tmpNexts.add(x * 100000 + (y + 1));
                }
            }
            nexts.clear();
            nexts.addAll(tmpNexts);
            if (flag == 1) {
                break;
            }else {
                ans++;
            }
        }
        return ans;
    }

    public static void demo() {
        String a =  "1  1  0  1  1  1  1  1  1\n" +
                    "1  0  0  0  0  0  0  1  1\n" +
                    "1  0  1  1  1  1  0  1  1\n" +
                    "1  0  0  0  0  0  0  0  1\n" +
                    "1  1  1  1  1  1  1  0  1";
        String[][] b = getInput(a);

        Integer ans = bfs(b);
        System.out.println(ans == -1 ? "不可达" : "可达，最短距离为" + ans + "步");
    }

    public static void main(String[] args) {
        demo();
    }
}