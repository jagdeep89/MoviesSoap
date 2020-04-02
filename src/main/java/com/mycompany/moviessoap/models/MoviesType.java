
package com.mycompany.moviessoap.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoviesType", propOrder = {
    "movie"
})
public class MoviesType {

    @XmlElement(name = "Movie", required = true)
    protected List<MovieType> movie;

    
    public List<MovieType> getMovie() {
        if (movie == null) {
            movie = new ArrayList<MovieType>();
        }
        return this.movie;
    }

}
