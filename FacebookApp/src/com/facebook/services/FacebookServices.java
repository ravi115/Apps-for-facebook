package com.facebook.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

@Path("/details")
public class FacebookServices {

	private static final Logger LOG = Logger.getLogger(FacebookServices.class);

	@SuppressWarnings("deprecation")
	@GET
	@Produces("TEXT/HTML")
	public String getUserInformation() {
		String accessToken = "EAACEdEose0cBAFDZATVFxqkhwFiNiei5fFwiUvtvBSs2tGJEPqvev25fS8M9CDhiZA5gXXTnQfXvnhskZC7kQO502GSHZAssxqktZCh2i48ZA0vF65PoZCBmUw8TkLt60iS79QLT4VzxojH7zdHsG8BDqW3yOm2Qy9fEBHz72PrNXdTCxhLTEdVLbGLFzfCWZAUZD";
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		User me = fbClient.fetchObject("me", User.class);
		LOG.info("the User name is : " + me.getFirstName());
		LOG.info("the User Birthday is : " + me.getBirthday());
		LOG.info("the User BIO is : " + me.getBio());
		LOG.info("the User RelatiosHip Stauts is : " + me.getRelationshipStatus());
		return "success";
	}
	
	@GET
	@Path("/user")
	@Produces("text/html")
	public String getOtherUserInformation() {
		return "succeefully returned";
	}
}
