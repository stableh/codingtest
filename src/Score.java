public class Score implements Comparable<Score> {
    int english;
    int math;

    public Score(int english, int math) {
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Score o) {
        if (this.english == o.english) return o.math - this.math;
        return o.english - this.english;
    }
}
