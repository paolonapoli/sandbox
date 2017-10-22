/*
 * File Document.java of project sandbox-s5-model.
 * File created on 21 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.nosql.documents;

import javax.persistence.Id;

import org.springframework.util.Base64Utils;

/**
 * Class Document.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public class Document {

    @Id
    public String id;

    public String name;
    public String description;
    public String mimeType;
    public String content;

    /**
     * Constructor for the class.
     *
     */
    public Document() {
	// Bean
    }

    /**
     * Constructor for the class.
     *
     * @param id
     * @param name
     * @param description
     * @param mimeType
     * @param content
     */
    public Document(String name, String description, String mimeType, byte[] content) {
	this.name = name;
	this.description = description;
	this.mimeType = mimeType;

	if ((content != null) && (content.length > 0)) {
	    this.content = Base64Utils.encodeToString(content);
	}
    }

    /**
     * Constructor for the class.
     *
     * @param id
     * @param name
     * @param description
     * @param mimeType
     * @param contentString
     */
    public Document(String name, String description, String mimeType, String contentString) {
	this.name = name;
	this.description = description;
	this.mimeType = mimeType;
	this.content = contentString;
    }

    /**
     * Getter for the field id:String.
     *
     * @return the id
     */
    public String getId() {
	return this.id;
    }

    /**
     * Setter for the field id.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * Getter for the field name:String.
     *
     * @return the name
     */
    public String getName() {
	return this.name;
    }

    /**
     * Setter for the field name.
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Getter for the field description:String.
     *
     * @return the description
     */
    public String getDescription() {
	return this.description;
    }

    /**
     * Setter for the field description.
     *
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Getter for the field mimeType:String.
     *
     * @return the mimeType
     */
    public String getMimeType() {
	return this.mimeType;
    }

    /**
     * Setter for the field mimeType.
     *
     * @param mimeType
     *            the mimeType to set
     */
    public void setMimeType(String mimeType) {
	this.mimeType = mimeType;
    }

    /**
     * Method getContentByte returns byte[].
     *
     * @return
     */
    public byte[] getContentByte() {
	return Base64Utils.decodeFromString(this.content);
    }

    /**
     * Method getContent returns String.
     *
     * @return
     */
    public String getContent() {
	return this.content;
    }

    /**
     * Setter for the field content.
     *
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
	this.content = content;
    }

    /**
     * Method setContentByte returns void.
     *
     * @param content
     */
    public void setContentByte(byte[] content) {
	this.content = Base64Utils.encodeToString(content);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Document [id=");
	builder.append(this.id);
	builder.append(", name=");
	builder.append(this.name);
	builder.append(", description=");
	builder.append(this.description);
	builder.append(", mimeType=");
	builder.append(this.mimeType);
	builder.append(", content=");
	builder.append(this.content);
	try {
	    String decoded = new String(Base64Utils.decodeFromString((this.content)));
	    builder.append(", content(dec)=");
	    builder.append(decoded);
	} catch (Exception e) {
	    /* not base 64: ignore */
	}
	builder.append("]");
	return builder.toString();
    }
}
