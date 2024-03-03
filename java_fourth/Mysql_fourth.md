# mysql入门练习

##### 1.用 SQL 语句，建立如下所示的表 cqupt_student

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/44f3ff19-bc2f-461f-a215-b79e01209e5e)

###### 题解：

```sql
create database stu;
use student;
create table cqupt_student(
    studentid varchar(10) primary key,
    name varchar(20) not null,
    sex varchar(2) not null,
    age integer,
    Fee decimal(10,2),
    address varchar(50),
    memo varchar(300));
```

![](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240302201329580.png)

##### 2.用 Create Table 语句建表 CourseAa

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/cd3d73e7-ab12-42ae-b6e1-696ccca97093)

###### 题解：

```sql
use student;
create table CourseAa(
    Aa1 Varchar(20),
    Aa2 integer,
    Aa3 DECIMAL(10));
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/989ea28f-8526-47bf-ab32-6ab6119d45a9)

##### 3.用Create Table 语句建表 ChooseBb

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/9a121147-85e2-4d95-8df2-b80d6dc1b24c)

###### 题解：；

```sql
use student;
create table ChooseBb(
    Bb1 Varchar(30),
    Bb2 Integer,
    Bb3 decimal(6));
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/55f27dad-9e20-45e9-86c7-7666b8026fef)

##### 4.用 Alter Table 语句更新表 ChooseBb，添加一个属性名 Bb4，类型 Varchar,长度 20,完整性约束设为非空值，缺省值设为字符“系统测试值”

###### 题解：

```sql
Alter table ChooseBb
add column Bb4 varchar(40) not null default('系统测试值');
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/df9e8d9a-747c-483a-ad98-823bbd6a078d)

##### 5.用 Alter Table 语句更新表 ChooseBb，添加一个属性名 Bb5，类型 Varchar长度 10，完整性约束设为主码。完成后，表 ChooseBb 的设计如下所示。

###### 题解：

```sql
alter table ChooseBb
add column Bb5 varchar(10) primary key;
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/2b9be716-e514-4c25-b9ab-4c015f95aca1)

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/21552d6f-b164-451e-b681-03f6e43b8d3f)

##### 6.用 Create View 语句建立一个视图 View_Choosebb,生成的视图属性名（View_bb1，View_bb2，view_bb3）, 其中 View_bb1 对应于基表 ChooseBb的 Bb1、View_bb2 对应于基表 ChooseBb 的 Bb4、view_bb3 对应于基表ChooseBb 的 Bb5。

###### 题解：

```sql
CREATE VIEW View_Choosebb AS
SELECT
    choosebb.Bb1 AS View_bb1,
    choosebb.Bb4 AS View_bb2,
    choosebb.Bb5 AS View_bb3
FROM
    choosebb;
SELECT * FROM View_Choosebb;
```

##### 7.用 Drop View 语句删除视图 View_Choosebb

###### 题解：

```sql
DROP VIEW View_Choosebb;
```

##### 8.用 Create Index 语句对表 ChooseBb 的 Bb2 属性建立一个升序索引，索引名 Index_bb2。 用 Create Index 语句对表 ChooseBb 的 Bb4 属性建立一个降序索引，索引名 Index_bb4。

###### 题解：

```sql
CREATE INDEX Index_bb2 ON choosebb (Bb2 ASC);
CREATE INDEX Index_bb4 ON choosebb (Bb4 DESC);
```

##### 9.用 Drop Index 语句删除索引 Index_bb2。

```sql
DROP INDEX index_bb2 ON choosebb;
DROP INDEX index_bb4 ON choosebb;
```

##### 10.用 Create Table 语句建立 test 表，test 表定义如下所示：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/3cb0c1c4-0cbe-4069-9d15-02860f9d1003)

###### 题解：

```sql
CREATE TABLE test(
Name VARCHAR(20),
Age INTEGER,
Score NUMERIC(10,2),
Address VARCHAR(60));
```

##### 11.用 INSERT 语句对表 test,插入如下 6 条记录：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/43ac002c-8015-44d3-8005-ef6340772329)

###### 解题：

```sql
INSERT INTO test
VALUES 
('赵一',20,580.00,'重邮宿舍 12-3-5'),
('钱二',19,540.00,'南福苑5-2-9'),
('孙三',21,555.50,'学生新区21-5-15'),
('李四',22,505.00,'重邮宿舍8-6-22'),
('周五',20,495.50,'学生新区23-4-8'),
('吴六',19,435.00,'南福苑2-5-12');
```

##### 12.再用 Create Table 语句建立 test_temp 表，test_temp 表定义如下所示：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/cf3de6fe-5622-4ff0-a727-54e84a7e510e)

###### 题解：

```sql
CREATE TABLE test_temp(
Name VARCHAR(20),
Age INTEGER,
Score NUMERIC(10,2),
Address VARCHAR(60));
```

##### 13.用 INSERT 语句对表 test_temp,插入如下 3 条记录：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/fd513f5a-385a-4748-9a2e-f1d29f0d3d1f)

###### 题解：

```sql
INSERT INTO test_temp
VALUES
('郑七',21,490.50,'重邮宿舍11-2-1'),
('张八',20,560.00,'南福苑3-3-3'),
('王九',10,515.00,'学生新区19-7-1');
```

##### 14.用 INSERT INTO ... SELECT ... FROM 语句，将 test_temp 表中的数据，插入到 test 表中

###### 题解：

```sql
INSERT INTO test SELECT * FROM test_temp;
```

##### 15.用 UPDATE 语句将 test 表中年龄小于等于 20 的数据，将成绩更新为原来的成绩加 5 分

###### 题解：

```sql
UPDATE test
SET Score = Score + 5
WHERE Age <= 20;
```

