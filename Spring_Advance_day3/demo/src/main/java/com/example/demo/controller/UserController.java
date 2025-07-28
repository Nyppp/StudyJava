package com.example.demo.controller;

import com.example.demo.model.AgeStats;
import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "사용자 관리 API")
public class UserController {

    // 임시 데이터 저장소
    private Map<Long, User> users = new HashMap<>();
    private Long idCounter = 1L;

    // 초기 데이터
    public UserController() {
        User user1 = new User();
        user1.setId(idCounter++);
        user1.setName("홍길동");
        user1.setEmail("hong@example.com");
        user1.setAge(30);
        users.put(user1.getId(), user1);
    }

    @Operation(summary = "모든 사용자 조회", description = "등록된 모든 사용자 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Operation(summary = "특정 사용자 조회", description = "ID로 특정 사용자를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    @GetMapping("/{id}")
    public User getUser(
            @Parameter(description = "사용자 ID", example = "1", required = true)
            @PathVariable Long id) {
        return users.get(id);
    }

    @Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping
    public User createUser(
            @Parameter(description = "생성할 사용자 정보", required = true)
            @RequestBody User user) {
        user.setId(idCounter++);
        users.put(user.getId(), user);
        return user;
    }

    @Operation(summary = "사용자 정보 수정", description = "기존 사용자의 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    @PutMapping("/{id}")
    public User updateUser(
            @Parameter(description = "사용자 ID", example = "1", required = true)
            @PathVariable Long id,
            @Parameter(description = "수정할 사용자 정보", required = true)
            @RequestBody User user) {
        if (users.containsKey(id)) {
            user.setId(id);
            users.put(id, user);
            return user;
        }
        return null;
    }

    @Operation(summary = "사용자 삭제", description = "특정 사용자를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    @DeleteMapping("/{id}")
    public void deleteUser(
            @Parameter(description = "사용자 ID", example = "1", required = true)
            @PathVariable Long id) {
        users.remove(id);
    }

    @Operation(summary = "이름으로 사용자 검색", description = "이름에 특정 문자열이 포함된 사용자를 검색합니다.")
    @GetMapping("/search")
    public List<User> searchUsers(
            @Parameter(description = "검색할 이름", example = "홍")
            @RequestParam String name) {
        return users.values().stream()
                .filter(user -> user.getName().contains(name))
                .toList();
    }

    @Operation(summary = "나이별 통계 조회", description = "사용자들의 나이 통계를 조회합니다.")
    @ApiResponse(
            responseCode = "200",
            description = "조회 성공",
            content = @Content(
                    schema = @Schema(implementation = AgeStats.class),
                    examples = @ExampleObject(
                            value = """
                                    {
                                    "averageAge" : 28.5,
                                    "minAge" : 18,
                                    "maxAge" : 65,
                                    "totalUsers" : 4,
                                    "ageGroups" : {
                                        "20대" : 2,
                                        "30대" : 1,
                                        "40대" : 1
                                        }
                                    }
                                    """
                    )
            )
    )
    @GetMapping("stats/age")
    public AgeStats getAgeStatistics(){
        AgeStats stats = new AgeStats();

        List<Integer> ages = users.values().stream()
                .map(User::getAge)
                .filter(age->age != null && age > 0)
                .toList();

        if(ages.isEmpty()){
            return stats;
        }

        stats.setAverageAge(ages.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        stats.setMinAge(ages.stream().mapToInt(Integer::intValue).min().orElse(0));
        stats.setMaxAge(ages.stream().mapToInt(Integer::intValue).max().orElse(0));
        stats.setTotalUsers(ages.size());

        Map<String, Integer> ageGroups = new HashMap<>();
        for (Integer age : ages){
            String group = (age/10) +"0대";

            ageGroups.merge(group, 1, Integer::sum);
        }
        stats.setAgeGroups(ageGroups);

        return stats;
    }
}