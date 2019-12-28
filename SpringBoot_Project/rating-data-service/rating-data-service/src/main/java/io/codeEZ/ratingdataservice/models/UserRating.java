/**
 * 
 */
package io.codeEZ.ratingdataservice.models;

import java.util.List;

/**
 * @author Muralidharan V
 *
 */
public class UserRating {
	
	private List<Rating> userRating;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	

}
