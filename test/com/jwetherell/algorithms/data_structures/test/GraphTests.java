package com.jwetherell.algorithms.data_structures.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.TYPE;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;

public class GraphTests {

    @Test
    public void testVertex() {
        final Vertex<Integer> p1 = new Vertex<Integer>(10,1);
        final Vertex<Integer> p2 = new Vertex<Integer>(10,2);
        final Vertex<Integer> p3 = new Vertex<Integer>(20,1);
        final Vertex<Integer> p4 = new Vertex<Integer>(20,2);
        final Vertex<Integer> p5 = new Vertex<Integer>(10,1);

        Assert.assertFalse(p1.equals(p2));
        Assert.assertFalse(p2.equals(p1));
        Assert.assertFalse(p1.equals(p3));
        Assert.assertFalse(p3.equals(p1));
        Assert.assertFalse(p1.equals(p4));
        Assert.assertFalse(p4.equals(p1));

        Assert.assertTrue(p1.equals(p5) && p1.hashCode()==p5.hashCode());
        Assert.assertTrue(p5.equals(p1) && p5.hashCode()==p1.hashCode());
    }

    @Test
    public void testEdge() {
        final Vertex<Integer> p1 = new Vertex<Integer>(10,1);
        final Vertex<Integer> p2 = new Vertex<Integer>(10,2);
        final Vertex<Integer> p3 = new Vertex<Integer>(20,1);
        final Vertex<Integer> p4 = new Vertex<Integer>(10,1);

        final Edge<Integer> e1 = new Edge<Integer>(1,p1,p2);
        final Edge<Integer> e2 = new Edge<Integer>(1,p2,p1);
        final Edge<Integer> e3 = new Edge<Integer>(2,p1,p2);
        final Edge<Integer> e4 = new Edge<Integer>(1,p1,p3);
        final Edge<Integer> e5 = new Edge<Integer>(1,p4,p2);

        Assert.assertFalse(e1.equals(e2));
        Assert.assertFalse(e2.equals(e1));
        Assert.assertFalse(e1.equals(e3));
        Assert.assertFalse(e3.equals(e1));
        Assert.assertFalse(e1.equals(e3));
        Assert.assertFalse(e3.equals(e1));
        Assert.assertFalse(e1.equals(e4));
        Assert.assertFalse(e4.equals(e1));

        Assert.assertTrue(e1.equals(e5) && e1.hashCode()==e5.hashCode());
        Assert.assertTrue(e5.equals(e1) && e5.hashCode()==e1.hashCode());
    }

    @Test
    public void testGraph() {
        final List<Vertex<Integer>> vertices = new ArrayList<Vertex<Integer>>();
        final Vertex<Integer> p1 = new Vertex<Integer>(10,1);
        vertices.add(p1);
        final Vertex<Integer> p2 = new Vertex<Integer>(10,2);
        vertices.add(p2);
        final Vertex<Integer> p3 = new Vertex<Integer>(20,1);
        vertices.add(p3);
        final Vertex<Integer> p4 = new Vertex<Integer>(10,2);
        vertices.add(p4);

        final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        final Edge<Integer> e1 = new Edge<Integer>(1,p1,p2);
        edges.add(e1);
        final Edge<Integer> e2 = new Edge<Integer>(1,p2,p1);
        edges.add(e2);
        final Edge<Integer> e3 = new Edge<Integer>(2,p1,p2);
        edges.add(e3);
        final Edge<Integer> e4 = new Edge<Integer>(1,p1,p3);
        edges.add(e4);
        final Edge<Integer> e5 = new Edge<Integer>(1,p4,p2);
        edges.add(e5);

        final Graph<Integer> graph = new Graph<Integer>(TYPE.DIRECTED, vertices, edges);
        final Graph<Integer> clone = new Graph<Integer>(graph);

        Assert.assertTrue(graph.equals(clone) && graph.hashCode()==clone.hashCode());
    }

