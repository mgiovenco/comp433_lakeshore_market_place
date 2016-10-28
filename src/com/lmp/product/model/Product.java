package com.lmp.product.model;

/**
 * @author Hattan
 */
public class Product {

    private int id;
    private String vendor_product_id;
    private String name;
    private String description;
    private boolean product_available;
    private int category_id;
    private int partner_id;
    private String picture;

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
    public Product(int id, String vendor_product_id, String name, String description, boolean product_available, int category_id,
                   int partner_id, String picture) {
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

    public int getId() {
        return id;
    }

    public String getVendor_product_id() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (isProduct_available() != product.isProduct_available()) return false;
        if (getCategory_id() != product.getCategory_id()) return false;
        if (getPartner_id() != product.getPartner_id()) return false;
        if (getVendor_product_id() != null ? !getVendor_product_id().equals(product.getVendor_product_id()) : product.getVendor_product_id() != null)
            return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        return getPicture() != null ? getPicture().equals(product.getPicture()) : product.getPicture() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getVendor_product_id() != null ? getVendor_product_id().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (isProduct_available() ? 1 : 0);
        result = 31 * result + getCategory_id();
        result = 31 * result + getPartner_id();
        result = 31 * result + (getPicture() != null ? getPicture().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", vendor_product_id='" + vendor_product_id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", product_available=" + product_available +
                ", category_id=" + category_id +
                ", partner_id=" + partner_id +
                ", picture='" + picture + '\'' +
                '}';
    }
}
