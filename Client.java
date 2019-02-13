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
public class Client
{
    String name;
    String address;
    String phone;
    BankAccount account;

    public Client(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public BankAccount getAccount()
    {
        return account;
    }

    public void setAccount(BankAccount account)
    {
        this.account = account;
    }
    
    
    public void view(){
        System.out.println("name : "+name);
        System.out.println("address : "+address);
        System.out.println("phone : "+phone);
       // account.view();
    }
    
}
