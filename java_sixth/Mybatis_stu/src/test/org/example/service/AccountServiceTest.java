package org.example.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Account;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AccountServiceTest {

    @Before
    public void Init() throws Exception {
    }

    @Test
    public void findAll() throws IOException {
        AccountService accountService = new AccountService();
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }


    @Test
    public void selectByPrimaryKey() throws IOException {
        String id = "id1";
        AccountService accountService = new AccountService();
        Account account = accountService.selectByPrimaryKey(id);
        System.out.println(account);
    }


    @Test
    public void deleteByPrimaryKey() throws IOException {
        String id = "id3";
        AccountService accountService = new AccountService();
        accountService.deleteByPrimaryKey(id);
        accountService.destroy();
    }


    @Test
    public void insert() throws IOException {
        AccountService accountService = new AccountService();
        String id = "id10";
        String name = "User10";
        int money = 2100;
        Date createtime = accountService.dateChange("2023-01-10 00:00:00");
        Date updatetime = accountService.dateChange("2023-01-10 00:00:00");
        Account account = new Account(id,name,money,createtime,updatetime);
        accountService.insert(account);
        accountService.destroy();
    }

    @Test
    public void updateByPrimaryKey() throws IOException {
        AccountService accountService = new AccountService();
        String id = "id10";
        String name = "User10";
        int money = 2000;
        Date createtime = accountService.dateChange("2023-01-10 00:00:00");
        Date updatetime = accountService.dateChange("2023-01-10 23:00:00");
        Account account = new Account(id,name,money,createtime,updatetime);
        int count = accountService.updateByPrimaryKey(account);
        System.out.println("影响行数："+count);
        accountService.destroy();
    }
}