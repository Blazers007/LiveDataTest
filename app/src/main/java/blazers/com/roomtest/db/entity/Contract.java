package blazers.com.roomtest.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import blazers.com.roomtest.db.entity.embbed.StaticCode;

/**
 * Created by blazers on 2017/12/13.
 * 合约
 */

@Entity
public class Contract {

    /* 主键 */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "code_market")
    private String codeDotMarket;
    /* 合约代码 */
    private String code;
    /* 合约名称 */
    private String name;
    /* 市场代码 */
    private String market;
    /* 市场名称 */
    @ColumnInfo(name = "market_name")
    private String marketName;
    /* 更新时间 */
    @ColumnInfo(name = "create_date")
    private Date createDate;
    /* 静态码表 */
    @Embedded
    private StaticCode staticCode;

    public Contract(String codeDotMarket, String code, String name, String market, String marketName, Date createDate, StaticCode staticCode) {
        this.codeDotMarket = codeDotMarket;
        this.code = code;
        this.name = name;
        this.market = market;
        this.marketName = marketName;
        this.createDate = createDate;
        this.staticCode = staticCode;
    }

    /* Getters & Setters */
    public String getCodeDotMarket() {
        return codeDotMarket;
    }

    public void setCodeDotMarket(String codeDotMarket) {
        this.codeDotMarket = codeDotMarket;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public StaticCode getStaticCode() {
        return staticCode;
    }

    public void setStaticCode(StaticCode staticCode) {
        this.staticCode = staticCode;
    }

    /* toString() */

    @Override
    public String toString() {
        return "Contract{" +
                "codeDotMarket='" + codeDotMarket + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", marketName='" + marketName + '\'' +
                ", createDate=" + createDate +
                ", staticCode=" + staticCode +
                '}';
    }
}
