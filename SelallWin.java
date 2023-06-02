import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SelallWin extends JFrame {

    DefaultTableModel tm;
    JTable tb;
    JScrollPane sp;
    SelallCtrl ctrl;

    SelallWin() { //コンストラクタ
        ctrl = new SelallCtrl();
        this.getContentPane().setLayout(new FlowLayout());

        String[][] rowData = {};
        String[] colNames = {"sno", "sname", "address", "age"};

        tm = new DefaultTableModel(rowData, colNames);
        tb = new JTable(tm);
        sp = new JScrollPane(tb);
        sp.setPreferredSize(new Dimension(460, 80));
        this.getContentPane().add(sp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student");
        this.setSize(480, 120);
    }

    public String[][] getData() {
        return ctrl.getdata();
    }

    public void setData(String[][] data) { //表に行を追加
        for (String[] datum : data) {
            String[] row = {datum[0], datum[1], datum[2], datum[3]};
            tm.addRow(row);
        }
    }

    public void openDB(String dbfile) {
        ctrl.openDB(dbfile);
    }

    public void closeDB() {
        ctrl.closeDB();
    }

    public static void main(String[] args) {
        SelallWin sw = new SelallWin();

        sw.openDB("jdbc:sqlite:/Users/sannamiyusaku/IdeaProjects/db/SQL/stock3.sqlite3");
        sw.setData(sw.getData());
        sw.setVisible(true);
        sw.closeDB();
    }
}