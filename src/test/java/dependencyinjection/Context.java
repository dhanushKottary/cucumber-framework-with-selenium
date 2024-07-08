package dependencyinjection;

import java.util.HashMap;

public class Context {
	
	private HashMap<String, String> state;
	
	public Context() {
		state = new HashMap<String, String>();
	}
	
	public void SetContext(String key, String value) {
		state.put(key, value);
	}
	
	public String getContext(String key) {
		return state.get(key);
	}

}
