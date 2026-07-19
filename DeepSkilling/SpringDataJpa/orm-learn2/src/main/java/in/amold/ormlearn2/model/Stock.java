package in.amold.ormlearn2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "stock")

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "st_code")
    private String stockCode;
    @Column(name = "st_date")
    private LocalDate stockDate;
    @Column(name = "st_open")
    private Integer stockOpen;
    @Column(name = "st_close")
    private Integer stockClose;
    @Column(name = "st_volume")
    private Integer stockVolume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public LocalDate getStockDate() {
        return stockDate;
    }

    public void setStockDate(LocalDate stockDate) {
        this.stockDate = stockDate;
    }

    public Integer getStockOpen() {
        return stockOpen;
    }

    public void setStockOpen(Integer stockOpen) {
        this.stockOpen = stockOpen;
    }

    public Integer getStockClose() {
        return stockClose;
    }

    public void setStockClose(Integer stockClose) {
        this.stockClose = stockClose;
    }

    public Integer getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(Integer stockVolume) {
        this.stockVolume = stockVolume;
    }
}
