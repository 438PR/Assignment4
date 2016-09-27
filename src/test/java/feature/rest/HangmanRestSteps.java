package feature.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import edu.csumb.cst438fa16.hangman.rest.HangmanResource;

/**
 * User story:
 *
 *   As a user I want to be able to enter a character and submit as a guess
 *	So that I can take steps to solve the puzzle
 */
public class HangmanRestSteps extends JerseyTest {
    Response response;

    @Override
    protected Application configure() {
        return new ResourceConfig(HangmanResource.class).property("word", "cat");
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    @When("^I call (\\w+) endpoint$")
    public void i_call_start_endpoint(String endpoint) throws Throwable {
    	WebTarget webTarget = target(endpoint);
        response = webTarget.request().get();
        System.out.println(response.getHeaderString(endpoint));
    }
    
	@Then("^the response is \\.\\.\\.$")
	public void the_response_is() throws Throwable {
		assertThat(response.getStatus(), equalTo(500));
	}
    
    @Then("^the response is \"([^\"]*)\"$")
    public void the_response_is(String arg1) throws Throwable {
    	assertThat(response.getStatus(), equalTo(arg1));
    }
}