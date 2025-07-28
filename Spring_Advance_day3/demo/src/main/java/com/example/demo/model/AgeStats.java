package com.example.demo.model;

import java.util.Map;
import java.util.HashMap;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "나이 통계")
public class AgeStats {
    @Schema(description = "평균 나이", example = "28.5")
    private Double averageAge = 0.0;

    @Schema(description = "최소 나이", example = "18")
    private Integer minAge = 0;

    @Schema(description = "최대 나이", example = "65")
    private Integer maxAge = 0;

    @Schema(description = "전체 사용자 수", example = "4")
    private Integer totalUsers = 0;

    @Schema(
            description = "연령대별 분포",
            example = "{\"20대\": 2, \"30대\": 1, \"40대\": 1}"
    )
    private Map<String, Integer> ageGroups = new HashMap<>();

    // Getters and Setters
    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Map<String, Integer> getAgeGroups() {
        return ageGroups;
    }

    public void setAgeGroups(Map<String, Integer> ageGroups) {
        this.ageGroups = ageGroups;
    }
}