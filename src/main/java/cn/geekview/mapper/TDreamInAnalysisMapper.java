package cn.geekview.mapper;

import cn.geekview.domain.TDreamInAnalysis;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

public interface TDreamInAnalysisMapper {

    String insert_sql = "insert into t_dream_in_analysis (pk_id, gv_index, product_id, \n" +
            "      update_date, share_count, support_person, currency_id, \n" +
            "      target_money_org, target_money, curr_money_org, \n" +
            "      curr_money, curr_money_fund_org, curr_money_fund, \n" +
            "      curr_money_external_org, curr_money_external, \n" +
            "      curr_money_forever_org, curr_money_forever, \n" +
            "      average_money, item_core_price_org, item_core_price, \n" +
            "      item_core_total, item_core_support, flow_value, \n" +
            "      money_value, item_core_value, finish_per\n" +
            "      )\n" +
            "    values (#{pkId,jdbcType=INTEGER}, #{gvIndex,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, \n" +
            "      #{updateDate,jdbcType=TIMESTAMP}, #{shareCount,jdbcType=INTEGER},#{supportPerson,jdbcType=INTEGER}, #{currencyId,jdbcType=INTEGER}, \n" +
            "      #{targetMoneyOrg,jdbcType=DECIMAL}, #{targetMoney,jdbcType=DECIMAL}, #{currMoneyOrg,jdbcType=DECIMAL}, \n" +
            "      #{currMoney,jdbcType=DECIMAL}, #{currMoneyFundOrg,jdbcType=DECIMAL}, #{currMoneyFund,jdbcType=DECIMAL}, \n" +
            "      #{currMoneyExternalOrg,jdbcType=DECIMAL}, #{currMoneyExternal,jdbcType=DECIMAL}, \n" +
            "      #{currMoneyForeverOrg,jdbcType=DECIMAL}, #{currMoneyForever,jdbcType=DECIMAL}, \n" +
            "      #{averageMoney,jdbcType=DECIMAL}, #{itemCorePriceOrg,jdbcType=DECIMAL}, #{itemCorePrice,jdbcType=DECIMAL}, \n" +
            "      #{itemCoreTotal,jdbcType=INTEGER}, #{itemCoreSupport,jdbcType=INTEGER}, #{flowValue,jdbcType=INTEGER}, \n" +
            "      #{moneyValue,jdbcType=INTEGER}, #{itemCoreValue,jdbcType=INTEGER}, #{finishPer,jdbcType=INTEGER}\n" +
            "      )";

    @Insert(insert_sql)
    int insert(TDreamInAnalysis inAnalysis);

    String updateproduct_sql = "update t_dream_product set\n" +
            "        gv_index = #{gvIndex,jdbcType=INTEGER},\n" +
            "        currency_id = #{currencyId,jdbcType=INTEGER},\n" +
            "        average_money = #{averageMoney,jdbcType=DECIMAL},\n" +
            "        target_money_org = #{targetMoneyOrg,jdbcType=DECIMAL},\n" +
            "        target_money = #{targetMoney,jdbcType=DECIMAL},\n" +
            "        curr_money_org = #{currMoneyOrg,jdbcType=DECIMAL},\n" +
            "        curr_money = #{currMoney,jdbcType=DECIMAL},\n" +
            "        item_core_price_org = #{itemCorePriceOrg,jdbcType=DECIMAL},\n" +
            "        item_core_price = #{itemCorePrice,jdbcType=DECIMAL},\n" +
            "        support_person = #{supportPerson,jdbcType=INTEGER},\n" +
            "        share_count = #{shareCount,jdbcType=INTEGER},\n" +
            "        finish_per = #{finishPer,jdbcType=INTEGER},\n" +
            "        update_date = #{updateDate,jdbcType=TIMESTAMP}\n" +
            "    where pk_id = #{productId,jdbcType=INTEGER}";

    @Update(updateproduct_sql)
    void updateProduct(TDreamInAnalysis inAnalysis);

    String selectPrevAnalysis_sql = "select *\n" +
            "    from t_dream_in_analysis\n" +
            "    where product_id = #{productId,jdbcType=INTEGER}\n" +
            "     and update_date < #{updateDate,jdbcType=TIMESTAMP}\n" +
            "     order by update_date desc\n" +
            "      limit 1";

    @Select(selectPrevAnalysis_sql)
    @Results({
            @Result( column="pk_id" ,jdbcType= JdbcType.INTEGER ,property="pkId" ),
            @Result( column="gv_index" ,jdbcType=JdbcType.INTEGER ,property="gvIndex" ),
            @Result( column="product_id" ,jdbcType=JdbcType.INTEGER ,property="productId" ),
            @Result( column="update_date" ,jdbcType=JdbcType.TIMESTAMP ,property="updateDate" ),
            @Result(column="share_count" ,jdbcType=JdbcType.INTEGER ,property="shareCount" ),
            @Result( column="support_person" ,jdbcType=JdbcType.INTEGER ,property="supportPerson" ),
            @Result( column="currency_id" ,jdbcType=JdbcType.INTEGER ,property="currencyId" ),
            @Result( column="target_money_org" ,jdbcType=JdbcType.DECIMAL ,property="targetMoneyOrg" ),
            @Result( column="target_money" ,jdbcType=JdbcType.DECIMAL ,property="targetMoney" ),
            @Result( column="curr_money_org" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyOrg" ),
            @Result( column="curr_money" ,jdbcType=JdbcType.DECIMAL ,property="currMoney" ),
            @Result( column="curr_money_fund_org" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyFundOrg" ),
            @Result( column="curr_money_fund" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyFund" ),
            @Result( column="curr_money_external_org" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyExternalOrg" ),
            @Result( column="curr_money_external" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyExternal" ),
            @Result( column="curr_money_forever_org" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyForeverOrg" ),
            @Result( column="curr_money_forever" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyForever" ),
            @Result( column="average_money" ,jdbcType=JdbcType.DECIMAL ,property="averageMoney" ),
            @Result( column="item_core_price_org" ,jdbcType=JdbcType.DECIMAL,property="itemCorePriceOrg" ),
            @Result( column="item_core_price" ,jdbcType=JdbcType.DECIMAL ,property="itemCorePrice" ),
            @Result( column="item_core_total" ,jdbcType=JdbcType.INTEGER ,property="itemCoreTotal" ),
            @Result( column="item_core_support" ,jdbcType=JdbcType.INTEGER ,property="itemCoreSupport" ),
            @Result( column="flow_value" ,jdbcType=JdbcType.INTEGER ,property="flowValue" ),
            @Result( column="money_value" ,jdbcType=JdbcType.INTEGER ,property="moneyValue" ),
            @Result( column="item_core_value" ,jdbcType=JdbcType.INTEGER ,property="itemCoreValue" ),
            @Result( column="finish_per" ,jdbcType=JdbcType.INTEGER ,property="finishPer" ),
    })
    TDreamInAnalysis selectPrevAnalysis(@Param("productId") Integer productId,@Param("updateDate") Date updateDate);

    String deleteByUpdate_sql = "\n" +
            "DELETE From t_dream_in_analysis where update_date = #{updateDate,jdbcType=TIMESTAMP}";

    @Delete(deleteByUpdate_sql)
    void deleteByUpdate(@Param("updateDate") Date updateDate);
}
