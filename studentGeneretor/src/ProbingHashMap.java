import java.lang.reflect.Array;

public class ProbingHashMap <E> {
    private HashMapNode<E>[] storage;
    private int capacity;
    private int size;

    private static final int[] possibleCapacities = { 401, 809, 1619, 3251, 6521, 13043, 26099, 52201, 104417 };
    private static int capacityIndex = 0;

    private Class<?> itemClass;


     ProbingHashMap(Class<E> clazz) {
        storage = (HashMapNode<E>[]) Array.newInstance(HashMapNode.class, 401);
        capacity = 401;
        itemClass = clazz;
    }

    ProbingHashMap(Class<E> clazz, int initialCapacity) {
        storage = (HashMapNode<E>[]) Array.newInstance(clazz, initialCapacity);
        capacity = initialCapacity;
        itemClass = clazz;
    }

    public void insert(E item)  {

         if (size == capacity) {
             this.doubleTheStorage();
         }

         int probingCounter = 0;
        int firstHash = Hashing.getFirstHash(item, capacity);
        int secondHash = Hashing.getSecondHash(item, capacity);

         // runs until we place the item to a slot
         while (true) {

             // create a new node for the new item
             HashMapNode<E> newItemNode = new HashMapNode<>(item);

             // calculate the probing index
             int probingIndex = ( firstHash + (probingCounter * secondHash) ) % capacity;

             HashMapNode<E> candidateSlot = storage[probingIndex];

             // if the slot at 'probingIndex' is empty, place it there
             if (storage[probingIndex] == null) {
                 storage[probingIndex] = newItemNode;
                 size++;
                 break;

             // if this slot is already occupied with the same key;
             // replace the contents
             } else if (candidateSlot.key == newItemNode.key) {
                 candidateSlot.data = newItemNode.data;
                 break;
             }

             // if 'probingIndex' is occupied with different key, try next probe

             probingCounter++;

         }


    }

    public E remove(int key) {

         if (size == 0) {
             System.err.println("ProbingHashMap: Cannot remove! HashMap is empty.");
         }

         int probingCounter = 0;
         int firstHash = Hashing.getFirstHashWithKey(key, capacity);
         int secondHash = Hashing.getSecondHashWithKey(key, capacity);

        // runs until we find the item
        while (true) {

            // calculate the probing index
            int probingIndex = ( firstHash + (probingCounter * secondHash) ) % capacity;

            HashMapNode<E> candidateSlot = storage[probingIndex];

            // if candidate slot is empty; there is no such item with 'key'
            if (storage[probingIndex].status == NodeStatus.EMPTY) {
                return null;

            } else if (candidateSlot.status == NodeStatus.PREVIOUSLY_USED) {
                probingCounter++;   // try next probe

            } else if (candidateSlot.key == key) {      // if this slot has the same key;
                E item = candidateSlot.data;

                candidateSlot.data = null;
                candidateSlot.status = NodeStatus.PREVIOUSLY_USED;
                candidateSlot.key = -1;

                return item;              // we found the correct slot
            }

        }


    }

    public E get(int key) {

        if (size == 0) {
            System.err.println("ProbingHashMap: Cannot find the item with 'key'! HashMap is empty.");
        }

        int probingCounter = 0;
        int firstHash = Hashing.getFirstHashWithKey(key, capacity);
        int secondHash = Hashing.getSecondHashWithKey(key, capacity);

        // runs until we find the item
        while (true) {

            // calculate the probing index
            int probingIndex = ( firstHash + (probingCounter * secondHash) ) % capacity;

            HashMapNode<E> candidateSlot = storage[probingIndex];


            // if candidate slot is empty; there is no such item with 'key'
            if ( (storage[probingIndex] == null) || (storage[probingIndex].status == NodeStatus.EMPTY) ) {
                return null;

            } else if (candidateSlot.status == NodeStatus.PREVIOUSLY_USED) {
                probingCounter++;   // try next probe

            } else if (candidateSlot.key == key) {      // if this slot has the same key;
                return candidateSlot.data;              // we found the correct slot
            }

        }

    }

    private void doubleTheStorage() {

         // choose the next capacity plateau
         capacityIndex++;

         int newCapacity = possibleCapacities[capacityIndex];

         // create a new, bigger array to store the elements
         HashMapNode<E>[] newStorage = (HashMapNode<E>[]) Array.newInstance(itemClass, newCapacity);

         // keep the reference of the old storage
         HashMapNode<E>[] oldStorage = storage;

         // replace the old storage and reset the values of the class
         storage = newStorage;
         size = 0;
         capacity = newCapacity;

         // insert each item in the old storage one by one to the new storage
         for (var item : oldStorage) {
             this.insert(item.data);
         }

    }


}

class HashMapNode <E> {

    E data;
    int key;
    NodeStatus status;

    HashMapNode() {
        data = null;
        status = NodeStatus.EMPTY;
        key = 0;
    }

    HashMapNode(E item) {
        data = item;
        status = NodeStatus.FULL;
        key = item.hashCode();
    }

}

enum NodeStatus {
    EMPTY,
    FULL,
    PREVIOUSLY_USED
}