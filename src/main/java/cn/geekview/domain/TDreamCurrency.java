package cn.geekview.domain;

import java.math.BigDecimal;

public class TDreamCurrency {
    private Integer pkId;

	private String currencyName;

	private String currencyNick;

	private String currencySign;

	private BigDecimal currencyExchange;

	private Integer currencyStatus;

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
	}

	public String getCurrencyName()
	{
		return currencyName;
	}

	public void setCurrencyName(String currencyName)
	{
		this.currencyName = currencyName == null ? null : currencyName.trim();
	}

	public String getCurrencyNick()
	{
		return currencyNick;
	}

	public void setCurrencyNick(String currencyNick)
	{
		this.currencyNick = currencyNick == null ? null : currencyNick.trim();
	}

	public String getCurrencySign()
	{
		return currencySign;
	}

	public void setCurrencySign(String currencySign)
	{
		this.currencySign = currencySign == null ? null : currencySign.trim();
	}

	public BigDecimal getCurrencyExchange()
	{
		return currencyExchange;
	}

	public void setCurrencyExchange(BigDecimal currencyExchange)
	{
		this.currencyExchange = currencyExchange;
	}

	public Integer getCurrencyStatus()
	{
		return currencyStatus;
	}

	public void setCurrencyStatus(Integer currencyStatus)
	{
		this.currencyStatus = currencyStatus;
	}

	@Override
	public String toString() {
		return "TDreamCurrency{" +
				"pkId=" + pkId +
				", currencyName='" + currencyName + '\'' +
				", currencyNick='" + currencyNick + '\'' +
				", currencySign='" + currencySign + '\'' +
				", currencyExchange=" + currencyExchange +
				", currencyStatus=" + currencyStatus +
				'}';
	}
}