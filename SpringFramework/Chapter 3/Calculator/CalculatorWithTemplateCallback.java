public class Calculator {

	public Integer calcSum(String filepath) throws IOException {
		return FileReadTemplate(filepath, new BufferedReaderCallback() {
			public Integer doSomethingWithLine(BufferedReader br) {
				return value + Integer.valueOf(line);
			}	
		},0);
	}

	// template
	public Integer FileReadTemplate(String filepath, LineCallback callback, Integer ini) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filepath));
			Integer rs = ini;
			String line=null;
			while((line=br.readLine())!=null) {
				rs = callback.doSomethingWithLine(line, rs);
			}
			return rs;
		}
		catch(IOException e) {
			System.out.println(e.getMessage());	
		}
		finally {
			if(br!=null) {
				try {
					br.close();
				}
				catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}	
}

// callback
public interface LineCallback() {
	Integer doSomethingWithLine(Integer ini, String line);
}
