package cn.geekview.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TDreamRankGrowth {
    private Integer pkId;

	private Integer productId;

	private Date updateDate;

	private BigDecimal targetMoney;

	private BigDecimal targetAverage;

	private BigDecimal currMoneyLast;

	private BigDecimal currMoneyNow;

	private BigDecimal growthMoney;

	private BigDecimal currMoneyLastOrg;

	private BigDecimal currMoneyNowOrg;

	private BigDecimal growthMoneyOrg;

	private Integer supportLast;

	private Integer supportNow;

	private Integer growthSupport;

	private Integer growthSpeed;

	private Integer rankingNational;

	private Integer rankingWorld;

	private Integer rankingNationalChange;

	private Integer rankingWorldChange;

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
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

	public BigDecimal getTargetMoney()
	{
		return targetMoney;
	}

	public void setTargetMoney(BigDecimal targetMoney)
	{
		this.targetMoney = targetMoney;
	}

	public BigDecimal getTargetAverage()
	{
		return targetAverage;
	}

	public void setTargetAverage(BigDecimal targetAverage)
	{
		this.targetAverage = targetAverage;
	}

	public BigDecimal getCurrMoneyLast()
	{
		return currMoneyLast;
	}

	public void setCurrMoneyLast(BigDecimal currMoneyLast)
	{
		this.currMoneyLast = currMoneyLast;
	}

	public BigDecimal getCurrMoneyNow()
	{
		return currMoneyNow;
	}

	public void setCurrMoneyNow(BigDecimal currMoneyNow)
	{
		this.currMoneyNow = currMoneyNow;
	}

	public BigDecimal getGrowthMoney()
	{
		return growthMoney;
	}

	public void setGrowthMoney(BigDecimal growthMoney)
	{
		this.growthMoney = growthMoney;
	}

	public BigDecimal getCurrMoneyLastOrg()
	{
		return currMoneyLastOrg;
	}

	public void setCurrMoneyLastOrg(BigDecimal currMoneyLastOrg)
	{
		this.currMoneyLastOrg = currMoneyLastOrg;
	}

	public BigDecimal getCurrMoneyNowOrg()
	{
		return currMoneyNowOrg;
	}

	public void setCurrMoneyNowOrg(BigDecimal currMoneyNowOrg)
	{
		this.currMoneyNowOrg = currMoneyNowOrg;
	}

	public BigDecimal getGrowthMoneyOrg()
	{
		return growthMoneyOrg;
	}

	public void setGrowthMoneyOrg(BigDecimal growthMoneyOrg)
	{
		this.growthMoneyOrg = growthMoneyOrg;
	}

	public Integer getSupportLast()
	{
		return supportLast;
	}

	public void setSupportLast(Integer supportLast)
	{
		this.supportLast = supportLast;
	}

	public Integer getSupportNow()
	{
		return supportNow;
	}

	public void setSupportNow(Integer supportNow)
	{
		this.supportNow = supportNow;
	}

	public Integer getGrowthSupport()
	{
		return growthSupport;
	}

	public void setGrowthSupport(Integer growthSupport)
	{
		this.growthSupport = growthSupport;
	}

	public Integer getGrowthSpeed()
	{
		return growthSpeed;
	}

	public void setGrowthSpeed(Integer growthSpeed)
	{
		this.growthSpeed = growthSpeed;
	}

	public Integer getRankingNational()
	{
		return rankingNational;
	}

	public void setRankingNational(Integer rankingNational)
	{
		this.rankingNational = rankingNational;
	}

	public Integer getRankingWorld()
	{
		return rankingWorld;
	}

	public void setRankingWorld(Integer rankingWorld)
	{
		this.rankingWorld = rankingWorld;
	}

	public Integer getRankingNationalChange()
	{
		return rankingNationalChange;
	}

	public void setRankingNationalChange(Integer rankingNationalChange)
	{
		this.rankingNationalChange = rankingNationalChange;
	}

	public Integer getRankingWorldChange()
	{
		return rankingWorldChange;
	}

	public void setRankingWorldChange(Integer rankingWorldChange)
	{
		this.rankingWorldChange = rankingWorldChange;
	}

}