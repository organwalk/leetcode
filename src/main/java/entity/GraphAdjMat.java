package entity;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMat {
    List<Integer> vertices; // 顶点列表
    List<List<Integer>> adjMat; // 邻接矩阵

    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        // 添加顶点
        for (int val : vertices) {
            addVertex(val);
        }
        // 添加边
        for (int[] e : edges) {
            addEdge(e[0], e[1]);
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return vertices.size();
    }

    public void addVertex(int val){
        int n = size();
        vertices.add(val);
        List<Integer> newRow = new ArrayList<>();
        for (int j = 0; j < n; j++){
            newRow.add(0);
        }
        adjMat.add(newRow);
        for (List<Integer> row : adjMat){
            row.add(0);
        }
    }

    public void removeVertex(int index){
        if (index >= size())
            throw new IndexOutOfBoundsException();
        vertices.remove(index);
        adjMat.remove(index);
        for (List<Integer> row : adjMat){
            row.remove(index);
        }
    }

    public void addEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        // 在无向图中，邻接矩阵关于主对角线对称，即满足 (i, j) == (j, i)
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    /* 删除边 */
    // 参数 i, j 对应 vertices 元素索引
    public void removeEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    public void print() {
        for (Integer element : vertices) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("======");
        printMatrix(this.adjMat);
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
