public class UserDaoConnectionCountingTest {
	public static void main(String[] argv) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao userdao = context.getBean("userdao",UserDao.class);

		CountingConnectionMaker ccm = context.getBean("connectionMaker",CountingConnectionMaker.class);
		System.out.println("Connection counter : " + ccm.getCounter());
	}
}