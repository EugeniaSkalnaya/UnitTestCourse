import UnitTestCourse.Homework04.book.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookTest {

        @Test
        void findExemplar() {
            BookRepository exemplar = mock(BookRepository.class);
            BookService service = new BookService(exemplar);
            Book book = new Book("123", "Book01", "Author01");
            when(exemplar.findById("123")).thenReturn(book);
            assertThat(service.findBookById("123")).isEqualTo(book);
        }

        @Test
        void findAll() {
            BookRepository exemplars = mock(BookRepository.class);
            BookService service = new BookService(exemplars);
            List<Book> bookList = List.of(
                    new Book("123", "Book01", "Author01"),
                    new Book("234", "Book02", "Author02"),
                    new Book("345", "Book03", "Author03"));
            when(exemplars.findAll()).thenReturn(bookList);
            assertThat(service.findAllBooks()).isEqualTo(bookList);
        }
    }