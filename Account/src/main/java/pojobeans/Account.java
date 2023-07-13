package pojobeans;

import java.util.Date;

public class Account {
    private long id;
    private String owenName;
    private double balance;
    private Date accessTime;
    private boolean locked;
    private int age;
    private String password;

    public Account() {
    }

    public Account(long id, String owenName, double balance, Date accessTime, boolean locked, int age, String password) {
        this.id = id;
        this.owenName = owenName;
        this.balance = balance;
        this.accessTime = accessTime;
        this.locked = locked;
        this.age = age;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwenName() {
        return owenName;
    }

    public void setOwenName(String owenName) {
        this.owenName = owenName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
