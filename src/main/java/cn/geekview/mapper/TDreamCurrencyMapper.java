package cn.geekview.mapper;

import cn.geekview.domain.TDreamCurrency;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TDreamCurrencyMapper {

    String selectCurrencyList_sql = "select \n" +
            "    *" +
            "    from t_dream_currency\n" +
            "    where currency_status = 1";
    @Select(selectCurrencyList_sql)
    @Results({
            @Result( column="pk_id" ,jdbcType= JdbcType.INTEGER ,property="pkId" ),
            @Result( column="currency_name" ,jdbcType=JdbcType.VARCHAR ,property="currencyName" ),
            @Result( column="currency_nick" ,jdbcType=JdbcType.VARCHAR ,property="currencyNick" ),
            @Result( column="currency_sign" ,jdbcType=JdbcType.VARCHAR ,property="currencySign" ),
            @Result( column="currency_exchange" ,jdbcType=JdbcType.DECIMAL ,property="currencyExchange" ),
            @Result( column="currency_status" ,jdbcType=JdbcType.INTEGER ,property="currencyStatus" ),
    })
    List<TDreamCurrency> selectCurrencyList();

}
