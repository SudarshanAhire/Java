import java.util.*;

class Process {
    int pid, arrivalTime, burstTime, priority, waitingTime, turnAroundTime;
    
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class Priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        List<Process> processes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Arrival Time, Burst Time and Priority for Process " + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();
            int priority = sc.nextInt();
            processes.add(new Process(i + 1, arrivalTime, burstTime, priority));
        }

        // Sorting by Arrival Time and Priority
        processes.sort(Comparator.comparingInt((Process p) -> p.arrivalTime)
                .thenComparingInt(p -> p.priority));
        int currentTime = 0;
        for (Process p : processes) {
            p.waitingTime = Math.max(0, currentTime - p.arrivalTime);
            p.turnAroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;
        }

        System.out.println("PID\tAT\tBT\tP\tWT\tTAT");
        for (Process p : processes) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n", p.pid, p.arrivalTime, p.burstTime, p.priority, p.waitingTime, p.turnAroundTime);
        }
        sc.close();
    }
}
