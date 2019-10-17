package clients.request_factory;

import java.util.HashMap;

public class HeaderFactory {
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";

	public static HashMap<String, String> defaultHeader() {
		HashMap<String, String> headers = new HashMap<>();
		headers.put(CONTENT_TYPE, APPLICATION_JSON);
		return headers;
	}
}