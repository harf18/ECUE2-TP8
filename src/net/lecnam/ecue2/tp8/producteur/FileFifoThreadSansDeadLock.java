package net.lecnam.ecue2.tp8.producteur;

import java.util.LinkedList;

public class FileFifoThreadSansDeadLock implements FileFifo {

    private LinkedList<String> q = new LinkedList<>();

    public synchronized String retirer() {

        while (q.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }

        return q.removeFirst();
    }

    public synchronized void ajouter(String o) {
        q.add(o);
        this.notify();
    }
}


