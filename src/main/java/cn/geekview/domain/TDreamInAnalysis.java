package cn.geekview.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TDreamInAnalysis {
    private Integer pkId;

	private Integer gvIndex;

	private Integer productId;

	private Date updateDate;

	private Integer shareCount;

	private Integer supportPerson;

	private Integer currencyId;

	private BigDecimal targetMoneyOrg;

	private BigDecimal targetMoney;

	private BigDecimal currMoneyOrg;

	private BigDecimal currMoney;

	private BigDecimal currMoneyFundOrg;

	private BigDecimal currMoneyFund;

	private BigDecimal currMoneyExternalOrg;

	private BigDecimal currMoneyExternal;

	private BigDecimal currMoneyForeverOrg;

	private BigDecimal currMoneyForever;

	private BigDecimal averageMoney;

	private BigDecimal itemCorePriceOrg;

	private BigDecimal itemCorePrice;

	private Integer itemCoreTotal;

	private Integer itemCoreSupport;

	private Integer flowValue;

	private Integer moneyValue;

	private Integer itemCoreValue;

	private Integer finishPer;

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
	}

	public Integer getGvIndex()
	{
		return gvIndex;
	}

	public void setGvIndex(Integer gvIndex)
	{
		this.gvIndex = gvIndex;
	}

	public Integer getProductId()
	{
		return productId;
	}

	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
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

	public Integer getCurrencyId()
	{
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId)
	{
		this.currencyId = currencyId;
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

	public BigDecimal getCurrMoneyFundOrg()
	{
		return currMoneyFundOrg;
	}

	public void setCurrMoneyFundOrg(BigDecimal currMoneyFundOrg)
	{
		this.currMoneyFundOrg = currMoneyFundOrg;
	}

	public BigDecimal getCurrMoneyFund()
	{
		return currMoneyFund;
	}

	public void setCurrMoneyFund(BigDecimal currMoneyFund)
	{
		this.currMoneyFund = currMoneyFund;
	}

	public BigDecimal getCurrMoneyExternalOrg()
	{
		return currMoneyExternalOrg;
	}

	public void setCurrMoneyExternalOrg(BigDecimal currMoneyExternalOrg)
	{
		this.currMoneyExternalOrg = currMoneyExternalOrg;
	}

	public BigDecimal getCurrMoneyExternal()
	{
		return currMoneyExternal;
	}

	public void setCurrMoneyExternal(BigDecimal currMoneyExternal)
	{
		this.currMoneyExternal = currMoneyExternal;
	}

	public BigDecimal getCurrMoneyForeverOrg()
	{
		return currMoneyForeverOrg;
	}

	public void setCurrMoneyForeverOrg(BigDecimal currMoneyForeverOrg)
	{
		this.currMoneyForeverOrg = currMoneyForeverOrg;
	}

	public BigDecimal getCurrMoneyForever()
	{
		return currMoneyForever;
	}

	public void setCurrMoneyForever(BigDecimal currMoneyForever)
	{
		this.currMoneyForever = currMoneyForever;
	}

	public BigDecimal getAverageMoney()
	{
		return averageMoney;
	}

	public void setAverageMoney(BigDecimal averageMoney)
	{
		this.averageMoney = averageMoney;
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

	public Integer getItemCoreTotal()
	{
		return itemCoreTotal;
	}

	public void setItemCoreTotal(Integer itemCoreTotal)
	{
		this.itemCoreTotal = itemCoreTotal;
	}

	public Integer getItemCoreSupport()
	{
		return itemCoreSupport;
	}

	public void setItemCoreSupport(Integer itemCoreSupport)
	{
		this.itemCoreSupport = itemCoreSupport;
	}

	public Integer getFlowValue()
	{
		return flowValue;
	}

	public void setFlowValue(Integer flowValue)
	{
		this.flowValue = flowValue;
	}

	public Integer getMoneyValue()
	{
		return moneyValue;
	}

	public void setMoneyValue(Integer moneyValue)
	{
		this.moneyValue = moneyValue;
	}

	public Integer getItemCoreValue()
	{
		return itemCoreValue;
	}

	public void setItemCoreValue(Integer itemCoreValue)
	{
		this.itemCoreValue = itemCoreValue;
	}

	public Integer getFinishPer()
	{
		return finishPer;
	}

	public void setFinishPer(Integer finishPer)
	{
		this.finishPer = finishPer;
	}

	@Override
	public String toString() {
		return "TDreamInAnalysis{" +
				"pkId=" + pkId +
				", gvIndex=" + gvIndex +
				", productId=" + productId +
				", updateDate=" + updateDate +
				", shareCount=" + shareCount +
				", supportPerson=" + supportPerson +
				", currencyId=" + currencyId +
				", targetMoneyOrg=" + targetMoneyOrg +
				", targetMoney=" + targetMoney +
				", currMoneyOrg=" + currMoneyOrg +
				", currMoney=" + currMoney +
				", currMoneyFundOrg=" + currMoneyFundOrg +
				", currMoneyFund=" + currMoneyFund +
				", currMoneyExternalOrg=" + currMoneyExternalOrg +
				", currMoneyExternal=" + currMoneyExternal +
				", currMoneyForeverOrg=" + currMoneyForeverOrg +
				", currMoneyForever=" + currMoneyForever +
				", averageMoney=" + averageMoney +
				", itemCorePriceOrg=" + itemCorePriceOrg +
				", itemCorePrice=" + itemCorePrice +
				", itemCoreTotal=" + itemCoreTotal +
				", itemCoreSupport=" + itemCoreSupport +
				", flowValue=" + flowValue +
				", moneyValue=" + moneyValue +
				", itemCoreValue=" + itemCoreValue +
				", finishPer=" + finishPer +
				'}';
	}
}