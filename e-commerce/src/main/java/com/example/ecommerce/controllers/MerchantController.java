package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Api;
import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getMerchants());
    }
    @PostMapping
    public ResponseEntity<Api> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isAddMerchants =merchantService.addMerchants(merchant);
        if (!isAddMerchants) {
            return ResponseEntity.status(400).body(new Api("Not Found Merchant!", 400));
        }
        return ResponseEntity.status(201).body(new Api("Merchant added!", 201));
    }
    @PutMapping("{index}")
    public ResponseEntity<Api> updateMerchant(@RequestBody @Valid Merchant merchant,@PathVariable Integer index, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isUpdateMerchants =merchantService.updateMerchants(index, merchant);
        if (!isUpdateMerchants) {
            return ResponseEntity.status(400).body(new Api(" Not found Merchant", 400));
        }
        return ResponseEntity.status(200).body(new Api("update Merchant", 200));
    }
    @DeleteMapping("{index}")
    public ResponseEntity<Api> deleteMerchant(@PathVariable Integer index) {
        boolean isDeleteMerchants =merchantService.deleteMerchants(index);
        if (!isDeleteMerchants) {
            return ResponseEntity.status(400).body(new Api(" Not found Merchant", 400));
        }
        return ResponseEntity.status(200).body(new Api("delete Merchant", 200));
    }
}
