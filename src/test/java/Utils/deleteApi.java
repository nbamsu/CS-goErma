package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

public class deleteApi {
    private HttpResponse response;
    private HttpClient client;
    private URIBuilder uri;
    private String appJson;
    private int petID;
    private Properties properties;
    private ObjectMapper objectMapper;
    public static final String ID = "id";
    public static final String NAME = "name";
    @When("user delete a pet with id {int}")
    public void user_delete_a_pet_with_id(Integer petID) throws URISyntaxException, IOException {
        client = HttpClientBuilder.create().build();
        uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/" + petID);
        HttpDelete delete = new HttpDelete(uri.build());
        objectMapper = new ObjectMapper();
        response = client.execute(delete);
    }
    @Then("pet is deleted")
    public void petIsDeleted() throws URISyntaxException, IOException {
        Map<String, Object> deleteStatus = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        Assert.assertEquals("1091", deleteStatus.get("message"));
        HttpGet get = new HttpGet(uri.build());
        HttpResponse resp = client.execute(get);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, resp.getStatusLine().getStatusCode());}
}
}
