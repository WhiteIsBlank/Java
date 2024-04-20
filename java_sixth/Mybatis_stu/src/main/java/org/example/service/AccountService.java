package org.example.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Account;
import org.example.dao.AccountDao;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    //初始化
    public AccountService() throws IOException{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    //释放资源
    public void destroy(){
        try{
            sqlSession.commit();
            sqlSession.close();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //date数据转换
    public Date dateChange(String datetime){
        Date time = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = sdf.parse(datetime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
    //1查询所有记录
    public List<Account> findAll(){
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }
    //2通过id删除记录
    public void deleteByPrimaryKey(String id){
        accountDao.deleteByPrimaryKey(id);
    }
    //3插入记录
    public void insert(Account record){
        accountDao.insert(record);
    }
    //4通过id查找对象
    public Account selectByPrimaryKey(String id){
        Account account = accountDao.selectByPrimaryKey(id);
        return account;
    }

    int updateByPrimaryKey(Account record){
        int Influence = accountDao.updateByPrimaryKey(record);
        return Influence;
    }
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
