public class CountingConnectionMaker implements ConnectionMaker {

	private int counter=0;
	private ConnectionMaker realConnectionMaker;

	public ConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker=realConnectionMaker;
	}

	public Connection makeConnection() {
		counter++;
		return realConnectionMaker.makeConnection();
	}

	public int getCounter() {
		return counter;
	}
}