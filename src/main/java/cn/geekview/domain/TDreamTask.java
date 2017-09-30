package cn.geekview.domain;

import java.util.Date;

public class TDreamTask {
    private Integer pkId;

	private Integer serverId;

	private Integer websiteCode;

	private Integer productEnabled;

	private Integer taskCode;

	private Integer taskStatus;

	private String originalId;

	private String productUrl;

	private String categoryName;

	private String taskRemark;

	private Date updateDate;

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
	}

	public Integer getServerId()
	{
		return serverId;
	}

	public void setServerId(Integer serverId)
	{
		this.serverId = serverId;
	}

	public Integer getWebsiteCode()
	{
		return websiteCode;
	}

	public void setWebsiteCode(Integer websiteCode)
	{
		this.websiteCode = websiteCode;
	}

	public Integer getProductEnabled()
	{
		return productEnabled;
	}

	public void setProductEnabled(Integer productEnabled)
	{
		this.productEnabled = productEnabled;
	}

	public Integer getTaskCode()
	{
		return taskCode;
	}

	public void setTaskCode(Integer taskCode)
	{
		this.taskCode = taskCode;
	}

	public Integer getTaskStatus()
	{
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus)
	{
		this.taskStatus = taskStatus;
	}

	public String getOriginalId()
	{
		return originalId;
	}

	public void setOriginalId(String originalId)
	{
		this.originalId = originalId == null ? null : originalId.trim();
	}

	public String getProductUrl()
	{
		return productUrl;
	}

	public void setProductUrl(String productUrl)
	{
		this.productUrl = productUrl == null ? null : productUrl.trim();
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public String getTaskRemark()
	{
		return taskRemark;
	}

	public void setTaskRemark(String taskRemark)
	{
		this.taskRemark = taskRemark == null ? null : taskRemark.trim();
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}
}