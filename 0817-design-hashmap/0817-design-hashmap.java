class MyHashMap {
    String[] a;

    public MyHashMap() {
        a = new String[1000001];
    }

    public void put(int key, int value) {
        a[key] =String.valueOf(value);
    }

    public int get(int key) {
        if (a[key] == null)
            return -1;
        return Integer.valueOf(a[key]);
    }

    public void remove(int key) {
        a[key] = null;
    }
}
