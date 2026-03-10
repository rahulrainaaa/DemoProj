package com.demo.book.repository;

import com.demo.book.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, String> {

    @Modifying
    @Query("""
               update Review r
               set r.likes = r.likes + :incrementBy
               where r.id = :reviewId
            """)
    int incrementLikes(String reviewId, int incrementBy);

    @Modifying
    @Query("""
            update Review r
                    set r.dislikes = r.dislikes + :incrementBy
                    where r.id = :reviewId
            """)
    int incrementDislikes(String reviewId, int incrementBy);
}