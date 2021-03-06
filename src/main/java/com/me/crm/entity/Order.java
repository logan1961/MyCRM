package com.me.crm.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.customer_id
     *
     * @mbggenerated
     */
    private Integer customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_no
     *
     * @mbggenerated
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.sale_chance_id
     *
     * @mbggenerated
     */
    private Integer saleChanceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_date
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date orderDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.create_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.update_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.product_id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated
     */
    public Order(Integer id, Integer customerId, String orderNo, Integer saleChanceId, Date orderDate, Integer status, Date createTime, Date updateTime, Integer productId) {
        this.id = id;
        this.customerId = customerId;
        this.orderNo = orderNo;
        this.saleChanceId = saleChanceId;
        this.orderDate = orderDate;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated
     */
    public Order() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.id
     *
     * @return the value of order.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.id
     *
     * @param id the value for order.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.customer_id
     *
     * @return the value of order.customer_id
     *
     * @mbggenerated
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.customer_id
     *
     * @param customerId the value for order.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_no
     *
     * @return the value of order.order_no
     *
     * @mbggenerated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_no
     *
     * @param orderNo the value for order.order_no
     *
     * @mbggenerated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.sale_chance_id
     *
     * @return the value of order.sale_chance_id
     *
     * @mbggenerated
     */
    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.sale_chance_id
     *
     * @param saleChanceId the value for order.sale_chance_id
     *
     * @mbggenerated
     */
    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_date
     *
     * @return the value of order.order_date
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss" , timezone = "GMT+08")
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_date
     *
     * @param orderDate the value for order.order_date
     *
     * @mbggenerated
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.status
     *
     * @return the value of order.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.status
     *
     * @param status the value for order.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.create_time
     *
     * @return the value of order.create_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss" , timezone = "GMT+08")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.create_time
     *
     * @param createTime the value for order.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.update_time
     *
     * @return the value of order.update_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss" , timezone = "GMT+08")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.update_time
     *
     * @param updateTime the value for order.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.product_id
     *
     * @return the value of order.product_id
     *
     * @mbggenerated
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.product_id
     *
     * @param productId the value for order.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", saleChanceId=").append(saleChanceId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", productId=").append(productId);
        sb.append("]");
        return sb.toString();
    }
}