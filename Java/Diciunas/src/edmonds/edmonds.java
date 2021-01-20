/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edmonds;

import java.util.Vector;

/**
 *
 * @author User
 */
public class edmonds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph graph = new Graph();
        // graph.printGraph();
        // graph.printPath();
        //  graph.printfreeNodes();
        graph.getMaximumMatching();
        //graph.printPath();
        //graph.printfreeNodes();

        graph.printEdges();

        graph.printM();
    }

}
class blossom 
{
    public int index;
    public Vector<Edge> blossomEdges = new Vector<Edge>();
    public Vector<Integer> connections = new Vector<>();
}
class Edge {

    public int virsune1;
    public int virsune2;

    public Edge(int v1, int v2) {
        this.virsune1 = v1;
        this.virsune2 = v2;
    }

    public int getMate(int i) {
        if (i == virsune1) {
            return virsune2;
        } else if (i == virsune2) {
            return virsune1;
        }
        return -1;
    }
}

class BFSNode {

    public int Value;
    public int counter = 1;

    public int getValue() {
        return Value;
    }

    public boolean isOdd() {
        if (counter % 2 == 0) {
            return false;
        } else if (counter % 2 == 1) {
            return true;
        }
        return false;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }
    Vector<BFSNode> node = new Vector<BFSNode>();

    public BFSNode(int Value) {
        this.Value = Value;
    }

    public BFSNode() {
        this.Value = -1;
    }

    public void addNode(int number) {
        BFSNode a = new BFSNode(number);
        this.counter ++;
        node.add(a);
    }

    public Vector<Integer> getChildren() {
        Vector<Integer> ayaya = new Vector<Integer>();
        for (int i = 0; i < node.size(); i++) {
            ayaya.add(node.get(i).Value);
        }
        return ayaya;
    }

    public boolean isInTree(int w) {
        //System.out.println(this.Value + "   " + w );
        if (w == this.Value) {
            return true;
        }
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).isInTree(w)) {
                return true;
            }
        }
        return false;
    }
}

class Graph {

    boolean[][] Graph;
    public Vector<Edge> krastines = new Vector<Edge>();
    public Vector<Edge> M = new Vector<Edge>();
    public Vector<Integer> freeNodes = new Vector<Integer>();
    public Vector<Integer> BfsQueue = new Vector<Integer>();
    public int maximumMatchingNumber = 0;
    public BFSNode tree = new BFSNode();
    public Vector<Integer> Path = new Vector<Integer>();

    public Graph(boolean graph[][]) {
        this.Graph = graph;
        iniciateData();
    }

    public Graph() {
        randomGraph();
        // iniciateData();
        // findMaximumMatchhing(); // first try 
    }
    public void randomGraph() {
        this.Graph = new boolean[][]{
            {false, false, true, false},
            {false, false, true, true},
            {true, true, false, true},
            {false, true, true, false}
                
        };
        /*     3 ---
               |   |
               1  | 
              /  |
             0---2 
         */
        iniciateData();
        // getMaximumMatching();
        
//        
//    public void randomGraph() {
//        this.Graph = new boolean[][]{
//            {false, true, true, false},
//            {false, false, true, true},
//            {true, true, false, true},
//            {false, true, true, false}
//                
//        };
//        /*     3 
//               |
//               1
//              / \ 
//             0---2 
//         */
//        iniciateData();
//        // getMaximumMatching();
//        
        
//                this.Graph = new boolean[][]{
//            {false, true, true, false,false,false},
//            {true, false,false , true,false,false},
//            {true, false, false, false,false,true},
//            {false, true, false, false,true,false},
//            {false, false, false, true,false,true},
//            {false, false, true, false,true,false}
//        };
//        /*     3  -- 4
//               |     |
//               1     5
//              /      |
//             0---2 --|
//         */
//        iniciateData();
//        // getMaximumMatching();
    }

