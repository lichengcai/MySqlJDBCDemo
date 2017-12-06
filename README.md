# MySqlJDBCDemo
Java对MySQL数据库进行连接、插入、查询和修改

 一般过程：

　　(1) 调用Class.forName()方法加载驱动程序。

　　(2) 调用DriverManager对象的getConnection()方法，获得一个Connection对象。

　　(3) 创建一个Statement对象，准备一个SQL语句，这个SQL语句可以是Statement对象（立即执行的的语句）、PreparedStatement语句（预编译的语句）或CallableStatement对象（存储过程调用的语句）。

　　(4) 调用excuteQuery()等方法执行SQL语句，并将结果保存在ResultSet对象；或者调用executeUpdate()等方法执行SQL语句，不返回ResultSet对象的结果。

　　(5)对返回的ResultSet对象进行显示等相当的处理。

　　(6)释放资源。

 
