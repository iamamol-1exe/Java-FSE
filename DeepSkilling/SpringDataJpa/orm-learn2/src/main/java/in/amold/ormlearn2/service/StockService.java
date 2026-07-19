package in.amold.ormlearn2.service;

import in.amold.ormlearn2.model.Stock;
import in.amold.ormlearn2.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    private StockRepository repo;

    public StockService(StockRepository repo){
        this.repo = repo;
    }

    public List<Stock> getStocksForFB(){
       return  repo.getStocksForFB(
                "FB",
                LocalDate.of(2019, 10, 1),
                LocalDate.of(2019, 10, 30)
        );
    }

    public List<Stock> getStocksForGOOG(){
        return  repo.getStocksForGOOG();
    }

}
