package com.servMe.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/data.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBrowserName() {
		String browsern = pro.getProperty("browser");
		return browsern;
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseurl");
		return url;
	}

	public String getusername() {
		String uname = pro.getProperty("username");
		return uname;
	}

	public String getpassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}

	public String getChromepath() {
		String chromep = pro.getProperty("chromepath");
		return chromep;
	}
}