package self.diy;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/3/6 13:39
 */
public class MyMap {

    /**
     * 存储元素的数组
     */
    public Node[] table;
    /**
     * 默认大小
     */
    int defaultSize = 16;

    /**
     * 实际大小
     */
    int size;

    /**
     * The next size value at which to resize (capacity * load factor).
     * @serial
     */
    int threshold;

    /**
     * The load factor for the hash table.
     *
     * @serial
     */
     float loadFactor;

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public MyMap(){
        init(defaultSize,DEFAULT_LOAD_FACTOR);
    }

    private void init(int capacity,float loadFactor){
        table = new Node[capacity];
        threshold = (int)Math.min(capacity * loadFactor,MAXIMUM_CAPACITY+1);
    }

    public String put(String key,String val){
        int hash = hash(key);
        int index = indexFor(hash,table.length);
        for(Node node = table[index]; node != null; node = node.next){
            //如果当前系统中已经存在此key ，则覆盖
            if(node.hash == hash && (key == node.key || node.key.equals(key))){
                String oldVal = node.val;
                node.val  = val;
                return oldVal;
            }
        }
        addNode(hash,key,val,index);
        return val;
    }

    private void addNode(int hash,String key,String val,int index){
        //1.7以后增加了另一个条件， 有hash冲突才扩容
        if(size >= threshold){
            resize(2* table.length);
            hash = (null== key) ? 0 : hash(key);
            index = indexFor(hash,table.length);
        }
        createNode(hash,key,val,index);
    }

    private void createNode(int hash,String key,String val,int index){
        Node node = table[index];
        table[index] = new Node(hash,key,val,node);
        size++;
    }



    public String  get(String key){
        int hash = hash(key);
        for (Node n = table[indexFor(hash,table.length)];n != null;n = n.next) {
            Node next = n.next;
            if(hash == n.hash && ( n.key == key || n.key.equals(key))){
                return n.val;
            }
        }
        return null;
    }

    /**
     * 扩容并重新整理index 等。
     * @param newCapacity
     */
    private void resize(int newCapacity){
        Node[] newtable = new Node[newCapacity];
        //原版的变量被大佬重新覆盖，引用，代码很简练，看出来大佬们很自信呀。
        for(Node node:table){
           while (null != node){
               //将next取出来
                Node next = node.next;
                int index = indexFor(hash(node.key),newCapacity);
                // 将新table index位置的元素放到node的next上
                node.next = newtable[index];
                // 将node 赋值给 新位置
                newtable[index] = node;
                //继续遍历
                node = next;
           }
        }
        table = newtable;
    }

    static class Node{
        int hash;
        String key;
        String val;
        Node next;

        Node(int hash,String key,String val,Node next){
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }

        String setVal(String newVal){
            String oldVal = val;
            val = newVal;
            return oldVal;
        }

    }

    private static int hash(Object obj){
        return obj.hashCode();
    }
    private static int indexFor(int hash ,int length){
        return hash & (length-1);
    }
}
