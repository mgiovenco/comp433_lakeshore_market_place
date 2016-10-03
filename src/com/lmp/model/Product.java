/**
 * 
 */
package com.lmp.model;

/**
 * @author Hattan
 *
 */
public class Product {

	private int id;
	private int vendor_product_id;
	private String name;
	private String description;
	private boolean product_available;
	private int category_id;
	private int partner_id;
	private String picture;

	public int getId() {
		return id;
	}

	public int getVendor_product_id() {
		return vendor_product_id;
	}

	
	public String getName() {
		return name;
	}

	
	public String getDescription() {
		return description;
	}


	public boolean isProduct_available() {
		return product_available;
	}

	public int getCategory_id() {
		return category_id;
	}

	public int getPartner_id() {
		return partner_id;
	}

	
	public String getPicture() {
		return picture;
	}

	/**
	 * @param id
	 * @param vendor_product_id
	 * @param name
	 * @param description
	 * @param product_available
	 * @param category_id
	 * @param partner_id
	 * @param picture
	 */

	public Product(int id, int vendor_product_id, String name, String description, boolean product_available,
			int category_id, int partner_id, String picture) {
		super();
		this.id = id;
		this.vendor_product_id = vendor_product_id;
		this.name = name;
		this.description = description;
		this.product_available = product_available;
		this.category_id = category_id;
		this.partner_id = partner_id;
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + partner_id;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + (product_available ? 1231 : 1237);
		result = prime * result + vendor_product_id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (category_id != other.category_id) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (partner_id != other.partner_id) {
			return false;
		}
		if (picture == null) {
			if (other.picture != null) {
				return false;
			}
		} else if (!picture.equals(other.picture)) {
			return false;
		}
		if (product_available != other.product_available) {
			return false;
		}
		if (vendor_product_id != other.vendor_product_id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", vendor_product_id=" + vendor_product_id + ", name=" + name + ", description="
				+ description + ", product_available=" + product_available + ", category_id=" + category_id
				+ ", partner_id=" + partner_id + ", picture=" + picture + "]";

	}

}
