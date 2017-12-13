package blazers.com.roomtest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import blazers.com.roomtest.db.entity.Contract;

/**
 * Created by blazers on 2017/12/13.
 * 合约Dao
 */

@Dao
public interface ContractDao {

    /* Query */
    @Query("SELECT * FROM contract")
    List<Contract> getAll();

    @Query("SELECT * FROM contract WHERE market = :market")
    LiveData<List<Contract>> loadAllByMarket(String market);

    @Query("SELECT * FROM contract WHERE code = :code")
    Contract findContractByCode(String code);




    /* Insert */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContracts(Contract...contracts);

    /* Insert */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContracts(List<Contract> contracts);




    /* Update */
    @Update
    void updateContracts(Contract...contracts);

    @Update
    void updateContracts(List<Contract> contracts);




    /* Delete */
    @Delete
    void delete(Contract...contracts);

    @Delete
    void delete(List<Contract> contracts);
}
