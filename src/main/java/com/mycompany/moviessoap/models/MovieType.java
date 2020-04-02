
package com.mycompany.moviessoap.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovieType", propOrder = {
    "idContent",
    "idCollection",
    "title",
    "plot",
    "released",
    "contentRating"
})
public class MovieType {

    @XmlElement(name = "IdContent")
    protected int idContent;
    @XmlElement(name = "IDCollection")
    protected int idCollection;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Plot", required = true)
    protected String plot;
    @XmlElement(name = "Released", required = true)
    protected String released;
    @XmlElement(name = "ContentRating")
    protected double contentRating;

    /**
     * Gets the value of the idContent property.
     * 
     */
    public int getIdContent() {
        return idContent;
    }

    /**
     * Sets the value of the idContent property.
     * 
     */
    public void setIdContent(int value) {
        this.idContent = value;
    }

    /**
     * Gets the value of the idCollection property.
     * 
     */
    public int getIDCollection() {
        return idCollection;
    }

    /**
     * Sets the value of the idCollection property.
     * 
     */
    public void setIDCollection(int value) {
        this.idCollection = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the plot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlot() {
        return plot;
    }

    /**
     * Sets the value of the plot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlot(String value) {
        this.plot = value;
    }

    /**
     * Gets the value of the released property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleased() {
        return released;
    }

    /**
     * Sets the value of the released property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleased(String value) {
        this.released = value;
    }

    /**
     * Gets the value of the contentRating property.
     * 
     */
    public double getContentRating() {
        return contentRating;
    }

    /**
     * Sets the value of the contentRating property.
     * 
     */
    public void setContentRating(double value) {
        this.contentRating = value;
    }

}
