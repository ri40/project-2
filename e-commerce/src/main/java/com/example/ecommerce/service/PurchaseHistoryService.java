package com.example.ecommerce.service;

import com.example.ecommerce.model.PurchaseHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PurchaseHistoryService {

    private ArrayList<PurchaseHistory>purchaseHistories=new ArrayList<>();
    public ArrayList<PurchaseHistory> getPurchaseHistories() {
        return purchaseHistories;
    }
}
