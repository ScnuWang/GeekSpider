package cn.geekview.mapper;

import cn.geekview.domain.TDreamRankGrowth;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface TDreamRankGrowthMapper {

    String insert_sql = "insert into t_dream_rank_growth (pk_id, product_id, update_date, \n" +
            "      target_money, target_average, curr_money_last, \n" +
            "      curr_money_now, growth_money, curr_money_last_org, \n" +
            "      curr_money_now_org, growth_money_org, support_last, \n" +
            "      support_now, growth_support, growth_speed, \n" +
            "      ranking_national, ranking_world, ranking_national_change, \n" +
            "      ranking_world_change)\n" +
            "    values (#{pkId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, #{updateDate,jdbcType=TIMESTAMP}, \n" +
            "      #{targetMoney,jdbcType=DECIMAL}, #{targetAverage,jdbcType=DECIMAL}, #{currMoneyLast,jdbcType=DECIMAL}, \n" +
            "      #{currMoneyNow,jdbcType=DECIMAL}, #{growthMoney,jdbcType=DECIMAL}, #{currMoneyLastOrg,jdbcType=DECIMAL}, \n" +
            "      #{currMoneyNowOrg,jdbcType=DECIMAL}, #{growthMoneyOrg,jdbcType=DECIMAL}, #{supportLast,jdbcType=INTEGER}, \n" +
            "      #{supportNow,jdbcType=INTEGER}, #{growthSupport,jdbcType=INTEGER}, #{growthSpeed,jdbcType=INTEGER}, \n" +
            "      #{rankingNational,jdbcType=INTEGER}, #{rankingWorld,jdbcType=INTEGER}, #{rankingNationalChange,jdbcType=INTEGER}, \n" +
            "      #{rankingWorldChange,jdbcType=INTEGER})";

    @Insert(insert_sql)
    int insert(TDreamRankGrowth growth);

    String deleteByWebsiteAndUpdateDate_sql="DELETE FROM t_dream_rank_growth WHERE update_date = #{updateDate,jdbcType=TIMESTAMP} AND  product_id in (SELECT t.pk_id from t_dream_product t WHERE t.website= #{website,jdbcType=INTEGER} AND t.update_date = #{updateDate,jdbcType=TIMESTAMP});";

    @Delete(deleteByWebsiteAndUpdateDate_sql)
    void deleteByWebsiteAndUpdateDate(@Param("website") Integer website,@Param("updateDate") Date updateDate);
}
