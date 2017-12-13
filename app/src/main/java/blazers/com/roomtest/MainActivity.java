package blazers.com.roomtest;

import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import blazers.com.roomtest.db.QuoteDatabase;
import blazers.com.roomtest.db.dao.ContractDao;
import blazers.com.roomtest.db.entity.Contract;
import blazers.com.roomtest.db.entity.builder.ContractBuilder;

public class MainActivity extends AppCompatActivity {

    private Random mRandom = new Random();
    /* DB */
    private QuoteDatabase mQuoteDatabase;
    private ContractDao mContractDao;

    /* UI Layer */
    private TextView mTvLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind views
        mTvLayer = findViewById(R.id.tv_ui);
        mTvLayer.setMovementMethod(new ScrollingMovementMethod());
        //
        mQuoteDatabase = Room.databaseBuilder(getApplicationContext(), QuoteDatabase.class, "quote").build();
        mContractDao = mQuoteDatabase.contractDao();
        // Get All
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("====", "---- Get all data ----");
                List<Contract> contracts = mContractDao.getAll();
                for (Contract contract : contracts) {
                    Log.i("====", contract.toString());
                }
            }
        }).start();
        // Register
        mContractDao.loadAllByMarket("SHFE").observe(this, new Observer<List<Contract>>() {
            @Override
            public void onChanged(@Nullable List<Contract> contracts) {
                Log.i("====", "SHFE result on change detected! "+ contracts.size() + " @Thread: " + Thread.currentThread().getName());
                for (Contract contract : contracts) {
                    Log.i("====", contract.toString());
                }
            }
        });

        mContractDao.loadAllByMarket("DCE").observe(this, new Observer<List<Contract>>() {
            @Override
            public void onChanged(@Nullable List<Contract> contracts) {
                Log.i("====", "DCE result on change detected! @Thread: " + contracts.size() + " @Thread: " + Thread.currentThread().getName());
                for (Contract contract : contracts) {
                    Log.i("====", contract.toString());
                }
            }
        });
    }

    private void insert(final String market) {
        log("Insert " + market, true);
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Contract> contracts = new ArrayList<>(10);
                for (int i = 0; i < 10; i++) {
                    Contract contract = new ContractBuilder()
                            .setCodeDotMarket("rb1801.SHFE" + i)
                            .setCode("rb1801")
                            .setMarket(market)
                            .setName("螺纹1801")
                            .setMarketName("上海期货")
                            .setCreateDate(new Date())
                            .createContract();
                    contracts.add(contract);
                }
                mContractDao.insertContracts(contracts);
            }
        }).start();
    }

    private void delete(final String market) {
        log("Delete " + market, true);
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                mContractDao.delete(mContractDao.loadAllByMarket(market).getValue());
            }
        });
    }

    private void update(final String market) {
        log("Update " + market, true);
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Contract> contracts = mContractDao.loadAllByMarket(market).getValue();
                for (Contract contract : contracts) {
                    contract.setName("焦煤1801");
                }
                mContractDao.updateContracts(contracts);
            }
        });
    }

    private void query(final String market) {
        log("Query " + market, true);
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Contract> contractList = mContractDao.loadAllByMarket(market).getValue();
                if (contractList != null) {
                    for (Contract contract : contractList) {
                        log(contract.toString());
                    }
                }
            }
        });
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                if (mRandom.nextInt(2) == 0) {
                    insert("DCE");
                } else {
                    insert("SHFE");
                }
                break;
            case R.id.btn_delete:
                if (mRandom.nextInt(2) == 0) {
                    delete("DCE");
                } else {
                    delete("SHFE");
                }
                break;
            case R.id.btn_update:
                if (mRandom.nextInt(2) == 0) {
                    update("DCE");
                } else {
                    update("SHFE");
                }
                break;
            case R.id.btn_query:
                if (mRandom.nextInt(2) == 0) {
                    query("DCE");
                } else {
                    query("SHFE");
                }
                break;
        }
    }

    private void log(String message) {
        log(message, false);
    }

    private void log(final String message, final boolean toast) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toast) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
                mTvLayer.setText(String.format("%s\n%s", mTvLayer.getText(), message));
            }
        });

    }
}
