package ee.bcs.java.controller;

public class TransactionDTO {
    private String accountnumber;
    private int ylekandesumma;
    private String created;
    private int saldo;
    private int id;


    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
    public int getYlekandesumma() {
        return ylekandesumma;
    }

    public void setYlekandesumma(int ylekandesumma) {
        this.ylekandesumma = ylekandesumma;
    }


}
