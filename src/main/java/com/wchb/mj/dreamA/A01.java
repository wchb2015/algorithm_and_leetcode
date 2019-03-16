package com.wchb.mj.dreamA;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @date 3/12/19 4:49 PM
 */
public class A01 {

    /*
    merge N files to 1 file, can only merge two files at one time,
    merge time is the sum of two files size, given a list of file size,
     return the min merge time.
     */

    public int mergeFiles(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0;

        for (int i : arr) q.offer(i);

        while (!q.isEmpty()) {
            int f1 = q.poll();
            int f2 = q.poll();

            if (!q.isEmpty()) {
                q.offer(f1 + f2);
            }
            ans += (f1 + f2);
        }

        return ans;
    }


    /*
    有两个List of apps， 里面存着每一个app的index 和 它所需的memory。
    从 foregroundList<Integer>（[1, 200], [2, 300]） 和一个boregroundList<Integer> ([1, 400], [2, 500]) 中各取一个组成一对,
    使得它们memory加起来的和最接近但不超过capacity。 需要注意的是多个app的memory有可能是相同。
    例如：  foregroundList<Integer> =[[1, 2000]], boregroundList<Integer> = [[1, 8000], [2, 8000]],
     capacity = 10000. 需要返回 [[1,1], [1,2]]
     */

    public int[][] approximateMemUsage(List<int[]> foregroundList, List<int[]> backgroundList, int capacity) {


        int min = Integer.MAX_VALUE;
        LinkedList<int[]> pair = new LinkedList<>();

        for (int i = 0; i < foregroundList.size(); i++) {
            for (int j = 0; j < backgroundList.size(); j++) {
                int diff = Math.abs(capacity - (foregroundList.get(i)[1] + backgroundList.get(j)[1]));
                if (diff < min) {
                    min = diff;
                    pair.clear();
                    pair.add(new int[]{foregroundList.get(i)[0], backgroundList.get(j)[0]});
                } else if (diff == min) {
                    pair.add(new int[]{foregroundList.get(i)[0], backgroundList.get(j)[0]});
                }
            }
        }

        for (int[] p : pair) {
            System.out.println(Arrays.toString(p));
        }

        return null;
    }

    /**
     * int numTotalAvailableCities: if N = 3. the cities are[1,2,3]
     * int numTotalAvailRoads:
     * List<int[]> roadsAvailable.
     * int numNewRoadsConstruct.
     * List<int[]> numNewRoadsConstruct eg:[1,3,10] to construct a road between cities 1 and 3, the cost would be 10.
     */


    /**
     *  numTotalAvailableCities: 6
     *  numTotalAvailRoads: 3
     *  roadsAvailable: (1,4) (4,5) (2,3)
     *  numNewRoadsConstruct: 4
     *  numNewRoadsConstruct(1,2,5) (1,3,10) (1,6,2) (5,6,5)
     *
     *  output: 7
     */

    /**
     * numTotalAvailableCities [0,50]
     * cost [1,1000]
     */
    public void mst(int numTotalAvailableCities,
                    int numTotalAvailRoads,
                    List<int[]> roadsAvailable,
                    int numNewRoadsConstruct,
                    List<int[]> numNewRoadsConstructCost) {


        UF uf = new UF(numTotalAvailableCities);

        for (int[] road : roadsAvailable) {
            uf.union(road[0], road[1]);
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        for (int[] c : numNewRoadsConstructCost) {
            if (uf.find(c[0]) == uf.find(c[1])) continue;
            pq.offer(new Edge(c[0], c[1], c[2]));
        }


        int ans = 0;
        while (!pq.isEmpty()) {

            Edge cur = pq.poll();
            if (uf.find(cur.from) == uf.find(cur.to)) continue;

            uf.union(cur.from, cur.to);
            ans += cur.cost;


        }


        System.out.println(ans);

    }

    class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }


    class UF {

        int size;
        int[] arr;

        public UF(int size) {
            this.size = size;
            arr = new int[size + 1];
            Arrays.fill(arr, -1);
        }

        public int size() {
            return size;
        }

        public void union(int v, int x) {

            if (find(v) == find(x)) return;

            int idOfV = find(v);
            int idOfX = find(x);


            for (int i = 0; i < arr.length; i++) {
                if (find(i) == idOfX) {
                    size--;
                    arr[i] = idOfV;
                }
            }

        }


        public int find(int v) {
            if (arr[v] == -1) return v;
            return arr[v];
        }
    }


}
