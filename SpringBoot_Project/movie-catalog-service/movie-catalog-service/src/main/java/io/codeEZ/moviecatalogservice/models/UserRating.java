/**
 * 
 */
package io.codeEZ.moviecatalogservice.models;

import java.util.List;

/**
 * @author Muralidharan V
 *
 */
public class UserRating {
	
	private List<Rating> userRating;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	

}
