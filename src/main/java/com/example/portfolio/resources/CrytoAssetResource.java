package com.example.portfolio.resources;


import com.example.portfolio.data.BinanceTicker;
import com.example.portfolio.data.CrytoAsset;
import com.example.portfolio.respository.CrytoAssetRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;

/**
 * @author brahimabouihia
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/wallet")
public class CrytoAssetResource {

    @Autowired
    private CrytoAssetRespository  crytoAssetRespository;

    @Autowired
    private WebClient.Builder webClientBuilder;

     @GetMapping("/{symbole}")
     public CrytoAsset  getBySymbole(@PathVariable String symbole){
        CrytoAsset  crytoAsset =  crytoAssetRespository.findById(symbole).get();

         final BinanceTicker binanceTicker = webClientBuilder.build()
                 .get()
                 .uri("https://api.binance.com/api/v3/ticker/24hr?symbol=" + symbole + "USDT")
                 .retrieve()
                 .bodyToMono(BinanceTicker.class)
                 .block();

         crytoAsset.setPrice(binanceTicker.getLastPrice());
         return crytoAsset;

     }

}
