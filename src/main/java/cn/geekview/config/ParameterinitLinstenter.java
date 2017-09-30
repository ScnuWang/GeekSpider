package cn.geekview.config;

import cn.geekview.domain.TDreamCurrency;
import cn.geekview.mapper.TDreamCurrencyMapper;
import cn.geekview.util.CommonConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 在Spring启动的时候初始化参数
 */
@Component
public class ParameterinitLinstenter implements ApplicationListener<ContextRefreshedEvent>{

    protected Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private TDreamCurrencyMapper currencyMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent()==null){
            logger.info("初始化汇率表");
            List<TDreamCurrency> currencyList = currencyMapper.selectCurrencyList();
            for (TDreamCurrency currency : currencyList) {
                CommonConstant.CURRENCY_MAP.put(currency.getCurrencyNick(),currency);
                logger.debug(currency);
            }
        }
    }
}
