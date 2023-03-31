package Cash;

import java.util.LinkedList;

public class Lvl1 {
    private LinkedList<Rest> list;
    private Lvl2 lvl2 = new Lvl2();

    public Lvl1() {
        list = new LinkedList<>();
        lvl2 = new Lvl2();
    }

    public void add(String _firstValue, String _secondValue,
            String _operator, String _result) {
        Rest st = new Rest(_firstValue, _secondValue, _operator, _result);
        int size = 10;
        if (list.size() == size) {
            lvl2.add(list.get(size - 1));
            list.remove(size - 1);
            list.addFirst(st);
        } else {
            list.addFirst(st);
        }
    }

    public String search(String _firstValue, String _secondValue, String _operator) {
        for (int i = 0; i < list.size(); i++) {
            if (_operator.equals("+") || _operator.equals("*")) {
                if ((list.get(i).firstValue.equals(_firstValue) && list.get(i).secondValue.equals(_secondValue)) ||
                        ((list.get(i).firstValue.equals(_secondValue) && list.get(i).secondValue.equals(_firstValue)))
                                &&
                                list.get(i).operator.equals(_operator)) {
                    list.addFirst(list.get(i));
                    list.remove(i + 1);
                    return list.getFirst().result;
                }
            }
            if (list.get(i).firstValue.equals(_firstValue) && list.get(i).secondValue.equals(_secondValue)
                    && list.get(i).operator.equals(_operator)) {
                list.addFirst(list.get(i));
                list.remove(i + 1);
                return list.getFirst().result;
            }
        }
        for (int i = 0; i < lvl2.list.size(); i++) {
            if (list.get(i).firstValue.equals(_firstValue) && list.get(i).secondValue.equals(_secondValue)
                    && list.get(i).operator.equals(_operator)) {
                list.addFirst(lvl2.get(i));
                lvl2.list.remove(i + 1);
                return lvl2.get(i).result;
            }
        }
        return "e";
    }

    public void print() {
        System.out.println("Lvl1");
        for (Rest r : list) {
            System.out.print(r.firstValue);
            System.out.print(r.operator);
            System.out.print(r.secondValue + "=");
            System.out.println(r.result);
        }
        lvl2.print();
    }
}
