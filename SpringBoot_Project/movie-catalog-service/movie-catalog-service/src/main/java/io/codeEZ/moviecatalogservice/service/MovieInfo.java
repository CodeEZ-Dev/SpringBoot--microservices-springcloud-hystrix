/**
 * 
 */
package io.codeEZ.moviecatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.codeEZ.moviecatalogservice.models.CatalogItem;
import io.codeEZ.moviecatalogservice.models.Movie;
import io.codeEZ.moviecatalogservice.models.Rating;

/**
 * @author Muralidharan V
 *
 */
@Service
public class MovieInfo {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getFallbackCatalogItem")
	public CatalogItem getCatalogItems(Rating rate) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rate.getMovieId() , Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rate.getRating());
	}
	public CatalogItem getFallbackCatalogItem(Rating rate) {
		return new CatalogItem("Movie Name Not Found", "", rate.getRating());
	}

}
