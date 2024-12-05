package com.obid.jon.day5;

import com.obid.jon.Reader;

import java.util.*;

public class Second {
    public static void main(String[] args) {
        List<String> lines = Reader.readLines(5);

        int res = 0;
        List<List<Integer>> inValids = new ArrayList<>();
        HashMap<Integer, Hold> map = new HashMap<>();
        for (String line : lines) {
            if (line.contains("|")) {
                String[] split = line.split("\\|");
                int f = Integer.parseInt(split[0]);
                int s = Integer.parseInt(split[1]);
                if (!map.containsKey(f)) {
                    map.put(f, new Hold());
                }
                map.get(f).next.add(s);

                if (!map.containsKey(s)) {
                    map.put(s, new Hold());
                }
                map.get(s).prev.add(f);
            } else if (!line.isEmpty()) {
                List<Integer> list = Arrays.stream(line.split(",")).map(x -> Integer.parseInt(x)).toList();

                List<Integer> white = new ArrayList<>();
                boolean is = false;
                for (Integer i : list) {
                    if (map.containsKey(i)) {
                        Hold hold = map.get(i);
                        List<Integer> next = hold.next;

                        boolean a = false;
                        for (Integer integer : white) {
                            if (next.contains(integer)) {
                                a = true;
                                break;
                            }
                        }

                        if (a) {
                            white.add(i);
                            is = true;
                            break;
                        }
                        white.add(i);
                    } else {
                        white.add(i);
                    }
                }
                if (is) {
                    inValids.add(list);
                }
            }
        }
        for (List<Integer> inv : inValids) {
            List<Integer> sorted = sort(inv, map);
            res += sorted.get(sorted.size() / 2);
        }
        System.out.println(res);
    }

    private static List<Integer> sort(List<Integer> list, HashMap<Integer, Hold> map) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int number : list) {
            inDegree.putIfAbsent(number, 0);
            graph.putIfAbsent(number, new ArrayList<>());

            Hold rule = map.get(number);
            if (rule != null) {
                for (int after : rule.next) {
                    if (list.contains(after)) {
                        graph.get(number).add(after);
                        inDegree.put(after, inDegree.getOrDefault(after, 0) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int number : inDegree.keySet()) {
            if (inDegree.get(number) == 0) {
                queue.add(number);
            }
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sortedOrder.add(current);

            for (int neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sortedOrder;
    }

    static class Hold {
        List<Integer> prev;
        List<Integer> next;

        public Hold() {
            prev = new ArrayList<>();
            next = new ArrayList<>();
        }
    }
}
