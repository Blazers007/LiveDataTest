package blazers.com.roomtest.db.entity.builder;

import java.util.Date;

import blazers.com.roomtest.db.entity.Contract;
import blazers.com.roomtest.db.entity.embbed.StaticCode;

public class ContractBuilder {
    private String mCodeDotMarket;
    private String mCode;
    private String mName;
    private String mMarket;
    private String mMarketName;
    private Date mCreateDate;
    private StaticCode mStaticCode;

    public ContractBuilder setCodeDotMarket(String codeDotMarket) {
        mCodeDotMarket = codeDotMarket;
        return this;
    }

    public ContractBuilder setCode(String code) {
        mCode = code;
        return this;
    }

    public ContractBuilder setName(String name) {
        mName = name;
        return this;
    }

    public ContractBuilder setMarket(String market) {
        mMarket = market;
        return this;
    }

    public ContractBuilder setMarketName(String marketName) {
        mMarketName = marketName;
        return this;
    }

    public ContractBuilder setCreateDate(Date createDate) {
        mCreateDate = createDate;
        return this;
    }

    public ContractBuilder setStaticCode(StaticCode staticCode) {
        mStaticCode = staticCode;
        return this;
    }

    public Contract createContract() {
        return new Contract(mCodeDotMarket, mCode, mName, mMarket, mMarketName, mCreateDate, mStaticCode);
    }
}
