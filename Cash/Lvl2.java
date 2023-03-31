package Cash;

import java.util.ArrayList;

class Lvl2 {
    ArrayList<Rest> list;

    Lvl2() {
        list = new ArrayList<>();
    }

    void add(Rest rest) {
        int size = 10;
        if (list.size() == size) {
            list.clear();
        } else {
            list.add(rest);
        }
    }

    Rest get(int ID) {
        return list.get(ID);
    }

    void print() {
        System.out.println("Lvl2");
        for (Rest r : list) {
            System.out.print(r.firstValue);
            System.out.print(r.operator);
            System.out.print(r.secondValue + "=");
            System.out.println(r.result);
        }
    }
}
