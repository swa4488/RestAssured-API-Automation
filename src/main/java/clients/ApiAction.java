package clients;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import clients.models.response.BasicAuthResponse;
import core.BaseSetup;

public class ApiAction extends BaseSetup {
	public BasicAuthResponse getBasicPostman(String uri){
		Response resp = restConsumer.getBasicAuth().doGetCall(uri, "application/json");
		Assert.assertEquals(resp.getStatusCode(), 200);
		return resp.as(BasicAuthResponse.class);
	}
}