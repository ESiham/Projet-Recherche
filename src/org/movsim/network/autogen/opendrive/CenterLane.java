//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.network.autogen.opendrive;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour centerLane complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="centerLane">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="link" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="predecessor" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="successor" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="userData" type="{}userData" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="include" type="{}include" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="userData" type="{}userData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="include" type="{}include" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "centerLane", propOrder = {
    "link",
    "userData",
    "include"
})
public class CenterLane
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected CenterLane.Link link;
    protected List<UserData> userData;
    protected List<Include> include;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "level")
    protected String level;

    /**
     * Obtient la valeur de la propriété link.
     * 
     * @return
     *     possible object is
     *     {@link CenterLane.Link }
     *     
     */
    public CenterLane.Link getLink() {
        return link;
    }

    /**
     * Définit la valeur de la propriété link.
     * 
     * @param value
     *     allowed object is
     *     {@link CenterLane.Link }
     *     
     */
    public void setLink(CenterLane.Link value) {
        this.link = value;
    }

    public boolean isSetLink() {
        return (this.link!= null);
    }

    /**
     * Gets the value of the userData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserData }
     * 
     * 
     */
    public List<UserData> getUserData() {
        if (userData == null) {
            userData = new ArrayList<UserData>();
        }
        return this.userData;
    }

    public boolean isSetUserData() {
        return ((this.userData!= null)&&(!this.userData.isEmpty()));
    }

    public void unsetUserData() {
        this.userData = null;
    }

    /**
     * Gets the value of the include property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the include property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInclude().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Include }
     * 
     * 
     */
    public List<Include> getInclude() {
        if (include == null) {
            include = new ArrayList<Include>();
        }
        return this.include;
    }

    public boolean isSetInclude() {
        return ((this.include!= null)&&(!this.include.isEmpty()));
    }

    public void unsetInclude() {
        this.include = null;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(int value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

    public void unsetId() {
        this.id = null;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Obtient la valeur de la propriété level.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevel() {
        return level;
    }

    /**
     * Définit la valeur de la propriété level.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevel(String value) {
        this.level = value;
    }

    public boolean isSetLevel() {
        return (this.level!= null);
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="predecessor" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="successor" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="userData" type="{}userData" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="include" type="{}include" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "predecessor",
        "successor",
        "userData",
        "include"
    })
    public static class Link
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        protected CenterLane.Link.Predecessor predecessor;
        protected CenterLane.Link.Successor successor;
        protected List<UserData> userData;
        protected List<Include> include;

        /**
         * Obtient la valeur de la propriété predecessor.
         * 
         * @return
         *     possible object is
         *     {@link CenterLane.Link.Predecessor }
         *     
         */
        public CenterLane.Link.Predecessor getPredecessor() {
            return predecessor;
        }

        /**
         * Définit la valeur de la propriété predecessor.
         * 
         * @param value
         *     allowed object is
         *     {@link CenterLane.Link.Predecessor }
         *     
         */
        public void setPredecessor(CenterLane.Link.Predecessor value) {
            this.predecessor = value;
        }

        public boolean isSetPredecessor() {
            return (this.predecessor!= null);
        }

        /**
         * Obtient la valeur de la propriété successor.
         * 
         * @return
         *     possible object is
         *     {@link CenterLane.Link.Successor }
         *     
         */
        public CenterLane.Link.Successor getSuccessor() {
            return successor;
        }

        /**
         * Définit la valeur de la propriété successor.
         * 
         * @param value
         *     allowed object is
         *     {@link CenterLane.Link.Successor }
         *     
         */
        public void setSuccessor(CenterLane.Link.Successor value) {
            this.successor = value;
        }

        public boolean isSetSuccessor() {
            return (this.successor!= null);
        }

        /**
         * Gets the value of the userData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the userData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUserData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UserData }
         * 
         * 
         */
        public List<UserData> getUserData() {
            if (userData == null) {
                userData = new ArrayList<UserData>();
            }
            return this.userData;
        }

        public boolean isSetUserData() {
            return ((this.userData!= null)&&(!this.userData.isEmpty()));
        }

        public void unsetUserData() {
            this.userData = null;
        }

        /**
         * Gets the value of the include property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the include property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInclude().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Include }
         * 
         * 
         */
        public List<Include> getInclude() {
            if (include == null) {
                include = new ArrayList<Include>();
            }
            return this.include;
        }

        public boolean isSetInclude() {
            return ((this.include!= null)&&(!this.include.isEmpty()));
        }

        public void unsetInclude() {
            this.include = null;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Predecessor
            implements Serializable
        {

            private final static long serialVersionUID = 1L;
            @XmlAttribute(name = "id")
            protected Integer id;

            /**
             * Obtient la valeur de la propriété id.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public int getId() {
                return id;
            }

            /**
             * Définit la valeur de la propriété id.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setId(int value) {
                this.id = value;
            }

            public boolean isSetId() {
                return (this.id!= null);
            }

            public void unsetId() {
                this.id = null;
            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Successor
            implements Serializable
        {

            private final static long serialVersionUID = 1L;
            @XmlAttribute(name = "id")
            protected Integer id;

            /**
             * Obtient la valeur de la propriété id.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public int getId() {
                return id;
            }

            /**
             * Définit la valeur de la propriété id.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setId(int value) {
                this.id = value;
            }

            public boolean isSetId() {
                return (this.id!= null);
            }

            public void unsetId() {
                this.id = null;
            }

        }

    }

}
