import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelallDB {

    Connection con;
    Statement st;
    ResultSet rs;

    public int getNdata() { //テーブルStudentのタプル数を得る
        try {
            String sql = "SELECT count(*) FROM Student"; //count(*) = 全てのタブルをカウント
            rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1); //一つ目のカラムを整数にして返す

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public String[][] getdata() { //テーブルStudentの情報をrowにセットして返す
        String[][] list = new String[getNdata()][4]; //タブル数に対応した二次元配列を定義

        try {
            String sql = "SELECT * FROM Student";
            rs = st.executeQuery(sql);
            int i = 0;

            while(rs.next()){

                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                String age = Integer.toString(rs.getInt("age"));

                list[i][0] = sno;
                list[i][1] = sname;
                list[i][2] = address;
                list[i][3] = age;

                i++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void open(String dbfile) { //データベースをオープンする
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(dbfile);
            st = con.createStatement();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() { //データベースをクローズする
        try {
            st.close();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}