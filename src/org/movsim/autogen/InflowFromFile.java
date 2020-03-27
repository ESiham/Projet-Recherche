//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="filename" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="column_time" use="required" type="{}positiveInteger" />
 *       &lt;attribute name="column_vehicle_type" use="required" type="{}positiveInteger" />
 *       &lt;attribute name="column_route_or_destination" type="{}positiveInteger" />
 *       &lt;attribute name="format_time" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="column_speed" type="{}positiveInteger" />
 *       &lt;attribute name="format_speed" type="{}positiveDouble" default="1" />
 *       &lt;attribute name="column_length" type="{}positiveInteger" />
 *       &lt;attribute name="column_weight" type="{}positiveInteger" />
 *       &lt;attribute name="column_lane" type="{}positiveInteger" />
 *       &lt;attribute name="column_comment" type="{}positiveInteger" />
 *       &lt;attribute name="column_separator" type="{http://www.w3.org/2001/XMLSchema}string" default=";" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "InflowFromFile")
public class InflowFromFile
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "filename", required = true)
    protected String filename;
    @XmlAttribute(name = "column_time", required = true)
    protected int columnTime;
    @XmlAttribute(name = "column_vehicle_type", required = true)
    protected int columnVehicleType;
    @XmlAttribute(name = "column_route_or_destination")
    protected Integer columnRouteOrDestination;
    @XmlAttribute(name = "format_time")
    protected String formatTime;
    @XmlAttribute(name = "column_speed")
    protected Integer columnSpeed;
    @XmlAttribute(name = "format_speed")
    protected Double formatSpeed;
    @XmlAttribute(name = "column_length")
    protected Integer columnLength;
    @XmlAttribute(name = "column_weight")
    protected Integer columnWeight;
    @XmlAttribute(name = "column_lane")
    protected Integer columnLane;
    @XmlAttribute(name = "column_comment")
    protected Integer columnComment;
    @XmlAttribute(name = "column_separator")
    protected String columnSeparator;

    /**
     * Obtient la valeur de la propriété filename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Définit la valeur de la propriété filename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    public boolean isSetFilename() {
        return (this.filename!= null);
    }

    /**
     * Obtient la valeur de la propriété columnTime.
     * 
     */
    public int getColumnTime() {
        return columnTime;
    }

    /**
     * Définit la valeur de la propriété columnTime.
     * 
     */
    public void setColumnTime(int value) {
        this.columnTime = value;
    }

    public boolean isSetColumnTime() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété columnVehicleType.
     * 
     */
    public int getColumnVehicleType() {
        return columnVehicleType;
    }

    /**
     * Définit la valeur de la propriété columnVehicleType.
     * 
     */
    public void setColumnVehicleType(int value) {
        this.columnVehicleType = value;
    }

    public boolean isSetColumnVehicleType() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété columnRouteOrDestination.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColumnRouteOrDestination() {
        return columnRouteOrDestination;
    }

    /**
     * Définit la valeur de la propriété columnRouteOrDestination.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnRouteOrDestination(int value) {
        this.columnRouteOrDestination = value;
    }

    public boolean isSetColumnRouteOrDestination() {
        return (this.columnRouteOrDestination!= null);
    }

    public void unsetColumnRouteOrDestination() {
        this.columnRouteOrDestination = null;
    }

    /**
     * Obtient la valeur de la propriété formatTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatTime() {
        if (formatTime == null) {
            return "";
        } else {
            return formatTime;
        }
    }

    /**
     * Définit la valeur de la propriété formatTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatTime(String value) {
        this.formatTime = value;
    }

    public boolean isSetFormatTime() {
        return (this.formatTime!= null);
    }

    /**
     * Obtient la valeur de la propriété columnSpeed.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColumnSpeed() {
        return columnSpeed;
    }

    /**
     * Définit la valeur de la propriété columnSpeed.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnSpeed(int value) {
        this.columnSpeed = value;
    }

    public boolean isSetColumnSpeed() {
        return (this.columnSpeed!= null);
    }

    public void unsetColumnSpeed() {
        this.columnSpeed = null;
    }

    /**
     * Obtient la valeur de la propriété formatSpeed.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getFormatSpeed() {
        if (formatSpeed == null) {
            return  1.0D;
        } else {
            return formatSpeed;
        }
    }

    /**
     * Définit la valeur de la propriété formatSpeed.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFormatSpeed(double value) {
        this.formatSpeed = value;
    }

    public boolean isSetFormatSpeed() {
        return (this.formatSpeed!= null);
    }

    public void unsetFormatSpeed() {
        this.formatSpeed = null;
    }

    /**
     * Obtient la valeur de la propriété columnLength.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColumnLength() {
        return columnLength;
    }

    /**
     * Définit la valeur de la propriété columnLength.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnLength(int value) {
        this.columnLength = value;
    }

    public boolean isSetColumnLength() {
        return (this.columnLength!= null);
    }

    public void unsetColumnLength() {
        this.columnLength = null;
    }

    /**
     * Obtient la valeur de la propriété columnWeight.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColumnWeight() {
        return columnWeight;
    }

    /**
     * Définit la valeur de la propriété columnWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnWeight(int value) {
        this.columnWeight = value;
    }

    public boolean isSetColumnWeight() {
        return (this.columnWeight!= null);
    }

    public void unsetColumnWeight() {
        this.columnWeight = null;
    }

    /**
     * Obtient la valeur de la propriété columnLane.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColumnLane() {
        return columnLane;
    }

    /**
     * Définit la valeur de la propriété columnLane.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnLane(int value) {
        this.columnLane = value;
    }

    public boolean isSetColumnLane() {
        return (this.columnLane!= null);
    }

    public void unsetColumnLane() {
        this.columnLane = null;
    }

    /**
     * Obtient la valeur de la propriété columnComment.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getColumnComment() {
        return columnComment;
    }

    /**
     * Définit la valeur de la propriété columnComment.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnComment(int value) {
        this.columnComment = value;
    }

    public boolean isSetColumnComment() {
        return (this.columnComment!= null);
    }

    public void unsetColumnComment() {
        this.columnComment = null;
    }

    /**
     * Obtient la valeur de la propriété columnSeparator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnSeparator() {
        if (columnSeparator == null) {
            return ";";
        } else {
            return columnSeparator;
        }
    }

    /**
     * Définit la valeur de la propriété columnSeparator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnSeparator(String value) {
        this.columnSeparator = value;
    }

    public boolean isSetColumnSeparator() {
        return (this.columnSeparator!= null);
    }

}
