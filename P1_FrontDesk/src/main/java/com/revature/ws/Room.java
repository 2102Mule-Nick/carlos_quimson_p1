
package com.revature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for room complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="room"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="roomNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="roomOccupied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="roomOutOfService" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="roomStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="roomType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "room", propOrder = {
    "roomNumber",
    "roomOccupied",
    "roomOutOfService",
    "roomStatus",
    "roomType"
})
public class Room {

    protected int roomNumber;
    protected boolean roomOccupied;
    protected boolean roomOutOfService;
    protected String roomStatus;
    protected String roomType;

    /**
     * Gets the value of the roomNumber property.
     * 
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the value of the roomNumber property.
     * 
     */
    public void setRoomNumber(int value) {
        this.roomNumber = value;
    }

    /**
     * Gets the value of the roomOccupied property.
     * 
     */
    public boolean isRoomOccupied() {
        return roomOccupied;
    }

    /**
     * Sets the value of the roomOccupied property.
     * 
     */
    public void setRoomOccupied(boolean value) {
        this.roomOccupied = value;
    }

    /**
     * Gets the value of the roomOutOfService property.
     * 
     */
    public boolean isRoomOutOfService() {
        return roomOutOfService;
    }

    /**
     * Sets the value of the roomOutOfService property.
     * 
     */
    public void setRoomOutOfService(boolean value) {
        this.roomOutOfService = value;
    }

    /**
     * Gets the value of the roomStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomStatus() {
        return roomStatus;
    }

    /**
     * Sets the value of the roomStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomStatus(String value) {
        this.roomStatus = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

}
