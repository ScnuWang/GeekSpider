package cn.geekview.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TDreamInProject {
    private Integer pkId;

	private Date updateDate;

	private String originalId;

	private String projectName;

	private String projectImage;

	private String projectUrl;

	private String projectDesc;

	private String projectStatus;

	private Integer statusValue;

	private Integer foreverStatus;

	private Date beginDate;

	private Date endDate;

	private Integer shareCount;

	private Integer supportPerson;

	private String moneyCurrency;

	private BigDecimal targetMoney;

	private BigDecimal currMoney;

	private BigDecimal currMoneyFund;

	private BigDecimal currMoneyForever;

	private BigDecimal currMoneyExternal;

	private Integer finishPer;

	private Integer remainDay;

	private String personName;

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public String getOriginalId()
	{
		return originalId;
	}

	public void setOriginalId(String originalId)
	{
		this.originalId = originalId == null ? null : originalId.trim();
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName == null ? null : projectName.trim();
	}

	public String getProjectImage()
	{
		return projectImage;
	}

	public void setProjectImage(String projectImage)
	{
		this.projectImage = projectImage == null ? null : projectImage.trim();
	}

	public String getProjectUrl()
	{
		return projectUrl;
	}

	public void setProjectUrl(String projectUrl)
	{
		this.projectUrl = projectUrl == null ? null : projectUrl.trim();
	}

	public String getProjectDesc()
	{
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc)
	{
		this.projectDesc = projectDesc == null ? null : projectDesc.trim();
	}

	public String getProjectStatus()
	{
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus)
	{
		this.projectStatus = projectStatus == null ? null : projectStatus.trim();
	}

	public Integer getStatusValue()
	{
		return statusValue;
	}

	public void setStatusValue(Integer statusValue)
	{
		this.statusValue = statusValue;
	}

	public Integer getForeverStatus()
	{
		return foreverStatus;
	}

	public void setForeverStatus(Integer foreverStatus)
	{
		this.foreverStatus = foreverStatus;
	}

	public Date getBeginDate()
	{
		return beginDate;
	}

	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Integer getShareCount()
	{
		return shareCount;
	}

	public void setShareCount(Integer shareCount)
	{
		this.shareCount = shareCount;
	}

	public Integer getSupportPerson()
	{
		return supportPerson;
	}

	public void setSupportPerson(Integer supportPerson)
	{
		this.supportPerson = supportPerson;
	}

	public String getMoneyCurrency()
	{
		return moneyCurrency;
	}

	public void setMoneyCurrency(String moneyCurrency)
	{
		this.moneyCurrency = moneyCurrency == null ? null : moneyCurrency.trim();
	}

	public BigDecimal getTargetMoney()
	{
		return targetMoney;
	}

	public void setTargetMoney(BigDecimal targetMoney)
	{
		this.targetMoney = targetMoney;
	}

	public BigDecimal getCurrMoney()
	{
		return currMoney;
	}

	public void setCurrMoney(BigDecimal currMoney)
	{
		this.currMoney = currMoney;
	}

	public BigDecimal getCurrMoneyFund()
	{
		return currMoneyFund;
	}

	public void setCurrMoneyFund(BigDecimal currMoneyFund)
	{
		this.currMoneyFund = currMoneyFund;
	}

	public BigDecimal getCurrMoneyForever()
	{
		return currMoneyForever;
	}

	public void setCurrMoneyForever(BigDecimal currMoneyForever)
	{
		this.currMoneyForever = currMoneyForever;
	}

	public BigDecimal getCurrMoneyExternal()
	{
		return currMoneyExternal;
	}

	public void setCurrMoneyExternal(BigDecimal currMoneyExternal)
	{
		this.currMoneyExternal = currMoneyExternal;
	}

	public Integer getFinishPer()
	{
		return finishPer;
	}

	public void setFinishPer(Integer finishPer)
	{
		this.finishPer = finishPer;
	}

	public Integer getRemainDay()
	{
		return remainDay;
	}

	public void setRemainDay(Integer remainDay)
	{
		this.remainDay = remainDay;
	}

	public String getPersonName()
	{
		return personName;
	}

	public void setPersonName(String personName)
	{
		this.personName = personName == null ? null : personName.trim();
	}

	@Override
	public String toString() {
		return "TDreamInProject{" +
				"pkId=" + pkId +
				", updateDate=" + updateDate +
				", originalId='" + originalId + '\'' +
				", projectName='" + projectName + '\'' +
				", projectImage='" + projectImage + '\'' +
				", projectUrl='" + projectUrl + '\'' +
				", projectDesc='" + projectDesc + '\'' +
				", projectStatus='" + projectStatus + '\'' +
				", statusValue=" + statusValue +
				", foreverStatus=" + foreverStatus +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", shareCount=" + shareCount +
				", supportPerson=" + supportPerson +
				", moneyCurrency='" + moneyCurrency + '\'' +
				", targetMoney=" + targetMoney +
				", currMoney=" + currMoney +
				", currMoneyFund=" + currMoneyFund +
				", currMoneyForever=" + currMoneyForever +
				", currMoneyExternal=" + currMoneyExternal +
				", finishPer=" + finishPer +
				", remainDay=" + remainDay +
				", personName='" + personName + '\'' +
				'}';
	}
}