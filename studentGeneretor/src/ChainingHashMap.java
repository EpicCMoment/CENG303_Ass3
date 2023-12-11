import java.lang.reflect.Array;

public class ChainingHashMap <E>{

    private static final int capacity = 4001;
    private int size;
    ChainingHashMapNode<E>[] table;

    ChainingHashMap(){
        // this ugly looking array creation is needed to create a generic array
        // reflection is used to solve the problem of type inference of generics
        this.table =  (ChainingHashMapNode<E>[]) Array.newInstance(ChainingHashMapNode.class, 4001);
    }

    public void insert(int key, E item){
        int hash = Hashing.getFirstHashWithKey(key, capacity);
        ChainingHashMapNode<E> newItemNode = new ChainingHashMapNode<>(item);

        if(table[hash] == null){
            table[hash] = newItemNode;
            size++;
        }
        else{
            ChainingHashMapNode<E> head = table[hash];

            while(head != null){

                //If there is an item with this key, update its data
                if(head.key == newItemNode.key){
                    head.data = newItemNode.data;
                    return;
                }
                head = head.next;
            }

            newItemNode.next = table[hash];
            table[hash]= newItemNode;
            size++;
        }
    }

    public void insert(E item){
        this.insert(item.hashCode(), item);
    }

    public E remove(int key){

        if(size == 0){
            System.err.println("ChainingHashMap: Cannot remove! HashMap is empty.");
        }

        int hash = Hashing.getFirstHashWithKey(key,capacity);

        if(table[hash] == null){
            return null;
        }

        //Check first node
        if(table[hash].key == key){
            ChainingHashMapNode<E> temp = table[hash];
            table[hash] = table[hash].next;
            temp.next = null;

            size--;
            return temp.data;
        }
        //Continue from second node
        ChainingHashMapNode<E> head = table[hash].next;

        //Save the previous node to connect after removing
        ChainingHashMapNode<E> prev = table[hash];

        while(head != null && head.key != key){
            prev = head;
            head = head.next;
        }

        //Shows that there is no item with this key
        if(head == null){
            return null;
        }

        prev.next = head.next;
        head.next = null;

        size--;
        return head.data;
    }

    public E get(int key){

        if(size == 0){
            System.err.println("ChainingHashMap: Cannot remove! HashMap is empty.");
        }

        int hash = Hashing.getFirstHashWithKey(key,capacity);

        ChainingHashMapNode<E> head = table[hash];

        while(head != null){

            if(head.key == key){
                return head.data;
            }
            head = head.next;
        }
        return null;
    }

class ChainingHashMapNode <E> {
    E data;
    int key;

    ChainingHashMapNode<E> next;

    ChainingHashMapNode() {
        this.data = null;
        this.key = 0;
        this.next = null;
    }

    ChainingHashMapNode(E item) {
        this.data = item;
        this.key = item.hashCode();
        this.next = null;
    }
}





}
