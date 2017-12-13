package blazers.com.roomtest.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by blazers on 2017/12/13.
 */

public class DateTypeConverter {

    @TypeConverter
    public static Date toDate(long toTimestamp) {
        return new Date(toTimestamp);
    }

    @TypeConverter
    public static long toTimestamp(Date date) {
        return date.getTime();
    }

}
