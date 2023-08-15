class LRUCache {
    LinkedHashMap<Integer,Integer> cache= new LinkedHashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public void recent(int key) {
        int value=cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }
    
    public int get(int key){
        if(!cache.containsKey(key))
        {
            return -1;
        }
        recent(key);
        return cache.get(key);
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
            return;
        }
        if(cache.size()>=capacity){
            Integer prev = cache.keySet().iterator().next();
            cache.remove(prev);
        }
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */