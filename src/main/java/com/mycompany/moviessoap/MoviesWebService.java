/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviessoap;

import com.mycompany.moviessoap.models.MovieType;
import com.mycompany.moviessoap.models.MoviesType;
import com.mycompany.moviessoap.resources.MovieDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author forev
 */
@WebService
public class MoviesWebService{
MovieDAO moviedao;
 

@WebMethod
@WebResult(name="ResponseMessage")
public String addMovie(@WebParam(name="Movie") MovieType addRequest) {
 
return new MovieDAO().addMovie(addRequest);
 
}
 

@WebMethod
@WebResult(name="ResponseMessage")
public String deleteMovie(@WebParam(name="MovieID") int idContent) {
 
return new MovieDAO().deleteMovie(idContent);
}
 

@WebMethod
@WebResult(name="ResponseMessage")
public String updateMovie(MovieType updateMovieRequest) {
 
return new MovieDAO().updateMovie(updateMovieRequest);
}
 

@WebMethod
@WebResult(name="Movie")
public MovieType getMovie(@WebParam(name="MovieName") int idContent) {
 
return new MovieDAO().getMovie(idContent);
}
 

@WebMethod
@WebResult(name="Movies")
public MoviesType getAllMovies() {
return new MovieDAO().getAllMovies();
}
 
}
