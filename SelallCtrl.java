public class SelallCtrl {

    SelallDB db;

    SelallCtrl() { //コンストラクタ
        db = new SelallDB();
    }

    public String[][] getdata() {
        return db.getdata();
    }

    public void openDB(String dbfile) {
        db.open(dbfile);
    }

    public void closeDB() {
        db.close();
    }
}