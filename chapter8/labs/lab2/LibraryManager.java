package chapter8.labs.lab2;

import java.util.*;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 *
 * 도서 관리 시스템의 주요 기능을 구현한 클래스입니다.
 */
public class LibraryManager {
    // 도서 목록 (ArrayList 활용)
    private List<Book> books;
    
    // 사용자별 대여 현황 (HashMap 활용)
    private Map<String, List<Book>> userBorrowMap;
    
    // 도서 카테고리 (HashSet 활용)
    private Set<String> categories;
    
    /**
     * 생성자
     */
    public LibraryManager() {
        // TODO: 필드를 초기화하세요.
        books = new ArrayList<>();
        userBorrowMap = new HashMap<>();
        categories = new HashSet<>();
    }
    
    /**
     * 도서 추가 메소드
     */
    public void addBook(Book book) {
        // TODO: 도서를 추가하고, 카테고리도 Set에 추가하세요.
        books.add(book);
        categories.add(book.getCategory());
    }
    
    /**
     * 도서 검색 메소드 (제목으로 검색)
     */
    public List<Book> searchBooksByTitle(String title) {
        // TODO: 제목에 검색어가 포함된 도서를 검색하세요.
        List<Book> search = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                search.add(book);
            }
        }

        return search;


        // return books.stream().filter(book -> book.getTitle().contains(title).collect(Collectors.toList());
    }
    
    /**
     * 도서 검색 메소드 (저자로 검색)
     */
    public List<Book> searchBooksByAuthor(String author) {
        // TODO: 저자명으로 도서를 검색하세요.
        List<Book> search = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(author)) {
                search.add(book);
            }
        }

        return search;
    }
    
    /**
     * 도서 대여 메소드
     */
    public boolean borrowBook(String userId, String isbn) {
        // TODO: 도서를 대여하고, 사용자별 대여 현황을 업데이트하세요.
        List<Book> borrowedList = userBorrowMap.get(userId);

        // 기존 대여목록이 null일 경우 새롭게 초기화 과정 필요
        if (borrowedList == null) {
            borrowedList = new ArrayList<>();
        }


        // 다른 사용자에게 빌려진 적 없는지 체크하는 과정 필요



        for (Book book : borrowedList) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("이미 대여중인 책입니다");
                return false;
            }
        }

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                borrowedList.add(books.get(books.indexOf(book)));
                break;
            }
        }

        userBorrowMap.put(userId, borrowedList);

        return true;
    }
    
    /**
     * 도서 반납 메소드
     */
    public boolean returnBook(String userId, String isbn) {
        // TODO: 도서를 반납하고, 사용자별 대여 현황을 업데이트하세요.
        List<Book> borrowedList = userBorrowMap.get(userId);

        for (Book book : borrowedList) {
            if (book.getIsbn().equals(isbn)) {
                borrowedList.remove(book);
                userBorrowMap.put(userId, borrowedList);
                System.out.println("책을 반납했습니다");

                return true;
            }
        }

        System.out.println("반납에 실패했습니다");
        System.out.println("빌렸던 책인지, 혹은 올바른 ISBN을 입력하셨는지 확인해주십시오");

        return false;
    }
    
    /**
     * 사용자의 대여 도서 목록 조회 메소드
     */
    public List<Book> getBorrowedBooks(String userId) {
        // TODO: 사용자가 대여한 도서 목록을 반환하세요.
        return userBorrowMap.get(userId);
    }
    
    
    // 이하 정렬메소드들
    // ...
    // 리스트 자체를 정렬해서 반환해야하는가, 아니면 정렬 전용 리스트를 새로 만들어서 반환해야 하는가
    // 일단 리스트 자체를 정렬하는 방향으로
    
    
    /**
     * 도서 정렬 메소드 (제목 기준)
     */
    public List<Book> getSortedBooksByTitle() {
        // TODO: 제목 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle));

        return sortedBooks;

        /*
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
         */


        // return books.stream().sorted(Comparator
    }
    
    /**
     * 도서 정렬 메소드 (출판년도 기준)
     */
    public List<Book> getSortedBooksByYear() {
        // TODO: 출판년도 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getPublicationYear));

        return sortedBooks;
    }
    
    /**
     * 도서 정렬 메소드 (가격 기준)
     */
    public List<Book> getSortedBooksByPrice() {
        // TODO: 가격 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getPrice));

        return sortedBooks;
    }
    
    /**
     * 카테고리 목록 조회 메소드
     */
    public Set<String> getCategories() {
        // TODO: 모든 카테고리를 반환하세요.
        return categories;
    }
    
    /**
     * 카테고리별 도서 목록 조회 메소드
     */
    public List<Book> getBooksByCategory(String category) {
        // TODO: 특정 카테고리에 속한 도서 목록을 반환하세요.
        List<Book> booksByCategory = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equals(category)) {
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }
    
    /**
     * 전체 도서 목록 조회 메소드
     */
    public List<Book> getAllBooks() {
        // TODO: 전체 도서 목록을 반환하세요.
        return books;
    }
} 