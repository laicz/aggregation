/**
 * Date:     2018/5/1916:56
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

import java.util.Date;

/**
 * 商品历史价格
 * 2018/5/19  16:56
 * created by zhoumb
 */
public class PriceHistory {
    private Long retail;//零售价
    private Long sale;//批发价
    private Date start;//开始时间
    private Date end;//结束时间

    public Long getRetail() {
        return retail;
    }

    public void setRetail(Long retail) {
        this.retail = retail;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
