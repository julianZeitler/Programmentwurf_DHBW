package notizbuch;

public class Notizbuch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBAccess da = new DBAccess();
        da.readDatabase();
	}
}