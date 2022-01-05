package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemTest {

    @Test
    public void ShouldWork(){
        QueueManagementSystem Bank = new  QueueManagementSystem("Bank");
        QueueManagementSystem School = new  QueueManagementSystem("School");
        int actual = Bank.getTotalTickets();




    }

}