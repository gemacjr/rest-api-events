package com.swiftbeard.restapievents.repository;

import com.swiftbeard.restapievents.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RateRepository  extends JpaRepository<Rate,String> {
    List<Rate> findByDate(Date date);
    Rate findByDateAndCode(Date date, String code);
}
