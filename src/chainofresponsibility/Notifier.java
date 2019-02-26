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
public abstract class Notifier {
    
    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }
    
    public void setNextNotifier(Notifier nextNotidier){
        this.nextNotifier = nextNotifier;
       
    }
    
    public void notifyManager(String message, int level){
        if(level>=priority){
            write(message);
        }
        if(nextNotifier!=null){
            nextNotifier.notifyManager(message, level);
        }
    }
    
    public abstract void write(String message);
    
}
