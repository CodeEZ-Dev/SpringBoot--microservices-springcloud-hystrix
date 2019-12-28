/**
 * 
 */
package io.codeEZ.ratingdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codeEZ.ratingdataservice.models.Rating;
import io.codeEZ.ratingdataservice.models.UserRating;

/**
 * @author Muralidharan V
 *
 */

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> rating= Arrays.asList(
				new Rating("100", 4),
				new Rating("567", 3));
		UserRating userRating=new UserRating();
		userRating.setUserRating(rating);
		return userRating;
	}
	
		
}
