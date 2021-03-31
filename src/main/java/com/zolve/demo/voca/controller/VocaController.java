package com.zolve.demo.voca.controller;

import com.zolve.demo.voca.exception.VocaException;
import com.zolve.demo.voca.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voca")
public class VocaController {

    @Autowired
    VocaService vocaService;

    @GetMapping("/createWallet/{phoneNumber}")
    public void createWallet(@PathVariable String phoneNumber) throws VocaException {
        vocaService.createWallet(phoneNumber);
    }
    
    @GetMapping("/getBalance/{phoneNumber}")
    public int getBalance(@PathVariable String phoneNumber) throws VocaException  {
        return vocaService.getBalance(phoneNumber);
    }

    @GetMapping("/credit/{phoneNumber}/{amount}")
    public void credit(@PathVariable String phoneNumber, @PathVariable String amount) throws VocaException  {
        vocaService.credit(phoneNumber, Integer.parseInt(amount));
    }

    @GetMapping("/debit/{phoneNumber}/{amount}")
    public void debit(@PathVariable String phoneNumber, @PathVariable String amount) throws VocaException  {
        vocaService.debit(phoneNumber, Integer.parseInt(amount));
    }
}
