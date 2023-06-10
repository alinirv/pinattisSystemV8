package br.edu.ifsp.domain.entities.cashier;

import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.entities.user.User;

import java.util.List;

public class Cashier {
    private Integer idCashier;
    private double openingBalance;
    private double finalBalance;
    private CashierStatus status;
    private User user;
    private List<Transaction> transaction;

    public Cashier() {
    }

    public Cashier(double openingBalance, double finalBalance, CashierStatus status, User user, List<Transaction> transaction) {
        this(null, openingBalance, finalBalance, status, user, transaction);
    }

    public Cashier(Integer idCashier, double openingBalance, double finalBalance, CashierStatus status, User user, List<Transaction> transaction) {
        this.idCashier = idCashier;
        this.openingBalance = openingBalance;
        this.finalBalance = finalBalance;
        this.status = status;
        this.user = user;
        this.transaction = transaction;
    }

    public Integer getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(Integer idCashier) {
        this.idCashier = idCashier;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public CashierStatus getStatus() {
        return status;
    }

    public void setStatus(CashierStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "id=" + idCashier +
                ", inicialCash=" + openingBalance +
                ", closingCash=" + finalBalance +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", transaction=" + transaction +
                '}';
    }
}
