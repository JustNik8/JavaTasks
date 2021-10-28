package factory.task3.createdocument;

import factory.task3.documents.IDocument;
import factory.task3.documents.MusicDocument;

public class CreateMusicDocument implements ICreateDocument{
    @Override
    public IDocument createNew() {
        return new MusicDocument();
    }

    @Override
    public IDocument open() {
        return new MusicDocument();
    }
}
