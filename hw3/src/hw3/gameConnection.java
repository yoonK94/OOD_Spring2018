package hw3;

import java.io.*;
import java.util.*;

public class gameConnection {
	
	private File file;
	private Map<String, Player> playerMap;
	
	public gameConnection(String fName) {
		
		file = new File(fName);
		if (!file.exists()) {
			playerMap = new HashMap<String, Player>();
		}
		else {
			try {
				InputStream is = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(is);
				playerMap = (Map<String, Player>)ois.readObject();
				ois.close();
			}
			catch (IOException ex) {
				System.out.println(ex);
				throw new RuntimeException("File is corrupt");
			}
			catch (ClassNotFoundException ex) {
				System.out.println(ex);
				throw new RuntimeException("Serialization problem");
			}	
		}
	}
	
	public Map<String, Player> getMap(){
		return playerMap;
	}
	
	public void saveMap(Map<String, Player> map) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(map);
			oos.close();
		}
		catch(Exception ex){
			throw new RuntimeException("File is corrupt");
		}
	}
}
