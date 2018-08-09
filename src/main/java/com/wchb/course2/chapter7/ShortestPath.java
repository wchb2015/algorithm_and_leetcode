package com.wchb.course2.chapter7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @date 6/14/18 7:03 AM
 */
public class ShortestPath {

    // 图的引用
    private IGraph g;
    // 起始点
    private int s;
    // 记录bfs的过程中节点是否被访问
    private boolean[] visited;
    // 记录路径,  from[i]表示查找的路径上i的上一个节点
    private int[] from;
    // 记录路径中节点的次序。order[i]表示i节点在路径中的次序。
    private int[] order;

    //构造函数,寻路算法,寻找图g从点s到其它点的路径
    public ShortestPath(IGraph g, int s) {
        this.g = g;
        this.s = s;

        if (s < 0 || s >= g.V()) {
            throw new IllegalArgumentException();
        }

        visited = new boolean[g.V()];
        from = new int[g.V()];
        order = new int[g.V()];

        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            order[i] = -1;
        }

        //无向图最短路径算法, 从s开始BSF遍历整张图
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        order[s] = 0;

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int i : g.iterable(v)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    order[i] = order[v] + 1;
                }
            }
        }
    }

    // 查询从s点到w点的路径, 存在在List中
    public List<Integer> path(int w) {
        assert hasPath(w);

        Stack<Integer> s = new Stack<>();

        // 通过from数组逆向找到从s到w的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        //从栈中依次取出元素, 获得顺序的从s到w的路径
        List<Integer> ret = new LinkedList<>();
        while (!s.empty()) {
            ret.add(s.pop());
        }
        return ret;
    }

    //打印从s点到w点的路径
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

    public boolean hasPath(int w) {
        if (w < 0 || w >= g.V()) {
            throw new IllegalArgumentException();
        }
        return visited[w];
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w) {
        assert w >= 0 && w < g.V();
        return order[w];
    }

}
