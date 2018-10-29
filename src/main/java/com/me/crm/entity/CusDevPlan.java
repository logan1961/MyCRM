package com.me.crm.entity;

import java.util.Date;

public class CusDevPlan {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.sale_chance_id
     *
     * @mbggenerated
     */
    private Integer saleChanceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.plan_item
     *
     * @mbggenerated
     */
    private String planItem;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.plan_date
     *
     * @mbggenerated
     */
    private Date planDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.exe_affect
     *
     * @mbggenerated
     */
    private String exeAffect;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cus_dev_plan.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cus_dev_plan
     *
     * @mbggenerated
     */
    public CusDevPlan(Integer id, Integer saleChanceId, String planItem, Date planDate, String exeAffect, Date createTime, Date updateTime) {
        this.id = id;
        this.saleChanceId = saleChanceId;
        this.planItem = planItem;
        this.planDate = planDate;
        this.exeAffect = exeAffect;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cus_dev_plan
     *
     * @mbggenerated
     */
    public CusDevPlan() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.id
     *
     * @return the value of cus_dev_plan.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.id
     *
     * @param id the value for cus_dev_plan.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.sale_chance_id
     *
     * @return the value of cus_dev_plan.sale_chance_id
     *
     * @mbggenerated
     */
    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.sale_chance_id
     *
     * @param saleChanceId the value for cus_dev_plan.sale_chance_id
     *
     * @mbggenerated
     */
    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.plan_item
     *
     * @return the value of cus_dev_plan.plan_item
     *
     * @mbggenerated
     */
    public String getPlanItem() {
        return planItem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.plan_item
     *
     * @param planItem the value for cus_dev_plan.plan_item
     *
     * @mbggenerated
     */
    public void setPlanItem(String planItem) {
        this.planItem = planItem == null ? null : planItem.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.plan_date
     *
     * @return the value of cus_dev_plan.plan_date
     *
     * @mbggenerated
     */
    public Date getPlanDate() {
        return planDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.plan_date
     *
     * @param planDate the value for cus_dev_plan.plan_date
     *
     * @mbggenerated
     */
    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.exe_affect
     *
     * @return the value of cus_dev_plan.exe_affect
     *
     * @mbggenerated
     */
    public String getExeAffect() {
        return exeAffect;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.exe_affect
     *
     * @param exeAffect the value for cus_dev_plan.exe_affect
     *
     * @mbggenerated
     */
    public void setExeAffect(String exeAffect) {
        this.exeAffect = exeAffect == null ? null : exeAffect.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.create_time
     *
     * @return the value of cus_dev_plan.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.create_time
     *
     * @param createTime the value for cus_dev_plan.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cus_dev_plan.update_time
     *
     * @return the value of cus_dev_plan.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cus_dev_plan.update_time
     *
     * @param updateTime the value for cus_dev_plan.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cus_dev_plan
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
        sb.append(", saleChanceId=").append(saleChanceId);
        sb.append(", planItem=").append(planItem);
        sb.append(", planDate=").append(planDate);
        sb.append(", exeAffect=").append(exeAffect);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}