/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Transaction;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class TransactionHistory {
    
    ArrayList<Transaction> transactionHistory;
    
    public TransactionHistory()
    {
        transactionHistory = new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    public Transaction newTransaction()
    {
        Transaction transaction = new Transaction();
        transactionHistory.add(transaction);
        return transaction;
    }
    
}
