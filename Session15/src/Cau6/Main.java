package Cau6;

public class Main {
    public static void main(String[] args) {
        PatientWaitingQueue pQueue = new PatientWaitingQueue();
        pQueue.addPatient(new Patient("BN01", "Nguyen Van A", 20, "Nam"));
        System.out.println("Next: " + pQueue.nextPatient());

        MedicalRecordHistory history = new MedicalRecordHistory("REC-100");
        history.addEditAction(new EditAction("Update Heart Rate", "Dr. Smith", "10:00"));
        history.addEditAction(new EditAction("Update Blood Type", "Nurse Joy", "10:05"));
        history.displayHistory();

        TicketSystem ts = new TicketSystem();
        ts.issueTicket("08:00");
        ts.issueTicket("08:01");
        ts.callNext();

        UndoManager undoer = new UndoManager(5);
        undoer.recordAction(new InputAction("Diagnosis", "None", "Flu", "09:00"));
        undoer.undo();
    }
}
