package restApi;

import clients.request_factory.HeaderFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import configuration.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class RestConsumer {
	private static Logger log = LoggerFactory.getLogger(RestConsumer.class);
	private HashMap<String, String> config;
	private RequestSpecification requestSpec;

	public RestConsumer() {
		config = Environment.getInstance().getEnvMap();
		requestSpec = RestAssured.given().relaxedHTTPSValidation().headers(HeaderFactory.defaultHeader());
	}

	public RestConsumer getBasicAuth(){
		requestSpec.auth().basic(config.get("username"),config.get("password"));
		return this;
	}

	public Response doGetCall(String requestURL, String contentType) {
		log.info("GET Request: URL:" + config.get("baseURL") + requestURL);
		return requestSpec.accept(contentType).baseUri(config.get("baseURL")).get(requestURL);
	}

	public Response doPostCall(String requestURL, String contentType, String body) {
		return requestSpec.accept(contentType).basePath(config.get("baseURL"))
				.content(body).post(requestURL);
	}
}
