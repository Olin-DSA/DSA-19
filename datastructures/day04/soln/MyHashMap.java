import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    // average number of entries per map before we grow the map
    private static final double ALPHA = 1.0;
    // average number of entries per map before we shrink the map
    private static final double BETA = .25;

    // resizing factor: (new size) = (old size) * (resize factor)
    private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

    private static final int MIN_BUCKETS = 16;

    // array of buckets
    protected LinkedList<Entry>[] buckets;
    private int size = 0;

    public MyHashMap() {
        initBuckets(MIN_BUCKETS);
    }

    public class Entry implements Map.Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            value = newValue;
            return value;
        }
    }

    private V getFromBucket(LinkedList<Entry> bucket, Object key) {
        for (Entry e : bucket)
            if (e.key.equals(key)) return e.value;
        return null;
    }

    private boolean bucketContainsKey(LinkedList<Entry> bucket, Object key) {
        for (Entry e : bucket)
            if (e.key.equals(key)) return true;
        return false;
    }

    private boolean bucketContainsValue(LinkedList<Entry> bucket, Object value) {
        for (Entry e : bucket) {
            if (e.value == null ? value == null : e.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * given a key, return the bucket where the `K, V` pair would be stored if it were in the map.
     */
    private LinkedList<Entry> chooseBucket(Object key) {
        // TODO
        // hint: use key.hashCode() to calculate the key's hashCode, and use this to choose which bucket the key should
        // go in
        int index = key == null ? 0 : Math.abs(key.hashCode()) % buckets.length;
        return buckets[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * return true if key is in map
     */
    @Override
    public boolean containsKey(Object key) {
        // TODO
        LinkedList<Entry> bucket = chooseBucket(key);
        return bucketContainsKey(bucket, key);
    }

    /**
     * return true if value is in map
     */
    @Override
    public boolean containsValue(Object value) {
        // TODO
        for (LinkedList<Entry> bucket : buckets) {
            if (bucketContainsValue(bucket, value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        // TODO
        return getFromBucket(chooseBucket(key), key);
    }

    /**
     * add a new key-value pair to the map. Grow if needed, according to `ALPHA`.
     * @return the value associated with the key if it was previously in the map, otherwise null.
     */
    @Override
    public V put(K key, V value) {
        // TODO: Complete this method
        // hint: use chooseBucket to determine which bucket to place the pair in
        // hint: use rehash() to appropriately grow the hashmap if needed
        V oldValue = null;
        if (containsKey(key)) {
            oldValue = remove(key);
        }
        LinkedList<Entry> map = chooseBucket(key);
        map.add(new Entry(key, value));
        size++;

        // check if the number of elements per map exceeds the threshold
        if (size() > buckets.length * ALPHA) rehash(GROWTH_FACTOR);
        return oldValue;
    }

    /**
     * Remove the key-value pair associated with the given key. Shrink if needed, according to `BETA`.
     * Make sure the number of buckets doesn't go below `MIN_BUCKETS`. Do nothing if the key is not in the map.
     * @return the value associated with the key if it was in the map, otherwise null.
     */
    @Override
    public V remove(Object key) {
        // TODO
        // hint: use chooseBucket to determine which bucket the key would be
        // hint: use rehash() to appropriately grow the hashmap if needed
        if (!containsKey(key)) return null;
        V oldValue = null;
        LinkedList<Entry> bucket = chooseBucket(key);
        int i = 0;
        for (Entry e : bucket) {
            if (e.key.equals(key)) {
                oldValue = bucket.remove(i).value;
                break;
            }
            i++;
        }
        size--;

        // check if the number of elements per map is below the threshold
        // make sure the number of buckets doesn't go too low
        if (buckets.length * SHRINK_FACTOR >= MIN_BUCKETS && size() < buckets.length * BETA) {
            rehash(SHRINK_FACTOR);
        }
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Changes the number of buckets and rehashes the existing entries.
     * If growthFactor is 2, the number of buckets doubles. If it is 0.25,
     * the number of buckets is divided by 4.
     */
    private void rehash(double growthFactor) {
        // TODO
        // hint: once you have removed all valued from the buckets, use put(k, v) to add them back in the correct place
        LinkedList<Entry>[] oldBuckets = buckets;
        int newSize = (int) (buckets.length * growthFactor);
        size = 0; // reset size because put() increments size

        initBuckets(newSize);

        for (int x = 0; x < oldBuckets.length; x++) {
            for (int y = 0; y < oldBuckets[x].size(); y++){
                Entry ent = oldBuckets[x].get(y);
                put(ent.getKey(), ent.getValue());
            }

        }

//        for (LinkedList<Entry> bucket : oldBuckets) {
//            for (Map.Entry<K, V> entry : bucket) {
//                put(entry.getKey(), entry.getValue());
//            }
//        }
    }

    private void initBuckets(int size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void clear() {
        initBuckets(buckets.length);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> e : entrySet()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (Map.Entry<K, V> e : entrySet()) {
            values.add(e.getValue());
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<Entry> map : buckets) {
            set.addAll(map);
        }
        return set;
    }
}
