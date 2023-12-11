public class Hashing {

    public static int getFirstHash(Object o, int limit) {
        return getFirstHashWithKey(o.hashCode(), limit);
    }

    public static int getFirstHashWithKey(int key, int limit) {
        return Math.abs( ( (13 * key) + 19 ) / 1001 ) % limit;
    }

    public static int getSecondHash(Object o, int limit) {
        return getSecondHashWithKey(o.hashCode(), limit);
    }

    public static int getSecondHashWithKey(int key, int limit) {
        return Math.abs( ( (7 * key) + 23 ) / 1001 ) % limit;
    }

}
