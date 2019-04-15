package assignment.a4;


public class Validate {
    public static void main(String[] args) {
//        long startTime, endTime, elapsed;
////        startTime = System.nanoTime();
        ChainHashMap chainHashMap = new ChainHashMap(100);
        LinearProbeHashMap linearProbeHashMap = new LinearProbeHashMap(100);
        QuadraticProbeHashMap quadraticProbeHashMap = new QuadraticProbeHashMap(100);

        //ChainHashMap
        MapEntry[] entries50 = new MapEntry[50];
        for (int i = 0; i < 50; i++) {
            entries50[i] = new MapEntry("MapEntry" + (i+1));
            System.out.println("Putting " + entries50[i] + " into ChainHashMap.");
            chainHashMap.put(entries50[i].getKey(), entries50[i].getValue());
        }

//        endTime = System.nanoTime();
//        elapsed = endTime - startTime;
//        System.out.println("Time: " + elapsed + " ns\n");

//        startTime = System.nanoTime();
        Iterable<Integer> keySet1 = chainHashMap.keySet();
        int counter1 = 0;
        for (Integer key : keySet1) {
            System.out.println("Getting key " + key + ": "+ chainHashMap.get(key));
            if (counter1 < 25){
                    System.out.println("Removing key: " + key);
                    chainHashMap.remove(key);
                    counter1++;
            }
        }
//        endTime = System.nanoTime();
//        elapsed = endTime - startTime;
//        System.out.println("Time: " + elapsed + " ns\n");


        //LinearProbeHashMap
        for (int i = 0; i < 50; i++) {
            System.out.println("Putting " + entries50[i] + " into LinearProbeHashMap.");
            linearProbeHashMap.put(entries50[i].getKey(), entries50[i].getValue());
        }
        Iterable<Integer> keySet2 = linearProbeHashMap.keySet();
        int counter2 = 0;
        for (Integer key : keySet2) {
            System.out.println("Getting key " + key + ": "+ linearProbeHashMap.get(key));
            if (counter2 < 25){
                System.out.println("Removing key: " + key);
                linearProbeHashMap.remove(key);
                counter2++;
            }
        }

        //QuadraticProbeHashMap
        for (int i = 0; i < 50; i++) {
            System.out.println("Putting " + entries50[i] + " into QuadraticProbeHashMap.");
            quadraticProbeHashMap.put(entries50[i].getKey(), entries50[i].getValue());
        }
        Iterable<Integer> keySet3 = quadraticProbeHashMap.keySet();
        int counter3 = 0;
        for (Integer key : keySet3) {
            System.out.println("Getting key " + key + ": "+ quadraticProbeHashMap.get(key));
            if (counter3 < 25){
                System.out.println("Removing key: " + key);
                quadraticProbeHashMap.remove(key);
                counter3++;
            }
        }


//        chainHashMap = new ChainHashMap(100);
//        linearProbeHashMap = new LinearProbeHashMap(100);
//        quadraticProbeHashMap = new QuadraticProbeHashMap(100);
//
//        //ChainHashMap
//        MapEntry[] entries150 = new MapEntry[150];
//        for (int i = 0; i < 100; i++) {
//            entries150[i] = new MapEntry("MapEntry" + (i+1));
//            System.out.println("Putting " + entries150[i] + " into ChainHashMap.");
//            chainHashMap.put(entries150[i].getKey(), entries150[i].getValue());
//        }
//        Iterable<Integer> keySet4 = chainHashMap.keySet();
//        int counter4 = 0;
//        for (Integer key : keySet4) {
//            System.out.println("Getting key " + key + ": "+ chainHashMap.get(key));
//            if (counter4 < 25){
//                System.out.println("Removing key: " + key);
//                chainHashMap.remove(key);
//                counter4++;
//            }
//        }
//
////        LinearProbeHashMap
//        for (int i = 0; i < 100; i++) {
//            System.out.println("Putting " + entries150[i] + " into LinearProbeHashMap.");
//            linearProbeHashMap.put(entries150[i].getKey(), entries150[i].getValue());
//        }
//        Iterable<Integer> keySet5 = linearProbeHashMap.keySet();
//        int counter5 = 0;
//        for (Integer key : keySet5) {
//            System.out.println("Getting key " + key + ": "+ linearProbeHashMap.get(key));
//            if (counter5 < 25){
//                System.out.println("Removing key: " + key);
//                linearProbeHashMap.remove(key);
//                counter5++;
//            }
//        }
//
//        //QuadraticProbeHashMap
//        for (int i = 0; i < 100; i++) {
//            System.out.println("Putting " + entries150[i] + " into QuadraticProbeHashMap.");
//            quadraticProbeHashMap.put(entries150[i].getKey(), entries150[i].getValue());
//        }
//        Iterable<Integer> keySet6 = quadraticProbeHashMap.keySet();
//        int counter6 = 0;
//        for (Integer key : keySet6) {
//            System.out.println("Getting key" + key + ": "+ quadraticProbeHashMap.get(key));
//            if (counter6 < 25){
//                System.out.println("Removing key: " + key);
//                quadraticProbeHashMap.remove(key);
//                counter6++;
//            }
//        }
    }
}
