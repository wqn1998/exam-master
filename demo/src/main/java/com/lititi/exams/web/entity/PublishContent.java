package com.lititi.exams.web.entity;

import com.fawkes.core.base.model.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PublishContent extends BaseEntity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.create_by
     *
     * @mbggenerated
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.create_date
     *
     * @mbggenerated
     */
    private Timestamp createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.update_by
     *
     * @mbggenerated
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.update_date
     *
     * @mbggenerated
     */
    private Timestamp updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.delete_flag
     *
     * @mbggenerated
     */
    private Integer deleteFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.classify
     *
     * @mbggenerated
     */
    private String classify;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.publish_date
     *
     * @mbggenerated
     */
    private Timestamp publishDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.publish_delay_date
     *
     * @mbggenerated
     */
    private Timestamp publishDelayDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.effective_date
     *
     * @mbggenerated
     */
    private Timestamp effectiveDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.share_flag
     *
     * @mbggenerated
     */
    private Integer shareFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.image_url
     *
     * @mbggenerated
     */
    private String imageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.content_code
     *
     * @mbggenerated
     */
    private String contentCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish_content.publish_flag
     *
     * @mbggenerated
     */
    private Integer publishFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table publish_content
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.id
     *
     * @return the value of publish_content.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.id
     *
     * @param id the value for publish_content.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.create_by
     *
     * @return the value of publish_content.create_by
     *
     * @mbggenerated
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.create_by
     *
     * @param createBy the value for publish_content.create_by
     *
     * @mbggenerated
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.create_date
     *
     * @return the value of publish_content.create_date
     *
     * @mbggenerated
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.create_date
     *
     * @param createDate the value for publish_content.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.update_by
     *
     * @return the value of publish_content.update_by
     *
     * @mbggenerated
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.update_by
     *
     * @param updateBy the value for publish_content.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.update_date
     *
     * @return the value of publish_content.update_date
     *
     * @mbggenerated
     */
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.update_date
     *
     * @param updateDate the value for publish_content.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.delete_flag
     *
     * @return the value of publish_content.delete_flag
     *
     * @mbggenerated
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.delete_flag
     *
     * @param deleteFlag the value for publish_content.delete_flag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.title
     *
     * @return the value of publish_content.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.title
     *
     * @param title the value for publish_content.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.classify
     *
     * @return the value of publish_content.classify
     *
     * @mbggenerated
     */
    public String getClassify() {
        return classify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.classify
     *
     * @param classify the value for publish_content.classify
     *
     * @mbggenerated
     */
    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.publish_date
     *
     * @return the value of publish_content.publish_date
     *
     * @mbggenerated
     */
    public Timestamp getPublishDate() {
        return publishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.publish_date
     *
     * @param publishDate the value for publish_content.publish_date
     *
     * @mbggenerated
     */
    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.publish_delay_date
     *
     * @return the value of publish_content.publish_delay_date
     *
     * @mbggenerated
     */
    public Timestamp getPublishDelayDate() {
        return publishDelayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.publish_delay_date
     *
     * @param publishDelayDate the value for publish_content.publish_delay_date
     *
     * @mbggenerated
     */
    public void setPublishDelayDate(Timestamp publishDelayDate) {
        this.publishDelayDate = publishDelayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.effective_date
     *
     * @return the value of publish_content.effective_date
     *
     * @mbggenerated
     */
    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.effective_date
     *
     * @param effectiveDate the value for publish_content.effective_date
     *
     * @mbggenerated
     */
    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.share_flag
     *
     * @return the value of publish_content.share_flag
     *
     * @mbggenerated
     */
    public Integer getShareFlag() {
        return shareFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.share_flag
     *
     * @param shareFlag the value for publish_content.share_flag
     *
     * @mbggenerated
     */
    public void setShareFlag(Integer shareFlag) {
        this.shareFlag = shareFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.content
     *
     * @return the value of publish_content.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.content
     *
     * @param content the value for publish_content.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.image_url
     *
     * @return the value of publish_content.image_url
     *
     * @mbggenerated
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.image_url
     *
     * @param imageUrl the value for publish_content.image_url
     *
     * @mbggenerated
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.content_code
     *
     * @return the value of publish_content.content_code
     *
     * @mbggenerated
     */
    public String getContentCode() {
        return contentCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.content_code
     *
     * @param contentCode the value for publish_content.content_code
     *
     * @mbggenerated
     */
    public void setContentCode(String contentCode) {
        this.contentCode = contentCode == null ? null : contentCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish_content.publish_flag
     *
     * @return the value of publish_content.publish_flag
     *
     * @mbggenerated
     */
    public Integer getPublishFlag() {
        return publishFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish_content.publish_flag
     *
     * @param publishFlag the value for publish_content.publish_flag
     *
     * @mbggenerated
     */
    public void setPublishFlag(Integer publishFlag) {
        this.publishFlag = publishFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table publish_content
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PublishContent other = (PublishContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getClassify() == null ? other.getClassify() == null : this.getClassify().equals(other.getClassify()))
            && (this.getPublishDate() == null ? other.getPublishDate() == null : this.getPublishDate().equals(other.getPublishDate()))
            && (this.getPublishDelayDate() == null ? other.getPublishDelayDate() == null : this.getPublishDelayDate().equals(other.getPublishDelayDate()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getShareFlag() == null ? other.getShareFlag() == null : this.getShareFlag().equals(other.getShareFlag()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getContentCode() == null ? other.getContentCode() == null : this.getContentCode().equals(other.getContentCode()))
            && (this.getPublishFlag() == null ? other.getPublishFlag() == null : this.getPublishFlag().equals(other.getPublishFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table publish_content
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getClassify() == null) ? 0 : getClassify().hashCode());
        result = prime * result + ((getPublishDate() == null) ? 0 : getPublishDate().hashCode());
        result = prime * result + ((getPublishDelayDate() == null) ? 0 : getPublishDelayDate().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getShareFlag() == null) ? 0 : getShareFlag().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getContentCode() == null) ? 0 : getContentCode().hashCode());
        result = prime * result + ((getPublishFlag() == null) ? 0 : getPublishFlag().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table publish_content
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
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", title=").append(title);
        sb.append(", classify=").append(classify);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", publishDelayDate=").append(publishDelayDate);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", shareFlag=").append(shareFlag);
        sb.append(", content=").append(content);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", contentCode=").append(contentCode);
        sb.append(", publishFlag=").append(publishFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}