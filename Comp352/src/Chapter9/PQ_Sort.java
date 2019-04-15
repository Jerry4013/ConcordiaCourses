package Chapter9;

import Chapter7.PositionalList;

public class PQ_Sort {
    public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E, ?> P){
        int n = S.size();
        for (int j = 0; j < n; j++) {
            E element = S.remove(S.first());
            P.insert(element, null);
        }
        for (int j = 0; j < n; j++) {
            E element = P.removeMin().getKey();
            S.addLast(element);
        }
    }
}
