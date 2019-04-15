package assignment.a3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

public class CPU_Simulator {

    private String PQtype;  //{"Unsorted List", "Sorted List",
    // "LinkedList-based Heap", "ArrayList-based Heap"};
    private long time;
    private Job[] jobsInputArray;
    private long totalWaitingTime;
    private int priorityChanges;
    private double systemTime;

    public CPU_Simulator(String PQtype, Job[] jobsInputArray) {
        this.PQtype = PQtype;
        this.jobsInputArray = jobsInputArray;
    }

    private PriorityQueue<Integer, Job> routing(){
        switch (PQtype){
            case "Unsorted List": return new UnsortedPriorityQueue();
            case "Sorted List": return new SortedPriorityQueue();
            case "LinkedList-based Heap": return new LinkedHeapPriorityQueue<>();
            default: return new ArrayHeapPriorityQueue();
        }
    }

    public void excecute(){
        PriorityQueue<Integer,Job> PQ = routing();
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < jobsInputArray.length; i++) {
            time++;
            Job job = jobsInputArray[i];
            job.setEntryTime(time);
            PQ.insert(job.getJobPriority(), job);
        }
        while (!PQ.isEmpty()){
            time++;
            Entry<Integer,Job> currentJob = PQ.removeMin();
            int length = currentJob.getValue().getCurrentJobLength();
            System.out.println(currentJob.getValue());
            if (length > 0){
                currentJob.getValue().setCurrentJobLength(length - 1);
                PQ.insert(currentJob.getKey(), currentJob.getValue());
            } else {
                currentJob.getValue().setEndTime(time);
                long entryTime = currentJob.getValue().getEntryTime();
                long waitTime = time - entryTime - currentJob.getValue().getJobLength();
                currentJob.getValue().setWaitTime(waitTime);
                totalWaitingTime += waitTime;
                if ((jobsInputArray.length - PQ.size()) % 30 == 0){
                    checkStarvation(PQ);
                }
            }
        }
        double endTime = System.currentTimeMillis();
        systemTime = endTime - startTime;
        printResult();
    }

    private void checkStarvation(PriorityQueue pq) {
        if (PQtype.equals("Unsorted List")){
            checkUnsorted(pq);
        } else if (PQtype.equals("Sorted List")){
            checkSorted(pq);
        } else if (PQtype.equals("ArrayList-based Heap")){
            checkArrayHeap(pq);
        }
    }

    private void printResult(){
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(
                    "SimulatorPerformanceResults.txt",true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file testrun.txt.");
            System.exit(0);
        }
        outputStream.println(PQtype + " Priority Queue");
        outputStream.println("Current system time (cycles): " + time);
        outputStream.println("Total number of jobs executed: " +
                jobsInputArray.length + " jobs");
        outputStream.println("Average process waiting time: " +
                totalWaitingTime / jobsInputArray.length + " cycles");
        outputStream.println("Total number of priority changes: " + priorityChanges);
        outputStream.println("Actual system time needed to execute all jobs: " +
                systemTime + " ms");
        outputStream.println();
        outputStream.flush();
    }

    private void checkUnsorted(PriorityQueue pq) {
        long oldest = 0;
        UnsortedPriorityQueue<Integer,Job> temp = (UnsortedPriorityQueue<Integer,Job>)pq;
        Iterator<Position<Entry<Integer,Job>>> iterator = temp.iterator();
        Position<Entry<Integer,Job>> tochange = null;
        while (iterator != null && iterator.hasNext()) {
            Position<Entry<Integer, Job>> position = iterator.next();
            time++;
            Job job = position.getElement().getValue();
            boolean isExecuted = (job.getJobLength() > job.getCurrentJobLength()) ;
            if ((!isExecuted) && job.getEntryTime() > oldest){
                oldest = job.getEntryTime();
                tochange = position;
            }
        }
        if (tochange != null){
            Entry<Integer, Job> entry = tochange.getElement();
            entry.setKey(1);
            entry.getValue().setFinalPriority(1);
            priorityChanges++;
        }
    }

    private void checkSorted(PriorityQueue pq){
        long oldest = 0;
        SortedPriorityQueue<Integer,Job> temp = (SortedPriorityQueue<Integer,Job>)pq;
        Iterator<Position<Entry<Integer,Job>>> iterator = temp.iterator();
        Position<Entry<Integer,Job>> tochange = null;
        while (iterator != null && iterator.hasNext()) {
            Position<Entry<Integer, Job>> position = iterator.next();
            time++;
            Job job = position.getElement().getValue();
            boolean isExecuted = (job.getJobLength() > job.getCurrentJobLength()) ;
            if ((!isExecuted) && job.getEntryTime() > oldest){
                oldest = job.getEntryTime();
                tochange = position;
            }
        }
        if (tochange != null){
            priorityChanges++;
            Entry<Integer, Job> entry = tochange.getElement();
            entry.setKey(1);
            entry.getValue().setFinalPriority(1);
            temp.removePosition(tochange);
            temp.insert(entry.getKey(), entry.getValue());
        }
    }

    private void checkArrayHeap(PriorityQueue pq){
        long oldest = 0;
        ArrayHeapPriorityQueue<Integer,Job> temp = (ArrayHeapPriorityQueue<Integer,Job>)pq;
        Iterator<Entry<Integer,Job>> iterator = temp.iterator();
        int index = 0;
        int changeIndex = -1;
        Entry<Integer,Job> toChange = null;
        while (iterator != null && iterator.hasNext()) {
            Entry<Integer, Job> entry = iterator.next();
            time++;
            Job job = entry.getValue();
            boolean isExecuted = (job.getJobLength() > job.getCurrentJobLength()) ;
            if ((!isExecuted) && job.getEntryTime() > oldest){
                oldest = job.getEntryTime();
                changeIndex = index;
                toChange = entry;
            }
            index++;
        }
        if (changeIndex != -1 && toChange != null){
            priorityChanges++;
            toChange.getValue().setFinalPriority(1);
            Job newJob = toChange.getValue();
            temp.replace(changeIndex, 1, newJob);
        }
    }
}
