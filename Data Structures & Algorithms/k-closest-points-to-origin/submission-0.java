class Solution {
    class Node{
        int x;
        int y;
        double d;
        Node(int x, int y, double d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Double.compare(a.d,b.d));

        for(int i = 0; i<points.length; ++i){
            double d = Math.sqrt((double)(points[i][0]*points[i][0] + points[i][1]*points[i][1]));
            Node n = new Node(points[i][0], points[i][1], d);
            pq.add(n);
        }

        int[][] result = new int[k][2];
        int counter = 0;
        while(counter<k && !pq.isEmpty()){
            Node n = pq.poll();
            result[counter][0] = n.x;
            result[counter][1] = n.y;
            counter++;
        }

        return result;
    }
}
