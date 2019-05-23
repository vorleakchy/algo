//package sandbox;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class PowerSet {
//
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(PowerSet.powerSet(list));
//    }
//
//    private static List<List<Integer>> powerSet(List<Integer> list) {
//        // union(powerset(list - last), distribute(powerset(list - last), last))
//        // base, list is empty, return powerset(emptylist)
//        // getLast element
//        // distribute
//        // union
//        // lastRemoved
//        if (list.isEmpty()) {
//            List<List<Integer>> empty = new ArrayList<>();
//            empty.add(new ArrayList<>());
//            return empty;
//        } else {
//            return union(powerSet(lastRemoved(list)), distribute(powerSet(lastRemoved(list)), getLast(list)));
//        }
//    }
//
//    private static List<List<Integer>> union(List<List<Integer>> one, List<List<Integer>> two) {
//        List<List<Integer>> list = new ArrayList<>(one);
//        list.addAll(two);
//        return list;
//    }
//
//    private static List<Integer> lastRemoved(List<Integer> list) {
//        return list.isEmpty() ? Collections.emptyList() : list.subList(0, list.size() - 1);
//    }
//
//    private static List<List<Integer>> distribute(List<List<Integer>> list, Integer element) {
//        List<List<Integer>> result = new ArrayList<>(list);
//        result.forEach(l -> l.add(element));
//        return result;
//    }
//
//    private static Integer getLast(List<Integer> list) {
//        return list.get(list.size() - 1);
//    }
//}