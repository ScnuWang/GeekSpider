package cn.geekview.domain;

import java.util.Date;
import java.math.BigDecimal;

public class TDreamProduct {
    private Integer pkId;

	private Integer website;

	private String originalId;

	private String productName;

	private String productDesc;

	private String productUrl;

	private String productImage;

	private String productVideo;

	private String productQrcode;

	private Date productBegin;

	private Date productEnd;

	private Integer foreverStatus;

	private Integer productEnabled;

	private String productStatus;

	private Integer statusValue;

	private String personName;

	private String personImage;

	private String personDesc;

	private Date createDate;

	private Integer currencyId;

	private BigDecimal averageMoney;

	private BigDecimal targetMoneyOrg;

	private BigDecimal targetMoney;

	private BigDecimal currMoneyOrg;

	private BigDecimal currMoney;

	private BigDecimal itemCorePriceOrg;

	private BigDecimal itemCorePrice;

	private Integer supportPerson;

	private Integer shareCount;

	private Integer focusCount;

	private Integer likeCount;

	private Integer finishPer;

	private Integer gvIndex;

	private Date updateDate;

	private String updateUser;

	private Integer remainDay;

	private String productImageUs;

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
	}

	public Integer getWebsite()
	{
		return website;
	}

	public void setWebsite(Integer website)
	{
		this.website = website;
	}

	public String getOriginalId()
	{
		return originalId;
	}

	public void setOriginalId(String originalId)
	{
		this.originalId = originalId == null ? null : originalId.trim();
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName == null ? null : productName.trim();
	}

	public String getProductDesc()
	{
		return productDesc;
	}

	public void setProductDesc(String productDesc)
	{
		this.productDesc = productDesc == null ? null : productDesc.trim();
	}

	public String getProductUrl()
	{
		return productUrl;
	}

	public void setProductUrl(String productUrl)
	{
		this.productUrl = productUrl == null ? null : productUrl.trim();
	}

	public String getProductImage()
	{
		return productImage;
	}

	public void setProductImage(String productImage)
	{
		this.productImage = productImage == null ? null : productImage.trim();
	}

	public String getProductVideo()
	{
		return productVideo;
	}

	public void setProductVideo(String productVideo)
	{
		this.productVideo = productVideo == null ? null : productVideo.trim();
	}

	public String getProductQrcode()
	{
		return productQrcode;
	}

	public void setProductQrcode(String productQrcode)
	{
		this.productQrcode = productQrcode == null ? null : productQrcode.trim();
	}

	public Date getProductBegin()
	{
		return productBegin;
	}

	public void setProductBegin(Date productBegin)
	{
		this.productBegin = productBegin;
	}

	public Date getProductEnd()
	{
		return productEnd;
	}

	public void setProductEnd(Date productEnd)
	{
		this.productEnd = productEnd;
	}

	public Integer getForeverStatus()
	{
		return foreverStatus;
	}
	
	public void setForeverStatus(Integer foreverStatus)
	{
		this.foreverStatus = foreverStatus;
	}

	public Integer getProductEnabled()
	{
		return productEnabled;
	}

	public void setProductEnabled(Integer productEnabled)
	{
		this.productEnabled = productEnabled;
	}

	public String getProductStatus()
	{
		return productStatus;
	}

	public void setProductStatus(String productStatus)
	{
		this.productStatus = productStatus == null ? null : productStatus.trim();
	}

	public Integer getStatusValue()
	{
		return statusValue;
	}

	public void setStatusValue(Integer statusValue)
	{
		this.statusValue = statusValue;
	}

	public String getPersonName()
	{
		return personName;
	}

	public void setPersonName(String personName)
	{
		this.personName = personName == null ? null : personName.trim();
	}

	public String getPersonImage()
	{
		return personImage;
	}

	public void setPersonImage(String personImage)
	{
		this.personImage = personImage == null ? null : personImage.trim();
	}

	public String getPersonDesc()
	{
		return personDesc;
	}

	public void setPersonDesc(String personDesc)
	{
		this.personDesc = personDesc == null ? null : personDesc.trim();
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Integer getCurrencyId()
	{
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId)
	{
		this.currencyId = currencyId;
	}

	public BigDecimal getAverageMoney()
	{
		return averageMoney;
	}

	public void setAverageMoney(BigDecimal averageMoney)
	{
		this.averageMoney = averageMoney;
	}

	public BigDecimal getTargetMoneyOrg()
	{
		return targetMoneyOrg;
	}

	public void setTargetMoneyOrg(BigDecimal targetMoneyOrg)
	{
		this.targetMoneyOrg = targetMoneyOrg;
	}

	public BigDecimal getTargetMoney()
	{
		return targetMoney;
	}

	public void setTargetMoney(BigDecimal targetMoney)
	{
		this.targetMoney = targetMoney;
	}

	public BigDecimal getCurrMoneyOrg()
	{
		return currMoneyOrg;
	}

	public void setCurrMoneyOrg(BigDecimal currMoneyOrg)
	{
		this.currMoneyOrg = currMoneyOrg;
	}

	public BigDecimal getCurrMoney()
	{
		return currMoney;
	}

	public void setCurrMoney(BigDecimal currMoney)
	{
		this.currMoney = currMoney;
	}

	public BigDecimal getItemCorePriceOrg()
	{
		return itemCorePriceOrg;
	}

	public void setItemCorePriceOrg(BigDecimal itemCorePriceOrg)
	{
		this.itemCorePriceOrg = itemCorePriceOrg;
	}

	public BigDecimal getItemCorePrice()
	{
		return itemCorePrice;
	}

	public void setItemCorePrice(BigDecimal itemCorePrice)
	{
		this.itemCorePrice = itemCorePrice;
	}

	public Integer getSupportPerson()
	{
		return supportPerson;
	}

	public void setSupportPerson(Integer supportPerson)
	{
		this.supportPerson = supportPerson;
	}

	public Integer getShareCount()
	{
		return shareCount;
	}

	public void setShareCount(Integer shareCount)
	{
		this.shareCount = shareCount;
	}

	public Integer getFocusCount()
	{
		return focusCount;
	}

	public void setFocusCount(Integer focusCount)
	{
		this.focusCount = focusCount;
	}

	public Integer getLikeCount()
	{
		return likeCount;
	}

	public void setLikeCount(Integer likeCount)
	{
		this.likeCount = likeCount;
	}

	public Integer getFinishPer()
	{
		return finishPer;
	}

	public void setFinishPer(Integer finishPer)
	{
		this.finishPer = finishPer;
	}

	public Integer getGvIndex()
	{
		return gvIndex;
	}

	public void setGvIndex(Integer gvIndex)
	{
		this.gvIndex = gvIndex;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public String getUpdateUser()
	{
		return updateUser;
	}

	public void setUpdateUser(String updateUser)
	{
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public Integer getRemainDay()
	{
		return remainDay;
	}

	public void setRemainDay(Integer remainDay)
	{
		this.remainDay = remainDay;
	}

	public String getProductImageUs()
	{
		return productImageUs;
	}

	public void setProductImageUs(String productImageUs)
	{
		this.productImageUs = productImageUs == null ? null : productImageUs.trim();
	}

	@Override
	public String toString() {
		return "TDreamProduct{" +
				"pkId=" + pkId +
				", website=" + website +
				", originalId='" + originalId + '\'' +
				", productName='" + productName + '\'' +
				", productDesc='" + productDesc + '\'' +
				", productUrl='" + productUrl + '\'' +
				", productImage='" + productImage + '\'' +
				", productVideo='" + productVideo + '\'' +
				", productQrcode='" + productQrcode + '\'' +
				", productBegin=" + productBegin +
				", productEnd=" + productEnd +
				", foreverStatus=" + foreverStatus +
				", productEnabled=" + productEnabled +
				", productStatus='" + productStatus + '\'' +
				", statusValue=" + statusValue +
				", personName='" + personName + '\'' +
				", personImage='" + personImage + '\'' +
				", personDesc='" + personDesc + '\'' +
				", createDate=" + createDate +
				", currencyId=" + currencyId +
				", averageMoney=" + averageMoney +
				", targetMoneyOrg=" + targetMoneyOrg +
				", targetMoney=" + targetMoney +
				", currMoneyOrg=" + currMoneyOrg +
				", currMoney=" + currMoney +
				", itemCorePriceOrg=" + itemCorePriceOrg +
				", itemCorePrice=" + itemCorePrice +
				", supportPerson=" + supportPerson +
				", shareCount=" + shareCount +
				", focusCount=" + focusCount +
				", likeCount=" + likeCount +
				", finishPer=" + finishPer +
				", gvIndex=" + gvIndex +
				", updateDate=" + updateDate +
				", updateUser='" + updateUser + '\'' +
				", remainDay=" + remainDay +
				", productImageUs='" + productImageUs + '\'' +
				'}';
	}
}