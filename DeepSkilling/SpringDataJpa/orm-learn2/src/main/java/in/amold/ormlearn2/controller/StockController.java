package in.amold.ormlearn2.controller;

import in.amold.ormlearn2.model.Stock;
import in.amold.ormlearn2.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    private StockService service;
    public StockController (StockService service){
        this.service = service;
    }

    @GetMapping("/getFBstocks")
    public List<Stock> getStocksForFacebook(){
        return service.getStocksForFB();
    }

    @GetMapping("/getGOOGstocks")
    public List<Stock> getStocksForGoogle(){
        return service.getStocksForGOOG();
    }
    
}
