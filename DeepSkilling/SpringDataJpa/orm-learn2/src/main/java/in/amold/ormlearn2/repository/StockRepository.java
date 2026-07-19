package in.amold.ormlearn2.repository;

import in.amold.ormlearn2.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query("""
SELECT s
FROM Stock s
WHERE s.stockCode = :code
AND s.stockDate BETWEEN :startDate AND :endDate
""")
    List<Stock> getStocksForFB(
            @Param("code") String code,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);


    @Query("SELECT s FROM Stock s WHERE s.stockCode = 'GOOG' AND s.stockOpen > 1250 ")
    List<Stock> getStocksForGOOG();
}
