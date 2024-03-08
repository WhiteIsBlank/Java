# JDBC

##### 创建数据表

```sql
CREATE TABLE student(
SNO VARCHAR(20),
Name VARCHAR(10),
Age INTEGER,
College VARCHAR(30));
```

##### 代码

```java
import java.sql.*;

class Properties {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc";
    public static final String USER = "root";
    public static final String PASSWORD = "200412";
}
public class jdbc {
    public static void printData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM student";
        Statement statement = conn.createStatement();
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //遍历输出结果
        while(resultSet.next()){
            //获取每一行元组中的属性值
            String SNO = resultSet.getNString("SNO");
            String Name = resultSet.getNString("Name");
            Integer Age = resultSet.getInt("Age");
            String College = resultSet.getNString("College");
            //输出元组信息
            System.out.println(SNO+","+Name+","+Age+","+College+",");
        }
        statement.close();
    }
    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Properties properties = new Properties();
        Connection conn = DriverManager.getConnection(properties.URL, properties.USER, properties.PASSWORD);
        System.out.println("------------------------");
        System.out.println("第1题的效果");
        System.out.println("------------------------");
        // 定义sql语句
        String sql = "INSERT INTO student (SNO,Name,Age,College)\n" +
                "VALUES \n" +
                "('s001','老大',20,'计算机学院'),\n" +
                "('s002','老二',19,'计算机学院'),\n" +
                "('s003','老三',18,'计算机学院'),\n" +
                "('s004','老四',17,'计算机学院')"; // 请替换 'someName' 为正确的值
        // 获取执行sql的对象
        Statement statement = conn.createStatement();
        // 执行sql
        statement.executeUpdate(sql); // 受影响的行数
        // 释放资源
        statement.close();
        printData(conn);
        System.out.println("------------------------");
        System.out.println("第2题的效果");
        System.out.println("------------------------");
        printData(conn);
        System.out.println("------------------------");
        System.out.println("第3题的效果");
        System.out.println("------------------------");
        String sql2 = "DELETE FROM student\n" +
                "WHERE SNO = 's004'";
        Statement statement2 = conn.createStatement();
        statement2.executeUpdate(sql2);
        printData(conn);
        statement2.close();
        System.out.println("------------------------");
        System.out.print("第4题：");
        String sql3 = "SELECT * FROM student\n" +
                "WHERE SNO = 's003'";
        Statement statement3 = conn.createStatement();
        ResultSet resultSet = statement3.executeQuery(sql3);
        if (resultSet.next()) {
            String SNO = resultSet.getString("SNO");
            String Name = resultSet.getString("Name");
            int Age = resultSet.getInt("Age"); // Use int for Age
            String College = resultSet.getString("College");
            System.out.println("Student{SNO=" + SNO + ",Name=" + Name + ",Age=" + Age + ",College=" + College + "}");
        }
        System.out.println("第4题的效果");
        System.out.println("------------------------");
        printData(conn);
        System.out.println("------------------------");
        System.out.println("第5题的效果");
        System.out.println("------------------------");
        String sql1 = "UPDATE student\n" +
                "set SNO = 's001',\n" +
                "Name = '老大',\n" +
                "Age = 20,\n" +
                "College = '通信学院'\n" +
                "WHERE SNO = 's001'";
        Statement statement1 = conn.createStatement();
        // 执行sql
        statement1.executeUpdate(sql1); // 受影响的行数
        printData(conn);
        statement1.close();
        conn.close();
    }
}
```

##### 运行结果

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/0aecd07d-bba3-4514-8301-d25196055f27)

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/d5191141-0674-43bc-a490-7db13bbc0bb6)
