package com.wchb.course2.chapter7;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @date 7/17/18 2:09 PM
 */
public class Path {

    private IGraph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点

    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public Path(IGraph graph, int s) {

        // 算法初始化
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        // 寻路算法
        dfs(s);
    }

    // 图的深度优先遍历
    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.iterable(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s点到w点的路径, 存放在vec中
    List<Integer> path(int w) {

        assert hasPath(w);

        Stack<Integer> s = new Stack<>();
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        List<Integer> res = new LinkedList<>();
        while (!s.empty()) {
            res.add(s.pop());
        }

        return res;
    }

    // 查询从s点到w点的路径, 存放在vec中
    List<Integer> pathV2(int w) {
        assert hasPath(w);
        LinkedList<Integer> res = new LinkedList<>();
        int p = w;
        while (p != -1) {
            res.addFirst(p);
            p = from[p];
        }
        return res;
    }

    // 打印出从s点到w点的路径
    public void showPath(int w) {

        assert hasPath(w);

        List<Integer> list = path(w);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i == list.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }
}
