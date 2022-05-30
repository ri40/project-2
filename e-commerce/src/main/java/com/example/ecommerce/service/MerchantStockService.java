package com.example.ecommerce.service;

import com.example.ecommerce.model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MerchantStockService {

    private ArrayList<MerchantStock>merchantStocks=new ArrayList<>();
    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public boolean addMerchantStocks(MerchantStock merchantStock) {
        return merchantStocks.add(merchantStock);
    }

    public boolean updateMerchantStocks(Integer index, MerchantStock merchantStock) {
        if(index > merchantStocks.size()-1 || index <0){
            return false;
        }
        MerchantStock currentMerchant = merchantStocks.set(index,merchantStock);
        return true;
    }

    public boolean deleteMerchantStocks(Integer index) {
        if(index > merchantStocks.size()-1 || index <0){
            return false;
        }
        merchantStocks.remove((int)index);
        return true;
    }
    ////////////////=================///////////////
    public MerchantStock getmerchantID(String merchantid){
        for(MerchantStock merchantStock:merchantStocks){
            if(merchantStock.getId().equals(merchantid))
                return merchantStock;
        }
        return null;
    }
}
