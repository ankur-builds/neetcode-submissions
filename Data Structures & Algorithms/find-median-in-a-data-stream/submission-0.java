class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int n = list.size();
        if(n%2!=0)
            return list.get(n/2);
        else
            return (list.get(n/2 - 1) + list.get(n/2))/2.0;
    }
}
