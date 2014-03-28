package kr.ac.jejuniv;

public class DaoFactory {

	public UserDao getUserDao() {
		return new UserDao(new DConnectionMaker());
	}

}