    public void printGraph() {
        System.out.println("GRAPH:");
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph[i].length; j++) {
                System.out.print(this.Graph[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void printEdges() {
        System.out.println("EDGES:");
        for (int i = 0; i < krastines.size(); i++) {

            System.out.println(this.krastines.get(i).virsune1 + "  " + this.krastines.get(i).virsune2);
        }

    }

    public void printM() {
        System.out.println("M:");
        for (int i = 0; i < M.size(); i++) {

            System.out.println(this.M.get(i).virsune1 + "  " + this.M.get(i).virsune2);
        }

    }

    public void iniciateData() {
        for (int i = 0; i < Graph.length; i++) {
            freeNodes.add(i);
        }
        for (int i = 0; i < Graph.length; i++) {
            for (int j = i; j < Graph.length; j++) {
                if (Graph[i][j] == true) {
                    krastines.add(new Edge(i, j));
                }
            }
        }
    }

    public void getMaximumMatching() {
        Path.add(freeNodes.firstElement());
        while (!freeNodes.isEmpty()) {
            System.out.println("kol yra neaptiktu virsuniu mes dedame i medi ir i queue");
            int r = freeNodes.firstElement();
            freeNodes.remove(0);
            boolean even_lenght = true;
            boolean odd_lenght = true;
            BfsQueue.add(r);
            tree = new BFSNode();
            tree.setValue(r);
            while (!BfsQueue.isEmpty()) {
                int v = BfsQueue.get(0);
                BfsQueue.remove(0);
                for (int i = 0; i < krastines.size(); i++) {

                    if (krastines.get(i).virsune1 == v) {
                        System.out.println("prasideda tikrinimas");
                        boolean isintheTree = tree.isInTree(krastines.get(i).virsune2);
                        if (!isintheTree && !freeNodes.contains(krastines.get(i).virsune2)) {
                            System.out.println("w nepriklauso T ir W matched");
                            tree.addNode(krastines.get(i).virsune2);
                            tree.addNode(getMate(krastines.get(i).virsune2));
                            BfsQueue.add(getMate(krastines.get(i).virsune2));
                        } else if (isintheTree && !tree.isOdd()) {
                            System.out.println("even lenght cycle");
                            continue;
                        } else if (isintheTree && tree.isOdd()) {
                            System.out.println("odd lenght cycle");
                            // we found a odd lenght cycle and we contract it 
                        } else if (freeNodes.contains(krastines.get(i).virsune2)) {
                            System.out.println("nauja virsune pridedame");
                            M.add(new Edge(v, krastines.get(i).virsune2));
                            for (int j = 0; j < freeNodes.size(); j++) {
                                if (freeNodes.get(j) == krastines.get(j).virsune2) {
                                    freeNodes.remove(j);
                                }
                            }

                            break;
                        }
                    }
                    if (krastines.get(i).virsune2 == v) {
                        System.out.println("prasideda tikrinimas");
                        boolean isintheTree = tree.isInTree(krastines.get(i).virsune1);
                        if (!isintheTree && !freeNodes.contains(krastines.get(i).virsune1)) {
                            System.out.println("w nepriklauso T ir W matched");
                            tree.addNode(krastines.get(i).virsune1);
                            tree.addNode(getMate(krastines.get(i).virsune1));
                            BfsQueue.add(getMate(krastines.get(i).virsune1));
                        } else if (isintheTree && !tree.isOdd()) {
                            System.out.println("eveb lenght cycle");
                            // we found a evne lenght cycle and dont do siht about it.
                            continue;
                        } else if (isintheTree && tree.isOdd()) {
                            System.out.println("odd lenght cycle");
                            // we found a odd lenght cycle and we contract it 
                        } else if (freeNodes.contains(krastines.get(i).virsune1)) {
                            System.out.println("nauja virsune pridedame");
                            M.add(new Edge(v, krastines.get(i).virsune1));
                            for (int j = 0; j < freeNodes.size(); j++) {
                                if (freeNodes.get(j) == krastines.get(j).virsune1) {
                                    freeNodes.remove(j);
                                }
                            }

                            break;
                        }
                    }
                }
            }

        }

    }

    public boolean matched(int w) {
        if (getMate(w) != -1) {
            return true;
        }
        return false;
    }

    public void printPath() {
        System.out.println("PATH:");
        for (int i = 0; i < Path.size(); i++) {
            System.out.print(Path.get(i) + " ");
        }
        System.out.println();
    }

    public void printfreeNodes() {
        System.out.println("freeNodes:");
        for (int i = 0; i < freeNodes.size(); i++) {
            System.out.print(freeNodes.get(i) + " ");
        }
        System.out.println();
    }

    public int getMate(int v) {
        for (int i = 0; i < M.size(); i++) {
            if (M.get(i).getMate(v) != 0) {
                return M.get(i).getMate(v);
            }
        }
        return -1;
    }

    public int O() {
        return ((this.Graph.length / 2) + (this.Graph.length % 2));
    }

    public void makeEdges() {
        for (int i = 0; i < Graph.length; i++) {
            for (int j = i + 1; j < Graph[i].length; j++) {
                if (Graph[i][j] == true) {
                    krastines.add(new Edge(i, j));
                }
            }
        }
    }
//
//    public boolean[][] findMaximumMatchhing() { // bad atempt
//        boolean jobIsDone = false;
//        boolean[] markedEdges = null;
//        boolean[] markedVertices = new boolean[this.Graph.length];
//        this.makeEdges();
//        markedEdges = new boolean[krastines.size()];
//        while (!jobIsDone) {
//            jobIsDone = true;
//            System.out.println("pogu");
//            for (int i = 0; i < Graph.length; i++) {
//                markedVertices[i] = true;
//                for (int j = i + 1; j < Graph[i].length; j++) {
//                    if (krastines.get(i).virsune1 == i && markedVertices[krastines.get(i).virsune2] == false) {
//                        markedVertices[krastines.get(i).virsune2] = true;
//                        M.add(new Edge(i, krastines.get(i).virsune2));
//                        jobIsDone = false;
//                        break;
//                    }
//                    if (krastines.get(i).virsune2 == i && markedVertices[krastines.get(i).virsune1] == false) {
//                        markedVertices[krastines.get(i).virsune1] = true;
//                        M.add(new Edge(i, krastines.get(i).virsune1));
//                        jobIsDone = false;
//                        break;
//                    }
//
//                }
//            }
//        }
//
//        return null;
//    }

}
