class LRUCache{


	int capacity;
	LinkedHashMap<Integer, Integer> cache;
	LRUCache(int capacity){
	
		this.capacity = capacity;
		cache = new LinkedHashMap<>();
	}

	public int get(int key){
	
		if(!cache.containsKey(key))
			return -1;
		int value = cache.get(key);
		cache.remove(key);
		cache.put(key, value);
		return value;
	}

	public void put(int key, int value){
	
		if(cache.containsKey(key))
			cache.remove(key);
		if(capacity <= cache.size())
			cache.remove(cache.entrySet().iterator().next().getKey());
		cache.put(key, value);
		return;
	}
}
