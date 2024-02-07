package com.gfg.shoutreview.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gfg.shoutreview.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query(value = "select avg(rating) from review_table where movie_id=?",nativeQuery = true)
	 Double getReviewAverage(Long id);
}