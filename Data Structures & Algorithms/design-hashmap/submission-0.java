class MyHashMap {
    private static final int SIZE = 1009 ;
    private LinkedList<Node>[] buckets ;
    class Node{
        int key ; 
        int value ; 
        Node(int key , int value){
            this.key = key ; 
            this.value = value ;
        }
    }

    private int hash(int key){
        return key % SIZE ;
    }
    public MyHashMap() {
       buckets = new LinkedList[SIZE] ;
       for(int i = 0 ; i < SIZE ; i++){
        buckets[i] = new LinkedList<Node>();
       } 
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        for(Node node : buckets[index]){
            if(node.key == key){
                node.value = value ;
                return ;
            }
        }
        buckets[index].add(new Node(key , value));
    }
    
    public int get(int key) {
        int index = hash(key) ;
        for(Node node : buckets[index]){
            if(node.key == key){
                return node.value ;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        for(Node node : buckets[index]){
            if(node.key == key){
                buckets[index].remove(node);
                return ;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */