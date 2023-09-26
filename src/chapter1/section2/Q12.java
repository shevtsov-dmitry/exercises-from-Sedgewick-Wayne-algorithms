package chapter1.section2;

import edu.princeton.cs.algs4.Date;

public class Q12 {
    public static void main(String[] args) {
        Client cl1 = new Client("Paul", 5000);
        Client cl2 = new Client("Paulina", 100);

        Transaction transaction = new Transaction(cl1, cl2, new Date(5, 12, 2002));

        System.out.println(STR. "Bank accounts: \{ transaction.getWho().getName() } has \{ transaction.getWho().getBankAccount() }$" +
                STR. " and \{ transaction.getToWhom().getName() } has \{ transaction.getToWhom().getBankAccount() }$." );

        transaction.sendTransaction(600);

        System.out.println(STR. "\{ cl1.getName() } sent \{ transaction.getHowMuch() }$ to \{ cl2.getName() } at \{ transaction.getWhen().toString() }." );

        System.out.println(STR. "Bank accounts: \{ transaction.getWho().getName() } has \{ transaction.getWho().getBankAccount() }$" +
                STR. " and \{ transaction.getToWhom().getName() } has \{ transaction.getToWhom().getBankAccount() }$." );

        Transaction microtransaction = new Transaction(cl1, cl2, new Date(5, 12, 2002));

        microtransaction.sendTransaction(600);

        System.out.println(transaction.equals(microtransaction));

    }

}

class Transaction {
    private Client who;
    private Client toWhom;
    private Date when;
    private double howMuch;

    public Transaction(Client who, Client toWhom, Date when) {
        this.who = who;
        this.toWhom = toWhom;
        this.when = when;
    }

    public Client getWho() {
        return who;
    }


    public Date getWhen() {
        return when;
    }

    public Client getToWhom() {
        return toWhom;
    }

    public double getHowMuch() {
        return howMuch;
    }

    public void sendTransaction(double howMuch) {
        this.howMuch = howMuch;
        if (who.getBankAccount() < howMuch) {
            System.out.println("insufficient amount of money to make transaction. " +
                    STR. "\n your amount: \{ who.getBankAccount() }. you are trying to send: \{ howMuch }" );
            return;
        }
        who.setBankAccount(who.getBankAccount() - howMuch);
        toWhom.setBankAccount(toWhom.getBankAccount() + howMuch);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (this.getClass() != other.getClass()) return false;

        Transaction that = (Transaction) other;
        return (this.who == that.who) &&
                (this.toWhom == that.toWhom) &&
                (this.howMuch == that.howMuch);
    }

}

class Client {

    private String name;
    private double bankAccount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Client(String name, double bankAccount) {
        this.name = name;
        this.bankAccount = bankAccount;
    }
}