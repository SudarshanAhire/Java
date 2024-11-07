import java.util.*;

class Process {
    int pid, arrivalTime, burstTime, waitingTime, turnAroundTime, remainingTime;
    
    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        System.out.println("Enter the time quantum: ");
        int quantum = sc.nextInt();
        List<Process> processes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Arrival Time and Burst Time for Process " + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();
            processes.add(new Process(i + 1, arrivalTime, burstTime));
        }
        
        Queue<Process> queue = new LinkedList<>();
        int currentTime = 0, completed = 0;
        for (Process p : processes) {
            queue.add(p);
        }

        while (completed != n) {
            Process currentProcess = queue.poll();
            if (currentProcess.remainingTime > quantum) {
                currentTime += quantum;
                currentProcess.remainingTime -= quantum;
            } else {
                currentTime += currentProcess.remainingTime;
                currentProcess.remainingTime = 0;
                completed++;
                currentProcess.turnAroundTime = currentTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;
            }
            
            if (currentProcess.remainingTime > 0) {
                queue.add(currentProcess);
            }
        }

        System.out.println("PID\tAT\tBT\tWT\tTAT");
        for (Process p : processes) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\n", p.pid, p.arrivalTime, p.burstTime, p.waitingTime, p.turnAroundTime);
        }
        sc.close();
    }
}