##### 16.用 UPDATE 语句将 test 表中居住在南福苑所有学生的年龄减少 1 岁

###### 题解：

```sql
UPDATE test
SET Age = Age - 1
WHERE Address LIKE '南福苑%';
```

##### 17.用 DELETE 语句将 test 表中年龄大于等于 21 并且成绩大于等于 500 的学生数据删除掉

###### 题解：

```sql
DELETE FROM test
WHERE Age >= 21 AND Score >= 500;
```

##### 18.用 DELETE 语句将 test 表中成绩小于 550 并且居住在重邮宿舍的学生数据删除掉

###### 题解：

```sql
DELETE FROM test
WHERE Score < 500 AND Address LIKE '重邮宿舍%';
```

##### 19.用 Create Table 建立 Student 表，表结构如下所示：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/8f11c512-90f7-41c1-bf8f-dbc4b1f8015f)

###### 题解：

```sql
CREATE TABLE Student(
SNO VARCHAR(20),
Name VARCHAR(10),
Age INTEGER,
College VARCHAR(30));
```

##### 20.用 Create Table 建立 Course 表，表结构如下所示：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/b8d949d3-a205-4498-871c-12ed847e860a)

###### 题解：

```sql
CREATE TABLE Course(
CouserID VARCHAR(15),
CouserName VARCHAR(30),
CouserBeforeID VARCHAR(15));
```

##### 21.用 Create Table 建立 Choose 表，表结构如下所示：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/194d6426-546d-482d-bb38-d9fe61635ca7)

###### 题解：

```sql
CREATE TABLE Choose(
SNO VARCHAR(20),
CourseID VARCHAR(30),
Score DECIMAL(5,2));
```

##### 22.用 INSERT 语句向 Student 表中插入 3 个元组：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/3568262a-1f10-4e57-8c68-c9bbce6c354d)

###### 题解：

```sql
INSERT INTO Student
VALUES
('S00001','张三',20,'计算机学院'),
('S00002','李四',19,'通信学院'),
('S00003','王五',21,'计算机学院');
```

##### 23.用 INSERT 语句向 Course 表中插入 3 个元组：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/691d6439-520c-4f55-afed-7e55142a30cc)

###### 题解：

```sql
INSERT INTO Course
VALUES
('C1','计算机引论',NULL),
('C2','C语言','C1'),
('C3','数据结构','C2');
```

##### 24.用 INSERT 语句向 Choose 表中插入 7 个元组：

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/8bebecf5-5c95-461e-81b6-e2be25eb3312)

###### 题解：

```sql
INSERT INTO Choose
VALUES
('S00001','C1',95),
('S00001','C2',880),
('S00001','C3',84),
('S00002','C1',80),
('S00002','C2',85),
('S00003','C1',78),
('S00003','C3',70);
```

##### 25.用 SELECT 语句，查询计算机学院学生的学号和姓名

###### 题解：

```sql
SELECT SNO,Name FROM Student WHERE College = '计算机学院'
```

##### 26.用 SELECT 语句的 between…and…表示查询条件，查询年龄在 20~23 岁的学生信息

###### 题解：

```sql
SELECT * FROM Student WHERE Age BETWEEN 20 AND 23;
```

##### 27.用 SELECT 语句的 COUNT()聚集函数，统计 Student 表中学生总人数

###### 题解：

```sql
SELECT COUNT(Name) FROM Student;
```

##### 28.分别用 SELECT 语句的 max()、min()、sum()、avg()四个聚集函数，计算Choose 表中 C1 课程的最高分、最低分、总分、平均分

###### 题解：

```sql
SELECT MAX(Score),MIN(Score),SUM(Score),AVG(Score) FROM Choose;
```

##### 29.用 SELECT 语句对空值(NULL)的判断条件，查询 Course 表中先修课称编号为空值的课程编号和课程名称

###### 题解：

```sql
SELECT CouserID,CouserName FROM Course WHERE CouserBeforeID IS NULL;
```

##### 30.用 SELECT 语句的连接查询，查询学生的学号、姓名、选修的课程名及成绩

###### 题解：

```sql
SELECT Student.SNO, Student.Name, Choose.CourseID,choose.Score
FROM Student
JOIN Choose ON Student.SNO = Choose.SNO;
```

##### 31.用 SELECT 的存在量词 EXISTS，查询与“张三”在同一个学院学习的学生信息

###### 题解：

```sql
SELECT * FROM student WHERE EXISTS(
SELECT * FROM student as s WHERE s.College = student.college AND s.name = '张三');
```

##### 32.用 SELECT 语句的嵌套查询，查询选修 C1 课程的成绩低于“张三”的学生的学号和成绩

###### 题解：

```sql
SELECT SNO, Score
FROM Choose
WHERE CourseID = 'C1' AND Score < (
    SELECT Score
    FROM Choose
    WHERE CourseID = 'C1' AND SNO = (
        SELECT SNO
        FROM Student
        WHERE Name = '张三'
    )
);
```

##### 33.用 SELECT 语句的组合查询(UNION)，查询选修了 C1 课程或者选修了 C3课程的学生学号

###### 题解：

```sql
SELECT SNO FROM Choose WHERE choose.CourseID = 'C1' 
UNION 
SELECT SNO FROM choose WHERE choose.CourseID = 'C3';
```

##### 34.用 SELECT 语句的组合查询(UNION)与 DISTINCT 短语，查询选修了 C1 课程或者选修了 C3 课程的学生学号，并取消重复的数据

###### 题解：

```sql
SELECT SNO FROM Choose WHERE choose.CourseID = 'C1' 
UNION DISTINCT
SELECT SNO FROM choose WHERE choose.CourseID = 'C3';
```

