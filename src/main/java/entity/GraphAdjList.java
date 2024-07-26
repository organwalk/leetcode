package entity;

import java.util.*;

/**
 * List<Vertex> v = valsToVets(new int[]{0, 1, 2, 3, 4});
 *         Vertex[][] edges = {
 *                 {v.get(0), v.get(1)},
 *                 {v.get(0), v.get(3)},
 *                 {v.get(1), v.get(2)},
 *                 {v.get(1), v.get(4)},
 *                 {v.get(3), v.get(4)}
 *         };
 *         GraphAdjList graph = new GraphAdjList(edges);
 */
public class GraphAdjList {
    // 邻接表，key：顶点，value：该顶点的所有邻接顶点
    Map<Vertex, List<Vertex>> adjList;

    /* 构造方法 */
    public GraphAdjList(Vertex[][] edges) {
        this.adjList = new HashMap<>();
        // 添加所有顶点和边
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return adjList.size();
    }

    /* 添加边 */
    public void addEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2)
            throw new IllegalArgumentException();
        // 添加边 vet1 - vet2
        adjList.get(vet1).add(vet2);
        adjList.get(vet2).add(vet1);
    }

    /* 删除边 */
    public void removeEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2)
            throw new IllegalArgumentException();
        // 删除边 vet1 - vet2
        adjList.get(vet1).remove(vet2);
        adjList.get(vet2).remove(vet1);
    }

    /* 添加顶点 */
    public void addVertex(Vertex vet) {
        if (adjList.containsKey(vet))
            return;
        // 在邻接表中添加一个新链表
        adjList.put(vet, new ArrayList<>());
    }

    /* 删除顶点 */
    public void removeVertex(Vertex vet) {
        if (!adjList.containsKey(vet))
            throw new IllegalArgumentException();
        // 在邻接表中删除顶点 vet 对应的链表
        adjList.remove(vet);
        // 遍历其他顶点的链表，删除所有包含 vet 的边
        for (List<Vertex> list : adjList.values()) {
            list.remove(vet);
        }
    }

    /* 打印邻接表 */
    public void print() {
        System.out.println("邻接表 =");
        for (Map.Entry<Vertex, List<Vertex>> pair : adjList.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : pair.getValue())
                tmp.add(vertex.val);
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }

    // 广度优先遍历
    public List<Vertex> graphBFS(GraphAdjList graph, Vertex startVet){
        List<Vertex> res = new ArrayList<>(); // 顶点遍历序列
        Set<Vertex> visited = new HashSet<>();
        visited.add(startVet);
        Queue<Vertex> que = new LinkedList<>();
        que.offer(startVet);
        while (!que.isEmpty()){
            Vertex vet = que.poll();
            res.add(vet);
            for (Vertex adjVet : graph.adjList.get(vet)){
                if (visited.contains(adjVet)) continue;
                que.offer(adjVet);
                visited.add(adjVet);
            }
        }
        return res;
    }
    void dfs(GraphAdjList graph, Set<Vertex> visited, List<Vertex> res, Vertex vet){
        res.add(vet);
        visited.add(vet);
        for (Vertex adjVet : graph.adjList.get(vet)){
            if (visited.contains(adjVet)) continue;
            dfs(graph, visited, res, adjVet);
        }
    }

    public List<Vertex> graphDFS(GraphAdjList graph, Vertex startVet) {
        // 顶点遍历序列
        List<Vertex> res = new ArrayList<>();
        // 哈希集合，用于记录已被访问过的顶点
        Set<Vertex> visited = new HashSet<>();
        dfs(graph, visited, res, startVet);
        return res;
    }
}
