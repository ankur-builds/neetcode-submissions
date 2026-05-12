class LRUCache {
    private Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private void moveToTail(Node curr){
        if(cache.size()==1)
            return;
        
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        Node last = tail.prev;
        last.next = curr;
        curr.prev = last;
        curr.next = tail;
        tail.prev = curr;
    }

    private void insertNode(int key, int value){
        // insertion happen at tail
        Node last = tail.prev;
        Node curr = new Node(key, value);
        last.next = curr;
        curr.prev = last;
        curr.next = tail;
        tail.prev = curr;

        cache.put(key, curr);
    }

    private void evictNode(){
        // remove first node from head
        int key = head.next.key;
        Node second = head.next.next;
        head.next = second;
        second.prev = head;
        cache.remove(key);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // check if key exists
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            moveToTail(curr);
            return curr.value;
        } else
            return -1;        
    }
    
    public void put(int key, int value) {
        // check if key exists
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            curr.value = value;
            moveToTail(curr);
        } else{
            if (cache.size() == this.capacity){
                evictNode();
            }

            insertNode(key, value);
        }
    }
}
