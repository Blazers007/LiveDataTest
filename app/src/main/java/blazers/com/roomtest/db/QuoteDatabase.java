package blazers.com.roomtest.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import blazers.com.roomtest.db.converter.DateTypeConverter;
import blazers.com.roomtest.db.dao.ContractDao;
import blazers.com.roomtest.db.entity.Contract;

/**
 * Created by blazers on 2017/12/13.
 * Room - Database
 */

@Database(entities = {Contract.class}, version = 1, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class QuoteDatabase extends RoomDatabase {

    public abstract ContractDao contractDao();

}
