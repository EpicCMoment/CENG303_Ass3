public class Hashing {

    public int getFirstHash(Object o, int limit) {
        return ( ( (13 * o.hashCode()) + 19 ) / 1001 ) % limit;
    }

    public int getSecondHash(Object o, int limit) {
        return ( ( (7 * o.hashCode()) + 23 ) / 1001 ) % limit;
    }

}
