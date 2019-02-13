/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingSystem;

/**
 *
 * @author Administrator
 */
public class BankAccount
{
    protected int accountId;
    protected double balance;
    protected Client owner;
    protected static int IDSGENERATOR =1000;
    public BankAccount()
    {   
        balance=0;
        accountId=IDSGENERATOR++;
    }
    public BankAccount(double balance){
        this.balance=balance;
        accountId=IDSGENERATOR++;
    }

    public int getAccountId()
    {
        return accountId;
    }

    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public static int getIDSGENERATOR()
    {
        return IDSGENERATOR;
    }

    public static void setIDSGENERATOR(int IDSGENERATOR)
    {
        BankAccount.IDSGENERATOR = IDSGENERATOR;
    }
    
    
    public boolean withdraw(double amountOfMoney){
    
        if(amountOfMoney<0){
            System.err.println("invalid amount");
            return false;
        }
        if(amountOfMoney>balance){
            System.err.println("balance is not sufficient");
            return false;
        }
        balance-=amountOfMoney;
        return true;
    }
    
    public boolean deposit(double amountOfMoney){
        if(amountOfMoney<=0){
            System.err.println("invalid amount");
            return false;
        }
        balance+=amountOfMoney;
        return true;
    }

    public Client getOwner()
    {
        return owner;
    }

    public void setOwner(Client owner)
    {
        this.owner = owner;
    }
    
    
    public void view(){
        System.out.println("account Id : "+accountId);
        System.out.println("balance : "+balance);
        owner.view();
    }
}
