package factory.task3.createdocument;

import factory.task3.documents.IDocument;

public interface ICreateDocument {

    IDocument createNew();
    IDocument open();
}
