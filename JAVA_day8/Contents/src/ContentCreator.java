public class ContentCreator extends Person implements Editor, VoiceActor{
    public ContentCreator(String name, int age) {
        super(name, age);
    }

    @Override
    public double evaluateEditingScore(int minutes, int cuts) {
        return (cuts*1.5) - (minutes/10.0);
    }

    @Override
    public int voiceQualityScore(int length, int retakes) {
        return Math.max(0, 100 - (length/2) - (retakes*5));
    }

}
