/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class BankingSystem
{

    static ArrayList<Client> allClients;
    static ArrayList<BankAccount> allAccounts;
    static Scanner input;
    
    static void showAllAccounts(){
        for(int i =0;i<allAccounts.size();i++){
            allAccounts.get(i).view();
            System.out.println("*******************************");
        }
    }
    static BankAccount search(int accountId){
        for(int i=0;i<allAccounts.size();i++){
            if(accountId==allAccounts.get(i).getAccountId()){
                return allAccounts.get(i);
            }
        }
        return null;
    }
    
    static int searchById(int accountId){
        for(int i=0;i<allAccounts.size();i++){
            if(accountId==allAccounts.get(i).getAccountId()){
                return i;
            }
        }
        return -1;
    }
    static void searchForAccount(){
        System.out.println("enter account id");
        int id = input.nextInt();
        BankAccount acc = search(id);
        if(acc==null){
            System.err.println("account not found");
            return;
        }
        acc.view();
        
    }

    static void removeAccount(){
         System.out.println("enter account id");
        int id = input.nextInt();
//        BankAccount acc = search(id);
//        if(acc==null){
//            System.err.println("account not found");
//            return;
//        }
//        allAccounts.remove(acc);
//        allClients.remove(acc.getOwner());
        
        int index = searchById(id);
        if(index==-1){
            System.err.println("account not found");
            return;
        }        
        /* 
        Todo: search for memory leak and how to avoid it
        */ 
        allClients.remove(allAccounts.get(index).owner);
        allAccounts.remove(index);
        System.out.println("account removed successfully");
    }
    
    static void deposit(){
           System.out.println("enter account id");
        int id = input.nextInt();
        
         int index = searchById(id);
        if(index==-1){
            System.err.println("account not found");
            return;
        }   
        System.out.println("enter amount to deposit");
        double amountOfMoney=input.nextDouble();
        if(allAccounts.get(index).deposit(amountOfMoney)){
            System.out.println("successfull operation");
        }
    }
    
    static void withdraw(){
           System.out.println("enter account id");
        int id = input.nextInt();
        
         int index = searchById(id);
        if(index==-1){
            System.err.println("account not found");
            return;
        }   
        System.out.println("enter amount to withdraw");
        double amountOfMoney=input.nextDouble();
        if(allAccounts.get(index).withdraw(amountOfMoney)){
            System.out.println("successfull operation");
        }
    }
    
    static void addAccount(){
        input.nextLine();
        System.out.println("enter client name");
        String name = input.nextLine();
        System.out.println("enter client address");
        String address = input.nextLine();
        System.out.println("enter client phone");
        String phone = input.nextLine();
        
        Client newClient = new Client(name, address, phone);
        System.out.println("please choose account type");
        System.out.println("1- basic bank account");
        System.out.println("2- savings bank account");
        int accType = input.nextInt();
        if(accType!=1&&accType!=2){
            System.err.println("invalid input");
            return;
        }
        BankAccount newAccount =null;
        System.out.println("enter account balance");
        double balance = input.nextDouble();
        if(accType==1){
            newAccount = new BankAccount(balance);
        }else if(accType==2){
            newAccount = new SavingsBankAccount(balance);
        }
        newAccount.setOwner(newClient);
        newClient.setAccount(newAccount);
        allAccounts.add(newAccount);
        allClients.add(newClient);
        System.out.println("account created successfully");
    }
    public static void main(String[] args)
    {
        allAccounts = new ArrayList<BankAccount>();
        allClients = new ArrayList<Client>();
        input = new Scanner(System.in);
        addTestData();

        while (true)
        {
            System.out.println("1- add account");
            System.out.println("2- list all Accounts");
            System.out.println("3- search for account");
            System.out.println("4- remove account");
            System.out.println("5- withdraw");
            System.out.println("6- deposit");
            System.out.println("7- exit");
            int option = input.nextInt();

            if (option == 1)
            {
                addAccount();
            } else if (option == 2)
            {
                showAllAccounts();
            } else if (option == 3)
            {
                searchForAccount();
            } else if (option == 4)
            {
                removeAccount();
            } else if (option == 5)
            {
                withdraw();
            } else if (option == 6)
            {
                
                deposit();
            } else if (option == 7)
            {
                break;
            }
        }

    }
    
    static void addTestData(){
        for(int i=0;i<20;i++){
            BankAccount ba = new BankAccount(i*50000);
            Client c = new Client("name "+i,"address "+i, "123456");

            c.setAccount(ba);
            ba.setOwner(c);
            
            allAccounts.add(ba);
            allClients.add(c);
        }
    }
}
