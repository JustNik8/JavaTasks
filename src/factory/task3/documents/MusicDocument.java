package factory.task3.documents;

public class MusicDocument implements IDocument {
    private double size;
    private String name;
    private String extension;

    public MusicDocument(double size, String name, String extension) {
        this.size = size;
        this.name = name;
        this.extension = extension;
    }

    public MusicDocument() {
        this(0, "New Music Document", "mp4");
    }

    @Override
    public double getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
