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

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        List<Process> processes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Arrival Time and Burst Time for Process " + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();
            processes.add(new Process(i + 1, arrivalTime, burstTime));
        }
        
        int currentTime = 0, completed = 0;
        while (completed != n) {
            Process shortest = null;
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0) {
                    if (shortest == null || p.remainingTime < shortest.remainingTime) {
                        shortest = p;
                    }
                }
            }
            
            if (shortest == null) {
                currentTime++;
                continue;
            }
            
            shortest.remainingTime--;
            currentTime++;
            
            if (shortest.remainingTime == 0) {
                completed++;
                shortest.turnAroundTime = currentTime - shortest.arrivalTime;
                shortest.waitingTime = shortest.turnAroundTime - shortest.burstTime;
            }
        }

        System.out.println("PID\tAT\tBT\tWT\tTAT");
        for (Process p : processes) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\n", p.pid, p.arrivalTime, p.burstTime, p.waitingTime, p.turnAroundTime);
        }
        sc.close();
    }
}
