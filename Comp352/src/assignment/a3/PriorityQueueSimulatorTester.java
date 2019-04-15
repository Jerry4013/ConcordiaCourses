package assignment.a3;

import java.util.Random;

public class PriorityQueueSimulatorTester {
    public static void main(String[] args) {
        int[] maxNumberOfJobs = {100,1000,3000};

        for (int numberOfJobs : maxNumberOfJobs) {
            Job[][] jobsInputArray = createJobArray(numberOfJobs);

            CPU_Simulator unsorted = new CPU_Simulator("Unsorted List", jobsInputArray[0]);
            unsorted.excecute();

            CPU_Simulator sorted = new CPU_Simulator("Sorted List", jobsInputArray[1]);
            sorted.excecute();

//            CPU_Simulator linkedHeap = new CPU_Simulator("LinkedList-based Heap", jobsInputArray);
//            linkedHeap.excecute();

            CPU_Simulator arrayHeap = new CPU_Simulator("ArrayList-based Heap", jobsInputArray[2]);
            arrayHeap.excecute();
        }
    }

    public static Job[][] createJobArray(int numberOfJobs){
        Random randomGenerator = new Random();
        Job[][] jobsInputArray = new Job[3][numberOfJobs];
        for (int i = 0; i < numberOfJobs; i++) {
            int jobLength = randomGenerator.nextInt(70) + 1;
            int jobPriority = randomGenerator.nextInt(40) + 1;
            for (int j = 0; j < 3; j++) {
                jobsInputArray[j][i] = new Job("Job_" + (i+1), jobLength, jobLength, jobPriority,
                        jobPriority, 0, 0, 0);
            }
        }
        return jobsInputArray;
    }

}
