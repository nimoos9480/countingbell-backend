package com.kh.countingBell.repo;

import com.kh.countingBell.domain.Food;
import com.kh.countingBell.domain.Menu;
import com.kh.countingBell.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantDAO extends JpaRepository<Restaurant, Integer> {

    // 지역에 따른 식당 조회
    @Query(value = "SELECT * FROM restaurant WHERE local_code = :code", nativeQuery = true)
    List<Restaurant> findByLocalCode(int code); // 이곳의 code가 쿼리문 안의 '?' 자리로 들어간다  ==> service로 메서드 추가하러 가기

    // 식당 1개에 따른 음식 종류 조회
    @Query(value = "SELECT * FROM food WHERE res_code = :code", nativeQuery = true)
    List<Food> findFoodByResCode(int code);

    // 식당 1개에 따른 메뉴 조회
    @Query(value = "SELECT * FROM menu WHERE res_code = :code", nativeQuery = true)
    List<Menu> findByResCode(int code);
}
