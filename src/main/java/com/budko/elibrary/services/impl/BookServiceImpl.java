package com.budko.elibrary.services.impl;

import com.budko.elibrary.controllers.dto.BookDTO;
import com.budko.elibrary.entities.Book;
import com.budko.elibrary.exceptions.FileExistException;
import com.budko.elibrary.repositories.AuthorRepository;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.repositories.UDKRepository;
import com.budko.elibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author DBudko.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private UDKRepository udkRepository;
    @Autowired
    private Environment environment;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {
        Pageable request = new PageRequest(pageable.getPageNumber()-1,pageable.getPageSize(),pageable.getSort());
        return bookRepository.findAll(request);
    }

    @Override
    public void addBook(BookDTO bookDTO) throws IOException, FileExistException {
        String fileName = getRandomFileNameWithExtension(bookDTO.getImage());
        fileUpload(bookDTO.getImage(),fileName);
        Book book = new Book(bookDTO,fileName);
        authorRepository.save(book.getAuthors());
        book.setUdkCategory(udkRepository.findOne(book.getUdkCategory().getId()));
        bookRepository.saveAndFlush(book);
    }

    private void fileUpload(MultipartFile multipartFile,String fileName) throws IOException, FileExistException {
        String filePath = environment.getProperty("com.budko.elibrary.imagePath");
        File dest = new File(filePath + fileName);
        if (dest.exists()) {
            throw new FileExistException();
        }
        multipartFile.transferTo(dest);
    }

    private String getRandomFileNameWithExtension(MultipartFile multipartFile) {
        UUID id = UUID.randomUUID();
        String extenstion = multipartFile.getContentType().split("/")[1];
        String fileName = id.toString() + "." + extenstion;
        return fileName;
    }


}
