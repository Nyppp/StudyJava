package com.example.spring_day8.servcie;

import com.example.spring_day8.model.Rating;

import java.util.List;

public interface RatingService {
    Rating saveRating(Rating rating);
    List<Rating> findRatingByCourseId(Long id);
    Rating findRatingByUserIdAtCourse(Long courseId, Long userId);

    Double getAvgRating(Long courseId);
}
