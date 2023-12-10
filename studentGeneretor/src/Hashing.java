public class Hashing {

    public static int getFirstHash(Object o, int limit) {
        return ( ( (13 * o.hashCode()) + 19 ) / 1001 ) % limit;
    }

    public static int getSecondHash(Object o, int limit) {
        return ( ( (7 * o.hashCode()) + 23 ) / 1001 ) % limit;
    }

}
