package sandbox;

public class BinarySearchString {
    public static boolean binarySearchString(String s, char c) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return s.charAt(0) == c;

        int mid = s.length() / 2;

        if (c == s.charAt(mid)) return true;
        if (c < s.charAt(mid)) return binarySearchString(s.substring(0, mid), c);
        return binarySearchString(s.substring(mid + 1), c);
    }

    public static void main(String[] args) {
        System.out.println(binarySearchString("abcdefgh", 'c'));
        System.out.println(binarySearchString("abcdefgh", 'z'));
    }
}
