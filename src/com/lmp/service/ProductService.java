/**
 * 
 */
package com.lmp.service;

import com.lmp.dao.ProductDao;
import com.lmp.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * This Service is to interact with product entities
 *
 */
public class ProductService {
	
	 private ProductDao productDao;

	    public ProductService(ProductDao productDao) {
	        this.productDao=productDao;
	    }

	    /**
	     * Get a product by id.
	     *
	     * @param id
	     * @return
	     * @throws SQLException
	     */
	    public Product getProduct(int id) throws SQLException {
	        return productDao.selectProduct(id);
	    }


	    /**
	     * List all the available products.
	     *
	     * @return
	     * @throws SQLException
	     */
	    public List<Product> selectAllProducts() throws SQLException {
	        return productDao.selectAllProducts();
	    }
	    
	    /**
	     * Add one product.
	     *
	     * @param product
	     * @throws Exception
	     */
	    public void createProduct(Product product) throws Exception {
	        productDao.createProduct(product);
	    }
	    
	    
	    /**
	     * Update a single product.
	     *
	     * @param product
	     */
	    public void updateProduct(Product product) {
	        productDao.updateProduct(product);
	    }
	    
	    public void updateProductAvilability(int id, boolean status) {
	    productDao.updateProductAvilability(id, status);
	    }
	    
	    /**
	     * Select all products belong to one category.
	     *
	     * @param product
	     */
	    public List<Product> selectProductsByCategoryId(int id) throws SQLException {
	    	return productDao.selectProductsByCategoryId(id);
	    	
	    }

}
