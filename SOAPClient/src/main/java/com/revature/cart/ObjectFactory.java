
package com.revature.cart;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.revature.cart package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddItem_QNAME = new QName("http://cart.revature.com/", "addItem");
    private final static QName _AddItemResponse_QNAME = new QName("http://cart.revature.com/", "addItemResponse");
    private final static QName _ItemQuanitity_QNAME = new QName("http://cart.revature.com/", "itemQuanitity");
    private final static QName _ItemQuanitityResponse_QNAME = new QName("http://cart.revature.com/", "itemQuanitityResponse");
    private final static QName _RemoveItem_QNAME = new QName("http://cart.revature.com/", "removeItem");
    private final static QName _RemoveItemResponse_QNAME = new QName("http://cart.revature.com/", "removeItemResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.cart
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddItem }
     * 
     */
    public AddItem createAddItem() {
        return new AddItem();
    }

    /**
     * Create an instance of {@link AddItemResponse }
     * 
     */
    public AddItemResponse createAddItemResponse() {
        return new AddItemResponse();
    }

    /**
     * Create an instance of {@link ItemQuanitity }
     * 
     */
    public ItemQuanitity createItemQuanitity() {
        return new ItemQuanitity();
    }

    /**
     * Create an instance of {@link ItemQuanitityResponse }
     * 
     */
    public ItemQuanitityResponse createItemQuanitityResponse() {
        return new ItemQuanitityResponse();
    }

    /**
     * Create an instance of {@link RemoveItem }
     * 
     */
    public RemoveItem createRemoveItem() {
        return new RemoveItem();
    }

    /**
     * Create an instance of {@link RemoveItemResponse }
     * 
     */
    public RemoveItemResponse createRemoveItemResponse() {
        return new RemoveItemResponse();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItem }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddItem }{@code >}
     */
    @XmlElementDecl(namespace = "http://cart.revature.com/", name = "addItem")
    public JAXBElement<AddItem> createAddItem(AddItem value) {
        return new JAXBElement<AddItem>(_AddItem_QNAME, AddItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItemResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddItemResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cart.revature.com/", name = "addItemResponse")
    public JAXBElement<AddItemResponse> createAddItemResponse(AddItemResponse value) {
        return new JAXBElement<AddItemResponse>(_AddItemResponse_QNAME, AddItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemQuanitity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemQuanitity }{@code >}
     */
    @XmlElementDecl(namespace = "http://cart.revature.com/", name = "itemQuanitity")
    public JAXBElement<ItemQuanitity> createItemQuanitity(ItemQuanitity value) {
        return new JAXBElement<ItemQuanitity>(_ItemQuanitity_QNAME, ItemQuanitity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemQuanitityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemQuanitityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cart.revature.com/", name = "itemQuanitityResponse")
    public JAXBElement<ItemQuanitityResponse> createItemQuanitityResponse(ItemQuanitityResponse value) {
        return new JAXBElement<ItemQuanitityResponse>(_ItemQuanitityResponse_QNAME, ItemQuanitityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveItem }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveItem }{@code >}
     */
    @XmlElementDecl(namespace = "http://cart.revature.com/", name = "removeItem")
    public JAXBElement<RemoveItem> createRemoveItem(RemoveItem value) {
        return new JAXBElement<RemoveItem>(_RemoveItem_QNAME, RemoveItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveItemResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveItemResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cart.revature.com/", name = "removeItemResponse")
    public JAXBElement<RemoveItemResponse> createRemoveItemResponse(RemoveItemResponse value) {
        return new JAXBElement<RemoveItemResponse>(_RemoveItemResponse_QNAME, RemoveItemResponse.class, null, value);
    }

}
