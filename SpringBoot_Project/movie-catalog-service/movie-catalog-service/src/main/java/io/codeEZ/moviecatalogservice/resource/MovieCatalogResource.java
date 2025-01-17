package io.codeEZ.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.codeEZ.moviecatalogservice.models.CatalogItem;
import io.codeEZ.moviecatalogservice.models.Movie;
import io.codeEZ.moviecatalogservice.models.Rating;
import io.codeEZ.moviecatalogservice.models.UserRating;
import io.codeEZ.moviecatalogservice.service.MovieInfo;
import io.codeEZ.moviecatalogservice.service.UserRatingInfo;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating rating= userRatingInfo.getUserRating(userId);
		return rating.getUserRating().stream().map(rate -> movieInfo.getCatalogItems(rate)).collect(Collectors.toList());
				
	}
	
}

/*
 * Using Webclient call the micro services apps
 * Movie movie = webClientBuilder.build()
	.get()
	.uri("http://localhost:8082/movies/"+ rate.getMovieId())
	.retrieve()
	.bodyToMono(Movie.class)
	.block();*/
