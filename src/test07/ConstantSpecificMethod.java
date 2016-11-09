package test07;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {
	DATE_TIME {
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	};
	
	abstract String getInfo();
}
