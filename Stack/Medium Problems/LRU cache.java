Doubly Linked List :
NULL <- [ HEAD ] <-> [ 4:Four ] <-> [ 1:One ] <-> [ 2:Two ] <-> [ TAIL ] -> NULL

    HashMap:
{
  1 → [1:One],
  2 → [2:Two],
  4 → [4:Four]
}


class Node{
    int key, val;
    Node prev, next;

    Node(int key , int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer,Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(node);
    }

    void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node){
        map.put(node.key,node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
