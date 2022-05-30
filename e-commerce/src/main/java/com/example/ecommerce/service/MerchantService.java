package com.example.ecommerce.service;

import com.example.ecommerce.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MerchantService {

    private ArrayList<Merchant>merchants=new ArrayList<>();
    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }
    public boolean addMerchants(Merchant merchant) {
        return merchants.add(merchant);
    }
    public boolean updateMerchants(Integer index, Merchant merchant) {
        if(index > merchants.size()-1 || index <0){
            return false;
        }
        Merchant currentMerchant = merchants.set(index,merchant);
        return true;
    }

    public boolean deleteMerchants(Integer index) {
        if(index > merchants.size()-1 || index <0){
            return false;
        }
        merchants.remove((int)index);
        return true;
    }
}
