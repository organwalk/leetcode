package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    int val;

    public Vertex(int val) {
        this.val = val;
    }

    public static List<Vertex> valsToVets(int[] values) {
        List<Vertex> vertices = new ArrayList<>();
        for (int val : values) {
            vertices.add(new Vertex(val));
        }
        return vertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
