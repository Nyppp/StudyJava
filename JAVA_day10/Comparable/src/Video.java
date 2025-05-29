public class Video implements Comparable<Video>{
    private int views;

    public Video(int views){
        this.views = views;
    }

    public int getViews() {
        return this.views;
    }

    //방법 1. 클래스 내부에서 Comparable 인터페이스 구현
    @Override
    public int compareTo(Video otherVideo) {
        return Integer.compare(otherVideo.getViews(), this.getViews());
    }

    @Override
    public String toString() {
        return "조회수 :  " + this.getViews();
    }
}
