package Cau6;
import java.util.*;

public class TicketSystem {
    Queue<Ticket> ticketQueue = new LinkedList<>();
    int currentNumber = 0;

    public void issueTicket(String time) {
        currentNumber++;
        ticketQueue.add(new Ticket(currentNumber, time));
        System.out.println("Issued Ticket No: " + currentNumber);
    }

    public void callNext() {
        Ticket t = ticketQueue.poll();
        if (t != null) {
            System.out.println("Calling Ticket: " + t.ticketNumber);
        }
    }
}