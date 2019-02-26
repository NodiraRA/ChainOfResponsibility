/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibility;

/**
 *
 * @author nodira
 */
public class BugTracker {

   
    public static void main(String[] args) {
       Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
       Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
       Notifier smsNotifier = new SMSNotifier(Priority.ASAP);
       
       reportNotifier.setNextNotifier(emailNotifier);
       emailNotifier.setNextNotifier(smsNotifier);
       
       
       reportNotifier.notifyManager("Everything is OK.", Priority.ROUTINE);
       reportNotifier.notifyManager("Somesing is wrong!", Priority.IMPORTANT);
       reportNotifier.notifyManager("Hey, we have had problem here!!!", Priority.ASAP);
    }
    
}
