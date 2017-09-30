package cn.geekview.mapper;

import cn.geekview.domain.TDreamProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TDreamProductMapper {
    String selectProductId_sql = "select pk_id\n" +
            "    from t_dream_product\n" +
            "    where website = #{website,jdbcType=INTEGER}\n" +
            "      and original_id = #{originalId,jdbcType=VARCHAR}\n" +
            "    limit 1";
    @Select(selectProductId_sql)
    Integer selectProductId(@Param("website")Integer website, @Param("originalId")String originalId);
}