    @Test
    public void testGraphImproved() {
        final List<Vertex<Integer>> vertices = new ArrayList<Vertex<Integer>>();
        final List<Vertex<Integer>> vertices2 = new ArrayList<Vertex<Integer>>();
        final List<Vertex<Integer>> vertices3 = new ArrayList<Vertex<Integer>>();
        final Vertex<Integer> p1 = new Vertex<Integer>(10,1);
        vertices.add(p1);
        vertices3.add(p1);
        final Vertex<Integer> p2 = new Vertex<Integer>(10,2);
        vertices.add(p2);
        final Vertex<Integer> p3 = new Vertex<Integer>(10,1);
        vertices3.add(p3);
        final Vertex<Integer> p4 = new Vertex<Integer>(20,2);
        vertices.add(p4);
        vertices3.add(p4);
        final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        final List<Edge<Integer>> edges2 = new ArrayList<Edge<Integer>>();
        final List<Edge<Integer>> edges3 = new ArrayList<Edge<Integer>>();
        final Edge<Integer> e1 = new Edge<Integer>(1,p1,p3);
        edges.add(e1);
        edges3.add(e1);
        final Edge<Integer> e2 = new Edge<Integer>(1,p2,p2);
        edges3.add(e2);
        final Edge<Integer> e3 = new Edge<Integer>(2,p3,p1);
        edges.add(e3);
        edges3.add(e3);
        final Edge<Integer> e4 = new Edge<Integer>(2,p3,p4);
        edges.add(e4); 
        //add the undirected type test for graph() function
        final Graph<Integer> graph = new Graph<Integer>(TYPE.UNDIRECTED, vertices, edges);
        final Graph<Integer> graph2 = new Graph<Integer>(TYPE.DIRECTED, vertices, edges2);
        final Graph<Integer> graph3 = new Graph<Integer>(TYPE.DIRECTED, vertices3, edges);
        final Graph<Integer> graph4 = new Graph<Integer>(TYPE.DIRECTED, vertices3, edges2);
        final Graph<Integer> graph5 = new Graph<Integer>(TYPE.DIRECTED, vertices3, edges3);
        final Graph<Integer> graph6 = new Graph<Integer>(TYPE.DIRECTED, vertices2, edges);
        final Graph<Integer> clone = new Graph<Integer>(graph);
        
        Assert.assertFalse(graph.equals(clone) && graph.hashCode()==clone.hashCode());
        //test equals function if statement coverage
        Assert.assertFalse(p1.equals(e1));//instanceof
        Assert.assertFalse(e1.equals(p1));//instanceof
        Assert.assertFalse(graph.equals(e1));//instanceof
        Assert.assertFalse(graph.equals(graph2));//this.type == g.type
        Assert.assertFalse(graph2.equals(graph6));//this.allVertices.size() == g.allVertices.size();
        Assert.assertFalse(graph2.equals(graph4));//if (!v1.equals(v2))
        Assert.assertFalse(graph5.equals(graph3));//if (!e1.equals(e2))
        //test to string function
        Assert.assertEquals(graph4.toString(), graph4.toString());
        //e1.cost with e2.cost   if (e1.cost != e2.cost)
        Assert.assertFalse(p3.equals(p1));

    }


    @Test
    public void testCostVertexPair() {
        final Graph.CostVertexPair<Integer> p1 = new Graph.CostVertexPair<Integer>(1, new Vertex<Integer>(10));
        final Graph.CostVertexPair<Integer> p2 = new Graph.CostVertexPair<Integer>(1, new Vertex<Integer>(11));
        final Graph.CostVertexPair<Integer> p3 = new Graph.CostVertexPair<Integer>(2, new Vertex<Integer>(10));
        final Graph.CostVertexPair<Integer> p4 = new Graph.CostVertexPair<Integer>(1, new Vertex<Integer>(10));

        Assert.assertFalse(p1.equals(p2));
        Assert.assertFalse(p2.equals(p1));
        Assert.assertFalse(p1.equals(p3));
        Assert.assertFalse(p3.equals(p1));

        Assert.assertTrue(p1.equals(p4) && p1.hashCode()==p4.hashCode());
        Assert.assertTrue(p4.equals(p1) && p4.hashCode()==p1.hashCode());
    }

    @Test
    public void testCostPathPair() {
        final List<Edge<Integer>> s1 = new ArrayList<Graph.Edge<Integer>>(3);
        s1.add(new Edge<Integer>(1, new Vertex<Integer>(10), new Vertex<Integer>(20)));
        s1.add(new Edge<Integer>(2, new Vertex<Integer>(20), new Vertex<Integer>(30)));
        final Graph.CostPathPair<Integer> p1 = new Graph.CostPathPair<Integer>(1, s1);

        final List<Edge<Integer>> s2 = new ArrayList<Graph.Edge<Integer>>(3);
        s2.add(new Edge<Integer>(2, new Vertex<Integer>(10), new Vertex<Integer>(20)));
        s2.add(new Edge<Integer>(1, new Vertex<Integer>(20), new Vertex<Integer>(30)));
        final Graph.CostPathPair<Integer> p2 = new Graph.CostPathPair<Integer>(1, s2);

        final List<Edge<Integer>> s3 = new ArrayList<Graph.Edge<Integer>>(3);
        s3.add(new Edge<Integer>(2, new Vertex<Integer>(10), new Vertex<Integer>(20)));
        s3.add(new Edge<Integer>(1, new Vertex<Integer>(20), new Vertex<Integer>(30)));
        final Graph.CostPathPair<Integer> p3 = new Graph.CostPathPair<Integer>(1, s3);

        Assert.assertFalse(p1.equals(p2));
        Assert.assertFalse(p2.equals(p1));

        Assert.assertTrue(p2.equals(p3) && p2.hashCode()==p3.hashCode());
        Assert.assertTrue(p3.equals(p2) && p3.hashCode()==p2.hashCode());
    }
}
