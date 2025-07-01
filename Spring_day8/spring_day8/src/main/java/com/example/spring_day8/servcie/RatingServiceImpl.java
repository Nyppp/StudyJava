package com.example.spring_day8.servcie;

import com.example.spring_day8.model.Rating;
import com.example.spring_day8.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> findRatingByCourseId(Long id) {
        return ratingRepository.findByCourseId(id);
    }

    @Override
    public Rating findRatingByUserIdAtCourse(Long courseId, Long userId) {
        List<Rating> ratingList = ratingRepository.findByCourseId(courseId);

        for (Rating rating : ratingList){
            if(rating.getUserId() == userId){
                return rating;
            }
        }
        return null;
    }

    @Override
    public Double getAvgRating(Long courseId) {
        List<Rating> ratingList = ratingRepository.findByCourseId(courseId);
        Double avg = 0.0;

        if(ratingList.isEmpty()){
            return 0.0;
        }

        for (Rating rating : ratingList){
            avg += rating.getRate();
        }
        avg /= ratingList.size();

        return avg;
    }
}
