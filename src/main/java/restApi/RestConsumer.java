package restApi;

import clients.request_factory.HeaderFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import configuration.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestConsumer {
	private static Logger log = LoggerFactory.getLogger(RestConsumer.class);
	private Configuration config;
	private RequestSpecification requestSpec;

	public RestConsumer() {
		config = new Configuration();
		requestSpec = RestAssured.given().relaxedHTTPSValidation().headers(HeaderFactory.defaultHeader());
	}

	public RestConsumer getBasicAuth(){
		requestSpec.auth().basic(config.getConfig("username"),config.getConfig("password"));
		return this;
	}

	public Response doGetCall(String requestURL, String contentType) {
		log.info("GET Request: URL:" + config.getConfig("baseURL") + requestURL);
		return requestSpec.accept(contentType).baseUri(config.getConfig("baseURL")).get(requestURL);
	}

	public Response doPostCall(String requestURL, String contentType, String body) {
		return requestSpec.accept(contentType).basePath(config.getConfig("baseURL"))
				.content(body).post(requestURL);
	}
}
