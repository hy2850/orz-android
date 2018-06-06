package kr.ac.kaist.orz;

import kr.ac.kaist.orz.models.Course;
import kr.ac.kaist.orz.models.Assignment;
import kr.ac.kaist.orz.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;
import java.util.Map;


public interface OrzApi {
    @POST("api/v1/signin")
    Call<User> signin(
            @Body Map<String, String> body
    );

    @POST("api/v1/signup")
    Call<Void> signup(
            @Body Map<String, Object> body
    );

    @GET("api/v1/schools/{schoolID}/courses")
    Call<List<Course>> getSchoolCourses(
            @Path("schoolID") int schoolID
    );

    @GET("api/v1/students/{userID}/courses")
    Call<List<Course>> getStudentCourses(
            @Path("userID") int userID
    );

    @GET("api/v1/students/{userID}/assignments")
    Call<List<Assignment>> getStudentAssignments(
            @Path("userID") int userID
    );

    // My Courses 에 있는 삭제 버튼을 누를 시, DB에 있는 해당 코스를 삭제함
    //(Used in myCourseViewAdapter)
    @DELETE("api/v1/students/{userID}/courses/{courseID}")
    Call<Void> deleteStudentCourses(
            @Path("userID") int userID,
            @Path("courseID") int courseID
    );

    // Open Courses 에 있는 구독 버튼을 누를 시, DB에 있는 해당 코스를 유저가 구독할 수 있게 함
    //(Used in openCourseViewAdapter)
    @POST("api/v1/students/{userID}/courses/{courseID}")
    Call<List<Course>> subscribeCourses(
            @Path("userID") int userID,
            @Path("courseID") int courseID
    );
}