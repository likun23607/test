package test01;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class FlyweightMap extends AbstractMap<String, String>{

	private static class Entry implements Map.Entry<String, String>{
		int index;
		Entry(int index){
			this.index=index;
		}
		@Override
		public String getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String setValue(String value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
	@Override
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
