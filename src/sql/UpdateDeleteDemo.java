package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDeleteDemo {

	public static void main(String[] args)throws Exception{
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
                
            String url="jdbc:mysql://localhost:3306/test?useSSL=true";    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,    "root","Ll0828Cc");
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");

            //查询数据的代码
            String sql = "select * from stu";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("原始数据： \n " + "编号"+"\t"+"姓名"+"\t"+"年龄");
                while (rs.next()){
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getInt(3) + "\t");
                    System.out.println();
                }
                
            //增加数据
            String sql1 = "insert into stu (number,name,age) values(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql1);
            pst.setInt(1,1);
            pst.setString(2,"sunlu");
            pst.setInt(3, 25);
            pst.executeUpdate();
            ResultSet rs1 = stmt.executeQuery(sql);//创建数据对象
            System.out.println("插入后数据：  \n" + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs1.next()){
                System.out.print(rs1.getInt(1) + "\t");
                System.out.print(rs1.getString(2) + "\t");
                System.out.print(rs1.getInt(3) + "\t");
                System.out.println();
            }
                
            //修改数据的代码
            String sql2 = "update stu set name=? where number=?";
            pst = conn.prepareStatement(sql2);
            pst.setString(1,"nick");
            pst.setInt(2,1);
            pst.executeUpdate();
                
            ResultSet rs3 = stmt.executeQuery(sql);//创建数据对象
            System.out.println("修改后数据：  \n" + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs3.next()){
                System.out.print(rs3.getInt(1) + "\t");
                System.out.print(rs3.getString(2) + "\t");
                System.out.print(rs3.getInt(3) + "\t");
                System.out.println();
            }
            //删除数据的代码
            String sql3 = "delete from stu where number=?";
            pst = conn.prepareStatement(sql3);
            pst.setInt(1,1);
            pst.executeUpdate();
                
            ResultSet rs2 = stmt.executeQuery(sql);//创建数据对象
            System.out.println("删除后数据：   \n" + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs2.next()){
                System.out.print(rs2.getInt(1) + "\t");
                System.out.print(rs2.getString(2) + "\t");
                System.out.print(rs2.getInt(3) + "\t");
                System.out.println();
            }
                
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
