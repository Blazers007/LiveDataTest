package blazers.com.roomtest.db.entity.embbed;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by blazers on 2017/12/13.
 */

public class StaticCode {

    public StaticCode(double settlement, double preSettlement, double open, double close, double preClose, double upperLimit, double lowerLimit, long tradingDay) {
        this.settlement = settlement;
        this.preSettlement = preSettlement;
        this.open = open;
        this.close = close;
        this.preClose = preClose;
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        this.tradingDay = tradingDay;
    }

    /* 今结价 */
    private double settlement;

    /* 昨结价 */
    @ColumnInfo(name = "pre_settlement")
    private double preSettlement;

    /* 开盘价 */
    private double open;

    /* 收盘价 */
    private double close;

    /* 昨收价 */
    @ColumnInfo(name = "pre_close")
    private double preClose;

    /* 涨停板价 */
    @ColumnInfo(name = "upper_limit")
    private double upperLimit;

    /* 跌停板价 */
    @ColumnInfo(name = "lower_limit")
    private double lowerLimit;

    /* 交易日 */
    @ColumnInfo(name = "trading_day")
    private long tradingDay;

    /* Getters & Setters */
    public double getSettlement() {
        return settlement;
    }

    public void setSettlement(double settlement) {
        this.settlement = settlement;
    }

    public double getPreSettlement() {
        return preSettlement;
    }

    public void setPreSettlement(double preSettlement) {
        this.preSettlement = preSettlement;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getPreClose() {
        return preClose;
    }

    public void setPreClose(double preClose) {
        this.preClose = preClose;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public long getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(long tradingDay) {
        this.tradingDay = tradingDay;
    }


    @Override
    public String toString() {
        return "StaticCode{" +
                "settlement=" + settlement +
                ", preSettlement=" + preSettlement +
                ", open=" + open +
                ", close=" + close +
                ", preClose=" + preClose +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                ", tradingDay=" + tradingDay +
                '}';
    }
}
