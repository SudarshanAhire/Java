import java.util.*;

class Process {
    int pid, arrivalTime, burstTime, priority, waitingTime, turnAroundTime, remainingTime;
    
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }
}

public class CPUScheduling {
    
    // FCFS Scheduling
    public static void fcfs(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int currentTime = 0;
        for (Process p : processes) {
            p.waitingTime = Math.max(0, currentTime - p.arrivalTime);
            p.turnAroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;
        }
    }

    // SJF Preemptive Scheduling
    public static void sjfPreemptive(List<Process> processes) {
        int n = processes.size();
        int currentTime = 0, completed = 0, minBurstTime, shortest = 0;
        boolean foundProcess;
        while (completed != n) {
            foundProcess = false;
            minBurstTime = Integer.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                Process p = processes.get(i);
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && p.remainingTime < minBurstTime) {
                    minBurstTime = p.remainingTime;
                    shortest = i;
                    foundProcess = true;
                }
            }
            
            if (!foundProcess) {
                currentTime++;
                continue;
            }
            
            Process p = processes.get(shortest);
            p.remainingTime--;
            currentTime++;
            
            if (p.remainingTime == 0) {
                completed++;
                p.turnAroundTime = currentTime - p.arrivalTime;
                p.waitingTime = p.turnAroundTime - p.burstTime;
            }
        }
    }

    // Priority Non-Preemptive Scheduling
    public static void priorityNonPreemptive(List<Process> processes) {
        processes.sort(Comparator.comparingInt((Process p) -> p.arrivalTime)
                .thenComparingInt(p -> p.priority));
        int currentTime = 0;
        for (Process p : processes) {
            p.waitingTime = Math.max(0, currentTime - p.arrivalTime);
            p.turnAroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;
        }
    }

    // Round Robin Preemptive Scheduling
    public static void roundRobin(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>();
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int currentTime = 0, index = 0, n = processes.size();
        queue.add(processes.get(index++));
        
        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();
            if (currentProcess.remainingTime > quantum) {
                currentTime += quantum;
                currentProcess.remainingTime -= quantum;
            } else {
                currentTime += currentProcess.remainingTime;
                currentProcess.remainingTime = 0;
                currentProcess.turnAroundTime = currentTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;
            }
            
            while (index < n && processes.get(index).arrivalTime <= currentTime) {
                queue.add(processes.get(index++));
            }
            if (currentProcess.remainingTime > 0) {
                queue.add(currentProcess);
            }
        }
    }

    // Helper function to print results
    public static void printResults(List<Process> processes) {
        System.out.println("PID\tAT\tBT\tWT\tTAT");
        for (Process p : processes) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\n", p.pid, p.arrivalTime, p.burstTime, p.waitingTime, p.turnAroundTime);
        }
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 8, 2));
        processes.add(new Process(2, 1, 4, 1));
        processes.add(new Process(3, 2, 9, 3));
        processes.add(new Process(4, 3, 5, 2));

        System.out.println("FCFS Scheduling:");
        fcfs(processes);
        printResults(processes);

        System.out.println("\nSJF Preemptive Scheduling:");
        processes.forEach(p -> p.remainingTime = p.burstTime); // Reset remaining times
        sjfPreemptive(processes);
        printResults(processes);

        System.out.println("\nPriority Non-Preemptive Scheduling:");
        priorityNonPreemptive(processes);
        printResults(processes);

        System.out.println("\nRound Robin Scheduling (Quantum = 3):");
        processes.forEach(p -> p.remainingTime = p.burstTime); // Reset remaining times
        roundRobin(processes, 3);
        printResults(processes);
    }
}
