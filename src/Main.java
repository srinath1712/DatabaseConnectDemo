import java.sql.*;


public class Main {
    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Srinath1712@");
            PreparedStatement pst = con.prepareStatement("update employee set EmpName =? where EmpId = ?");

            pst.setString(1,"Sony");
            pst.setInt(2,59);
            pst.executeUpdate();

            ResultSet resultSet = pst.executeQuery("Select * from employee");

            while(resultSet.next())
            {
                System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
}