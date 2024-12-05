package com.obid.jon.day5;

import com.obid.jon.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> lines = Reader.readLines(5);

        int res = 0;
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
                if (!is) {
                    res += list.get((list.size() - 1) / 2);
                }
            }
        }
        System.out.println(res);
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
