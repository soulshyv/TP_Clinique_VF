package clinique.dal;

import java.util.Properties;


public class Config {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Config.class.getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Retourne une connexion � la base de donn�es
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}

