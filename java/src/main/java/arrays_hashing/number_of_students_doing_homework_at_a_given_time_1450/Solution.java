package arrays_hashing.number_of_students_doing_homework_at_a_given_time_1450;

public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;
        for(int i = 0; i < startTime.length; ++i){
            answer += (queryTime >= startTime[i] && queryTime <= endTime[i] ? 1 : 0);
        }
        return answer;
    }
}
