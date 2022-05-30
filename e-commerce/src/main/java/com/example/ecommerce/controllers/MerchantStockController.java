package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Api;
import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }

    @PostMapping
    public ResponseEntity<Api> addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isAddMerchantStocks =merchantStockService.addMerchantStocks(merchantStock);
        if (!isAddMerchantStocks) {
            return ResponseEntity.status(400).body(new Api("Not Found Merchant Stock!", 400));
        }
        return ResponseEntity.status(201).body(new Api("Merchant Stock added!", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity<Api> updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock,@PathVariable Integer index, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isUpdateMerchantStocks =merchantStockService.updateMerchantStocks(index, merchantStock);
        if (!isUpdateMerchantStocks) {
            return ResponseEntity.status(400).body(new Api(" Not found Merchant Stock", 400));
        }
        return ResponseEntity.status(200).body(new Api("update Merchant Stock", 200));
    }
    @DeleteMapping("{index}")
    public ResponseEntity<Api> deleteMerchantStock(@PathVariable Integer index) {
        boolean isDeleteMerchantStocks =merchantStockService.deleteMerchantStocks(index);
        if (!isDeleteMerchantStocks) {
            return ResponseEntity.status(400).body(new Api(" Not found Merchant Stock", 400));
        }
        return ResponseEntity.status(200).body(new Api("delete Merchant Stock", 200));
    }
}
