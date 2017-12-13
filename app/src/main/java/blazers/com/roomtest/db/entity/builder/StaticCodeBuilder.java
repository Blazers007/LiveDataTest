package blazers.com.roomtest.db.entity.builder;

import blazers.com.roomtest.db.entity.Contract;
import blazers.com.roomtest.db.entity.embbed.StaticCode;

public class StaticCodeBuilder {
    private double mSettlement;
    private double mPreSettlement;
    private double mOpen;
    private double mClose;
    private double mPreClose;
    private double mUpperLimit;
    private double mLowerLimit;
    private long mTradingDay;

    public StaticCodeBuilder setSettlement(double settlement) {
        mSettlement = settlement;
        return this;
    }

    public StaticCodeBuilder setPreSettlement(double preSettlement) {
        mPreSettlement = preSettlement;
        return this;
    }

    public StaticCodeBuilder setOpen(double open) {
        mOpen = open;
        return this;
    }

    public StaticCodeBuilder setClose(double close) {
        mClose = close;
        return this;
    }

    public StaticCodeBuilder setPreClose(double preClose) {
        mPreClose = preClose;
        return this;
    }

    public StaticCodeBuilder setUpperLimit(double upperLimit) {
        mUpperLimit = upperLimit;
        return this;
    }

    public StaticCodeBuilder setLowerLimit(double lowerLimit) {
        mLowerLimit = lowerLimit;
        return this;
    }

    public StaticCodeBuilder setTradingDay(long tradingDay) {
        mTradingDay = tradingDay;
        return this;
    }

    public StaticCode createStaticCode() {
        return new StaticCode(mSettlement, mPreSettlement, mOpen, mClose, mPreClose, mUpperLimit, mLowerLimit, mTradingDay);
    }
}
