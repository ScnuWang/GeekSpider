package cn.geekview.mapper;

import cn.geekview.domain.TDreamInProject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface TDreamInProjectMapper {

    String insert_sql = "insert into t_dream_in_project (pk_id, update_date, original_id, \n" +
            "      project_name, project_image, project_url, \n" +
            "      project_desc, project_status, status_value, \n" +
            "      forever_status, begin_date, end_date, \n" +
            "      share_count, support_person, money_currency, \n" +
            "      target_money, curr_money, curr_money_fund, \n" +
            "      curr_money_forever, curr_money_external, finish_per, \n" +
            "      remain_day, person_name)\n" +
            "    values (#{pkId,jdbcType=INTEGER}, #{updateDate,jdbcType=TIMESTAMP}, #{originalId,jdbcType=VARCHAR}, \n" +
            "      #{projectName,jdbcType=VARCHAR}, #{projectImage,jdbcType=VARCHAR}, #{projectUrl,jdbcType=VARCHAR}, \n" +
            "      #{projectDesc,jdbcType=VARCHAR}, #{projectStatus,jdbcType=VARCHAR}, #{statusValue,jdbcType=INTEGER}, \n" +
            "      #{foreverStatus,jdbcType=INTEGER}, #{beginDate,jdbcType=TIMESTAMP}, #{endDate,jdbcType=TIMESTAMP}, \n" +
            "      #{shareCount,jdbcType=INTEGER}, #{supportPerson,jdbcType=INTEGER}, #{moneyCurrency,jdbcType=VARCHAR}, \n" +
            "      #{targetMoney,jdbcType=DECIMAL}, #{currMoney,jdbcType=DECIMAL}, #{currMoneyFund,jdbcType=DECIMAL}, \n" +
            "      #{currMoneyForever,jdbcType=DECIMAL}, #{currMoneyExternal,jdbcType=DECIMAL}, #{finishPer,jdbcType=INTEGER}, \n" +
            "      #{remainDay,jdbcType=INTEGER}, #{personName,jdbcType=VARCHAR})";
    @Insert(insert_sql)
    int insert(TDreamInProject inProject);

    String select_sql = "select * from t_dream_in_project t where t.update_date = #{updateDate,jdbcType=TIMESTAMP}";

    @Select(select_sql)
    @Results({
            @Result(column="pk_id" ,jdbcType=JdbcType.INTEGER ,property="pkId" ),
        @Result( column="update_date" ,jdbcType=JdbcType.TIMESTAMP ,property="updateDate" ),
        @Result( column="original_id" ,jdbcType=JdbcType.VARCHAR ,property="originalId" ),
        @Result( column="project_name" ,jdbcType=JdbcType.VARCHAR ,property="projectName" ),
        @Result( column="project_image" ,jdbcType=JdbcType.VARCHAR ,property="projectImage"),
        @Result( column="project_url" ,jdbcType=JdbcType.VARCHAR ,property="projectUrl" ),
        @Result( column="project_desc" ,jdbcType=JdbcType.VARCHAR ,property="projectDesc"),
        @Result( column="project_status" ,jdbcType=JdbcType.VARCHAR ,property="projectStatus" ),
        @Result( column="status_value" ,jdbcType=JdbcType.INTEGER ,property="statusValue" ),
        @Result( column="forever_status" ,jdbcType=JdbcType.INTEGER ,property="foreverStatus" ),
        @Result( column="begin_date" ,jdbcType=JdbcType.TIMESTAMP ,property="beginDate" ),
        @Result( column="end_date" ,jdbcType=JdbcType.TIMESTAMP ,property="endDate" ),
        @Result( column="share_count" ,jdbcType=JdbcType.INTEGER ,property="shareCount" ),
        @Result( column="support_person" ,jdbcType=JdbcType.INTEGER ,property="supportPerson" ),
        @Result( column="money_currency" ,jdbcType=JdbcType.VARCHAR ,property="moneyCurrency" ),
        @Result( column="target_money" ,jdbcType=JdbcType.DECIMAL ,property="targetMoney" ),
        @Result( column="curr_money" ,jdbcType=JdbcType.DECIMAL ,property="currMoney" ),
        @Result( column="curr_money_fund" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyFund" ),
        @Result( column="curr_money_forever" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyForever" ),
        @Result( column="curr_money_external" ,jdbcType=JdbcType.DECIMAL ,property="currMoneyExternal" ),
        @Result( column="finish_per" ,jdbcType=JdbcType.INTEGER ,property="finishPer" ),
        @Result( column="remain_day" ,jdbcType=JdbcType.INTEGER ,property="remainDay" ),
        @Result( column="person_name" ,jdbcType=JdbcType.VARCHAR ,property="personName" ),
    })
    List<TDreamInProject> selectListByUpdateDate(Date updateDate);

    String insertproduct_sql = "insert into t_dream_product (\n" +
            "      website, original_id, product_name, product_desc, product_url, \n" +
            "      product_image, product_begin, product_end, \n" +
            "      forever_status,product_status, status_value, product_enabled,\n" +
            "      like_count,focus_count,remain_day,\n" +
            "      person_name, create_date,update_date,update_user)\n" +
            "    values (4, #{originalId,jdbcType=VARCHAR},#{projectName,jdbcType=VARCHAR}, #{projectDesc,jdbcType=VARCHAR}, #{projectUrl,jdbcType=VARCHAR}, \n" +
            "      #{projectImage,jdbcType=VARCHAR},#{beginDate,jdbcType=TIMESTAMP}, #{endDate,jdbcType=TIMESTAMP}, \n" +
            "      #{foreverStatus,jdbcType=INTEGER}, #{projectStatus,jdbcType=VARCHAR},#{statusValue,jdbcType=INTEGER}, 1,\n" +
            "      0,0,#{remainDay,jdbcType=VARCHAR},\n" +
            "      #{personName,jdbcType=VARCHAR},#{updateDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP},'程序W')";
    @Insert(insertproduct_sql)
    void insertProduct(TDreamInProject project);

    String updateproduct_sql ="UPDATE t_dream_product\n" +
            "SET product_name = #{projectName,jdbcType=VARCHAR},\n" +
            " product_url = #{projectUrl,jdbcType=VARCHAR},\n" +
            " product_desc = #{projectDesc,jdbcType=VARCHAR},\n" +
            " product_image =  #{projectImage,jdbcType=VARCHAR},\n" +
            " person_name = #{personName,jdbcType=VARCHAR},\n" +
            " product_begin = #{beginDate,jdbcType=TIMESTAMP},\n" +
            " product_end = #{endDate,jdbcType=TIMESTAMP},\n" +
            " product_status = #{projectStatus,jdbcType=VARCHAR},\n" +
            " status_value = #{statusValue,jdbcType=INTEGER},\n" +
            " forever_status = #{foreverStatus,jdbcType=INTEGER},\n" +
            " remain_day = #{remainDay,jdbcType=VARCHAR},\n" +
            " update_date = #{updateDate,jdbcType=TIMESTAMP}\n" +
            "WHERE\n" +
            "\toriginal_id = #{originalId,jdbcType=INTEGER}\n" +
            "AND website = 4";
    @Update(updateproduct_sql)
    void updateProduct(TDreamInProject project);

    String deleteByUpdate_sql = "DELETE FROM t_dream_in_project where update_date = #{updateDate,jdbcType=TIMESTAMP} ";

    @Delete(deleteByUpdate_sql)
    void deleteByUpdate(Date updateDate);

}
